package com.example.bmi_calculator;

public interface BMICalculate {
    // getter
    String getInputHeight();
    String getInputWeight();
    double getCalcHeight();
    double getCalcWeight();
    double getBmi();
    boolean getIsInput();

    // setter
    void setInputHeight(String inputHeight);
    void setInputWeight(String inputWeight);
    void setCalcHeight(double calcHeight);
    void setCalcWeight(double calcWeight);
    void setBmi(double bmi);
    void setIsInput(boolean isInput);

    // wrap methods
    void callCalcBmi();
    void callConvertBmi();
}
