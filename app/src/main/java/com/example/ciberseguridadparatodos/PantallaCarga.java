package com.example.ciberseguridadparatodos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PantallaCarga extends AppCompatActivity {

    private ConstraintLayout cargando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_carga);

        cargando = findViewById(R.id.cargando);

        cargando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PantallaCarga.this, Menu_principal.class);
                startActivity(intent);
            }
        });
    }
}