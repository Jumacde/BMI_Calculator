package com.example.bmi_calculator.impl;

import com.example.bmi_calculator.BMICalculate;
import com.example.bmi_calculator.ButtonController;

public class ButtonController_impl implements ButtonController {
    private final BMICalculate bmiCalculate;
    private String buttons;

    public ButtonController_impl(BMICalculate bmiCalculate) {
        this.bmiCalculate = bmiCalculate;
        this.buttons = "";
    }

    @Override
    public String getButtons() {
        return buttons;
    }

    @Override
    public void setButtons(String buttons) {
        this.buttons = buttons;
    }

    @Override
    public void callPushButton() {
        pushButton();
    }

    private void pushButton() {
        String inputHeight = bmiCalculate.getInputHeight();
        String inputWeight = bmiCalculate.getInputWeight();
        double calcHeight = bmiCalculate.getCalcHeight();
        double calcWeight = bmiCalculate.getCalcWeight();
        double bmi = bmiCalculate.getBmi();
        boolean isInput = bmiCalculate.getIsInput();

        if (buttons.equals("submit")) {
            bmiCalculate.callCalcBmi();
        } else if (buttons.equals("clear")) {
            
        }
    }

}
