package com.example.letembetclaude.madrental.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.letembetclaude.madrental.R;
import com.example.letembetclaude.madrental.ReservationsAdapter;
import com.example.letembetclaude.madrental.dto.ReservationsDTO;

import java.util.ArrayList;
import java.util.List;

public class ReservationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        // init :
        RecyclerView recyclerView = findViewById(R.id.liste_voitures);
// à ajouter pour de meilleures performances :
        recyclerView.setHasFixedSize(true);
// layout manager, décrivant comment les items sont disposés :
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
// contenu d'exemple :
        List<ReservationsDTO> listReservationsDTO = new ArrayList<>();

        listReservationsDTO.add(new ReservationsDTO("ReservationsDTO 1 ","21-10-2018","" ,11.0,"zoom-buggy.jpg"));
        listReservationsDTO.add(new ReservationsDTO("ReservationsDTO 2 ","27-10-2018","",12.3,"zoom-mad-pickup.jpg"));

// adapter :
        ReservationsAdapter ReservationsAdapter = new ReservationsAdapter(listReservationsDTO);
        recyclerView.setAdapter(ReservationsAdapter);
    }


    }


