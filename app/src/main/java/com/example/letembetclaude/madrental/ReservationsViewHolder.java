package com.example.letembetclaude.madrental;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ReservationsViewHolder extends RecyclerView.ViewHolder
{
    // TextView intitulé course :
    public ImageView ivImage;
    public TextView tvLibelle;
    public TextView tvDateDebut;
    public TextView tvDateFin;


    // Constructeur :
    public ReservationsViewHolder(View itemView)
    {
        super(itemView);
        ivImage = itemView.findViewById(R.id.image_voiture);
        tvLibelle = itemView.findViewById(R.id.libelle_voiture);
        tvDateDebut = itemView.findViewById(R.id.debut_date);
        tvDateFin = itemView.findViewById(R.id.fin_date);
    }
}