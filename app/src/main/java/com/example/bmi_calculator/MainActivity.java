package com.example.bmi_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bmi_calculator.impl.BMICalculate_impl;
import com.example.bmi_calculator.impl.BMIDisplay_impl;
import com.example.bmi_calculator.impl.ButtonController_impl;
import com.example.bmi_calculator.impl.CommentDisplay_impl;

public class MainActivity extends AppCompatActivity {
    private TextView textViewBMI,textViewComment;
    private BMICalculate bmiCalculate;
    private BMIDisplay bmiDisplay;
    private CommentDisplay commentDisplay;
    private ButtonController buttonController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textViewBMI = findViewById(R.id.bmiText);
        textViewComment = findViewById(R.id.commentText);

        bmiCalculate = new BMICalculate_impl();
        bmiDisplay = new BMIDisplay_impl();
        commentDisplay = new CommentDisplay_impl();
        buttonController = new ButtonController_impl();

        setUpSubmitButton(R.id.submit);
        setUpClearButton(R.id.clear);
    }

    private void setUpSubmitButton(int id) {
        Button button = findViewById(id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void setUpClearButton(int id) {
        Button button = findViewById(id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}