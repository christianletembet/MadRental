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

import com.example.letembetclaude.madrental.R;
import com.example.letembetclaude.madrental.helper.DateHelper;

public class ProfilActivity extends AppCompatActivity {

    TextView tvProfil;
    Typeface fontBtn;
    EditText etNom;
    EditText etPrenom;
    EditText etDateNaissance;
    Button btnValider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        tvProfil = (TextView) findViewById(R.id.tvProfil);

        etNom = (EditText)findViewById(R.id.et_nom);

        etPrenom = (EditText)findViewById(R.id.et_prenom);

        etDateNaissance = (EditText)findViewById(R.id.et_datenaissance);
//Polices
        fontBtn = Typeface.createFromAsset(getAssets(),"fontBtn.ttf");
        tvProfil.setTypeface(fontBtn);

        btnValider = (Button)findViewById(R.id.btn_valider);
    }

    public void valider(View view){
        if (validerFormulaire()){
            SharedPreferences preferences =
                    PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("nom", etNom.getText().toString());
            editor.putString("prenom", etPrenom.getText().toString());
            editor.putString("datenaissance", etDateNaissance.getText().toString());
            editor.apply();
            editor.commit();
            startActivity(new Intent(this,MainActivity.class));
            Toast.makeText(this, getResources().getString(R.string.profilajour), Toast.LENGTH_LONG).show();
        }
    }
    //Methodes de validations du formulaire

    public boolean validerFormulaire(){
        Boolean valid = true;
        String nom = etNom.getText().toString();
        String prenom = etPrenom.getText().toString();
        String datenaissance = etDateNaissance.getText().toString();

        if(nom.isEmpty()){
            etNom.setError(getResources().getString(R.string.erreurnom));
            valid = false;
        }

        if(prenom.isEmpty()){
            etPrenom.setError(getResources().getString(R.string.erreurprenom));
            valid = false;

        }

        if(datenaissance.isEmpty()){
            etDateNaissance.setError(getResources().getString(R.string.erreurdatenaissance));
            valid = false;

        }

        if(DateHelper.parse(datenaissance) == null){
            etDateNaissance.setError(getResources().getString(R.string.dateinvalide));
            valid = false;

        }

        return valid;

    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(this);
         etNom.setText(preferences.getString("nom",""));
         etPrenom.setText(preferences.getString("prenom",""));
         etDateNaissance.setText(preferences.getString("datenaissance",""));
    }


}

