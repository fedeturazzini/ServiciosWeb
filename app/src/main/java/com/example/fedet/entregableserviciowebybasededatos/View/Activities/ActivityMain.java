package com.example.fedet.entregableserviciowebybasededatos.View.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fedet.entregableserviciowebybasededatos.Model.POJO.Track;
import com.example.fedet.entregableserviciowebybasededatos.R;
import com.example.fedet.entregableserviciowebybasededatos.View.Fragments.FragmentDetailTrack;
import com.example.fedet.entregableserviciowebybasededatos.View.Fragments.FragmentTrack;

public class ActivityMain extends AppCompatActivity implements FragmentTrack.NotifyChanges {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTrack fragmentTrack = new FragmentTrack();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedorFragment, fragmentTrack);
        fragmentTransaction.commit();

    }

    @Override
    public void sendTrack(Track track) {
        Bundle bundle = new Bundle();

        bundle.putInt(FragmentDetailTrack.KEY_ID, track.getId());
        bundle.putString(FragmentDetailTrack.KEY_IMAGE, track.getThumbnailUrl());
        bundle.putString(FragmentDetailTrack.KEY_TITLE, track.getTitle());

        FragmentDetailTrack fragmentDetailTrack = new FragmentDetailTrack();
        fragmentDetailTrack.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedorFragment, fragmentDetailTrack);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
