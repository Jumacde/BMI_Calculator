package com.example.bmi_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bmi_calculator.impl.BMICalculate_impl;
import com.example.bmi_calculator.impl.DisplayControlControl_impl;
import com.example.bmi_calculator.impl.ButtonController_impl;
import com.example.bmi_calculator.impl.InputController_impl;

public class MainActivity extends AppCompatActivity {
    private TextView textViewBMI,textViewComment;
    private EditText editTextHeight, editTextWeight;
    private InputController inputController;
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
        editTextHeight = (EditText) findViewById(R.id.height);
        editTextWeight = (EditText) findViewById(R.id.weight);

        inputController = new InputController_impl();
        bmiCalculate = new BMICalculate_impl(inputController);
        displayControl = new DisplayControlControl_impl(bmiCalculate, buttonController, inputController);
        buttonController = new ButtonController_impl(bmiCalculate, inputController);

        setUpSubmitButton(R.id.submit);
        setUpClearButton(R.id.clear);
    }

    private void setUpSubmitButton(int id) {
        Button button = findViewById(id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonController.callPushSubmitButton();
            }
        });
    }

    private void setUpClearButton(int id) {
        Button button = findViewById(id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayControl.callClearDisplay();
            }
        });
    }

}