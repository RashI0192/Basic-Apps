package com.example.germanteachingapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button blue, white, black, redB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        blue = findViewById(R.id.blue);
        white = findViewById(R.id.white);
        black = findViewById(R.id.black);
        redB = findViewById(R.id.redB);

        // Setting up OnClickListener for all buttons
        redB.setOnClickListener(this);
        black.setOnClickListener(this);
        blue.setOnClickListener(this);
        white.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Find the button by ID and play the correct sound
        int clickedBtnId = v.getId();

        if (clickedBtnId == R.id.redB) {
            PlaySounds(R.raw.red);
        } else if (clickedBtnId == R.id.black) {
            PlaySounds(R.raw.black);
        } else if (clickedBtnId == R.id.white) {
            PlaySounds(R.raw.white);
        } else if (clickedBtnId == R.id.blue) {
            PlaySounds(R.raw.blue);
        }
    }

    public void PlaySounds(int id) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, id);
        mediaPlayer.start();
    }
}
