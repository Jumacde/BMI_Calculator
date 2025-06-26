package com.example.bmi_calculator.impl;

import android.annotation.SuppressLint;

import com.example.bmi_calculator.BMICalculate;
import com.example.bmi_calculator.ButtonController;
import com.example.bmi_calculator.DisplayControl;
import com.example.bmi_calculator.InputController;

public class DisplayControlControl_impl implements DisplayControl {
    private String bmiDisplay;
    private String commentDisplay;
    private final BMICalculate bmiCalculate;
    private final ButtonController buttonController;
    private final InputController inputController;

    public DisplayControlControl_impl(BMICalculate bmiCalculate, ButtonController buttonController, InputController inputController) {
        this.bmiCalculate = bmiCalculate;
        this.buttonController = buttonController;
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
    public String callShowBMI() {
        return showBMI();
    }

    /**
     * wrap method: to use updateDisplay method.
     * @ Param: double num
     * - to set a input number.
     * **/
    @Override
    public String callFormatNumber(double num) {
        return formatNumber(num);
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

    private String showBMI() {
        String buttons = buttonController.getButtons();
        double bmi = bmiCalculate.getBmi();
        if (buttons.equals("submit")) {
            return formatNumber(bmi);
        } else {
            return null;
        }
    }

    /**
     * - method: float number format to a integer
     * @ param: double num
     * - set each number(storedNumber)
     * **/
    @SuppressLint("DefaultLocale")
    private String formatNumber(double num) {
        if (num == (long) num) {
            return String.format("%d", (long) num);
        } else {
            return String.format("%s", num);
        }
    }
}
