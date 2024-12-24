package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });//error detection
        //creating a refrence to our textview
        TextView hello=findViewById(R.id.hello);
        //edit text is for user inputs
        EditText entername=findViewById(R.id.entername);
        String inputText = entername.getText().toString();

        Button myButton = findViewById(R.id.myButton);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When the button is clicked, show a Toast
                String inputText = entername.getText().toString();  // Read input text on click
                Toast.makeText(MainActivity.this, "Hello, " + inputText, Toast.LENGTH_SHORT).show();
            }
        });

        ImageView myImage=findViewById(R.id.myImage);
        myImage.setImageResource(R.drawable.pic);





    }
}