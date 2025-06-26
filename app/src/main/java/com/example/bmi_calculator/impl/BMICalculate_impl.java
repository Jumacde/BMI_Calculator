package com.example.bmi_calculator.impl;

import com.example.bmi_calculator.BMICalculate;

public class BMICalculate_impl implements BMICalculate {
    private String inputHeight;
    private String inputWeight;
    private double calcHeight;
    private double calcWeight;
    private double bmi;

    public BMICalculate_impl() {
        this.inputHeight = "0";
        this.inputWeight = "0";
        this.bmi = 0;
        this.calcHeight = 0;
        this.calcWeight = 0;
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
        this.calcHeight = Double.parseDouble(inputHeight);
    }

    @Override
    public void setCalcWeight(double calcWeight) {
        this.calcWeight = Double.parseDouble(inputWeight);
    }

    @Override
    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    // wrap method
    @Override
    public void callCalcBMI() {
        calcBMI();
    }

    private void calcBMI(){

    }
}
