package com.avantadi.petagramCurso3Semana4.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.avantadi.petagramCurso3Semana4.adapter.MascotaAdaptador;
import com.avantadi.petagramCurso3Semana4.adapter.PerfilMascotaAdaptador;
import com.avantadi.petagramCurso3Semana4.pojo.Mascota;
import com.avantadi.petagramCurso3Semana4.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class PerfilMascotaFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView RecyclerViewListaPerfilMacotas;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v_rv_fragment_perfil = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);


        //asociación XML a RecyclerView
        RecyclerViewListaPerfilMacotas = (RecyclerView) v_rv_fragment_perfil.findViewById(R.id.rvPerfilMascotas);

        /*
        //LayoutManagwer: LinearLayoutManager
        LinearLayoutManager LayoutManagwerMascotas = new LinearLayoutManager(getActivity());
        LayoutManagwerMascotas.setOrientation(LinearLayoutManager.VERTICAL);
        */

        //LayoutManagwer: GridLayoutManager
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        RecyclerViewListaPerfilMacotas.setLayoutManager(glm);

        //asociación LayoutManagwer a RecyclerView
        RecyclerViewListaPerfilMacotas.setLayoutManager(glm);

        //inicializar ArrayList mascotas
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.icons8_dog_100, "Minino", 1));
        mascotas.add(new Mascota(R.drawable.icons8_dog_100, "Gorky", 3));
        mascotas.add(new Mascota(R.drawable.icons8_dog_100, "Nemo", 2));
        mascotas.add(new Mascota(R.drawable.icons8_dog_100, "Fritz", 4));
        mascotas.add(new Mascota(R.drawable.icons8_dog_100, "Adelantado", 2));
        mascotas.add(new Mascota(R.drawable.icons8_dog_100, "Rabitt", 3));

        //Adaptador
        PerfilMascotaAdaptador adaptadorPerfilMascotas = new PerfilMascotaAdaptador(mascotas);

        //asociación Adaptador a RecyclerView
        RecyclerViewListaPerfilMacotas.setAdapter(adaptadorPerfilMascotas);

        return v_rv_fragment_perfil;
    }


}