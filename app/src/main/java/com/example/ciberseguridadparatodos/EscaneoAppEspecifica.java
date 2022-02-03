package com.example.ciberseguridadparatodos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class EscaneoAppEspecifica extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escaneo_app_especifica);

        listView = findViewById(R.id.id_list_view);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.aplicaciones_usuario));
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(EscaneoAppEspecifica.this, listView.getItemAtPosition(i)+" ", Toast.LENGTH_SHORT).show();
                if(listView.getItemAtPosition(i).toString().equalsIgnoreCase("Nequi")){
                    Intent intent = new Intent(EscaneoAppEspecifica.this, EscaneandoApp.class);
                    startActivity(intent);
                }
            }
        });


    }
}