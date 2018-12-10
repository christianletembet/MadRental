package com.example.letembetclaude.madrental;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class VoituresViewHolder extends RecyclerView.ViewHolder
{
    // TextView intitulé course :
    public ImageView imageViewVoiture;
    public TextView textViewLibelleVoitures;
    public TextView textViewDebutDate;
    public TextView textViewFinDate;
    public TextView textViewPrix;


    // Constructeur :
    public VoituresViewHolder(View itemView)
    {
        super(itemView);
        textViewLibelleVoitures = itemView.findViewById(R.id.libelle_voiture);
        imageViewVoiture = itemView.findViewById(R.id.imageVoiture);
        textViewDebutDate = itemView.findViewById(R.id.debutDate);
        textViewFinDate = itemView.findViewById(R.id.finDate);
        textViewPrix = itemView.findViewById(R.id.prix);
    }
}