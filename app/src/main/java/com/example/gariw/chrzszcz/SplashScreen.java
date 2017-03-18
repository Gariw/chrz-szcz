package com.example.gariw.chrzszcz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SplashScreen extends Activity {

    private static final int CZAS = 700;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        // Uruchom wątek otwierający główną aktywność
        ActivityStarter starter = new ActivityStarter();
        starter.start();
    }

    private class ActivityStarter extends Thread {

        @Override
        public void run() {
            try {
                // tutaj wrzucamy wszystkie akcje potrzebne podczas ładowania aplikacji
                Thread.sleep(CZAS);
            } catch (Exception e) {
                Log.e("SplashScreen", e.getMessage());
            }

            // Włącz główną aktywność
            Intent intent = new Intent(SplashScreen.this, MainMenu.class);
            SplashScreen.this.startActivity(intent);
            SplashScreen.this.finish();
        }
    }

}