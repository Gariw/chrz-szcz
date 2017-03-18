package com.example.gariw.chrzszcz;


import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Gariw on 2016-12-21.
 */

public class Slowniczek extends ListActivity {
    private static int BAZA = 62585;
    String[] words;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_slowniczek);
        words = new String[BAZA];
        Open_DB w = new Open_DB();
        Cursor c = w.db(this);
        c.moveToNext();
        for (int i = 0; i < BAZA; i++) {
            words[i] = c.getString(1);
            c.moveToNext();
        }




        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_slowniczek,words));

        ListView listView = getListView();
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void wroc(View view) {
        this.finish();
    }

}
