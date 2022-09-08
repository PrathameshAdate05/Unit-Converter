package com.prathamesh.unit_converter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    CardView CDTime, CDTemperature, CDWeight, CDLength;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        CDLength = findViewById(R.id.CARD_Length);
        CDTemperature = findViewById(R.id.CARD_Temperature);
        CDTime = findViewById(R.id.CARD_Time);
        CDWeight = findViewById(R.id.CARD_Weight);

        CDWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Home.this,Weight.class);
                startActivity(intent);
            }
        });

        CDTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Home.this,Time.class);
                startActivity(intent);
            }
        });

        CDTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Home.this,Temperature.class);
                startActivity(intent);
            }
        });

        CDLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Home.this,Length.class);
                startActivity(intent);
            }
        });
    }
}