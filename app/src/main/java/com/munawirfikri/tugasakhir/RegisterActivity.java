package com.munawirfikri.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText reg_nama, reg_email, reg_password, reg_web;
    private Button btn_daftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        reg_nama = findViewById(R.id.reg_nama);
        reg_email = findViewById(R.id.reg_email);
        reg_password = findViewById(R.id.reg_password);
        reg_web = findViewById(R.id.reg_web);

        btn_daftar = findViewById(R.id.btn_daftar);

        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (reg_nama.getText().toString().isEmpty() || reg_email.getText().toString().isEmpty() || reg_password.getText().toString().isEmpty() || reg_web.getText().toString().isEmpty() )
                {
                    Toast.makeText(RegisterActivity.this, "Silahkan isi semua field", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    String nama = reg_nama.getText().toString();
                    String email = reg_email.getText().toString();
                    String password = reg_password.getText().toString();
                    String web = reg_web.getText().toString();

                    intent.putExtra("nama", nama);
                    intent.putExtra("email", email);
                    intent.putExtra("password", password);
                    intent.putExtra("web", web);
                    startActivity(intent);
                }
            }
        });

    }
}
