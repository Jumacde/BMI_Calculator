package com.example.bmi_calculator.impl;

import com.example.bmi_calculator.BMICalculate;
import com.example.bmi_calculator.InputController;

public class BMICalculate_impl implements BMICalculate {
    private double calcHeight;
    private double calcWeight;
    private double bmi;
    private double goalWeight;
    private boolean isInput;

    private final InputController inputController;

    public BMICalculate_impl(InputController inputController) {
        this.inputController = inputController;
        this.bmi = 0;
        this.calcHeight = 0;
        this.calcWeight = 0;
        this.isInput = false;
    }

    // getter
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
    public double getGoalWeight() {
        return goalWeight;
    }

    @Override
    public boolean getIsInput() {
        return isInput;
    }

    // setter
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
    public void setGoalWeight(double goalWeight) {
        this.goalWeight = goalWeight;
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

    @Override
    public void callStandardWeight() {
        callStandardWeight();
    }

    /**
     * method: calculate BMI
     * 1. from inputted number remove units(cm or kg) and pick up only a number(height and weight).
     *      ex: 180 cm and 90kg => 180 and 90.
     * 2. calculate BMI.
     * **/
    private void calcBmi(){
        setIsInput(true);
        String height = inputController.getHeight();
        String weight = inputController.getWeight();

        double squHeight;
        double result;
        // pick up only number parts.
        String cleanHeight = height.replaceAll("[^\\d.]", "");
        String cleanWeight = weight.replaceAll("[^\\d.]", "");

        if (!cleanHeight.isEmpty() && ! cleanWeight.isEmpty()) {
            // try catch: avoid the number convert-error.
            try {
                calcHeight = Double.parseDouble(cleanHeight);
                calcWeight = Double.parseDouble(cleanWeight);
                // if the inputted height or weight is 0, shows "error".
                if (calcHeight == 0 || calcWeight == 0) {
                    result = Double.POSITIVE_INFINITY;
                    bmi = result;
                    return; // not calculate.
                }
                // if no problem, calculate BMI.
                squHeight = Math.pow(calcHeight, 2); // calcHeight^2
                result = calcWeight / squHeight;
                bmi = result * 10000;
            } catch (NumberFormatException  nFe) {
                bmi = Double.NaN; // not a number.
            }

        } else {
            bmi = Double.NaN; // not a number.
        }
    }

    /**
     * method: calculate appropriate weight.
     * calculate method of standard weight = height × height * 22
     * **/
    private void standardWeight() {
        double standardWeight = calcHeight * calcHeight * 0.0022;
        if (bmi < 18.5) {
            goalWeight = standardWeight - calcWeight;
        } else if (bmi > 29.9) {
            goalWeight = calcWeight - standardWeight;
        }
    }


}
