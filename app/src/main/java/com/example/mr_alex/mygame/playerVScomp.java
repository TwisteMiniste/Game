package com.example.mr_alex.mygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class playerVScomp extends AppCompatActivity {
    TextView tvInfo;
    TextView tvComp1, tvComp2;
    EditText etInput;
    Button bControl;

    int compMinBorder = 1;
    int compMaxBorder = 100;
    int answer;
    int compNum;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_vs_comp);

        tvInfo = findViewById(R.id.tvInfo);
        tvComp1 = findViewById(R.id.tvComp1);
        tvComp2 = findViewById(R.id.tvComp2);

        tvInfo.setText(getResources().getString(R.string.app_name));
        bControl.setText(getResources().getString(R.string.button_begin));

        answer = (int)(Math.random()*100);
        compNum = (int)(Math.random()*100);

        gameFinished = false;
    }

    public void onClick(View v) {
        if (etInput.getText().length() != 0) {
            if (!gameFinished) {
                int inp = Integer.parseInt(etInput.getText().toString());

                if (inp > answer) {
                    tvInfo.setText(getResources().getString(R.string.less_than_input));
                }
                if (compNum > answer) {
                    tvComp1.setText(getResources().getString(R.string.comp_input) + compNum);
                    tvComp2.setText(getResources().getString(R.string.comp_greater_than_input));
                    if (compNum < compMaxBorder){
                        compMaxBorder = compNum;
                    }
                    compNum = (int) (Math.random()*(compMaxBorder - compMinBorder + 1)) + compMinBorder;
                }

                if (inp < answer) {
                    tvInfo.setText(getResources().getString(R.string.greater_than_input));
                }
                if (compNum < answer) {
                    tvComp1.setText(getResources().getString(R.string.comp_input) + compNum);
                    tvComp2.setText(getResources().getString(R.string.comp_less_than_input));
                    if (compNum > compMinBorder){
                        compMinBorder = compNum;
                    }
                    compNum = (int) (Math.random()*(compMaxBorder - compMinBorder + 1)) + compMinBorder;
                }

                if (inp == answer) {
                    tvInfo.setText(getResources().getString(R.string.win));
                    bControl.setText(getResources().getString(R.string.play_again));

                    gameFinished = true;
                }
                if (compNum == answer) {
                    tvInfo.setText(getResources().getString(R.string.lose));
                    tvComp1.setText(getResources().getString(R.string.comp_input) + compNum);
                    tvComp2.setText(getResources().getString(R.string.comp_win));
                    bControl.setText(getResources().getString(R.string.play_again));

                    gameFinished = true;
                }
            } else {
                answer = (int) (Math.random() * 100);

                compMinBorder = 0;
                compMaxBorder = 100;
                compNum = (int)(Math.random()*100);

                bControl.setText(getResources().getString(R.string.input_value));
                tvInfo.setText(getResources().getString(R.string.app_name));

                gameFinished = false;
            }
            etInput.setText("");
        }
        else {
            Toast.makeText(this,"Пустое поле!", Toast.LENGTH_SHORT).show();tvInfo.setText(getResources().getString(R.string.error));}
    }
}
