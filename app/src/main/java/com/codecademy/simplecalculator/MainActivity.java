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
        final Button equal = findViewById(R.id.buttonEqual);
        final TextView finalresult = findViewById(R.id.result);

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final int textNumberOne = Integer.parseInt(firstNumber.getText().toString());
               final int textNumberTwo = Integer.parseInt(secondNumber.getText().toString());
               final int operatorId = operators.getCheckedRadioButtonId();
               Integer result = 0;
               //were
                    if(operatorId == add.getId()){

                        result = textNumberOne + textNumberTwo;

                        }else if(operatorId == sub.getId()) {

                        result = textNumberOne - textNumberTwo;

                        }
                finalresult.setText(result.toString());
            }
        });

    }
}