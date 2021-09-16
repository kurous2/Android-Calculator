package com.dahee.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public final class MainActivity extends AppCompatActivity {
    Button buttonZero;
    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    Button buttonFour;
    Button buttonFive;
    Button buttonSix;
    Button buttonSeven;
    Button buttonEight;
    Button buttonNine;

    Button buttonClear;
    Button buttonOpenParentheses;
    Button buttonClosedParentheses;
    Button buttonPercent;
    Button buttonDivision;
    Button buttonSquare;
    Button buttonSquareRoot;
    Button buttonMultiplication;
    Button buttonSubtraction;
    Button buttonAddition;
    Button buttonEqual;
    Button buttonDot;
    Button buttonDel;

    TextView textViewInputNumbers;
    String inputText = "";

    String formula = "";
    String tempFormula = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);
        initializeViewVariables();

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = textViewInputNumbers.getText().toString();
                if (inputText.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a valid number", Toast.LENGTH_SHORT).show();
                } else {
                    setInputText("0");
                }
            }
        });
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputText("1");
            }
        });
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputText("2");
            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputText("3");
            }
        });
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputText("4");
            }
        });
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputText("5");
            }
        });
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputText("6");
            }
        });
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputText("7");
            }
        });
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputText("8");
            }
        });
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputText("9");
            }
        });
        buttonOpenParentheses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputText("(");
            }
        });
        buttonClosedParentheses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputText(")");
            }
        });
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = textViewInputNumbers.getText().toString();
                if (temp.isEmpty()) {
                    setInputText("0.");
                } else {
                    String lastExpression = temp.substring(temp.length() - 1);
                    if (lastExpression.equals(".")) {
                        setInputText("0");
                    } else {
                        boolean isValid = false;
                        for (int i = 0; i < inputText.length(); i++) {
                            if (inputText.charAt(i) == '.') {
                                isValid = false;
                                break;
                            } else
                                isValid = true;
                        }
                        if (isValid)
                            setInputText(".");
                        else
                            setInputText("");
                    }

                }
            }
        });

        buttonAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = textViewInputNumbers.getText().toString();
                if (temp.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a valid number", Toast.LENGTH_SHORT).show();
                } else {
                    String lastExpression = temp.substring(temp.length() - 1);

                    if (lastExpression.equals("+")) {
                        setInputText("");
                    } else {
                        setInputText("+");
                    }

                }
            }
        });

        buttonSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = textViewInputNumbers.getText().toString();
                if (temp.isEmpty()) {
                    setInputText("-");
                } else {
                    String lastExpression = temp.substring(temp.length() - 1);
                    if (lastExpression.equals("-")) {
                        setInputText("");
                    } else {
                        setInputText("-");
                    }

                }
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = textViewInputNumbers.getText().toString();
                if (temp.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a valid number", Toast.LENGTH_SHORT).show();
                } else {
                    String lastExpression = temp.substring(temp.length() - 1);
                    if (lastExpression.equals("/")) {
                        setInputText("");
                    } else {
                        setInputText("/");
                    }

                }
            }
        });
        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = textViewInputNumbers.getText().toString();
                if (temp.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a valid number", Toast.LENGTH_SHORT).show();
                } else {
                    String lastExpression = temp.substring(temp.length() - 1);
                    if (lastExpression.equals("*")) {
                        setInputText("");
                    } else {
                        setInputText("*");
                    }

                }
            }
        });
        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = inputText;
                if (temp.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a valid number", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isValid = false;
                    for (int i = 0; i < inputText.length(); i++) {
                        if (!isNumeric(inputText.charAt(i))&&inputText.charAt(0)!='-') {
                            isValid = false;
                            break;
                        } else
                            isValid = true;
                    }

                    if (isValid) {
                        System.out.println(isValid);
                        double percentage = Double.parseDouble(inputText)/100;
                        inputText = String.valueOf(percentage);
                        textViewInputNumbers.setText(inputText);
                    } else
                        Toast.makeText(getApplicationContext(), "Wrong Format", Toast.LENGTH_SHORT).show();

                }
            }
        });
        buttonSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = textViewInputNumbers.getText().toString();
                if (temp.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a valid number", Toast.LENGTH_SHORT).show();
                } else {
                    String lastExpression = temp.substring(temp.length() - 1);
                    if (lastExpression.equals("^")) {
                        setInputText("");
                    } else {
                        setInputText("^");
                    }

                }
            }
        });
        buttonSquareRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = inputText;
                if (temp.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a valid number", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isValid = false;
                    for (int i = 0; i < inputText.length(); i++) {
                        if (!isNumeric(inputText.charAt(i))) {
                            isValid = false;
                            break;
                        } else
                            isValid = true;
                    }

                    if (isValid) {
                        System.out.println(isValid);
                        double squareRoot = Math.sqrt(Double.parseDouble(temp));
                        inputText = String.valueOf(squareRoot);
                        textViewInputNumbers.setText(inputText);
                    } else
                        Toast.makeText(getApplicationContext(), "Please enter a valid number", Toast.LENGTH_SHORT).show();

                }
            }
        });

        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = inputText;
                if (!temp.equals("")) {
                    temp = temp.substring(0, temp.length() - 1);
                    textViewInputNumbers.setText(temp);
                    inputText = temp;
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewInputNumbers.setText("");
                inputText = "";
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double result = null;
                ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
                checkForPowerOf();
                try {
                    result = (double) engine.eval(formula);
                    inputText = String.valueOf(result.doubleValue());
                } catch (ScriptException e) {
                    Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
                }

                if (result != null)
                    textViewInputNumbers.setText(String.valueOf(inputText));
            }
        });
    }

    private void checkForPowerOf() {
        ArrayList<Integer> indexOfPowers = new ArrayList<>();
        for (int i = 0; i < inputText.length(); i++) {
            if (inputText.charAt(i) == '^')
                indexOfPowers.add(i);
        }

        formula = inputText;
        tempFormula = inputText;
        for (Integer index : indexOfPowers) {
            changeFormula(index);
        }
        formula = tempFormula;
    }

    private void changeFormula(Integer index) {
        String numberLeft = "";
        String numberRight = "";

        for (int i = index + 1; i < inputText.length(); i++) {
            if (isNumeric(inputText.charAt(i)))
                numberRight = numberRight + inputText.charAt(i);
            else
                break;
        }

        for (int i = 0 ; i < index; i++) {
            if (isNumeric(inputText.charAt(i)))
                numberLeft = numberLeft + inputText.charAt(i);
            else
                break;
        }

        String original = numberLeft + "^" + numberRight;
        String changed = "Math.pow(" + numberLeft + "," + numberRight + ")";
        tempFormula = tempFormula.replace(original, changed);
    }

    private boolean isNumeric(char c) {
        if ((c <= '9' && c >= '0') || c == '.')
            return true;

        return false;
    }

    private void initializeViewVariables() {
        buttonZero = (Button) findViewById(R.id.button_zero);
        buttonOne = (Button) findViewById(R.id.button_one);
        buttonTwo = (Button) findViewById(R.id.button_two);
        buttonThree = (Button) findViewById(R.id.button_three);
        buttonFour = (Button) findViewById(R.id.button_four);
        buttonFive = (Button) findViewById(R.id.button_five);
        buttonSix = (Button) findViewById(R.id.button_six);
        buttonSeven = (Button) findViewById(R.id.button_seven);
        buttonEight = (Button) findViewById(R.id.button_eight);
        buttonNine = (Button) findViewById(R.id.button_nine);

        buttonClear = (Button) findViewById(R.id.button_clear);
        buttonOpenParentheses = (Button) findViewById(R.id.button_openParentheses);
        buttonClosedParentheses = (Button) findViewById(R.id.button_closedParentheses);
        buttonSquare = (Button) findViewById(R.id.button_square);
        buttonSquareRoot = (Button) findViewById(R.id.button_squareRoot);
        buttonPercent = (Button) findViewById(R.id.button_percent);
        buttonDivision = (Button) findViewById(R.id.button_div);
        buttonDel = (Button) findViewById(R.id.button_del);
        buttonMultiplication = (Button) findViewById(R.id.button_multiplication);
        buttonSubtraction = (Button) findViewById(R.id.button_subtraction);
        buttonAddition = (Button) findViewById(R.id.button_addition);
        buttonEqual = (Button) findViewById(R.id.button_equal);
        buttonDot = (Button) findViewById(R.id.button_dot);
        textViewInputNumbers = (TextView) findViewById(R.id.textView_input_numbers);
    }

    private void setInputText(String givenValue) {
        inputText = inputText + givenValue;
        textViewInputNumbers.setText(inputText);
    }

}
