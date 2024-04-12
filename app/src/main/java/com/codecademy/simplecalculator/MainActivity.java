package com.codecademy.simplecalculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        final EditText firstNumber = findViewById(R.id.number1);
        final EditText secondNumber = findViewById(R.id.number2);
        final RadioGroup operators = findViewById(R.id.operators);
        final RadioButton add = findViewById(R.id.radioButtonAdd);
        final RadioButton sub = findViewById(R.id.radioButtonSub);
        final RadioButton mult = findViewById(R.id.radioButtonMult);
        final RadioButton div = findViewById(R.id.radioButtonDiv);
        final Button equal = findViewById(R.id.buttonEqual);
        final TextView finalresult = findViewById(R.id.result);
        final TextView selectOperator = findViewById(R.id.textViewSelectOperator);

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final double textNumberOne = Double.parseDouble(firstNumber.getText().toString());
               final double textNumberTwo = Double.parseDouble(secondNumber.getText().toString());
               final int operatorId = operators.getCheckedRadioButtonId();
               double result = 0;

// calculation logic functions
                    if(operatorId == add.getId()){

                        result = textNumberOne + textNumberTwo;

                        }else if(operatorId == sub.getId()) {

                            result = textNumberOne - textNumberTwo;

                                }else if(operatorId == mult.getId()) {

                                    result = textNumberOne * textNumberTwo;

                                        }else if(operatorId == div.getId()) {

                                            result = textNumberOne / textNumberTwo;

                    }

                finalresult.setText(Double.toString(result));
            }
        });

        // after i press my operator we can see a visual change, for that i use the listener for wend one of the operator is press, set the textfilt we have in the middle
        operators.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(add.isPressed()){
                    selectOperator.setText("+");
                    }else if(sub.isPressed()){
                        selectOperator.setText("-");
                        }else if(mult.isPressed()){
                            selectOperator.setText("x");
                        }else if(div.isPressed()){
                            selectOperator.setText(":");
                }
            }


        });

    }
}