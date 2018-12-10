package com.example.letembetclaude.madrental;

public class ReservationsDTO {
    public String intitule;
    public String dateDebut;
    public Integer prix;
    public String dateFin;
    public String imageURL;

    public ReservationsDTO(String intitule, String dateDebut, String dateFin, Integer prix, String imageURL) {
        this.intitule = intitule;
        this.dateDebut = dateDebut;
        this.prix = prix;
        this.dateFin = dateFin;
        this.imageURL = imageURL;
    }
}
