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

    @Override
    public String callShowCommentAsian() {
        return showCommentAsian();
    }

    @Override
    public String callShowGoalWeight() {
        return showGoalWeight();
    }

    @Override
    public String callShowGoalWeightAsian() {
        return showGoalWeightAsian();
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
        this.inputController.setHeight("");
        this.bmiCalculate.setCalcHeight(0);
        this.inputController.setWeight("");
        this.bmiCalculate.setCalcWeight(0);
        this.bmiCalculate.setBmi(0);
        this.bmiCalculate.setIsInput(false);
        this.bmiDisplay = "0";
        this.commentDisplay = "0";
    }

    private String showBMI() {
        double bmi = bmiCalculate.getBmi();
        String bmiFormat = formatNumber(bmi);
        String bmiResult;
        if (Double.isInfinite(bmi) || Double.isNaN(bmi)) {
            return bmiResult = "ERROR_VALUE";
        } else {
            return bmiResult = bmiFormat;
        }
    }

    private String showComment() {
        double bmi = bmiCalculate.getBmi();
        double goalWeight = bmiCalculate.getGoalWeight();
        String comment;
        // normal case
        if (Double.isInfinite(bmi) || Double.isNaN(bmi)) {
            return comment = "ERROR_VALUE";
        } else if (bmi < 18.5) {
            return comment = "underweight.";
        } else if (bmi >= 18.5 && bmi < 25) {
            return comment = "normal weight.";
        } else if (bmi >= 25 && bmi < 30) {
            return comment = "pre-obesity.";
        } else if (bmi >= 30 && bmi < 34.9){
            return comment = "obesity class I";
        } else if (bmi >= 35 && bmi < 39.9) {
            return comment = "obesity class II";
        } else {
            return comment = "obesity class III";
        }
    }

    private String showCommentAsian() {
        double bmi = bmiCalculate.getBmi();
        String comment;
        // normal case
        if (Double.isInfinite(bmi) || Double.isNaN(bmi)) {
            return comment = "ERROR_VALUE";
        } else if (bmi < 17.5) {
            return comment = "underweight.";
        } else if (bmi >= 17.5 && bmi < 23) {
            return comment = "normal weight.";
        } else if (bmi >= 23 && bmi < 28) {
            return comment = "pre-obesity.";
        } else if (bmi >= 27.5 && bmi < 30){ // bmi >= 28
            return comment = "obesity class I";
        } else if (bmi >= 30 && bmi < 35) {
            return comment = "obesity class II";
        } else {
            return comment = "obesity class III";
        }
    }

    private String showGoalWeight() {
        double bmi = bmiCalculate.getBmi();
        double calcWeight = bmiCalculate.getCalcWeight();
        double goalWeight = bmiCalculate.getGoalWeight();
        double dietWeightGain = goalWeight + calcWeight;
        double dietWeightLoss = calcWeight - goalWeight;
        String commentGoal;

        if (bmi < 18.5) {
            return commentGoal = "goal weight gain +" + dietWeightGain + "kg";
        } else {
            return commentGoal = "goal weight loss -" + dietWeightLoss + "kg";
        }
    }

    private String showGoalWeightAsian() {
        double bmi = bmiCalculate.getBmi();
        double calcWeight = bmiCalculate.getCalcWeight();
        double goalWeight = bmiCalculate.getGoalWeight();
        double dietWeight;
        String comment;

        if (bmi < 17.5) {
            dietWeight = goalWeight + calcWeight;
            return comment = "goal weight gain +" + dietWeight + "kg";
        } else {
            dietWeight = calcWeight - goalWeight;
            return comment = "goal weight loss -" + dietWeight + "kg";
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
