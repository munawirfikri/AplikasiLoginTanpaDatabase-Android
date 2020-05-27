package com.munawirfikri.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private EditText email, password;
    private Button button_login, button_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent i = getIntent();
        final Bundle bundle = i.getExtras();

        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        button_login = findViewById(R.id.btn_login);
        button_register = findViewById(R.id.btn_register);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = email.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if (bundle != null) {
                    String nama = (String) bundle.get("nama");
                    String emailUser = (String) bundle.get("email");
                    String passwordUser = (String) bundle.get("password");
                    String web = (String) bundle.get("web");

                    if (user.equals(emailUser) && pass.equals(passwordUser)) {
                        Intent i = new Intent (LoginActivity.this, WelcomeActivity.class);
                        i.putExtra("nama", nama);
                        i.putExtra("email", emailUser);
                        i.putExtra("web", web);
                        startActivity(i);
                    }else {
                        Toast.makeText(LoginActivity.this, "Username atau password salah", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onClick: "+user+" "+pass);
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "Silahkan register terlebih dahulu", Toast.LENGTH_SHORT).show();
                }


            }
        });

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}
