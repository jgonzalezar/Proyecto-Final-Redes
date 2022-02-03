package com.example.ciberseguridadparatodos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ciberseguridadparatodos.DbUtils.LocalDB;
import com.example.ciberseguridadparatodos.DbUtils.User;

public class SignUpActivity extends AppCompatActivity {

    private EditText edUsername;
    private EditText edPassword;
    private EditText edConfirmPass;
    private Button btnCreateUser;
    private TextView yaTieneCuenta;

    private final String CREDENCIAL_SHARED_PREF = "our_shared_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edUsername = findViewById(R.id.ed_username);
        edPassword = findViewById(R.id.ed_password);
        edConfirmPass = findViewById(R.id.ed_condirm_password);
        btnCreateUser = findViewById(R.id.id_btn_create_user);
        yaTieneCuenta = findViewById(R.id.crear_cuenta);

        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strPassword = edPassword.getText().toString();
                String strConfirmPassword = edConfirmPass.getText().toString();
                String strUsername = edUsername.getText().toString();

                if(strPassword!= null && strConfirmPassword != null && strPassword.equalsIgnoreCase(strConfirmPassword)){
/*                    SharedPreferences credentials = getSharedPreferences(CREDENCIAL_SHARED_PREF, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = credentials.edit();
                    editor.putString("Password", strPassword);
                    editor.putString("Username", strUsername);
                    editor.commit();
*/
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            User user = new User();
                            user.setUsername(strUsername);
                            user.setPassword(strPassword);
                            LocalDB dbInstance = ciberseguridadparatodos.getmInstance().getDbInstance();
                            dbInstance.userDao().createUser(user);
                        }
                    }).start();
                    SignUpActivity.this.finish();
                }else{
                    Toast.makeText(SignUpActivity.this, "Llene ien los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        yaTieneCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}