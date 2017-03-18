package com.example.gariw.chrzszcz;

import android.database.Cursor;

import java.util.Random;

/**
 * Created by Gariw on 2016-11-02.
 */

public class Word {
    private static int BAZA = 62585;
    private int id;
    private  String slowko;
    private int poziom;
    private String cwicz;
    private String znaki_poziom_1;
    private String znaki_poziom_2_3;

    private int ileWyst;//liczba wystapien u,h,z
    private int P;//poziom
    public Word(int lp, String s, int p, String c, String p1, String p23, int poz){
        id = lp;
        slowko = s;
        poziom = p;
        cwicz = c;
        P = poz;
        znaki_poziom_1 = p1;
        znaki_poziom_2_3 = p23;
    }
    public String  getPositions(){
        String [] zw;
        if(P == 1) {
            return znaki_poziom_1;
        }else if (P == 2) {
            Random generator = new Random();
            zw = znaki_poziom_2_3.split(" ", 10);
            int los = generator.nextInt(zw.length);
            return zw[los];
        }else if (P == 3){
            return znaki_poziom_2_3;
        }else if(P == 4){
            String ret = null;
            for(int i = 0; i < slowko.length(); i++){
                if(slowko.substring(i, i+1).equals("u") || slowko.substring(i, i+1).equals("ó")){
                    if(ret != null)
                    {
                        ret += " " + Integer.toString(i);
                    }else {
                        ret = Integer.toString(i);
                    }
                    --ileWyst;
                }
                if(ileWyst == 0){break;}
            }
            return ret;
        }else if(P == 5) {
            String ret = null;
            for (int i = 0; i < slowko.length(); i++) {
                if (slowko.substring(i, i + 1).equals("h")) {
                    if(ret != null){
                        ret += " "+ Integer.toString(i);
                    }else{
                        ret = Integer.toString(i);
                    }
                    --ileWyst;
                } else if (slowko.substring(i, i + 2).equals("ch")) {
                    if(ret != null)
                    {
                        ret += " -"+ Integer.toString(i);
                    }
                    else {
                        ret = "-" + Integer.toString(i);
                    }
                    --ileWyst;
                }
                if (ileWyst == 0) {break;}
            }
            return ret;
        }else if(P == 6) {
            String ret = null;
            for (int i = 0; i < slowko.length(); i++) {
                if (slowko.substring(i, i + 1).equals("ż")) {
                    if(ret != null){
                        ret += " "+ Integer.toString(i);
                    }else{
                        ret = Integer.toString(i);
                    }
                    --ileWyst;
                } else if (slowko.substring(i, i + 2).equals("rz")) {
                    if(ret != null)
                    {
                        ret += " -"+ Integer.toString(i);
                    }
                    else {
                        ret = "-" + Integer.toString(i);
                    }
                    --ileWyst;
                }
                if (ileWyst == 0) {break;}
            }
            return ret;
        }
        return znaki_poziom_1;
    }
    public String getWord(){
        return slowko;
    }

    public void checkWord(Cursor c) {
            switch(P){
                case 1:
                    checkP(c);
                    break;
                case 2:
                    checkP(c);
                    break;
                case 3:
                    checkP(c);
                    break;
                case 4:
                    while((ileWyst = (Integer.parseInt(cwicz)/100)) == 0){
                        if (id == 62585) {
                            c.moveToFirst();
                        } else {
                            c.moveToNext();
                        }
                        ++id;
                        cwicz = c.getString(3);
                    }
                    break;
                case 5:
                    while((ileWyst = (Integer.parseInt(cwicz)/10)%10) == 0){
                        if (id == 62585) {
                            c.moveToFirst();
                        } else {
                            c.moveToNext();
                        }
                        ++id;
                        cwicz = c.getString(3);
                    }
                    break;
                case 6:
                    while((ileWyst = (Integer.parseInt(cwicz)%10)) == 0){
                        if (id == 62585) {
                            c.moveToFirst();
                        } else {
                            c.moveToNext();
                        }
                        ++id;
                        cwicz = c.getString(3);
                    }
                    break;
                default:
                    checkP(c);
            }
        id = c.getInt(0);
        slowko = c.getString(1);
        znaki_poziom_1 = c.getString(4);
        znaki_poziom_2_3 = c.getString(5);

    }
    //sprawdza poziom
    private void checkP(Cursor c){
        while (poziom % 10 != P && poziom / 10 != P){
            if (id == 62585) {
                c.moveToFirst();
            } else {
                c.moveToNext();
            }
            ++id;
            poziom = c.getInt(2);
        }
    }
    /*
    public void checkWord(Cursor c) {
        Random generator;
        generator = new Random();
        switch(P){
            case 1:
                while (poziom % 10 != P && poziom / 10 != P){

                    int los = generator.nextInt(BAZA);
                    c.moveToPosition(los);
                    poziom = c.getInt(2);
                }
                break;
            case 2:
                while (poziom % 10 != P && poziom / 10 != P){
                    int los = generator.nextInt(BAZA);
                    c.moveToPosition(los);
                    poziom = c.getInt(2);
                }
                break;
            case 3:
                while (poziom % 10 != P && poziom / 10 != P){
                    int los = generator.nextInt(BAZA);
                    c.moveToPosition(los);
                    poziom = c.getInt(2);
                }
                break;
            case 4:
                while((ileWyst = (Integer.parseInt(cwicz)/100)) == 0){
                    int los = generator.nextInt(BAZA);
                    c.moveToPosition(los);
                    cwicz = c.getString(3);
                }
                break;
            case 5:
                while((ileWyst = (Integer.parseInt(cwicz)/10)%10) == 0){
                    int los = generator.nextInt(BAZA);
                    c.moveToPosition(los);
                    cwicz = c.getString(3);
                }
                break;
            case 6:
                while((ileWyst = (Integer.parseInt(cwicz)%10)) == 0){
                    int los = generator.nextInt(BAZA);
                    c.moveToPosition(los);

                    cwicz = c.getString(3);
                }
                break;
            default:
                while (poziom % 10 != P && poziom / 10 != P){
                    int los = generator.nextInt(BAZA);
                    c.moveToPosition(los);
                    poziom = c.getInt(2);
                }
        }
        id = c.getInt(0);
        slowko = c.getString(1);
        znaki_poziom_1 = c.getString(4);
        znaki_poziom_2_3 = c.getString(5);
    }
*/
}
