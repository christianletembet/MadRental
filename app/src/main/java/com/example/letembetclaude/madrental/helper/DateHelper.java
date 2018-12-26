package com.example.letembetclaude.madrental.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Methode pour convertir un String en Date
public class DateHelper {
    public static final String FORMAT_DATE = "dd/MM/yyyy";
    public static Date parse(String date){
        Date d;

        if (date == null || date.isEmpty()){
            return null;
        }


        else {
            String [] segment = date.split("/");
            if (segment.length == 3 && segment[2].length()==4){
            SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE);
            dateFormat.setLenient(false);
            try {
                d = dateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
            }
            else {
                return null;
            }
        }
        return d;
    }
}
