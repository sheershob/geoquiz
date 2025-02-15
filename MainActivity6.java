package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity6 extends AppCompatActivity {
    private int sc;
    private TextView t5,t6;
    Button b1,b2;
    private static final String CHANNEL_ID = "my_channel_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        b1 = findViewById(R.id.button3);
        b2 = findViewById(R.id.button4);
        t6 = findViewById(R.id.textView5);
        t5 = findViewById(R.id.textView6);

        SharedPreferences sharedPref = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        String name = sharedPref.getString("shared_string", "Player");
        t6.setText(name + "'s Score");
        sc = getIntent().getIntExtra("score",0);
        t5.setText(sc + "/3");

        createNotificationChannel();
        sendNotification();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity6.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName = "result.txt";
                String data = name + " : " + sc + "\n";

                FileOutputStream fos = null;
                try {
                    fos = openFileOutput(fileName, MODE_PRIVATE | MODE_APPEND);
                    fos.write(data.getBytes());
                    Toast.makeText(MainActivity6.this, "Score saved", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity6.this, "Failed to save data", Toast.LENGTH_SHORT).show();
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
        private void createNotificationChannel() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence Name = "My Channel";
                String description = "Channel for My Notifications";
                int importance = NotificationManager.IMPORTANCE_DEFAULT;
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, Name, importance);
                channel.setDescription(description);


                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(channel);
            }
        }
        private void sendNotification(){
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_launcher_foreground) 
                    .setContentTitle("My Notification")
                    .setContentText("Thank you for playing.")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            int notificationId = 1;
            notificationManager.notify(notificationId, builder.build());
        }
    }