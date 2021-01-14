package com.erensaridag.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
         final ArrayList<String> landmarkName = new ArrayList<>();
        landmarkName.add("Pisa");
        landmarkName.add("Eiffel");
        landmarkName.add("Coliseum");
        landmarkName.add("Istanbul");



         final ArrayList<String> countryName = new ArrayList<>();
        countryName.add("Italy");
        countryName.add("France");
        countryName.add("Italy");
        countryName.add("Turkey");

         Bitmap pisa = BitmapFactory.decodeResource(getApplication().getResources(), R.drawable.pisa);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplication().getResources(), R.drawable.eiffel);
        Bitmap coliseum = BitmapFactory.decodeResource(getApplication().getResources(), R.drawable.coliseum);
        Bitmap istanbul = BitmapFactory.decodeResource(getApplication().getResources(), R.drawable.istanbul);

         final ArrayList<Bitmap> landmarkİmages = new ArrayList<>();
        landmarkİmages.add(pisa);
        landmarkİmages.add(eiffel);
        landmarkİmages.add(coliseum);
        landmarkİmages.add(istanbul);

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, landmarkName);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("name",landmarkName.get(position));
                intent.putExtra("country",countryName.get(position));
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(landmarkİmages.get(position));


                startActivity(intent);

            }
        });

    }
}