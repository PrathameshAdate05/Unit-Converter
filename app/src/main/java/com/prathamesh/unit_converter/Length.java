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

public class Length extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner inputSpinner, outputSpinner;
    int input = 0, output = 0;
    Button convert;
    Double answer;
    TextView TVOutput;
    EditText ETInput;

    String[] lengths = {"Kilometer","Meter","Millimeter","Feet","Inch"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        inputSpinner = findViewById(R.id.SpinnerInputLength);
        outputSpinner = findViewById(R.id.SpinnerOutputLength);
        convert = findViewById(R.id.BTN_ConvertLength);
        TVOutput = findViewById(R.id.TV_Output_Length);
        ETInput = findViewById(R.id.ET_InputLength);

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,lengths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputSpinner.setAdapter(adapter);
        inputSpinner.setOnItemSelectedListener(this);
        outputSpinner.setAdapter(adapter);
        outputSpinner.setOnItemSelectedListener(this);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ETInput.getText().toString().equals("")){
                    ETInput.setError("Enter Input");
                    return;
                }
                else{
                    if (input == output)
                        answer = Double.parseDouble(ETInput.getText().toString());
                    // kilometer to other
                    else if (input == 0 && output == 1)
                        answer = Double.parseDouble(ETInput.getText().toString()) * 1000;
                    else if (input == 0 && output == 2)
                        answer = Double.parseDouble(ETInput.getText().toString()) * Constants.MILLIMETER;
                    else if (input == 0 && output == 3)
                        answer = Double.parseDouble(ETInput.getText().toString()) * Constants.FEET;
                    else if (input == 0 && output == 4)
                        answer = Double.parseDouble(ETInput.getText().toString()) * Constants.INCH;

                        // meter to other
                    else if (input == 1 && output == 0)
                        answer = Double.parseDouble(ETInput.getText().toString()) / 1000;
                    else if (input == 1 && output == 2)
                        answer = Double.parseDouble(ETInput.getText().toString()) * 1000;
                    else if (input == 1 && output == 3)
                        answer = Double.parseDouble(ETInput.getText().toString()) * 3.28084;
                    else if (input == 1 && output == 4)
                        answer = Double.parseDouble(ETInput.getText().toString()) * 39.3701;

                        // millimeter to other
                    else if (input == 2 && output == 0)
                        answer = Double.parseDouble(ETInput.getText().toString()) / Constants.MILLIMETER;
                    else if (input == 2 && output == 1)
                        answer = Double.parseDouble(ETInput.getText().toString()) / 1000;
                    else if (input == 2 && output == 3)
                        answer = Double.parseDouble(ETInput.getText().toString()) / 305;
                    else if (input == 2 && output == 4)
                        answer = Double.parseDouble(ETInput.getText().toString()) / 25.4;

                        // feet to others
                    else if (input == 3 && output == 0)
                        answer = Double.parseDouble(ETInput.getText().toString()) * 0.000305;
                    else if (input == 3 && output == 1)
                        answer = Double.parseDouble(ETInput.getText().toString()) * 0.3048;
                    else if (input == 3 && output == 2)
                        answer = Double.parseDouble(ETInput.getText().toString()) * 304.8;
                    else if (input == 3 && output == 4)
                        answer = Double.parseDouble(ETInput.getText().toString()) * 12;

                        // inch to others
                    else if (input == 4 && output == 0)
                        answer = Double.parseDouble(ETInput.getText().toString()) * 2.54E-5;
                    else if (input == 4 && output == 1)
                        answer = Double.parseDouble(ETInput.getText().toString()) * 0.0254;
                    else if (input == 4 && output == 2)
                        answer = Double.parseDouble(ETInput.getText().toString()) * 25.4;
                    else if (input == 4 && output == 3)
                        answer = Double.parseDouble(ETInput.getText().toString()) * 0.0833;
                }
                TVOutput.setText(String.valueOf(answer));
            }
        });


    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getId() == R.id.SpinnerInputLength)
            input = i;
        else
            output = i;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}