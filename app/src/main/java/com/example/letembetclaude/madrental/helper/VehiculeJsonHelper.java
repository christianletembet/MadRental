package com.example.letembetclaude.madrental.helper;

import com.example.letembetclaude.madrental.dto.Equipement;
import com.example.letembetclaude.madrental.dto.Option;
import com.example.letembetclaude.madrental.dto.Vehicule;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VehiculeJsonHelper {
    public static List<Vehicule> listeVehicules(String vehiculesJsonString){
                    List<Vehicule> vehicules = new ArrayList<>();

        try {
            JSONArray vehiculesJsonArray = new JSONArray(vehiculesJsonString);
            for (int i=0;i<vehiculesJsonArray.length();i++){
                JSONObject v = vehiculesJsonArray.getJSONObject(i);

                Vehicule vehicule = new Vehicule(v.getInt("id"),v.getString("nom"),v.getString("image"),
                        v.getInt("disponible"),v.getDouble("prixjournalierbase"),v.getInt("promotion"),
                        v.getInt("agemin"),v.getString("categorieco2"),
                        getEquipements(v.getJSONArray("equipements")),getOptions(v.getJSONArray("options")));
                vehicules.add(vehicule);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return vehicules;
    }

    public static List<Equipement> getEquipements(JSONArray equipementsJsonArray) {

       List<Equipement> equipements = new ArrayList<>();

       for (int i=0;i<equipementsJsonArray.length();i++){
           try {
               JSONObject v = equipementsJsonArray.getJSONObject(i);
               equipements.add(new Equipement(v.getInt("id"),v.getString("nom")));
           } catch (JSONException e) {
               e.printStackTrace();
           }
       }
       return equipements;
    }

    public static List<Option> getOptions(JSONArray optionsJsonArray) {

        List<Option> options = new ArrayList<>();

        for (int i=0;i<optionsJsonArray.length();i++){
            try {
                JSONObject v = optionsJsonArray.getJSONObject(i);
                options.add(new Option(v.getInt("id"),v.getString("nom"),v.getDouble("prix")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return options;
    }
}




