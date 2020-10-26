package com.jgmayer.mascotaspersistencia;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.jgmayer.mascotaspersistencia.adapters.PageAdapter;
import com.jgmayer.mascotaspersistencia.fragments.RankingFragment;

import java.util.ArrayList;

public class Favoritas extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        /*if(toolbar != null){
            setSupportActionBar( toolbar );
        }*/

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setUpViewPager();

    }

    public void setUpViewPager(){
        viewPager.setAdapter( new PageAdapter( getSupportFragmentManager(), agregarFragments() ));
        tabLayout.setupWithViewPager( viewPager );
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();

        fragments.add( new RankingFragment() );

        return fragments;
    }


}