package com.avantadi.petagramCurso3Semana4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import com.avantadi.petagramCurso3Semana4.adapter.MascotaAdaptador;
import com.avantadi.petagramCurso3Semana4.pojo.Mascota;

import java.util.ArrayList;

public class SegundaActividad extends AppCompatActivity {
    ArrayList<Mascota> mascotas;

    private RecyclerView RecyclerViewListaMacotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);


        //Action Bar
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        //activandpo la navegación hacia atrás
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        //inicializar ArrayList mascotas
        mascotas = new ArrayList<Mascota>();

        //5 mascotas favoritas
        mascotas.add(new Mascota(R.drawable.icons8_german_shepherd_100,"Fritz",4));
        mascotas.add(new Mascota(R.drawable.icons8_horse_100,"Adelantado",2));
        mascotas.add(new Mascota(R.drawable.icons8_dog_100,"Gorky",3));
        mascotas.add(new Mascota(R.drawable.icons8_clown_fish_100,"Nemo",2));
        mascotas.add(new Mascota(R.drawable.icons8_rabbit_100,"Rabitt",3));

        //asociación XML a RecyclerView
        RecyclerViewListaMacotas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);

        //LayoutManagwer: LinearLayoutManager
        LinearLayoutManager LayoutManagwerMascotas = new LinearLayoutManager(this);
        LayoutManagwerMascotas.setOrientation(LinearLayoutManager.VERTICAL);

        //asociación LayoutManagwer a RecyclerView
        RecyclerViewListaMacotas.setLayoutManager(LayoutManagwerMascotas);

        //Adaptador
        MascotaAdaptador adaptadorMascotas = new MascotaAdaptador(mascotas);

        //asociación Adaptador a RecyclerView
        RecyclerViewListaMacotas.setAdapter(adaptadorMascotas);

    }

    //si se pulsa retroceder se realiza un Intent a MainActivity
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(SegundaActividad.this,MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}