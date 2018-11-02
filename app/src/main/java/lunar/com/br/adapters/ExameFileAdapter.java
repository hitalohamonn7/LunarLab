package lunar.com.br.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import lunar.com.br.applacad.R;
import lunar.com.br.model.ExameFile;

/**
 * Created by hitalo on 05/07/18.
 */

public class ExameFileAdapter extends RecyclerView.Adapter<ExameFileAdapter.ExamesViewHolder> {
    Context context;
    List<ExameFile> exames;

    public ExameFileAdapter(Context context, List<ExameFile> exames) {
        this.context = context;
        this.exames = exames;
    }

    @Override
    public ExamesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewHolder = LayoutInflater.from(context).inflate(R.layout.exame,parent,false);
        return new ExamesViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(ExamesViewHolder holder, int position) {
        ExameFile exameFile = exames.get(position);
        String data = exameFile.getData().replaceAll("-", "/");
        String[] s = data.split("/");
        String novaData = s[2]+"/"+s[1]+"/"+s[0];
            holder.data.setText(novaData);

        holder.nome.setText(exameFile.getNome());
        holder.link = exameFile.getLink();
    }

    @Override
    public int getItemCount() {
        return exames.size();
    }


    public class ExamesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView nome;
        final TextView data;
         String link;
        public ExamesViewHolder(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.tv_exame);
            data = itemView.findViewById(R.id.tv_data);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
            view.getContext().startActivity(intent);
        }
    }
}
