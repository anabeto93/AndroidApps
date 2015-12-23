package com.example.richard.loginscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class NameLists extends AppCompatActivity {

    private static ListView list_view;
    private static String[] NAMES= new String[] {"Richard","Momi","Gabriel","Opare","Melvin"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_lists);

        listViews();

    }
    public void listViews(){
        list_view = (ListView) findViewById(R.id.lv_names);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.user_name_lists,NAMES);
        list_view.setAdapter(adapter);

        list_view.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String value= (String) list_view.getItemAtPosition(i);
                        Toast.makeText(NameLists.this,"Position: "+(i+1)+" Value: "+value,
                                Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

}
