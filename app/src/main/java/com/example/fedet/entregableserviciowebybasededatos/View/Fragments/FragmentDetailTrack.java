package com.example.fedet.entregableserviciowebybasededatos.View.Fragments;


import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fedet.entregableserviciowebybasededatos.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetailTrack extends Fragment {


    public static final String KEY_IMAGE = "clave_imagen";
    public static final String KEY_TITLE = "clave_title";
    public static final String KEY_ID = "clave_id";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_detalle_track, container, false);

        Bundle bundle = getArguments();

        String imageTrackDetail = bundle.getString(KEY_IMAGE);
        String title = bundle.getString(KEY_TITLE);
        Integer id = bundle.getInt(KEY_ID);


        //Seteo los campos del xml
        ImageView imagenDetalle = (ImageView) view.findViewById(R.id.imagenDetalleTrack);
        Picasso.with(getContext()).load(imageTrackDetail).placeholder(R.drawable.iconodeespera).into(imagenDetalle);

        TextView textView = (TextView) view.findViewById(R.id.titleIdDetail);
        textView.setText(title);

        TextView textId = (TextView) view.findViewById(R.id.idNumber);
        textId.setText(id.toString());


        return view;
    }

}
