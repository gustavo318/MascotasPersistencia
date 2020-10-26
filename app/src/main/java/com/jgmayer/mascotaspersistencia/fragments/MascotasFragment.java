package com.jgmayer.mascotaspersistencia.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jgmayer.mascotaspersistencia.R;
import com.jgmayer.mascotaspersistencia.classes.Mascota;
import com.jgmayer.mascotaspersistencia.presentador.IMascotasFragmentPresenter;
import com.jgmayer.mascotaspersistencia.presentador.MascotasFragmentPresenter;

import java.util.ArrayList;

public class MascotasFragment<MascotaAdaptador extends RecyclerView.Adapter> extends Fragment implements IMascotasFragmentView {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IMascotasFragmentPresenter iMascotasFragmentPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);
        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        iMascotasFragmentPresenter = new MascotasFragmentPresenter( this, getContext() );
        iMascotasFragmentPresenter.obtenerMascotasBD();
        generateLinearLayot();

        return v;
    }

    public void initMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add( new Mascota(R.drawable.leslie, "Leslie", 5) );
        mascotas.add( new Mascota(R.drawable.benja, "Benja", 1) );
        mascotas.add( new Mascota(R.drawable.duque, "Duque", 2) );
        mascotas.add( new Mascota(R.drawable.niebla, "Niebla", 11) );
        mascotas.add( new Mascota(R.drawable.odie, "Odie", 10) );
        mascotas.add( new Mascota(R.drawable.juana, "Juana", 4) );
        mascotas.add( new Mascota(R.drawable.coco, "Coco", 20) );
        mascotas.add( new Mascota(R.drawable.kira, "Kira", 2) );
    }

    @Override
    public void generateLinearLayot() {
        LinearLayoutManager llm = new LinearLayoutManager( getContext() );
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override

    public MascotaAdaptador generateMascotaAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador( mascotas );
        return mascotaAdaptador;
    }

    @Override
        public void initAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter( adaptador );
    }
}
