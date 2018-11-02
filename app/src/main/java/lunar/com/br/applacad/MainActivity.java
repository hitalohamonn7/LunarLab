package lunar.com.br.applacad;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import java.util.ArrayList;
import java.util.List;

import lunar.com.br.adapters.ExameFileAdapter;
import lunar.com.br.model.ExameFile;
import lunar.com.br.model.Exames;
import lunar.com.br.model.Token;
import lunar.com.br.retrofit.RetrofitStarter;
import lunar.com.br.service.ExameService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<ExameFile> exames;
    ExameFileAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exames = new ArrayList<>();
        getSupportActionBar().setTitle("LACAD");

       carregaLista();

        rv = findViewById(R.id.rv_exames);
        adapter = new ExameFileAdapter(this, exames);

        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    }

    public void carregaLista(){
        Token token = new Token();
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences("login", Context.MODE_PRIVATE);
        String tok = sharedPreferences.getString("token","00");
        token.setToken(tok);
        Call<Exames> call = new RetrofitStarter().getExameService().getExames(token);
        call.enqueue(new Callback<Exames>() {
            @Override
            public void onResponse(Call<Exames> call, Response<Exames> response) {
                Log.i("onrespnse", "onResponse: deu certo"+response.body().getExames().get(0).getLink());
                response.body().getExames();
                adapter.notifyDataSetChanged();
                ArrayList<ExameFile> lista = (ArrayList<ExameFile>) response.body().getExames();
                for (ExameFile exame:lista) {
                    exames.add(exame);
                }

            }

            @Override
            public void onFailure(Call<Exames> call, Throwable t) {
                Log.i("deu ruim", "onFailure: "+t.getMessage());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:{
                SharedPreferences sp = getSharedPreferences("login",Context.MODE_PRIVATE);
                sp.edit().clear().commit();
                finish();

            }break;
            case R.id.lunar:{
                Intent intentLunar = new Intent(MainActivity.this,LunarActivity.class);
                startActivity(intentLunar);
            }break;
            case R.id.lab:{
                Intent intentLacad = new Intent(MainActivity.this,LacadActivity.class);
                startActivity(intentLacad);
            }

        }
        return super.onOptionsItemSelected(item);
    }
}
