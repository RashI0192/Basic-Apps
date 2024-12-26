package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button button;

    TextView text1;
    EditText text2;
    TextView poundT;




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

        text1=findViewById(R.id.text1);//just display
        text2=findViewById(R.id.text2);
        button=findViewById(R.id.button);
        poundT=findViewById(R.id.poundT);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText=text2.getText().toString();//when we click , get this text
                //convert into double for the function
                double kilos = Double.parseDouble(inputText);
                double pounds = makeConversion(kilos);
                //display
                poundT.setText(""+pounds+ " Pounds");




            }
        });



    }
    public double makeConversion(double kilos){//always define  outside main activity class
        return(kilos*2.20462);
    }

}