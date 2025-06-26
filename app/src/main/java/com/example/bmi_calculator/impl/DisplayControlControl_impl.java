package com.example.bmi_calculator.impl;

import com.example.bmi_calculator.BMICalculate;
import com.example.bmi_calculator.DisplayControl;
import com.example.bmi_calculator.InputController;

public class DisplayControlControl_impl implements DisplayControl {
    private String bmiDisplay;
    private String commentDisplay;
    private final BMICalculate bmiCalculate;
    private final InputController inputController;

    public DisplayControlControl_impl(BMICalculate bmiCalculate, InputController inputController) {
        this.bmiCalculate = bmiCalculate;
        this.inputController = inputController;
        callClearDisplay();
    }

    @Override
    public String getBmiDisplay() {
        return bmiDisplay;
    }

    @Override
    public String getCommentDisplay() {
        return commentDisplay;
    }

    @Override
    public void setBmiDisplay(String bmiDisplay) {
        this.bmiDisplay = bmiDisplay;
    }

    @Override
    public void setCommentDisplay(String commentDisplay) {
        this.commentDisplay = commentDisplay;
    }

    // wrap methods
    @Override
    public void callClearDisplay() {
        clearDisplay();
    }

    @Override
    public void callShowBMI() {
        showBMI();
    }

    private void clearDisplay() {
        this.inputController.setHeight("0");
        this.bmiCalculate.setCalcHeight(0);
        this.inputController.setWeight("0");
        this.bmiCalculate.setCalcWeight(0);
        this.bmiCalculate.setBmi(0);
        this.bmiCalculate.setIsInput(false);
        this.bmiDisplay = "0";
        this.commentDisplay = "0";
    }

    private void showBMI() {

    }
}
