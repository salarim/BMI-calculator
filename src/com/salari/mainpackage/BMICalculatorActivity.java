package com.salari.mainpackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class BMICalculatorActivity extends Activity {

    /** Called when the activity is first created. */
    OnClickListener listener = new OnClickListener() {

                                 @Override
                                 public void onClick(View arg0) {
                                     Intent myIntent = new Intent(BMICalculatorActivity.this, SecondActivity.class);
                                     startActivity(myIntent);
                                 }
                             };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button myButton = (Button) findViewById(R.id.start_btn);
        myButton.setOnClickListener(listener);
    }
}