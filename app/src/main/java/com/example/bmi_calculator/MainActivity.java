package com.example.bmi_calculator;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bmi_calculator.impl.BMICalculate_impl;
import com.example.bmi_calculator.impl.DisplayController_impl;
import com.example.bmi_calculator.impl.ButtonController_impl;
import com.example.bmi_calculator.impl.InputController_impl;
/**
 * this class is able to execute the application and control UI methods.
 * UI methods:
 * 1. setUpSubmitButton: set up the submit button function.
 *  - execute BMI calculation.
 * 2. setUpClearButton: set up the clear button function.
 *  - reset display.
 * 3.setUpTextWatcher: set to show units(cm and kg) on the input console.
 * **/
public class MainActivity extends AppCompatActivity {
    private TextView textViewBMI,textViewComment;
    private EditText editTextHeight, editTextWeight;
    private CheckBox aCheckBox;
    private InputController inputController;
    private BMICalculate bmiCalculate;
    private DisplayController displayController;
    private ButtonController buttonController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textViewBMI = findViewById(R.id.bmiText);
        textViewComment = findViewById(R.id.commentText);
        editTextHeight = (EditText) findViewById(R.id.height);
        editTextWeight = (EditText) findViewById(R.id.weight);
        aCheckBox = findViewById(R.id.checkbox);

        inputController = new InputController_impl();
        bmiCalculate = new BMICalculate_impl(inputController);
        buttonController = new ButtonController_impl(bmiCalculate, inputController);
        displayController = new DisplayController_impl(bmiCalculate, buttonController, inputController);

        setUpSubmitButton(R.id.submit);
        setUpClearButton(R.id.clear);
        // TextWatcher: fix to show always cm and kg
        setUpTextWatcher(editTextHeight, "cm");
        setUpTextWatcher(editTextWeight, "kg");
        // set units on the display.
        editTextHeight.setText("0cm");
        editTextWeight.setText("0kg");

        // cursor moves on the weight textview after input finish on the height and push "enter".
        editTextHeight.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_NEXT || i == EditorInfo.IME_ACTION_DONE
                        || (keyEvent != null && keyEvent.getKeyCode()
                        == keyEvent.KEYCODE_ENTER && keyEvent.getAction()
                        == keyEvent.ACTION_DOWN)) {
                    // move cursor(focus) on the weight text view.
                    editTextWeight.requestFocus();
                    return true; // successfully execute
                }
                return false; // not execute
            }
        });
    }

    /**
     * method: set up the submit button function.
     * @ Param: int id => to search id from xml.
     *  this button sends number part of height and weight.
     *  inputController -> inputController_impl.
     *  buttonController -> buttonController_impl -> callPushSubmitButton -> pushSubmitButton -> bmiCalculate from BMICalculate_impl
     *      1. get number part of height and weight from inputController.
     *      2. calculate BMI via callPushSubmitButton from buttonController.
     *      3.a. set BMI result and comment on the textView(display).
     *      3.b. set comment for asian if you check the checkBox.
     *      4. heide the keyboard after push the submit-button.
     *      5. error message shows on a new message-window.
     * **/
    private void setUpSubmitButton(int id) {
        Button button = findViewById(id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get both editText and convert to String.
                inputController.setHeight(editTextHeight.getText().toString());
                inputController.setWeight(editTextWeight.getText().toString());
                bmiCalculate.setIsAsian(aCheckBox.isChecked()); // check asian.
                buttonController.callPushSubmitButton(); // calculate BMI.

                // set up error message on a new message window.
                String bmiResultText = displayController.callShowBMI();
                String commentText = displayController.callShowComment();
                String commentGoalText = displayController.callShowGoalWeight();
                // comment for asian.
                if (aCheckBox.isChecked()) {
                    commentText = displayController.callShowComment();
                    commentGoalText = displayController.callShowGoalWeight();
                } else {
                    commentText = displayController.callShowComment();
                    commentGoalText = displayController.callShowGoalWeight();
                }

                if ("ERROR_VALUE".equals(bmiResultText) || "ERROR_VALUE".equals(commentText)) {
                    // show error dialog
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Error")
                            .setMessage("failed height or weight.\nplease input your height and weight again.")
                            .setPositiveButton("OK", (dialog,whitch)-> {
                                // nothing to do what does after pushing ok button.
                            }).show();
                    textViewBMI.setText("0"); // initialise text
                    textViewComment.setText(""); // initialise text
                } else {
                    textViewBMI.setText(bmiResultText); // get the BMI result.
                    textViewComment.setText(commentText);
                    textViewComment.setText(commentGoalText);
                }

                // hide the keyboard
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if(inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        });
    }
    /**
     * method: set up the clear button function.
     * @ Param: int id => to search id from xml.
     *  execute "clearDisplay" method by wrap method from displayController_impl class via the interface class "displayController"
     *  displayController -> displayController_impl-> callClearDisplay(wrap method) -> clearDisplay.
     *      1. clear(initialize) inputted number part of height and weight.
     *      2. clear(initialize) BMI calculate result.
     *      3. clear(initialize) BMI comment.
     * **/
    private void setUpClearButton(int id) {
        Button button = findViewById(id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayController.callClearDisplay();
                editTextHeight.setText("");
                editTextWeight.setText("");
                textViewBMI.setText("0"); // initialise text
                textViewComment.setText(""); // initialise text
            }
        });
    }

    /**
     * method: TextWatcher: fix to show always a unit (cm and kg)
     * @ Param: final EditText editText
     * @ Param: final String unit
     *      - cm or kg
     * **/
    private void setUpTextWatcher(final EditText editText, final String unit) {
        editText.addTextChangedListener(new TextWatcher() {
            private boolean isUpdate = false;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // nothing to do here
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // nothing to do here
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (isUpdate) {
                    return; // avoid infinite loop.
                }
                isUpdate = true;
                String text = editable.toString();
                // if already a unit(cm or kg) is there, nothing to do.
                if (text.endsWith(unit) && text.length() > text.length() && text.substring(0, text.length() - unit.length()).matches(".*\\d.*")) {
                    if (editText.getSelectionEnd() == text.length() - unit.length()) {
                        isUpdate = false;
                        return;
                    }
                }
                // puck up a number and remove units(cm and kg).
                String number = text.replaceAll("[^\\d.]", "");
                // remove 0 if user input any number.
                if (number.length() > 1 && number.startsWith("0") && !number.startsWith("0.")) {
                    number = number.substring(1);
                }
                // if no number is there, add a unit.
                if (!number.isEmpty()) {
                    String textWithUnit = number + unit;
                    editText.setText(textWithUnit);
                    editText.setSelection(number.length()); // move the cursor to just after the number
                } else if (text.isEmpty()) {
                    editText.setText("0" + unit); // initialize the number("0").
                    editText.setSelection(1); // move the cursor to just after initialized number("0").
                }
                isUpdate = false;
            }
        });

    }

}