package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView t3;
    private Button b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t3 = findViewById(R.id.textView4);
        String s = getIntent().getStringExtra("name");
        SharedPreferences sharedPref = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        s = sharedPref.getString("shared_string", "Player");
        t3.setText("Welcome " + s + " !");
        b3 = findViewById(R.id.button2);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(i);
            }
        });
    }
}