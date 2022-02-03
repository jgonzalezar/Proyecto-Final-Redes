package com.example.ciberseguridadparatodos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OpcionesAdminClaves extends AppCompatActivity {

    private Button generarContrasena;
    private Button analizarContrasena;
    private Button misContrasenas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_admin_claves);

        generarContrasena = findViewById(R.id.btn_Generar_contrasena);
        analizarContrasena = findViewById(R.id.btn_Analizar_contrasena);
        misContrasenas = findViewById(R.id.btn_mis_contrasenasp);

        misContrasenas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OpcionesAdminClaves.this, MisContrasenas.class);
                startActivity(intent);
            }
        });

        generarContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OpcionesAdminClaves.this, GenerarContrasena.class);
                startActivity(intent);
            }
        });

        analizarContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OpcionesAdminClaves.this, AnalizadorContrasena.class);
                startActivity(intent);
            }
        });
    }
}