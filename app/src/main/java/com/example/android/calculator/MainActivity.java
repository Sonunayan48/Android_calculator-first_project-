package com.example.android.calculator;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean isOpPressed = false;
    private double firstNumber = 0;
    private int secondNumberIndex = 0;
    private char currentOp;
    private String screenContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView CalculatorScreen = findViewById(R.id.CalculatorScreen);
        final ImageButton n0 = findViewById(R.id.n0);
        final ImageButton n1 = findViewById(R.id.n1);
        final ImageButton n2 = findViewById(R.id.n2);
        final ImageButton n3 = findViewById(R.id.n3);
        final ImageButton n4 = findViewById(R.id.n4);
        final ImageButton n5 = findViewById(R.id.n5);
        final ImageButton n6 = findViewById(R.id.n6);
        final ImageButton n7 = findViewById(R.id.n7);
        final ImageButton n8 = findViewById(R.id.n8);
        final ImageButton n9 = findViewById(R.id.n9);
        final ImageButton percentage = findViewById(R.id.percentage);
        final ImageButton div = findViewById(R.id.div);
        final ImageButton mul = findViewById(R.id.mul);
        final ImageButton sub = findViewById(R.id.sub);
        final ImageButton add = findViewById(R.id.add);
        final ImageButton dot = findViewById(R.id.dot);
        final ImageButton equal = findViewById(R.id.equal);




        final View.OnClickListener calculatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int id = v.getId();

                switch (id){
                    case R.id.n0:
                        CalculatorScreen.append("0");
                        break;
                    case R.id.n1:
                        CalculatorScreen.append("1");
                        break;
                    case R.id.n2:
                        CalculatorScreen.append("2");
                        break;
                    case R.id.n3:
                        CalculatorScreen.append("3");
                        break;
                    case R.id.n4:
                        CalculatorScreen.append("4");
                        break;
                    case R.id.n5:
                        CalculatorScreen.append("5");
                        break;
                    case R.id.n6:
                        CalculatorScreen.append("6");
                        break;
                    case R.id.n7:
                        CalculatorScreen.append("7");
                        break;
                    case R.id.n8:
                        CalculatorScreen.append("8");
                        break;
                    case R.id.n9:
                        CalculatorScreen.append("9");
                        break;
                    case R.id.dot:
                        CalculatorScreen.append(".");
                        break;
                    case R.id.equal:
                        if(isOpPressed){
                            if(currentOp == '+'){
                                screenContent = CalculatorScreen.getText().toString();
                                double secondNumber = Double.parseDouble(screenContent.substring(secondNumberIndex,screenContent.length()));
                                firstNumber+=secondNumber;
                                CalculatorScreen.setText(String.valueOf(firstNumber));
                            }
                            else if(currentOp == '-'){
                                screenContent = CalculatorScreen.getText().toString();
                                double secondNumber = Double.parseDouble(screenContent.substring(secondNumberIndex,screenContent.length()));
                                firstNumber-=secondNumber;
                                CalculatorScreen.setText(String.valueOf(firstNumber));
                            }
                            else if(currentOp == '*'){
                                screenContent = CalculatorScreen.getText().toString();
                                double secondNumber = Double.parseDouble(screenContent.substring(secondNumberIndex,screenContent.length()));
                                firstNumber*=secondNumber;
                                CalculatorScreen.setText(String.valueOf(firstNumber));
                            }
                            else if(currentOp == '/'){
                                screenContent = CalculatorScreen.getText().toString();
                                double secondNumber = Double.parseDouble(screenContent.substring(secondNumberIndex,screenContent.length()));
                                firstNumber/=secondNumber;
                                CalculatorScreen.setText(String.valueOf(firstNumber));
                            }
                            else if(currentOp == '%'){
                                screenContent = CalculatorScreen.getText().toString();
                                double secondNumber = Double.parseDouble(screenContent.substring(secondNumberIndex,screenContent.length()));
                                firstNumber/=100;
                                firstNumber*=secondNumber;
                                CalculatorScreen.setText(String.valueOf(firstNumber));
                            }
                        }
                        break;
                    case R.id.add:
                        String screenContent = CalculatorScreen.getText().toString();
                        firstNumber = Double.parseDouble(screenContent);
                        secondNumberIndex = screenContent.length() + 1;
                        CalculatorScreen.append("+");
                        isOpPressed = true;
                        currentOp = '+';
                        break;

                    case R.id.sub:
                        screenContent = CalculatorScreen.getText().toString();
                        firstNumber = Double.parseDouble(screenContent);
                        secondNumberIndex = screenContent.length() + 1;
                        CalculatorScreen.append("-");
                        isOpPressed = true;
                        currentOp = '-';
                        break;

                    case R.id.mul:
                        screenContent = CalculatorScreen.getText().toString();
                        firstNumber = Double.parseDouble(screenContent);
                        secondNumberIndex = screenContent.length() + 1;
                        CalculatorScreen.append("*");
                        isOpPressed = true;
                        currentOp = '*';
                        break;

                    case R.id.div:
                        screenContent = CalculatorScreen.getText().toString();
                        firstNumber = Double.parseDouble(screenContent);
                        secondNumberIndex = screenContent.length() + 1;
                        CalculatorScreen.append("/");
                        isOpPressed = true;
                        currentOp = '/';
                        break;

                    case R.id.percentage:
                        screenContent = CalculatorScreen.getText().toString();
                        firstNumber = Double.parseDouble(screenContent);
                        secondNumberIndex = screenContent.length() + 1;
                        CalculatorScreen.append("%");
                        isOpPressed = true;
                        currentOp = '%';
                        break;
                }

            }
        };
        n0.setOnClickListener(calculatorListener);
        n1.setOnClickListener(calculatorListener);
        n2.setOnClickListener(calculatorListener);
        n3.setOnClickListener(calculatorListener);
        n4.setOnClickListener(calculatorListener);
        n5.setOnClickListener(calculatorListener);
        n6.setOnClickListener(calculatorListener);
        n7.setOnClickListener(calculatorListener);
        n8.setOnClickListener(calculatorListener);
        n9.setOnClickListener(calculatorListener);
        percentage.setOnClickListener(calculatorListener);
        add.setOnClickListener(calculatorListener);
        sub.setOnClickListener(calculatorListener);
        mul.setOnClickListener(calculatorListener);
        div.setOnClickListener(calculatorListener);
        equal.setOnClickListener(calculatorListener);
        dot.setOnClickListener(calculatorListener);

        final ImageButton back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String displayedElements = CalculatorScreen.getText().toString();
                int length = displayedElements.length();

                if(length>0){
                    displayedElements = displayedElements.substring(0,length-1);
                    CalculatorScreen.setText(displayedElements);
                }
            }
        });

        final ImageButton ac = findViewById(R.id.ac);
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 CalculatorScreen.setText("");
            }
        });
    }
}
