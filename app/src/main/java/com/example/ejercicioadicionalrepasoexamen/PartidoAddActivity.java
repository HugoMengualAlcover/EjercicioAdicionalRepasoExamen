package com.example.ejercicioadicionalrepasoexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.ejercicioadicionalrepasoexamen.Modelos.Partido;
import com.example.ejercicioadicionalrepasoexamen.databinding.ActivityPartidoAddBinding;

public class PartidoAddActivity extends AppCompatActivity {

    private ActivityPartidoAddBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPartidoAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCrearAddPartido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Partido p = crearPartido();
            }
        });

    }

    private Partido crearPartido() {
        //Partido p = new Partido(binding.txtResultadoAddPartido());
        return null;
    }
}