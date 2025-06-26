package com.example.bmi_calculator.impl;

import com.example.bmi_calculator.BMICalculate;

public class BMICalculate_impl implements BMICalculate {
    private String inputHeight;
    private String inputWeight;
    private double calcHeight;
    private double calcWeight;
    private double bmi;
    private boolean isInput;

    public BMICalculate_impl() {
        this.inputHeight = "0";
        this.inputWeight = "0";
        this.bmi = 0;
        this.calcHeight = 0;
        this.calcWeight = 0;
        this.isInput = false;
    }

    // getter
    @Override
    public String getInputHeight() {
        return inputHeight;
    }

    @Override
    public String getInputWeight() {
        return inputWeight;
    }

    @Override
    public double getCalcHeight() {
        return calcHeight;
    }

    @Override
    public double getCalcWeight() {
        return calcWeight;
    }

    @Override
    public double getBmi() {
        return bmi;
    }

    @Override
    public boolean getIsInput() {
        return isInput;
    }

    // setter
    @Override
    public void setInputHeight(String inputHeight) {
        this.inputHeight = inputHeight;
    }

    @Override
    public void setInputWeight(String inputWeight) {
        this.inputWeight = inputWeight;
    }

    @Override
    public void setCalcHeight(double calcHeight) {
        this.calcHeight = calcHeight;
    }

    @Override
    public void setCalcWeight(double calcWeight) {
        this.calcWeight = calcWeight;
    }

    @Override
    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    @Override
    public void setIsInput(boolean isInput) {
        this.isInput = isInput;
    }

    // wrap methods
    @Override
    public void callCalcBmi() {
        calcBmi();
    }

    private void calcBmi(){
        setIsInput(true);
        double squHeight;
        double result;
        if (!inputHeight.isEmpty() && !inputWeight.isEmpty()) {
            calcHeight = Double.parseDouble(inputHeight);
            calcWeight = Double.parseDouble(inputWeight);
            squHeight = calcHeight * calcHeight;

            result = calcWeight / squHeight;
            bmi = result * 10000;
        } else {
            result = Double.POSITIVE_INFINITY;
            bmi = result;
        }
    }

}
