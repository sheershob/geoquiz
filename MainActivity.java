package com.example.geoquiz;

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
import androidx.appcompat.app.AlertDialog;

import java.util.*;

public class MainActivity extends AppCompatActivity {
    private TextView t1;
    private Button b1;
    private EditText e1,e2;
    private int incorrect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button);
        t1 = findViewById(R.id.textView2);
        e1 = findViewById(R.id.editTextNumber);
        e2 = findViewById(R.id.editTextText);
        Random random = new Random();
        int n = random.nextInt(10);
        t1.setText(String.valueOf(n));
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int key;
                if(e1.getText().toString().equals("")){
                    key = 0;
                }
                else
                key = Integer.parseInt(e1.getText().toString());
                if(key == n*n){
                    SharedPreferences sharedPref = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("shared_string", e2.getText().toString());
                    editor.apply();
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra("name",e2.getText().toString());
                    startActivity(i);
                }
                else {
                    if(incorrect >= 3){
                        finishAffinity();
                    }
                    incorrect++;
                    Toast.makeText(MainActivity.this, (4 - incorrect) + " Tries remaining.", Toast.LENGTH_LONG).show();
                }
            }
        });
//        private void showAlert(String message) {
//            new AlertDialog.Builder(this)
//                    .setTitle("Alert")
//                    .setMessage(message)
//                    .setPositiveButton("OK", null)
//                    .show();
    }

}