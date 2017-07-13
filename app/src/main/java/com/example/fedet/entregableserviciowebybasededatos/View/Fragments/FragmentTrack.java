package com.example.fedet.entregableserviciowebybasededatos.View.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fedet.Util.ResultListener;
import com.example.fedet.entregableserviciowebybasededatos.Controller.ControllerTrack;
import com.example.fedet.entregableserviciowebybasededatos.Model.POJO.Track;
import com.example.fedet.entregableserviciowebybasededatos.R;
import com.example.fedet.entregableserviciowebybasededatos.View.Adapters.AdapterRecycleView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTrack extends Fragment {




    private NotifyChanges notificator;
    private AdapterRecycleView adapterRecycleView;
    private List <Track> trackList;
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_track, container, false);
        //Inicio tracklist
        trackList = new ArrayList<>();
        // Llamo recycler
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleViewId);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapterRecycleView = new AdapterRecycleView(getContext(), trackList);
        recyclerView.setAdapter(adapterRecycleView);


        ControllerTrack controllerTrack = new ControllerTrack();
        controllerTrack.getCard(getContext(), new ResultListener<List<Track>>() {
            @Override
            public void finish(List<Track> resultado) {
                trackList = resultado;
                adapterRecycleView.updateList(trackList);


            }
        });

        View.OnClickListener listenerClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer position = recyclerView.getChildAdapterPosition(v);
                Track track = adapterRecycleView.getItem(position);
                notificator.sendTrack(track);
            }
        };

        adapterRecycleView.setListener(listenerClick);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        notificator = (NotifyChanges) context;
    }

    public interface NotifyChanges {
        public void sendTrack (Track track);
    }

}
