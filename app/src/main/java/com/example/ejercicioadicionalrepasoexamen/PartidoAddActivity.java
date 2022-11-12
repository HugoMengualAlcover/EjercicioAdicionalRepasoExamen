package com.example.ejercicioadicionalrepasoexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;

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
                if (p != null){
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("PARTIDO", p);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK,intent);
                    finish();
                }else{
                    Toast.makeText(PartidoAddActivity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private Partido crearPartido() {
        if(binding.spnEquipo1AddPartido.getSelectedItemPosition() !=0 &&
                binding.spnEquipo1AddPartido.getSelectedItemPosition()!=0 &&
                !binding.txtResultadoAddPartido.getText().toString().isEmpty() &&
                !binding.txtComentariosAddPartido.getText().toString().isEmpty()){
            return  new Partido(binding.txtResultadoAddPartido.getText().toString(),
                    binding.spnEquipo1AddPartido.getSelectedItem().toString(),
                    binding.spnEquipo2AddPartido.getSelectedItem().toString(),
                    binding.txtComentariosAddPartido.getText().toString());
        }
        return null;
    }
}