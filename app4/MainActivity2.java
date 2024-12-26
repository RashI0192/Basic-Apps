package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        Button button2 = findViewById(R.id.button2);
        //receiving intent.getExtra
        Intent i = getIntent();
        String username=i.getStringExtra("name");
        int diceNum = genDice();
        textView3.setText(""+diceNum);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(username,diceNum);
            }
        });


    }
    public int genDice(){
        Random random=new Random();
        int upperLimit=6;
        int diceNum= random.nextInt(upperLimit);
        return diceNum;

    }
    public void shareData(String username,int diceNum){
        //implicit
        Intent i = new Intent(Intent.ACTION_SEND);//action to send to other application
        i.setType("text/plain");
        //aditional info
        i.putExtra(Intent.EXTRA_SUBJECT,username+" rolled the dice! ");
        i.putExtra(Intent.EXTRA_TEXT,"The shows "+diceNum);

        startActivity(Intent.createChooser(i,"Choose a Platform"));//which application use


    }
}