package com.example.ciberseguridadparatodos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ciberseguridadparatodos.DbUtils.LocalDB;
import com.example.ciberseguridadparatodos.DbUtils.User;

public class LoginActivity extends AppCompatActivity {

    private EditText edUsuario;
    private EditText edPassword;
    private Button btnLogin;
    private Button btnSignup;
    private TextView crearCuenta;

    private final String CREDENCIAL_SHARED_PREF = "our_shared_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edUsuario = findViewById(R.id.id_username);
        edPassword =findViewById(R.id.id_password);
        btnLogin = findViewById(R.id.id_btn_login);
        //btnSignup = findViewById(R.id.id_btn_signup);
        crearCuenta = findViewById(R.id.crear_cuenta);


        crearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*SharedPreferences credentials = getSharedPreferences(CREDENCIAL_SHARED_PREF, Context.MODE_PRIVATE);
                String strUsername = credentials.getString("Username", null);
                String strPassword = credentials.getString("Password", null);*/

                final String username_from_ed = edUsuario.getText().toString();
                final String password_from_ed = edPassword.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LocalDB dbInstance = ciberseguridadparatodos.getmInstance().getDbInstance();
                        User user = dbInstance.userDao().getUserByUsername(username_from_ed);

                        if(user != null && user.getUsername() != null && username_from_ed != null && user.getUsername().equalsIgnoreCase(username_from_ed)) {
                            if (user.getPassword() != null && password_from_ed != null && user.getPassword().equalsIgnoreCase(password_from_ed)) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(LoginActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(LoginActivity.this,PantallaCarga.class);
                                        startActivity(intent);
                                    }
                                });

                            }else{
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(LoginActivity.this, "Usuario y/o Contraseña incorrectos", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            }
                        }else{
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(LoginActivity.this, "Usuario inexistente", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    }
                }).start();

            }
        });
    }
}