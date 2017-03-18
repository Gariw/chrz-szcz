package com.example.gariw.chrzszcz;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static android.graphics.Color.GRAY;
import static android.graphics.Color.CYAN;
import static android.graphics.Color.GREEN;

/**
 * Created by Gariw on 2016-11-09.
 */
/**************************
 * legenda

 10: ch, h  11
 20: rz, ż  21
 30: u, ó   31
 40: en, ę  41
 50: on, ą  51
 60: ci, ć  61
 70: ni, ń  71
 80: si, ś  81
 90: zi, ź  91


*/
public class Click_Button extends AppCompatActivity {
    private Button button;
    private Button choice_1;
    private Button choice_2;
    private String znak;
    private boolean block;
    private int poprawny;
    private int wybrany;
    private int col_butt_1; //zmienna przechowywująca kolor przycisku 1;
    private int col_butt_2; //zmienna przechowywująca kolor przycisku 2;
    private Options opcje;
    public Click_Button(Context context, Button b1, Button b2, String z){
        button = new Button(context);
        choice_1 = b1;
        choice_2 = b2;
        znak = z;
        block = false;
        wybrany = -1;
        sprawdz_znak();
        col_butt_1 = GRAY;
        col_butt_2 = GRAY;
        String ch_1 = null;
        String ch_2 = null;

        if(poprawny/10 == 1){
            ch_1 = "ch";
            ch_2 = "h";
        }else if(poprawny/10 == 2){
            ch_1 = "rz";
            ch_2 = "ż";
        }else if(poprawny/10 == 3){
            ch_1 = "u";
            ch_2 = "ó";
        }else if(poprawny/10 == 4){
            ch_1 = "en";
            ch_2 = "ę";
        }else if(poprawny/10 == 5){
            ch_1 = "on";
            ch_2 = "ą";
        }else if(poprawny/10 == 6){
            ch_1 = "ci";
            ch_2 = "ć";
        }else if(poprawny/10 == 7){
            ch_1 = "ni";
            ch_2 = "ń";
        }else if(poprawny/10 == 8){
            ch_1 = "si";
            ch_2 = "ś";
        }else if(poprawny/10 == 9){
            ch_1 = "zi";
            ch_2 = "ź";
        }
        final String finalCh_1 = ch_1;
        final String finalCh_2 = ch_2;
        button.setTextSize(15);
        button.setPadding(0,0,0,0);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                choice_1.setText(finalCh_1);
                choice_2.setText(finalCh_2);
                choice_1.setBackgroundColor(col_butt_1);
                choice_2.setBackgroundColor(col_butt_2);
                if(!block) {

                    choice_1.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            col_butt_1 = CYAN;
                            col_butt_2 = GRAY;
                            choice_1.setBackgroundColor(col_butt_1);
                            choice_2.setBackgroundColor(col_butt_2);
                            button.setText(finalCh_1);
                            wybrany = 0;
                        }
                    });
                    choice_2.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            col_butt_1 = GRAY;
                            col_butt_2 = CYAN;
                            choice_1.setBackgroundColor(col_butt_1);
                            choice_2.setBackgroundColor(col_butt_2);
                            button.setText(finalCh_2);
                            wybrany = 1;
                        }
                    });
                }

            }
        });

    }

    private void sprawdz_znak(){
        switch (znak) {
            case "ch":
                poprawny = 10;
                break;
            case "h":
                poprawny = 11;
                break;
            case "rz":
                poprawny = 20;
                break;
            case "ż":
                poprawny = 21;
                break;
            case "u":
                poprawny = 30;
                break;
            case "ó":
                poprawny = 31;
                break;
            case "en":
                poprawny = 40;
                break;
            case "ę":
                poprawny = 41;
                break;
            case "on":
                poprawny = 50;
                break;
            case "ą":
                poprawny = 51;
                break;
            case "ci":
                poprawny = 60;
                break;
            case "ć":
                poprawny = 61;
                break;
            case "ni":
                poprawny = 70;
                break;
            case "ń":
                poprawny = 71;
                break;
            case "si":
                poprawny = 80;
                break;
            case "ś":
                poprawny = 81;
                break;
            case "zi":
                poprawny = 90;
                break;
            case "ź":
                poprawny = 91;
                break;
        }
    }

    public int checkCorrect(){
        if(wybrany == (poprawny%10)){
            button.setBackgroundColor(GREEN);
        }else{
            button.setBackgroundColor(Color.RED);
        }
        block = true;
        choice_1.setClickable(false);
        choice_2.setClickable(false);
        if(poprawny%10 == 0){

            col_butt_1 = GREEN;
        }
        else{

            col_butt_2 = GREEN;
        }
        choice_1.setBackgroundColor(col_butt_1);
        choice_2.setBackgroundColor(col_butt_2);

        return poprawny;
    }
    public int checkAll(){
      if(wybrany != -1) {
          return 1;
      }
      return 0;
    }
    public Button r_bud(){return button;}
}
