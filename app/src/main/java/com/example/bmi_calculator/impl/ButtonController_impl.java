package com.example.bmi_calculator.impl;

import com.example.bmi_calculator.BMICalculate;
import com.example.bmi_calculator.ButtonController;

public class ButtonController_impl implements ButtonController {
    private final BMICalculate bmiCalculate;

    public ButtonController_impl(BMICalculate bmiCalculate) {
        this.bmiCalculate = bmiCalculate;
    }

    @Override
    public void callPushSubmitButton() {
        pushSubmitButton();
    }

    @Override
    public void callPushClearButton() {
        pushClearButton();
    }

    private void pushSubmitButton() {
        String inputHeight = bmiCalculate.getInputHeight();
        String inputWeight = bmiCalculate.getInputWeight();
        double calcHeight = bmiCalculate.getCalcHeight();
        double calcWeight = bmiCalculate.getCalcWeight();
        double bmi = bmiCalculate.getBmi();
        boolean isInput = bmiCalculate.getIsInput();

        if () {

        }
    }

    private void pushClearButton() {

    }
}
