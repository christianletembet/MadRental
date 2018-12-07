package com.example.letembetclaude.madrental;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class VoituresViewHolder extends RecyclerView.ViewHolder
{
    // TextView intitulé course :
    public TextView textViewLibelleVoitures;
    // Constructeur :
    public VoituresViewHolder(View itemView)
    {
        super(itemView);
        textViewLibelleVoitures = itemView.findViewById(R.id.libelle_voiture);
    }
}