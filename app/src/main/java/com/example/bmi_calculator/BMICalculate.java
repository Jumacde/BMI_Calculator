package com.example.bmi_calculator;

public interface BMICalculate {
    // getter
    double getCalcHeight();
    double getCalcWeight();
    double getBmi();
    double getStandardWeight();
    double getGoalWeight();
    boolean getIsInput();
    boolean getIsAsian();

    // setter
    void setCalcHeight(double calcHeight);
    void setCalcWeight(double calcWeight);
    void setBmi(double bmi);
    void setStandardWeight(double standardWeight);
    void setGoalWeight(double goalWeight);
    void setIsInput(boolean isInput);
    void setIsAsian(boolean isAsian);

    // wrap methods
    void callCalcBmi();
    double callCalcGoalWeight();
}
