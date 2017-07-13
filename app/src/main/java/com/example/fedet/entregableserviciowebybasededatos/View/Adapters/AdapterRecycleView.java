package com.example.fedet.entregableserviciowebybasededatos.View.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fedet.entregableserviciowebybasededatos.Model.POJO.Track;
import com.example.fedet.entregableserviciowebybasededatos.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecycleView extends RecyclerView.Adapter implements View.OnClickListener{

    Context context;
    private List<Track> listTrack = new ArrayList<>();
    private View.OnClickListener onClickListener;

    public AdapterRecycleView(Context context, List<Track> listTrack) {
        this.context = context;
        this.listTrack = listTrack;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recycleview_track_celda, parent, false);
        view.setOnClickListener(this);

        ViewHolder myViewHolder = new ViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Track track = listTrack.get(position);
        ViewHolder myViewHolder = (ViewHolder) holder;
        myViewHolder.loadData(track);
    }

    public void updateList(List<Track> list){
        this.listTrack = list;
        notifyDataSetChanged();
    }

    public Track getItem (Integer position){
        return listTrack.get(position);
    }

    @Override
    public int getItemCount() {
        return listTrack.size();
    }

    public void setListener (View.OnClickListener listener){
        onClickListener = listener;
    }

    @Override
    public void onClick(View v) {
        if(onClickListener != null) {
            onClickListener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imagen;
        TextView titulo;
        TextView id;

        public ViewHolder(View itemView) {
            super(itemView);
            imagen = (ImageView) itemView.findViewById(R.id.imagenCardView);
            titulo = (TextView) itemView.findViewById(R.id.textViewTitulo);
            id = (TextView) itemView.findViewById(R.id.numeroId);
        }

        public void loadData(Track track){
            Picasso.with(context).load(track.getThumbnailUrl()).placeholder(R.drawable.iconodeespera).into(imagen);
            titulo.setText(track.getTitle());
            id.setText(track.getId().toString());
        }
    }
}
