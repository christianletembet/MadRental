package com.example.letembetclaude.madrental.dto;

public class ReservationsDTO {
    public String intitule;
    public String dateDebut;
    public Double prix;
    public String dateFin;
    public String image;

    public ReservationsDTO(String intitule, String dateDebut, String dateFin, Double prix, String image) {
        this.intitule = intitule;
        this.dateDebut = dateDebut;
        this.prix = prix;
        this.dateFin = dateFin;
        this.image = image;
    }
}
