package com.example.letembetclaude.madrental.dto;

import com.example.letembetclaude.madrental.dto.Equipement;
import com.example.letembetclaude.madrental.dto.Option;

import java.util.ArrayList;
import java.util.List;

public class Vehicule {
    public Integer id;
    public String nom;
    public String image;
    public Integer disponible;
    public Double prixjournalierbase;
    public Integer promotion;
    public Integer agemin;
    public String categorieco2;
    public List<Equipement> equipements = new ArrayList<>(0);
    public List<Option> options= new ArrayList<>(0);

    public Vehicule(Integer id, String nom, String image, Integer disponible, Double prixjournalierbase, Integer promotion, Integer agemin, String categorieco2, List<Equipement> equipements, List<Option> options) {
        this.id = id;
        this.nom = nom;
        this.image = image;
        this.disponible = disponible;
        this.prixjournalierbase = prixjournalierbase;
        this.promotion = promotion;
        this.agemin = agemin;
        this.categorieco2 = categorieco2;
        this.equipements = equipements;
        this.options = options;
    }
}







