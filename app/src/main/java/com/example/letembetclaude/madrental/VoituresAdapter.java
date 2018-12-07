package com.example.letembetclaude.madrental;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class VoituresAdapter extends RecyclerView.Adapter<VoituresViewHolder>
{
    // Liste d'objets métier :
    private List<Voiture> listeVoitures;
    // Constructeur :
    public VoituresAdapter(List<Voiture> listeVoitures)
    {
        this.listeVoitures = listeVoitures;
    }
    @Override
    public VoituresViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View viewVoiture = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.voitures_item_liste, parent, false);
        return new VoituresViewHolder(viewVoiture);
    }
    @Override
    public void onBindViewHolder(VoituresViewHolder holder, int position)
    {
        holder.textViewLibelleVoitures.setText(listeVoitures.get(position).intitule);
    }
    @Override
    public int getItemCount()
    {
        return listeVoitures.size();
    }
}