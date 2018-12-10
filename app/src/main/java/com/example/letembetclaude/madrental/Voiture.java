package com.example.letembetclaude.madrental;

public class Voiture {
    // Attributs :
    public String intitule;
    public String dateDebut;
    public Integer prix;
    public String dateFin;
    public String imageURL;
    // Constructeur :

    public Voiture(String intitule, String dateDebut, Integer prix, String dateFin, String imageURL) {
        this.intitule = intitule;
        this.dateDebut = dateDebut;
        this.prix = prix;
        this.dateFin = dateFin;
        this.imageURL = imageURL;
    }
}
