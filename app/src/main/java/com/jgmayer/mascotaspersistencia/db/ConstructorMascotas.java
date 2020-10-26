package com.jgmayer.mascotaspersistencia.db;


import android.content.ContentValues;
import android.content.Context;

import com.jgmayer.mascotaspersistencia.R;
import com.jgmayer.mascotaspersistencia.classes.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {

    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> getMascotas(){
        /*ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        mascotas.add( new Mascota(R.drawable.bianca, "Bianca", 20) );
        mascotas.add( new Mascota(R.drawable.dolly, "Dolly", 11) );
        mascotas.add( new Mascota(R.drawable.jack, "Jack", 10) );
        mascotas.add( new Mascota(R.drawable.loki, "Loki", 5) );
        mascotas.add( new Mascota(R.drawable.peco, "Peco", 2) );
        return mascotas;*/

        BaseDatos db = new BaseDatos( context );
        //db.deleteMascotas();
        if( db.getMascotas().size() == 0 )
            insertMascotas( db );
        return db.getMascotas();
    }

    public void insertMascotas( BaseDatos db ){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        mascotas.add( new Mascota(R.drawable.leslie, "Leslie", 6) );
        mascotas.add( new Mascota(R.drawable.benja, "Benja", 1) );
        mascotas.add( new Mascota(R.drawable.duque, "Duque", 2) );
        mascotas.add( new Mascota(R.drawable.niebla, "Niebla", 11) );
        mascotas.add( new Mascota(R.drawable.odie, "Odie", 10) );
        mascotas.add( new Mascota(R.drawable.juana, "Juana", 4) );
        mascotas.add( new Mascota(R.drawable.coco, "Coco", 20) );
        mascotas.add( new Mascota(R.drawable.kira, "Kira", 2) );

        for (Mascota mascota: mascotas){
            ContentValues contentValues = new ContentValues();
            contentValues.put( Config.TABLE_MASCOTAS_NOMBRE, mascota.getNombre() );
            contentValues.put( Config.TABLE_MASCOTAS_FOTO, mascota.getImage() );
            db.insertMascota( contentValues );
        }
    }

    public void darLikeMascota( Mascota mascota ){
        BaseDatos db = new BaseDatos( context );
        ContentValues contentValues = new ContentValues();
        contentValues.put(  Config.TABLE_MASCOTAS_LIKES_ID_MASCOTA, mascota.getId() );
        contentValues.put( Config.TABLE_MASCOTAS_LIKES_NUMERO_LIKES, 1 );
        db.insertLike( contentValues );
    }

    public int getLikesMascota( Mascota mascota ){
        BaseDatos db = new BaseDatos( context );
        return db.getLikes( mascota );
    }

}

