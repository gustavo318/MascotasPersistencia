package com.jgmayer.mascotaspersistencia.fragments;

import com.jgmayer.mascotaspersistencia.classes.Mascota;

import java.util.ArrayList;

public interface IMascotasFragmentView {
    public void generateLinearLayot();
    public MascotaAdaptador generateMascotaAdaptador(ArrayList<Mascota> mascotas );
    public void initAdaptadorRV( MascotaAdaptador adaptador );
}