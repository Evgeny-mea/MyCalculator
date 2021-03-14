package com.mea.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private СalculatorLogic calculatorLogic;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int [] numbers = new int[] {
                R.id.button0,
                R.id.button1,
                R.id.button2,
                R.id.button3,
                R.id.button4,
                R.id.button5,
                R.id.button6,
                R.id.button7,
                R.id.button8,
                R.id.button9,
                R.id.buttonPt,
        };

        int [] logic = new int [] {
                R.id.buttonAdd,
                R.id.buttonDiv,
                R.id.buttonMinus,
                R.id.buttonMult,
                R.id.buttonRes,
        };

        text = findViewById(R.id.textView);

        calculatorLogic = new СalculatorLogic();

        View.OnClickListener LogicEnter = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorLogic.onActionPressed(v.getId(), text);
            }
        };


        View.OnClickListener NumberEnter = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorLogic.onNumPressed(v.getId(), text);
            }
        };


        for (int i = 0; i < numbers.length; i++) {
            findViewById(numbers[i]).setOnClickListener(NumberEnter);
        }

        for (int i = 0; i < logic.length; i++) {
            findViewById(logic[i]).setOnClickListener(LogicEnter);
        }

        findViewById(R.id.settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
}