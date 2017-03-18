package com.example.gariw.chrzszcz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
    }
    public void test(View view) {
        Intent intent = new Intent(this, Trening.class);
        startActivity(intent);
    }
    public void finito(View view)
    {
        System.exit(0);
    }

    public void reguly(View view){
        Intent intent = new Intent(this, Reguly.class);
        startActivity(intent);
    }
    public void slowniczek(View view) {
        Intent intent = new Intent(this, Slowniczek.class);
        startActivity(intent);
    }
}
