package com.example.gariw.chrzszcz;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Gariw on 2016-12-19.
 */

public class Reguly extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reguly);
    }

    public  void regulyU(View view){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        LayoutInflater inflater = (LayoutInflater)getSystemService
                (LAYOUT_INFLATER_SERVICE);

        final View inflate = inflater.inflate(R.layout.reguly, null);
        TextView textView = (TextView) inflate.findViewById(R.id.regulyTresc);
        textView.setText("U piszemy  na początku wyrazów.  \nWyjątki: ówcześnie, ówdzie, ówczesny, ósmy, ósemka, ów \n U piszemy zawsze na końcu wyrazu np.: stołu. \n U piszemy w czasownikach zakończonych na uj, ujesz i uje np.: zapoluje. \n\n Ó piszemy gdy wymienia sie w innych formach tego samego wyrazu na o, e, a np.: powóz - powozy \n Ó piszemy w wyrazach zakończnych na ów, ówna: ogrów, Nowakówna, oraz ówka: kreskówka \nWyjątki skuwka, wsuwka, zasuwka");
        AlertDialog dialog;
        builder.setView(inflate);
        dialog = builder.create();

        dialog.show();
    }

    public  void regulyH(View view){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        LayoutInflater inflater = (LayoutInflater)getSystemService
                (LAYOUT_INFLATER_SERVICE);

        final View inflate = inflater.inflate(R.layout.reguly, null);
        TextView textView = (TextView) inflate.findViewById(R.id.regulyTresc);
        textView.setText("Ch piszemy gdy wymienia się w innych formach tego samego typu na sz np.: mucha - muszka  \nCh piszemy po literze s np.: schab, schody\n Ch piszemy na końcu wyrazów np.: orzech\nWyjatki: druh\n\n H piszemy gdy wymienia sie w innych formach tego samego wyrazu na g, ż, z, dz np: druh - drużyna");
        AlertDialog dialog;
        builder.setView(inflate);
        dialog = builder.create();

        dialog.show();
    }
    public  void regulyZ(View view){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        LayoutInflater inflater = (LayoutInflater)getSystemService
                (LAYOUT_INFLATER_SERVICE);

        final View inflate = inflater.inflate(R.layout.reguly, null);
        TextView textView = (TextView) inflate.findViewById(R.id.regulyTresc);
        textView.setText("RZ piszemy gdy wymienia się w innych formach tego samego typu na r np.:rowerzysta - rower \nRZ piszemy w zakończeniach wyrazów: arz, erz, mierz, mistrz np.: pisarz\nRZ piszemy po spółgłoskach: b, p, d, t, g, k, ch, j, w np.: brzeg, ujrzeć\nWyjątki: gżegzółka, piegża\n\nŻ piszemy gdy wymienia się w innych formach tego samego typu na g, dz, h, ź, s np.: książka - księga \nŻ piszemy po literach l, ł, r, n np.: lżej");
        AlertDialog dialog;
        builder.setView(inflate);
        dialog = builder.create();

        dialog.show();
    }

    public void finito(View view)
    {
        this.finish();
    }
}
