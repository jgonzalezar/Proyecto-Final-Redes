package com.example.ciberseguridadparatodos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TipoScanner extends AppCompatActivity {

    private Button btnEscaneoRapido;
    private Button btnEscaneoApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_scanner);

        btnEscaneoRapido = findViewById(R.id.btn_escaneo_rapido);
        btnEscaneoApp = findViewById(R.id.btn_Escanear_una_App);

        btnEscaneoApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TipoScanner.this, EscaneoAppEspecifica.class);
                startActivity(intent);
            }
        });

        btnEscaneoRapido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(TipoScanner.this, EscaneoRapido.class);
                startActivity(intento);
            }
        });
    }
}