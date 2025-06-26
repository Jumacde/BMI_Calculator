package com.example.bmi_calculator;

public interface DisplayControl {
    // getter
    String getBmiDisplay();
    String getCommentDisplay();
    // setter
    void setBmiDisplay(String bmiDisplay);
    void setCommentDisplay(String commentDisplay);
    // wrap methods
    void callClearDisplay();
    void callShowBMI();

    String callFormatNumber(double num);
}
