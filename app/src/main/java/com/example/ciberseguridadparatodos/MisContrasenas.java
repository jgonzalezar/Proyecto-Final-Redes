package com.example.ciberseguridadparatodos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MisContrasenas extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_contrasenas);

        listView = findViewById(R.id.id_list_view);

        CustomAdapter adapter = new CustomAdapter(this, getAplicaciones());
        listView.setAdapter(adapter);
    }

    private ArrayList<AplicacionesUsuario> getAplicaciones(){
        AplicacionesUsuario app = new AplicacionesUsuario();
        app.setNombreApp("Nequi");
        app.setClaveApp("1234");

        AplicacionesUsuario app2 = new AplicacionesUsuario();
        app2.setNombreApp("BBVA Movil");
        app2.setClaveApp("3578");

        AplicacionesUsuario app3 = new AplicacionesUsuario();
        app3.setNombreApp("Facebook");
        app3.setClaveApp("123456");

        AplicacionesUsuario app4 = new AplicacionesUsuario();
        app4.setNombreApp("Mensajería");
        app4.setClaveApp("1210");

        AplicacionesUsuario app5 = new AplicacionesUsuario();
        app5.setNombreApp("Galeria");
        app5.setClaveApp("1234567");

        ArrayList<AplicacionesUsuario> apps = new ArrayList<>();
        apps.add(app);
        apps.add(app2);
        apps.add(app3);
        apps.add(app4);
        apps.add(app5);

        return apps;
    }
}