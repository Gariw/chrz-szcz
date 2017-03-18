package com.example.gariw.chrzszcz;


import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static java.lang.Math.abs;


public class Trening extends AppCompatActivity{
    private static int BAZA = 62585;
    Click_Button [] tab_c_but;//przechowuje adresy click_button w danym slowku
    Options options;
    Word word;
    Cursor c;
    int poziom;
    Random generator;
    //int [] check_all;//sprawdza czy wszystkie pozycje są wybrane;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        options = new Options(this);

        poziom = options.returnPoziom();
        generator = new Random();
        Open_DB w = new Open_DB();
        c = w.db(Trening.this);

        loadActivity();

    }

    public void loadActivity(){
        setContentView(R.layout.activity_trening);
        int los = generator.nextInt(BAZA);
        c.moveToFirst();
        c.moveToPosition(los);
        //for (int i = 0; i < los +1; i++) {
        //  c.moveToNext();
        //}
        word = new Word(c.getInt(0), c.getString(1), c.getInt(2), c.getString(3), c.getString(4),c.getString(5), poziom);
        word.checkWord(c);
        String [] nazw = new String[2];

        nazw[0] = word.getWord();
        nazw[1] = word.getPositions();

        choice_button();
        choice(nazw[0], nazw[1]);


    }
    //ustawienie przycisków do obslugi wyswietlania np rz
    private void choice_button(){
        TableLayout table = (TableLayout) findViewById(R.id.tableChoice);

        TableRow tableRow = new TableRow(this);
        tableRow.setGravity(Gravity.CENTER);
        tableRow.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.MATCH_PARENT,
                1.0f));
        for(int i = 0; i < 2; i++){
            Button button = new Button(this);
            button.setId(i);

            button.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.MATCH_PARENT,
                    1.0f));
            button.setBackgroundColor(Color.GRAY);
            tableRow.addView(button);

        }
        assert table != null;
        table.addView(tableRow);
    }
    //funkcja : wypisywanie slowek, zamiana liter na kwadraty,
    private void choice(String w, String p) {
        int i = 0;
        final Button but_1 = (Button) findViewById(i);
        i++;
        final Button but_2 = (Button) findViewById(i);

        String poz[] = p.split(" ",10);
        TableLayout table = (TableLayout) findViewById(R.id.tableWords);

        TableRow tableRow = new TableRow(this);
        tableRow.setGravity(Gravity.CENTER);
        assert table != null;
        table.addView(tableRow);
        TextView text;


        int wspornik = 0;
        int pozycja;
        int stara_poz = 0;
        String wypisz = "";
        int sprawdz = 0;

        if(poz[0] != null){
            int ile_or = poz.length;
            tab_c_but = new Click_Button[ile_or];

            int j = 0;
            for (String aPoz : poz) {
                if (aPoz.substring(0, 1).equals("-")) {
                    wspornik = 1;
                }
                pozycja = Integer.parseInt(aPoz);
                pozycja = abs(pozycja);
                for (i = stara_poz; i < w.length(); i++) {
                    if (i == pozycja) {
                        text = new TextView(this);
                        text.setText(wypisz);
                        text.setTextSize(30);
                        tableRow.addView(text);
                        wypisz = "";
                        Click_Button c_button;
                        if (wspornik == 1) {
                            c_button  = new Click_Button(this, but_1, but_2, w.substring(i, i + 2));
                            ++i;
                        }else{
                            c_button  = new Click_Button(this, but_1, but_2, w.substring(i, i + 1));
                        }
                        c_button.r_bud().setLayoutParams (new TableRow.LayoutParams(100, 100));
                        tableRow.addView(c_button.r_bud());
                        tab_c_but[j] = c_button;
                        j++;
                        stara_poz = i;
                        ++sprawdz;
                        wspornik = 0;
                        if(sprawdz != poz.length) {
                            stara_poz++;
                            break;
                        }
                    } else {
                        wypisz += w.substring(i, i + 1);
                    }
                }
                if (!wypisz.equals("")) {
                    text = new TextView(this);
                    text.setText(wypisz);
                    text.setTextSize(30);
                    tableRow.addView(text);
                    wypisz = "";
                }
            }
        }else{
                text = new TextView(this);
                text.setText(w);
                text.setTextSize(30);
                tableRow.addView(text);
            }
    }
    public void spr_dal(View view){
        Button but_1 = (Button) findViewById(R.id.button_spr_dal);
        assert but_1 != null;
        String slowo = (String) but_1.getText();
        if(slowo.equals("SPRAWDŹ") ){
            int check_all = 0;
            for(Click_Button aTAB_c_but :tab_c_but){
                check_all += aTAB_c_but.checkAll();
            }
            if (check_all != tab_c_but.length) {
                Toast.makeText(Trening.this, "zaznacz wszystkie", Toast.LENGTH_SHORT).show();
            } else {
                for (Click_Button aTab_c_but : tab_c_but) {
                    aTab_c_but.checkCorrect();
                }
                but_1.setText("DALEJ");
            }
        }else{
            but_1.setText("SPRAWDŹ");
            loadActivity();
        }



    }
   public void showDialog(View view){

       options.showOptions(this);
       Button opcjeOK = options.opcje_but;
       opcjeOK.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               poziom = options.returnPoziom();
               loadActivity();
               options.endDialog();
           }
       });

   }
    public void wstecz(View view){
        this.finish();
    }
}