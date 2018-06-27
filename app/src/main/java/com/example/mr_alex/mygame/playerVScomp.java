package com.example.mr_alex.mygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class playerVScomp extends AppCompatActivity {

    TextView tvInfo, tvInput;
    TextView tvComp1, tvComp2;
    Button button_delete, button_enter;
    Button button_difficulty;

    static int diff = 100;
    static int compMinBorder = 1;
    static int compMaxBorder = 100;
    static int answer;
    static int compNum;
    static boolean gameFinished;

    private static final int
            DIFFICULTY_EASY = 0,
            DIFFICULTY_NORMAL = 1,
            DIFFICULTY_HARD = 2,
            DIFFICULTY_IMPOSSIBLE = 3;

    private static int DIFFICULTY = 0;

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

        button_difficulty.setText(R.string.easy);
        tvInfo.setText(R.string.difficulty_easy);

        answer = (int)(Math.random()*diff + 1);

        gameFinished = false;
    }

    public void onClick(View view) {
        if (!gameFinished) {
            switch (view.getId()) {
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
                    setTvInput('0');
                }
                break;
            }
        }
        switch (view.getId()) {
            case R.id.button_delete: {
                if (!gameFinished) {
                    tvInput.setText(R.string.empty);
                } else {
                    finish();
                }
            }
            break;
            case R.id.button_enter: {
                if (!gameFinished) {
                    checkPlayerInput();
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
        String strInput = tvInput.getText().toString();
        if (strInput.equals("0")){
                strInput = "" + ch;
        } else {
            strInput = strInput + ch;
        }
        if (strInput.length() <= 6) {
            tvInput.setText(strInput);
        } else {
            Toast.makeText(this, R.string.overflow, Toast.LENGTH_SHORT).show();
        }
    }

    private void playagain_yes () {

        answer = (int) (Math.random() * diff + 1);

        switch (DIFFICULTY){
            case DIFFICULTY_EASY: {
                tvInfo.setText(R.string.difficulty_easy);
            } break;
            case DIFFICULTY_NORMAL: {
                tvInfo.setText(R.string.difficulty_normal);
            } break;
            case DIFFICULTY_HARD: {
                tvInfo.setText(R.string.difficulty_hard);
            } break;
            case DIFFICULTY_IMPOSSIBLE: {
                tvInfo.setText(R.string.difficulty_impossible);
            } break;
            default: break;
        }

        button_delete.setText(R.string.num_delete);
        button_enter.setText(R.string.num_enter);

        gameFinished = false;
    }

    private void checkPlayerInput() {
        if (!tvInput.getText().toString().equals("")) {
            int inp = Integer.parseInt(tvInput.getText().toString());
            if (inp < answer) {
                tvInfo.setText(R.string.greater_than_input);
                if (inp > compMinBorder) {
                    compMinBorder = inp;
                }
            } else if (inp > answer) {
                tvInfo.setText(R.string.less_than_input);
                if (inp < compMaxBorder) {
                    compMaxBorder = inp;
                }
            } else {
                gameFinished = true;
                tvInfo.setText(R.string.win);
                button_delete.setText(R.string.no);
                button_enter.setText(R.string.yes);
            }
            randomComp();
        } else {
            Toast.makeText(this, R.string.empty_field, Toast.LENGTH_SHORT).show();
        }
    }

    private void randomComp() {
        compNum = (int) (Math.random()*(compMaxBorder - compMinBorder + 1)) + compMinBorder;
        checkCompInput();
    }

    private void checkCompInput() {
        if (compNum > answer) {
            tvComp1.setText(getString(R.string.comp_input, compNum));
            tvComp2.setText(R.string.comp_greater_than_input);
            if (compNum < compMaxBorder){
                compMaxBorder = compNum;
            }
            compNum = (int) (Math.random()*(compMaxBorder - compMinBorder + 1)) + compMinBorder;
        } else if (compNum < answer) {
            tvComp1.setText(getString(R.string.comp_input, compNum));
            tvComp2.setText(R.string.comp_less_than_input);
            if (compNum > compMinBorder){
                compMinBorder = compNum;
            }
            compNum = (int) (Math.random()*(compMaxBorder - compMinBorder + 1)) + compMinBorder;
        } else {
            tvInfo.setText(R.string.lose);
            tvComp1.setText(getString(R.string.comp_input, compNum));
            tvComp2.setText(R.string.comp_win);
            button_delete.setText(R.string.no);
            button_enter.setText(R.string.yes);

            gameFinished = true;
        }
    }

    private void changeDifficulty (int maxBorder){
        answer = (int)(Math.random()*diff+1);
        compMinBorder = 1;
        compMaxBorder = maxBorder;
        tvComp1.setText(R.string.empty);
        tvComp2.setText(R.string.empty);
        compNum = (int) (Math.random()*(compMaxBorder - compMinBorder + 1)) + compMinBorder;
    }

    public void openPopupmenu (View view){
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(R.menu.difficulty_menu);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.easy: {
                        DIFFICULTY = DIFFICULTY_EASY;
                        diff = 100;
                        button_difficulty.setText(R.string.easy);
                        tvInfo.setText(R.string.difficulty_easy);
                        changeDifficulty(diff);
                    } break;
                    case R.id.normal: {
                        DIFFICULTY = DIFFICULTY_NORMAL;
                        diff = 500;
                        button_difficulty.setText(R.string.normal);
                        tvInfo.setText(R.string.difficulty_normal);
                        changeDifficulty(diff);
                    } break;
                    case R.id.hard: {
                        DIFFICULTY = DIFFICULTY_HARD;
                        diff = 1000;
                        button_difficulty.setText(R.string.hard);
                        tvInfo.setText(R.string.difficulty_hard);
                        changeDifficulty(diff);
                    } break;
                    case R.id.impossible: {
                        DIFFICULTY = DIFFICULTY_IMPOSSIBLE;
                        diff = 999999;
                        button_difficulty.setText(R.string.impossible);
                        tvInfo.setText(R.string.difficulty_impossible);
                        changeDifficulty(diff);
                    } break;
                }
                return true;
            }
        });
        popupMenu.show();
    }
}
