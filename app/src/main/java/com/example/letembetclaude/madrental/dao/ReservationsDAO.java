package com.example.letembetclaude.madrental.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.letembetclaude.madrental.BaseContrat;
import com.example.letembetclaude.madrental.helper.DataBaseHelper;
import com.example.letembetclaude.madrental.dto.ReservationsDTO;

import java.util.ArrayList;
import java.util.List;

public class ReservationsDAO {


    public static List<ReservationsDTO> getListeReservzations(Context context)
    {
        // projection (colonnes utilisées après la requète) :
        String[] projection = {BaseContrat.ReservationContrat._ID,
                BaseContrat.ReservationContrat.COLONNE_INTITULE,
                BaseContrat.ReservationContrat.COLONNE_DEBUT_DATE,
                BaseContrat.ReservationContrat.COLONNE_FIN_DATE,
                BaseContrat.ReservationContrat.COLONNE_PRIX,
                BaseContrat.ReservationContrat.COLONNE_IMAGE_URL


        };


        // accès en lecture (query) :
        DataBaseHelper databaseHelper = new DataBaseHelper(context);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        // requête :
        Cursor cursor = db.query(
                BaseContrat.ReservationContrat.TABLE_RESERVATION,	// table sur laquelle faire la requète
                projection,								// colonnes à retourner
                null,							// colonnes pour la clause WHERE (inactif)
                null,						// valeurs pour la clause WHERE (inactif)
                null,							// GROUP BY (inactif)
                null,							// HAVING (inactif)
                null,									// ordre de tri
                null);								// LIMIT (inactif)

        // construction de la liste de mémos
        List<ReservationsDTO> listeReservations = new ArrayList<>();
        if (cursor != null)
        {
            try
            {
                cursor.moveToFirst();
                while (!cursor.isAfterLast())
                {
                    // conversion des données remontées en un objet métier :
                    listeReservations.add(new ReservationsDTO(cursor.getString(cursor.getColumnIndex(BaseContrat.ReservationContrat.COLONNE_INTITULE)),
                            cursor.getString(cursor.getColumnIndex(BaseContrat.ReservationContrat.COLONNE_DEBUT_DATE)),
                            cursor.getString(cursor.getColumnIndex(BaseContrat.ReservationContrat.COLONNE_FIN_DATE)),
                            cursor.getDouble(cursor.getColumnIndex(BaseContrat.ReservationContrat.COLONNE_PRIX)),
                            cursor.getString(cursor.getColumnIndex(BaseContrat.ReservationContrat.COLONNE_IMAGE_URL))));
                    cursor.moveToNext();
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            finally
            {
                cursor.close();
            }
        }

        return listeReservations;
    }

    /**
     * Ajout d'un mémo en base de données.
     * @param context Context
     * @param intitule Intitulé
     * @return ID mémo
     */
    public static long ajouterVoiture(Context context, String intitule , String dateDebut , String dateFin , String prix)
    {
        // accès en écriture (insert, update, delete) :
        DataBaseHelper databaseHelper = new DataBaseHelper(context);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        // objet de valeurs :
        ContentValues values = new ContentValues();
        values.put(BaseContrat.ReservationContrat.COLONNE_INTITULE, intitule);
        values.put(BaseContrat.ReservationContrat.COLONNE_DEBUT_DATE, dateDebut);
        values.put(BaseContrat.ReservationContrat.COLONNE_FIN_DATE, dateFin);
        values.put(BaseContrat.ReservationContrat.COLONNE_INTITULE, prix);

        // ajout :
        return db.insert(BaseContrat.ReservationContrat.TABLE_RESERVATION, null, values);
    }
}
