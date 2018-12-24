package com.example.letembetclaude.madrental.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.letembetclaude.madrental.BaseContrat;

public class DataBaseHelper extends SQLiteOpenHelper




{
    // Constructeur :
    public DataBaseHelper(Context context)
    {
        super(context, "reservations.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + BaseContrat.ReservationContrat.TABLE_RESERVATION +"("
                + BaseContrat.ReservationContrat._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + BaseContrat.ReservationContrat.COLONNE_INTITULE + " TEXT NOT NULL,"
                + BaseContrat.ReservationContrat.COLONNE_DEBUT_DATE + " TEXT NOT NULL,"
                + BaseContrat.ReservationContrat.COLONNE_FIN_DATE + " TEXT NOT NULL,"
                + BaseContrat.ReservationContrat.COLONNE_PRIX + " INTEGER NOT NULL,"
                + BaseContrat.ReservationContrat.COLONNE_IMAGE_URL + " TEXT NOT NULL"

                + ")"
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}


