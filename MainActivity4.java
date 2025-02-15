package com.example.geoquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    private TextView countdownText, questionText;
    private Button option1, option2, option3, option4;
    private CountDownTimer countDownTimer;
    private int sc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        countdownText = findViewById(R.id.countdown_text);
        questionText = findViewById(R.id.question_text);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        sc = getIntent().getIntExtra("score",0);

        questionText.setText("What is the capital of South Africa?");
        option1.setText("Johannesburg");
        option2.setText("Victoria");
        option3.setText("Durban");
        option4.setText("Pretoria");

        View.OnClickListener answerListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer((Button) v);
            }
        };

        option1.setOnClickListener(answerListener);
        option2.setOnClickListener(answerListener);
        option3.setOnClickListener(answerListener);
        option4.setOnClickListener(answerListener);

        // Create a 30-second countdown timer
        countDownTimer = new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                countdownText.setText("Seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                countdownText.setText("Time's up!");
                goToNextActivity();
            }
        };
        // Start the countdown timer
        countDownTimer.start();
    }

    private void checkAnswer(Button selectedButton) {
        String answer = selectedButton.getText().toString();
        if (answer.equals("Pretoria")) {
            sc++;
            MediaPlayer mp = MediaPlayer.create(this,R.raw.correct_sound_effect);
            mp.start();
            option4.setBackgroundColor(Color.GREEN);
            Toast.makeText(this, "Correct!", Toast.LENGTH_LONG).show();
        } else {
            MediaPlayer mp = MediaPlayer.create(this,R.raw.wrong_sound_effect);
            mp.start();
            selectedButton.setBackgroundColor(Color.RED);
            Toast.makeText(this, "Wrong answer!", Toast.LENGTH_LONG).show();
        }
        countDownTimer.cancel(); // Cancel the timer
        goToNextActivity();
    }

    private void goToNextActivity() {
        Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
        intent.putExtra("score",sc);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
