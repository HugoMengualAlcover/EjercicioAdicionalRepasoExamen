package com.example.ejercicioadicionalrepasoexamen.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicioadicionalrepasoexamen.MainActivity;
import com.example.ejercicioadicionalrepasoexamen.Modelos.Partido;
import com.example.ejercicioadicionalrepasoexamen.PartidoAddActivity;
import com.example.ejercicioadicionalrepasoexamen.R;
import com.example.ejercicioadicionalrepasoexamen.ShowPartidoActiviity;

import java.util.ArrayList;
import java.util.List;

public class PartidoAdapter extends RecyclerView.Adapter<PartidoAdapter.PartidoVH> {

    private List<Partido> objects;
    private int resource;
    private Context context;

    public PartidoAdapter(List<Partido> objects, int resource, Context context) {
        this.objects = objects;
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public PartidoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productoFilaView = LayoutInflater.from(context).inflate(resource, null);
        productoFilaView.setLayoutParams(new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        return new PartidoVH(productoFilaView);
    }

    @Override
    public void onBindViewHolder(@NonNull PartidoVH holder, int position) {
        Partido partido = objects.get(position);
        holder.lblResultado.setText(partido.getResult());
        holder.lblEquipos.setText(partido.getEquipo1() + " VS " +partido.getEquipo2());
        holder.btnGanador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verGanador(partido).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("PARTIDO", partido);
                Intent intent = new Intent(context, ShowPartidoActiviity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });
    }

    private AlertDialog verGanador(Partido partido) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Ganador");
        builder.setCancelable(false);
        String[] trozos = partido.getResult().split("-");
        if(Integer.parseInt(trozos[0])  > Integer.parseInt(trozos[1])){
            builder.setMessage("Ha ganado "+partido.getEquipo1());
        }else if(Integer.parseInt(trozos[0])  < Integer.parseInt(trozos[1])){
            builder.setMessage("Ha ganado "+partido.getEquipo2());
        }else {
            builder.setMessage("EMPATE");
        }

        builder.setNegativeButton("CERRAR", null);
        return  builder.create();
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class PartidoVH extends RecyclerView.ViewHolder {

        TextView lblEquipos;
        TextView lblResultado;
        Button btnGanador;

        public PartidoVH(@NonNull View itemView) {
            super(itemView);
            lblEquipos = itemView.findViewById(R.id.lblEquiposPartidoCard);
            lblResultado = itemView.findViewById(R.id.lblResultadoPartidoCard);
            btnGanador = itemView.findViewById(R.id.btnGanadorPartido);
        }
    }
}
