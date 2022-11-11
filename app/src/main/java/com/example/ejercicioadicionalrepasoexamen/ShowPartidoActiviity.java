package com.example.ejercicioadicionalrepasoexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ejercicioadicionalrepasoexamen.Modelos.Partido;
import com.example.ejercicioadicionalrepasoexamen.databinding.ActivityShowPartidoActiviityBinding;

public class ShowPartidoActiviity extends AppCompatActivity {

    private ActivityShowPartidoActiviityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityShowPartidoActiviityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        rellenar();
    }

    private void rellenar() {
        Partido p = (Partido) getIntent().getExtras().getSerializable("PARTIDO");

        binding.lblEquiposPartidoShow.setText(p.getEquipo1()+" VS "+ p.getEquipo2());
        binding.lblResultadoPartidoShow.setText(p.getResult());
        binding.lblDescripcionPartidoShow.setText(p.getComentario());
    }
}