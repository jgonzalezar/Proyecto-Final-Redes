package com.example.ciberseguridadparatodos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Menu_principal extends AppCompatActivity {

    private Button escanearTel;
    private Button adminClaves;

    private final int CAPTURE_IMAGE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        escanearTel = findViewById(R.id.btn_escanear_telefono);
        adminClaves = findViewById(R.id.btn_admin_claves);

        escanearTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu_principal.this, TipoScanner.class);
                startActivity(intent);
            }
        });

        adminClaves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu_principal.this, OpcionesAdminClaves.class);
                startActivity(intent);
            }
        });
    }

/*    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CAPTURE_IMAGE){
            if(data != null && data.getExtras() != null) {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                imgImagen.setImageBitmap(bitmap);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }*/
}