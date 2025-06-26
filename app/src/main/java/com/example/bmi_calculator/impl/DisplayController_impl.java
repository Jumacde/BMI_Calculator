package com.example.bmi_calculator.impl;

import android.annotation.SuppressLint;

import com.example.bmi_calculator.BMICalculate;
import com.example.bmi_calculator.ButtonController;
import com.example.bmi_calculator.DisplayController;
import com.example.bmi_calculator.InputController;

public class DisplayController_impl implements DisplayController {
    private String bmiDisplay;
    private String commentDisplay;
    private final BMICalculate bmiCalculate;
    private final ButtonController buttonController;
    private final InputController inputController;

    public DisplayController_impl(BMICalculate bmiCalculate, ButtonController buttonController, InputController inputController) {
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

    @Override
    public String callShowComment() {
        return showComment();
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
            return String.valueOf(Double.POSITIVE_INFINITY);
        }
    }

    private String showComment() {
        double bmi = bmiCalculate.getBmi();
        String comment;

        if (Double.isInfinite(bmi) || Double.isNaN(bmi)) {
            return comment = "ERROR";
        } else if (bmi < 18.5) {
            return comment = "you are too skinny..";
        } else if (bmi >= 18.5 && bmi < 25) {
            return comment = "you are healthy:)";
        } else if (bmi >= 25 && bmi < 30) {
            return comment = "you are overweight..";
        } else { // bmi >= 30
            return comment = "you are obese:(";
        }
    }
    /**
     * - method: float number format to a integer
     * @ param: double num
     * - set each number
     * **/
    @SuppressLint("DefaultLocale")
    private String formatNumber(double num) {
        //display up to two decimal places
        return String.format("%.2f", num);
    }
}
