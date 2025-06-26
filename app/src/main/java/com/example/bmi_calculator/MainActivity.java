package com.example.bmi_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bmi_calculator.impl.BMICalculate_impl;
import com.example.bmi_calculator.impl.DisplayControlControl_impl;
import com.example.bmi_calculator.impl.ButtonController_impl;

public class MainActivity extends AppCompatActivity {
    private TextView textViewBMI,textViewComment;
    private BMICalculate bmiCalculate;
    private DisplayControl displayControl;
    private ButtonController buttonController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textViewBMI = findViewById(R.id.bmiText);
        textViewComment = findViewById(R.id.commentText);

        bmiCalculate = new BMICalculate_impl();
        displayControl = new DisplayControlControl_impl(bmiCalculate);
        buttonController = new ButtonController_impl(bmiCalculate);

        setUpButton(R.id.submit, "submit");
        setUpButton(R.id.clear, "clear");
    }

    private void setUpButton(int id, final String buttons) {
        Button button = findViewById(id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}