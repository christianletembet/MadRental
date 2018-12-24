package com.example.letembetclaude.madrental.activites;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.letembetclaude.madrental.helper.DataBaseHelper;
import com.example.letembetclaude.madrental.R;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle;
    Button btnReservation;
    Button btnProfil;
    Button btnRechercher;

    Typeface fontTitle;
    Typeface fontBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBaseHelper databaseHelper = new DataBaseHelper(this);
        databaseHelper.getWritableDatabase();

        tvTitle = (TextView)findViewById(R.id.tvTitle);
        btnReservation = (Button)findViewById(R.id.btnReservation);
        btnProfil = (Button)findViewById(R.id.btnProfil);
        btnRechercher = (Button)findViewById(R.id.btnRechercher);

        fontTitle = Typeface.createFromAsset(getAssets(),"fontTitle.otf");
        fontBtn = Typeface.createFromAsset(getAssets(),"fontBtn.ttf");

        tvTitle.setTypeface(fontTitle);
        btnReservation.setTypeface(fontBtn);
        btnProfil.setTypeface(fontBtn);
        btnRechercher.setTypeface(fontBtn);

    }

    public void reservations(View view){
        startActivity(new Intent(this,ReservationActivity.class));
    }

    public void profil(View view){
        startActivity(new Intent(this,ProfilActivity.class));
    }
}
