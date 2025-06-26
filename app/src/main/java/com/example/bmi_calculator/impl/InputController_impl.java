package com.example.bmi_calculator.impl;

import com.example.bmi_calculator.InputController;

public class InputController_impl implements InputController {
    private String height;
    private String weight;

    public InputController_impl() {
        this.height = "0";
        this.weight = "0";
    }

    @Override
    public String getHeight() {
        return height;
    }

    @Override
    public String getWeight() {
        return weight;
    }

    @Override
    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public void setWeight(String weight) {
        this.weight = weight;
    }
}
