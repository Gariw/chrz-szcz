package com.example.gariw.chrzszcz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuTrening extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trening);
    }
    public void wroc(View view)
    {
        this.finish();
    }

    public void test(View view) {
        Intent intent = new Intent(this, Trening.class);
        startActivity(intent);
    }
}
