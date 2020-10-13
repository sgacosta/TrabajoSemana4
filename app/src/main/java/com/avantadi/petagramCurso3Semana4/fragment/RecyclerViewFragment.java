package com.avantadi.petagramCurso3Semana4.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.avantadi.petagramCurso3Semana4.adapter.MascotaAdaptador;
import com.avantadi.petagramCurso3Semana4.pojo.Mascota;
import com.avantadi.petagramCurso3Semana4.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class RecyclerViewFragment extends Fragment  {

    ArrayList<Mascota> mascotas;
    private RecyclerView RecyclerViewListaMacotas;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v_rv_fragment = inflater.inflate(R.layout.fragment_recycler_view, container, false);


        //asociación XML a RecyclerView
        RecyclerViewListaMacotas = (RecyclerView) v_rv_fragment.findViewById(R.id.rvMascotas);

        //LayoutManagwer: LinearLayoutManager
        LinearLayoutManager LayoutManagwerMascotas = new LinearLayoutManager(getActivity());
        LayoutManagwerMascotas.setOrientation(LinearLayoutManager.VERTICAL);

        //asociación LayoutManagwer a RecyclerView
        RecyclerViewListaMacotas.setLayoutManager(LayoutManagwerMascotas);

        //inicializar ArrayList mascotas
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.icons8_cat_100,"Minino",1));
        mascotas.add(new Mascota(R.drawable.icons8_dog_100,"Gorky",3));
        mascotas.add(new Mascota(R.drawable.icons8_clown_fish_100,"Nemo",2));
        mascotas.add(new Mascota(R.drawable.icons8_german_shepherd_100,"Fritz",4));
        mascotas.add(new Mascota(R.drawable.icons8_horse_100,"Adelantado",2));
        mascotas.add(new Mascota(R.drawable.icons8_rabbit_100,"Rabitt",3));

        //Adaptador
        MascotaAdaptador adaptadorMascotas = new MascotaAdaptador(mascotas);

        //asociación Adaptador a RecyclerView
        RecyclerViewListaMacotas.setAdapter(adaptadorMascotas);

        return v_rv_fragment;
    }




    public void mostrarFragmentoPerfil() {
        Fragment someFragment = new PerfilMascotaFragment();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        fm.beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .show(someFragment)
                .commit();

    }
}