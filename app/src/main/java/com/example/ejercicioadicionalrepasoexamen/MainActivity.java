package com.example.ejercicioadicionalrepasoexamen;

import android.content.Intent;
import android.os.Bundle;

import com.example.ejercicioadicionalrepasoexamen.Adapters.PartidoAdapter;
import com.example.ejercicioadicionalrepasoexamen.Modelos.Partido;
import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

import com.example.ejercicioadicionalrepasoexamen.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private ArrayList<Partido> partidosList;
    private ActivityResultLauncher<Intent> launcherAdapter;

    private PartidoAdapter partidoAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        partidosList = new ArrayList<>();
        inicializarLaunchers();

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherAdapter.launch(new Intent(MainActivity.this, PartidoAddActivity.class));
            }
        });
    }

    private void inicializarLaunchers() {
        launcherAdapter = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK) {
                    if (result.getData() != null && result.getData().getExtras() != null) {
                        Partido p = (Partido) result.getData().getExtras().getSerializable("PARTIDO");
                        partidosList.add(p);
                        partidoAdapter.notifyItemInserted(partidosList.size()-1);
                    } else {
                        Toast.makeText(MainActivity.this, "NO HAY INTENT o BUNDLE", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "VENTANA CANCELADA", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}