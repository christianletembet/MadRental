package com.example.letembetclaude.madrental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
        List<Voiture> listVoitures = new ArrayList<>();

        listVoitures.add(new Voiture("Voiture 1 ","21-10-2018",180 ,"27-10-2018",""));
        listVoitures.add(new Voiture("Voiture 2 ","27-10-2018",188,"29-10-2018",""));

// adapter :
        VoituresAdapter VoituresAdapter = new VoituresAdapter(listVoitures);
        recyclerView.setAdapter(VoituresAdapter);
    }


    }


