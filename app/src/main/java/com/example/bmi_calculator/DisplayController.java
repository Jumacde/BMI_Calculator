package com.example.bmi_calculator;

public interface DisplayController {
    // getter
    String getBmiDisplay();
    String getCommentDisplay();
    // setter
    void setBmiDisplay(String bmiDisplay);
    void setCommentDisplay(String commentDisplay);
    // wrap methods
    void callClearDisplay();
    String callShowBMI();
    String callShowComment();

    String callFormatNumber(double num);
}
