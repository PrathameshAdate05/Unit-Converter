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
import android.widget.Toast;

public class Weight extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView TVOutput;
    EditText ETInput;
    Spinner inputSpinner, outputSpinner;
    Button BTNConvert;
    int input = 0, output = 0;
    double answer;

    String[] weights = {"Kilogram","Gram","Pound"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        TVOutput = findViewById(R.id.TV_Output_Weight);
        ETInput = findViewById(R.id.ET_InputWeight);
        inputSpinner = findViewById(R.id.SpinnerInputWeight);
        outputSpinner = findViewById(R.id.SpinnerOutputWeight);
        BTNConvert = findViewById(R.id.BTN_ConvertWeight);

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,weights);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        inputSpinner.setAdapter(adapter);
        inputSpinner.setOnItemSelectedListener(this);
        outputSpinner.setAdapter(adapter);
        outputSpinner.setOnItemSelectedListener(this);

        BTNConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ETInput.getText().toString().equals("")){
                    ETInput.setError("Enter Input");
                    return;
                }

                else{
                    if (input == output)
                        answer = Double.parseDouble(ETInput.getText().toString());

                    // kilograms to others
                    else if (input == 0 && output == 1)
                        answer = Double.parseDouble(ETInput.getText().toString()) * 1000;
                    else if (input == 0 && output == 2)
                        answer = Double.parseDouble(ETInput.getText().toString()) * 2.205;

                    // gram to others
                    else if (input == 1 && output == 0)
                        answer = Double.parseDouble(ETInput.getText().toString()) / 1000;
                    else if (input == 1 && output == 2)
                        answer = Double.parseDouble(ETInput.getText().toString()) / 453.6;

                    // pound to others
                    else if (input == 2 && output == 0)
                        answer = Double.parseDouble(ETInput.getText().toString()) / 2.205;
                    else if (input == 2 && output == 1)
                        answer = Double.parseDouble(ETInput.getText().toString()) * 453.6;

                    TVOutput.setText(String.valueOf(answer));
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getId() == R.id.SpinnerInputWeight)
            input = i;
        else
            output = i;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}