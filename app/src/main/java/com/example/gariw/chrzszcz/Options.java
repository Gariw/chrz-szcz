package com.example.gariw.chrzszcz;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

/**
 * Created by Gariw on 2016-11-05.
 */

public class Options extends AppCompatActivity{
    //public static final String LINE_SEP = System.getProperty("line.separator");
    private int opcje_poziom;// OD 1-6
    Button opcje_but;
    AlertDialog dialog;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sp_editor;
    public Options(Context context){
        sharedPreferences = context.getSharedPreferences("com.example.gariw.chrzszcz", Context.MODE_PRIVATE);
        sp_editor = sharedPreferences.edit();
        opcje_poziom = sharedPreferences.getInt("poziom", 1);


    }


    public void showOptions(final Context context){
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        //LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService
                (LAYOUT_INFLATER_SERVICE);

        final View inflate = inflater.inflate(R.layout.opcje, null);


        zaznaczRadioButton(inflate);
        zaznaczLadowanie(inflate);
        builder.setView(inflate);
        dialog = builder.create();
        opcje_but = (Button) inflate.findViewById(R.id.opcje_ok);

/*
        opcje_but.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


            }


        });

*/

        dialog.show();
    }
    public void endDialog(){
        sp_editor.putInt("poziom",opcje_poziom);
        sp_editor.commit();
        dialog.dismiss();
    }
    public void zaznaczRadioButton(final View inf){
        RadioButton spr;
        spr = (RadioButton) inf.findViewById(R.id.poziom1);
        spr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                opcje_poziom = 1;
            }
        });
        spr = (RadioButton) inf.findViewById(R.id.poziom2);
        spr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                opcje_poziom = 2;
            }
        });
        spr = (RadioButton) inf.findViewById(R.id.poziom3);
        spr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                opcje_poziom = 3;
            }
        });
        spr = (RadioButton) inf.findViewById(R.id.s_u);
        spr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                opcje_poziom = 4;
            }
        });
        spr = (RadioButton) inf.findViewById(R.id.s_h);
        spr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                opcje_poziom = 5;
            }
        });
        spr = (RadioButton) inf.findViewById(R.id.s_z);
        spr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                opcje_poziom = 6;
            }
        });

    }
    public void zaznaczLadowanie(final View inf){
        RadioButton zaznacz;
        switch (opcje_poziom){
            case 1:
                zaznacz = (RadioButton) inf.findViewById(R.id.poziom1);
                zaznacz.setChecked(true);
                break;
            case 2:
                zaznacz = (RadioButton) inf.findViewById(R.id.poziom2);
                zaznacz.setChecked(true);
                break;
            case 3:
                zaznacz = (RadioButton) inf.findViewById(R.id.poziom3);
                zaznacz.setChecked(true);
                break;
            case 4:
                zaznacz = (RadioButton) inf.findViewById(R.id.s_u);
                zaznacz.setChecked(true);
                break;
            case 5:
                zaznacz = (RadioButton) inf.findViewById(R.id.s_h);
                zaznacz.setChecked(true);
                break;
            case 6:
                zaznacz = (RadioButton) inf.findViewById(R.id.s_z);
                zaznacz.setChecked(true);
                break;
            default:
                zaznacz = (RadioButton) inf.findViewById(R.id.poziom1);
                zaznacz.setChecked(true);

                break;
        }
    }
    public int returnPoziom(){return opcje_poziom;}

}
