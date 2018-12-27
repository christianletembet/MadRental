package com.example.letembetclaude.madrental.activites;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.letembetclaude.madrental.helper.DataBaseHelper;
import com.example.letembetclaude.madrental.R;
import com.example.letembetclaude.madrental.helper.DateHelper;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle;
    Button btnReservation;
    Button btnProfil;
    Button btnRechercher;
    EditText et_debutreservation;
    EditText et_finreservation;

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
        et_debutreservation = (EditText)findViewById(R.id.et_debutreservation);
        et_finreservation = (EditText)findViewById(R.id.et_finreservation);


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

    public void rechercher(View view){
        if (validerFormulaire()){
            startActivity(new Intent(this,RechercheActivity.class));
        }
    }
    //Methodes de validations du formulaire

    public boolean validerFormulaire(){
        Boolean valid = true;
        String debutreservation = et_debutreservation.getText().toString();
        String finreservation = et_finreservation.getText().toString();

        if(debutreservation.isEmpty()){
            et_debutreservation.setError(getResources().getString(R.string.erreurdate));
            valid = false;
        }

        if(finreservation.isEmpty()){
            et_finreservation.setError(getResources().getString(R.string.erreurdate));
            valid = false;

        }


        if(DateHelper.parse(debutreservation) == null){
            et_debutreservation.setError(getResources().getString(R.string.dateinvalide));
            valid = false;

        }

        if(DateHelper.parse(finreservation) == null){
            et_finreservation.setError(getResources().getString(R.string.dateinvalide));
            valid = false;

        }

        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(this);
        String datenaissance = preferences.getString("datenaissance","");
        if (datenaissance.isEmpty()){
            Toast.makeText(this, getResources().getString(R.string.infoprofil), Toast.LENGTH_LONG).show();
            valid = false;
        }

        return valid;

    }

}
