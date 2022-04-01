package com.example.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner unitSpinner;
    EditText inputEditText;
    TextView leftCol1;
    TextView leftCol2;
    TextView leftCol3;
    TextView rightCol1;
    TextView rightCol2;
    TextView rightCol3;
    ImageButton metreButton;
    ImageButton celsiusButton;
    ImageButton kiloButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unitSpinner = findViewById(R.id.unitSpinner);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitSpinner.setAdapter(spinnerAdapter);

        inputEditText = findViewById(R.id.inputEditText);
        leftCol1 = findViewById(R.id.leftCol1);
        leftCol2 = findViewById(R.id.leftCol2);
        leftCol3 = findViewById(R.id.leftCol3);
        rightCol1 = findViewById(R.id.rightCol1);
        rightCol2 = findViewById(R.id.rightCol2);
        rightCol3 = findViewById(R.id.rightCol3);
        metreButton = findViewById(R.id.metreButton);
        celsiusButton = findViewById(R.id.celsiusButton);
        kiloButton = findViewById(R.id.kiloButton);
        metreButton.setImageResource(R.drawable.metre);
        celsiusButton.setImageResource(R.drawable.celsius);
        kiloButton.setImageResource(R.drawable.kilo);

        metreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String unit = unitSpinner.getSelectedItem().toString();
                if (unit.equals("Metres"))
                {
                    double input = Double.parseDouble(inputEditText.getText().toString());

                    double centimetreResult = input * 100;
                    double feetResult = input * 3.2808;
                    double inchResult = input * 39.370;

                    leftCol1.setText(String.format("%.2f", centimetreResult));
                    leftCol2.setText(String.format("%.2f", feetResult));
                    leftCol3.setText(String.format("%.2f", inchResult));
                    rightCol1.setText("Centimetre");
                    rightCol2.setText("Foot");
                    rightCol3.setText("Inch");

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Please select the correct conversion icon.", Toast.LENGTH_LONG).show();
                }
            }
        });

        celsiusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String unit = unitSpinner.getSelectedItem().toString();
                if (unit.equals("Celsius"))
                {
                    double input = Double.parseDouble(inputEditText.getText().toString());

                    double fahrenheitResult = input * 9/5 + 32;
                    double kelvinResult = input + 273.15;

                    leftCol1.setText(String.format("%.2f", fahrenheitResult));
                    leftCol2.setText(String.format("%.2f", kelvinResult));
                    leftCol3.setText("");
                    rightCol1.setText("Fahrenheit");
                    rightCol2.setText("Kelvin");
                    rightCol3.setText("");

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Please select the correct conversion icon.", Toast.LENGTH_LONG).show();
                }


            }
        });

        kiloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String unit = unitSpinner.getSelectedItem().toString();
                if (unit.equals("Kilograms"))
                {
                    double input = Double.parseDouble(inputEditText.getText().toString());

                    double gramResult = input * 1000;
                    double ounceResult = input * 35.2739619;
                    double poundResult = input * 2.205;

                    leftCol1.setText(String.format("%.2f", gramResult));
                    leftCol2.setText(String.format("%.2f", ounceResult));
                    leftCol3.setText(String.format("%.2f", poundResult));
                    rightCol1.setText("Gram");
                    rightCol2.setText("Ounce(Oz)");
                    rightCol3.setText("Pound(lb)");

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Please select the correct conversion icon.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //String choice = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}