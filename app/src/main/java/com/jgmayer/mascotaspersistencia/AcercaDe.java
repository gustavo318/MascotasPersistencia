package com.jgmayer.mascotaspersistencia;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}