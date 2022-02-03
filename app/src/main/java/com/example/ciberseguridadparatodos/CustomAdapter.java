package com.example.ciberseguridadparatodos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<AplicacionesUsuario> aplicacionesArrayList;

    public CustomAdapter(Context context, ArrayList<AplicacionesUsuario> aplicacionesArrayList) {
        this.context = context;
        this.aplicacionesArrayList = aplicacionesArrayList;
    }

    @Override
    public int getCount() {
        if (aplicacionesArrayList != null && aplicacionesArrayList.size() > 0){
            return aplicacionesArrayList.size();
        }else{
            return 0;
        }

    }

    @Override
    public Object getItem(int position) {
        return aplicacionesArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.aplicacion_list_item,viewGroup, false);
        }

        LinearLayout appsLayout = view.findViewById(R.id.aplicaciones_layout);

        TextView txtAppName = view.findViewById(R.id.tv_nombre_app);
        TextView txtAppClave = view.findViewById(R.id.tv_clave_app);

        txtAppName.setText(aplicacionesArrayList.get(i).getNombreApp());


        appsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtAppClave.setText("Clave: " + aplicacionesArrayList.get(i).getClaveApp());
                //Toast.makeText(context, "Clicked " + aplicacionesArrayList.get(i).getClaveApp(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}

