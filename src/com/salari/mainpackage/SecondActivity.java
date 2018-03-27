package com.salari.mainpackage;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        final EditText height = (EditText) findViewById(R.id.editTextHeight);
        final EditText weight = (EditText) findViewById(R.id.editTextWeight);
        final TextView finalresult = (TextView) findViewById(R.id.result);
        LinearLayout myLinearLayout = (LinearLayout) findViewById(R.id.LinearLayout2);
        final TextView interpretation = new TextView(this);
        interpretation.setTextSize(20);
        interpretation.setGravity(Gravity.CENTER);
        interpretation.setTextColor(Color.parseColor("#000000"));
        myLinearLayout.addView(interpretation);
        final OnClickListener listener = new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (height.getText().toString().equals("") || weight.getText().toString().equals("")) {
                    interpretation.setText("Please enter the requests!");
                    return;
                }
                double editTextHeightToDoubleValue = Double.parseDouble(height.getText().toString());
                double editTextWeightToDoubleValue = Double.parseDouble(weight.getText().toString());
                double bmiCalculation = Math.round(editTextWeightToDoubleValue / (editTextHeightToDoubleValue * editTextHeightToDoubleValue));
                String bmiCalculationToString = Double.toString(bmiCalculation);
                finalresult.setText(bmiCalculationToString);
                if (bmiCalculation < 18.5)
                    interpretation.setText("You have to gain weight!");
                else if (bmiCalculation < 24.9)
                    interpretation.setText("You are normal!");
                else if (bmiCalculation < 30)
                    interpretation.setText("You have to lose weight!");
                else
                    interpretation.setText("You are too fat!");
            }
        };
        Button calculate = (Button) findViewById(R.id.calculate);
        calculate.setOnClickListener(listener);
    }
}
