package com.example.letembetclaude.madrental;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.letembetclaude.madrental.dto.ReservationsDTO;
import com.example.letembetclaude.madrental.helper.NetworkHelper;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ReservationsAdapter extends RecyclerView.Adapter<ReservationsViewHolder>
{
    // Liste d'objets métier :
    private List<ReservationsDTO> listeReservationsDTO;
    // Constructeur :
    public ReservationsAdapter(List<ReservationsDTO> listeReservationsDTO)
    {
        this.listeReservationsDTO = listeReservationsDTO;
    }
    @Override
    public ReservationsViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View viewVoiture = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.voitures_item_liste, parent, false);
        return new ReservationsViewHolder(viewVoiture);
    }
    @Override
    public void onBindViewHolder(ReservationsViewHolder holder, int position)
    {
        ReservationsDTO dto = listeReservationsDTO.get(position);
        String url  = NetworkHelper.IMAGE_BASE_URL + "/" + dto.image;

        Picasso.get().load(url).into(holder.ivImage);
        Log.v(ReservationsAdapter.class.getName(),url );
        holder.tvLibelle.setText(dto.intitule + " - "+ dto.prix + " € " );
        holder.tvDateDebut.setText(dto.dateDebut);
        holder.tvDateFin.setText(dto.dateFin);


    }
    @Override
    public int getItemCount()
    {
        return listeReservationsDTO.size();
    }
}










