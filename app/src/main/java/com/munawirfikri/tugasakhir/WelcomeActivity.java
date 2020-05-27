package com.munawirfikri.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    private TextView tv_nama, tv_email, tv_web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        tv_nama = findViewById(R.id.tv_nama);
        tv_email = findViewById(R.id.tv_email);
        tv_web = findViewById(R.id.tv_web);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String nama = (String) bundle.get("nama");
        String email = (String) bundle.get("email");
        String web = (String) bundle.get("web");

        tv_nama.setText(nama);
        tv_email.setText(email);
        tv_web.setText(web);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent( WelcomeActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },1250);

    }
}
