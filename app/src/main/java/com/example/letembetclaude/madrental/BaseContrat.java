package com.example.letembetclaude.madrental;

import android.provider.BaseColumns;

public final class BaseContrat
{
    // constructeur privé afin de ne pas instancier la classe :
    private BaseContrat() {}
    // contenu de la table "RESERVATIONS" :
    public static class ReservationContrat implements BaseColumns
    {
        public static final String TABLE_RESERVATION = "RESERVATION";
        public static final String COLONNE_INTITULE = "intitule";
        public static final String COLONNE_PRIX = "prix";
        public static final String COLONNE_DEBUT_DATE = "debutDate";
        public static final String COLONNE_FIN_DATE = "finDate";
    }
}