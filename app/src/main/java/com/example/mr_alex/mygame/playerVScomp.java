package com.example.mr_alex.mygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class playerVScomp extends AppCompatActivity {
    TextView tvInfo, tvInput;
    TextView tvComp1, tvComp2;
    Button button_delete, button_enter;
    Button button_difficulty;

    int diff = 100;
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
        tvInput = findViewById(R.id.tvInput);
        tvComp1 = findViewById(R.id.tvComp1);
        tvComp2 = findViewById(R.id.tvComp2);
        button_delete = findViewById(R.id.button_delete);
        button_enter = findViewById(R.id.button_enter);
        button_difficulty = findViewById(R.id.button_difficulty);

        button_difficulty.setText(getString(R.string.easy));
        tvInfo.setText(getString(R.string.difficulty_easy));

        button_difficulty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(playerVScomp.this, button_difficulty);
                popupMenu.getMenuInflater().inflate(R.menu.difficulty_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.easy: {
                                diff = 100;
                                button_difficulty.setText(getString(R.string.easy));
                                tvInfo.setText(getString(R.string.difficulty_easy));
                                answer = (int)(Math.random()*diff+1);
                                compMinBorder = 1;
                                compMaxBorder = 100;
                                tvComp1.setText(getString(R.string.empty));
                                tvComp2.setText(getString(R.string.empty));
                                compNum = (int) (Math.random()*(compMaxBorder - compMinBorder + 1)) + compMinBorder;
                            }
                            break;
                            case R.id.normal: {
                                diff = 500;
                                button_difficulty.setText(getString(R.string.normal));
                                tvInfo.setText(getString(R.string.difficulty_normal));
                                answer = (int)(Math.random()*diff+1);
                                compMinBorder = 1;
                                compMaxBorder = 500;
                                tvComp1.setText(getString(R.string.empty));
                                tvComp2.setText(getString(R.string.empty));
                                compNum = (int) (Math.random()*(compMaxBorder - compMinBorder + 1)) + compMinBorder;
                            }
                            break;
                            case R.id.hard: {
                                diff = 1000;
                                button_difficulty.setText(getString(R.string.hard));
                                tvInfo.setText(getString(R.string.difficulty_hard));
                                answer = (int)(Math.random()*diff+1);
                                compMinBorder = 1;
                                compMaxBorder = 1000;
                                tvComp1.setText(getString(R.string.empty));
                                tvComp2.setText(getString(R.string.empty));
                                compNum = (int) (Math.random()*(compMaxBorder - compMinBorder + 1)) + compMinBorder;
                            }
                            break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        answer = (int)(Math.random()*diff+1);
        compNum = (int)(Math.random()*diff+1);

        gameFinished = false;
    }

    public void onClick(View v) {
        if (!gameFinished) {
            switch (v.getId()) {
                case R.id.num_1: {
                    setTvInput('1');
                }
                break;
                case R.id.num_2: {
                    setTvInput('2');
                }
                break;
                case R.id.num_3: {
                    setTvInput('3');
                }
                break;
                case R.id.num_4: {
                    setTvInput('4');
                }
                break;
                case R.id.num_5: {
                    setTvInput('5');
                }
                break;
                case R.id.num_6: {
                    setTvInput('6');
                }
                break;
                case R.id.num_7: {
                    setTvInput('7');
                }
                break;
                case R.id.num_8: {
                    setTvInput('8');
                }
                break;
                case R.id.num_9: {
                    setTvInput('9');
                }
                break;
                case R.id.num_0: {
                    if (!tvInput.getText().toString().equals("0")) {
                        setTvInput('0');
                    }
                }
                break;
            }
        }
        switch (v.getId()) {
            case R.id.button_delete: {
                if (!gameFinished) {
                    tvInput.setText(R.string.empty);
                } else {
                    playagain_no();
                }
            }
            break;
            case R.id.button_enter: {
                if (!gameFinished) {
                    compare(tvInput.getText().toString());
                    tvInput.setText(R.string.empty);
                } else {
                    playagain_yes();
                }
            }
            break;
            default:
                break;
        }
    }

    private void setTvInput (char ch){
        String strInput;
        if (!tvInput.getText().toString().equals("0")){
            strInput = tvInput.getText().toString() + ch;
        } else {
            strInput = "" + ch;
        }
        if (strInput.length() <= 6) {
            tvInput.setText(strInput);
        } else {
            Toast.makeText(this,getString(R.string.overflow), Toast.LENGTH_SHORT).show();
        }
    }

    private void playagain_yes () {
        answer = (int) (Math.random() * diff+1);

        tvInfo.setText(getString(R.string.app_name));
        button_delete.setText(getString(R.string.num_delete));
        button_enter.setText(getString(R.string.num_enter));

        gameFinished = false;
    }

    private void playagain_no () {
/*        Intent mainMenu = new Intent(this, mainMenu.class);
        startActivity(mainMenu);*/
        finish();
    }

    private void compare (String str){
        if (!tvInput.getText().toString().equals("")) {
            if (!gameFinished) {
                int inp = Integer.parseInt(str);

                if (inp > answer) {
                    tvInfo.setText(getString(R.string.less_than_input));
                }
                if (compNum > answer) {
                    tvComp1.setText(getString(R.string.comp_input) + compNum);
                    tvComp2.setText(getString(R.string.comp_greater_than_input));
                    if (compNum < compMaxBorder){
                        compMaxBorder = compNum;
                    }
                    compNum = (int) (Math.random()*(compMaxBorder - compMinBorder + 1)) + compMinBorder;
                }

                if (inp < answer) {
                    tvInfo.setText(getString(R.string.greater_than_input));
                }
                if (compNum < answer) {
                    tvComp1.setText(getString(R.string.comp_input) + compNum);
                    tvComp2.setText(getString(R.string.comp_less_than_input));
                    if (compNum > compMinBorder){
                        compMinBorder = compNum;
                    }
                    compNum = (int) (Math.random()*(compMaxBorder - compMinBorder + 1)) + compMinBorder;
                }

                if (inp == answer) {
                    gameFinished = true;

                    tvInfo.setText(getString(R.string.win));

                    button_delete.setText(getString(R.string.no));
                    button_enter.setText(getString(R.string.yes));
                }
                if (compNum == answer) {
                    tvInfo.setText(getString(R.string.lose));
                    tvComp1.setText(getString(R.string.comp_input) + compNum);
                    tvComp2.setText(getString(R.string.comp_win));
                    button_delete.setText(getString(R.string.no));
                    button_enter.setText(getString(R.string.yes));

                    gameFinished = true;
                }
            }
        } else {Toast.makeText(this,getString(R.string.empty_field), Toast.LENGTH_SHORT).show();}
    }

}
