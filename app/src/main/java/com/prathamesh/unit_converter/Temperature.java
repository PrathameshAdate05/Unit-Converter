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

public class Temperature extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView TVOutput;
    EditText ETInput;
    Spinner inputSpinner, outputSpinner;
    Button BTNConvert;
    int input = 0, output = 0;
    double answer;

    String[] temperatures = {"Celsius","Fahrenheit","Kelvin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        TVOutput = findViewById(R.id.TV_Output_Temperature);
        ETInput = findViewById(R.id.ET_InputTemperature);
        inputSpinner = findViewById(R.id.SpinnerInputTemperature);
        outputSpinner = findViewById(R.id.SpinnerOutputTemperature);
        BTNConvert = findViewById(R.id.BTN_ConvertTemperature);

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,temperatures);
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
                }else{

                    if (input == output)
                        answer = Double.parseDouble(ETInput.getText().toString());

                    // celsius to others
                    else if (input == 0 && output == 1)
                        answer = (1.8 * Double.parseDouble(ETInput.getText().toString())) + 32;
                    else if (input == 0 && output == 2)
                        answer = Double.parseDouble(ETInput.getText().toString()) + 273.15;

                    // Fahrenheit to others
                    else if (input == 1 && output == 0)
                        answer = (0.55) * (Double.parseDouble(ETInput.getText().toString()) - 32);
                    else if (input == 1 && output == 2)
                        answer = ((0.55) * (Double.parseDouble(ETInput.getText().toString()) - 32)) + 273.15;

                    // kelvin to others
                    else if (input == 2 && output == 0)
                        answer = Double.parseDouble(ETInput.getText().toString()) - 273.15;
                    else if (input == 2 && output == 1)
                        answer = (Double.parseDouble(ETInput.getText().toString()) - 273.15) * 1.8 + 32;

                    TVOutput.setText(String.valueOf(answer));
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getId() == R.id.SpinnerInputTemperature)
            input = i;
        else
            output = i;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}