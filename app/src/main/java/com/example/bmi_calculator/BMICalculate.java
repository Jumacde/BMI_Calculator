package com.example.bmi_calculator;

public interface BMICalculate {
    // getter
    double getCalcHeight();
    double getCalcWeight();
    double getBmi();
    double getGoalWeight();
    boolean getIsInput();

    // setter
    void setCalcHeight(double calcHeight);
    void setCalcWeight(double calcWeight);
    void setBmi(double bmi);
    void setGoalWeight(double goalWeight);
    void setIsInput(boolean isInput);

    // wrap methods
    void callCalcBmi();
    void callStandardWeight();
}
