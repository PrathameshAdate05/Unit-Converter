package com.prathamesh.unit_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Time extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView TVOutput;
    EditText ETInput;
    Spinner inputSpinner, outputSpinner;
    Button BTNConvert;
    int input = 0, output = 0;
    double answer;

    String[] times = {"Hours", "Minutes", "Seconds"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        TVOutput = findViewById(R.id.TV_Output_Time);
        ETInput = findViewById(R.id.ET_InputTime);
        inputSpinner = findViewById(R.id.SpinnerInputTime);
        outputSpinner = findViewById(R.id.SpinnerOutputTime);
        BTNConvert = findViewById(R.id.BTN_ConvertTime);

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,times);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputSpinner.setAdapter(adapter);
        outputSpinner.setAdapter(adapter);
        inputSpinner.setOnItemSelectedListener(this);
        outputSpinner.setOnItemSelectedListener(this);

        BTNConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ETInput.getText().toString().equals("")){
                    ETInput.setError("Enter Input");
                    return;
                }else {
                    if (input == output)
                        answer = Double.parseDouble(ETInput.getText().toString());

                    // hour to others
                    else if (input == 0 && output == 1)
                        answer = Double.parseDouble(ETInput.getText().toString()) * 60;
                    else if (input == 0 && output == 2)
                        answer = Double.parseDouble(ETInput.getText().toString()) * 3600;

                    // minutes to others
                    else if (input == 1 && output == 0)
                        answer = Double.parseDouble(ETInput.getText().toString()) / 60;
                    else if (input == 1 && output == 2)
                        answer = Double.parseDouble(ETInput.getText().toString()) * 60;

                    // seconds to others
                    else if (input == 2 && output == 0)
                        answer = Double.parseDouble(ETInput.getText().toString()) / 3600;
                    else if (input == 2 && output == 1)
                        answer = Double.parseDouble(ETInput.getText().toString()) / 60;

                    TVOutput.setText(String.valueOf(answer));
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getId() == R.id.SpinnerInputTime)
            input = i;
        else
            output = i;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}