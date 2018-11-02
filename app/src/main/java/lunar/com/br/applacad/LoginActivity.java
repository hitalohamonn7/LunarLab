package lunar.com.br.applacad;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import lunar.com.br.model.Token;
import retrofit2.Call;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import lunar.com.br.model.User;
import lunar.com.br.retrofit.RetrofitStarter;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    TextView tvCPF;
    TextView tvSenha;
    Button btLogin;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("LACAD");
        tvCPF = findViewById(R.id.tv_cpf);
        tvSenha = findViewById(R.id.tv_senha);
        btLogin =findViewById(R.id.bt_logar);
        sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        if(logado()){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();

        }else{
            logar();

        }




    }

    private boolean logado() {
        String token = sharedPreferences.getString("token",null);
        return token != null;
    }

    public void logar(){
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user = new User(tvCPF.getText().toString(),tvSenha.getText().toString());
                Call call = new RetrofitStarter().getUserService().logar(user);
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        if(response.body().toString() != null){
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            Token token = (Token) response.body();
                            Log.i("testetoken", "onResponse: Token"+token.getToken());
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("token",token.getToken());
                            editor.apply();
                            startActivity(intent);
                        }else{
                            Toast.makeText(LoginActivity.this,"CPF ou Senha Incorretos",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Log.i("onresponse", "onFailure: Deu Errado"+t.getMessage());

                    }
                });

            }
        });
    }

}
