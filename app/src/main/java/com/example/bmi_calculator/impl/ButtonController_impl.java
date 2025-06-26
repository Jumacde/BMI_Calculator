package com.example.bmi_calculator.impl;

import com.example.bmi_calculator.BMICalculate;
import com.example.bmi_calculator.ButtonController;
import com.example.bmi_calculator.InputController;

public class ButtonController_impl implements ButtonController {
    private final BMICalculate bmiCalculate;
    private final InputController inputController;
    private String buttons;

    public ButtonController_impl(BMICalculate bmiCalculate, InputController inputController) {
        this.bmiCalculate = bmiCalculate;
        this.inputController = inputController;
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
    public void callPushSubmitButton() {
        pushSubmitButton();
    }

    private void pushSubmitButton() {
        String height = inputController.getHeight();
        String weight = inputController.getWeight();
        double calcHeight = bmiCalculate.getCalcHeight();
        double calcWeight = bmiCalculate.getCalcWeight();
        double bmi = bmiCalculate.getBmi();
        boolean isInput = bmiCalculate.getIsInput();
        bmiCalculate.setIsInput(true);

        bmiCalculate.callCalcBmi();
    }

}
