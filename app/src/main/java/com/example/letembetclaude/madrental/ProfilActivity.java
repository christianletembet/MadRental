package com.example.letembetclaude.madrental;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfilActivity extends AppCompatActivity {

    TextView tvProfil;

    Typeface fontBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        tvProfil = (TextView)findViewById(R.id.tvProfil);

        fontBtn = Typeface.createFromAsset(getAssets(),"fontBtn.ttf");

        tvProfil.setTypeface(fontBtn);
    }
}
