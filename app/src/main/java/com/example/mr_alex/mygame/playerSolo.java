package com.example.mr_alex.mygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class playerSolo extends AppCompatActivity {

    TextView tvInfo;
    TextView tvInput;
    Button button_delete, button_enter;
    Button button_difficulty;

    int diff=100;
    int answer;
    boolean gameFinished;

    private static final int
            DIFFICULTY_EASY = 0,
            DIFFICULTY_NORMAL = 1,
            DIFFICULTY_HARD = 2,
            DIFFICULTY_IMPOSSIBLE = 3;

    private static int DIFFICULTY = 0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_solo);

        tvInfo = findViewById(R.id.tvInfo);
        tvInput = findViewById(R.id.tvInput);
        button_delete = findViewById(R.id.button_delete);
        button_enter = findViewById(R.id.button_enter);
        button_difficulty = findViewById(R.id.button_difficulty);

        answer = (int)(Math.random()*diff+1);

        button_difficulty.setText(getString(R.string.easy));
        tvInfo.setText(getResources().getString(R.string.difficulty_easy));

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

    private void playagain_no () {
        finish();
    }

    private void checkPlayerInput() {
        if (!tvInput.getText().toString().equals("")) {
            int inp = Integer.parseInt(tvInput.getText().toString());
            if (inp < answer) {
                tvInfo.setText(R.string.greater_than_input);
            } else if (inp > answer) {
                tvInfo.setText(R.string.less_than_input);
            } else {
                gameFinished = true;
                tvInfo.setText(R.string.win);
                button_delete.setText(R.string.no);
                button_enter.setText(R.string.yes);
            }
        } else {
            Toast.makeText(this, R.string.empty_field, Toast.LENGTH_SHORT).show();
        }
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
                        answer = (int)(Math.random()*diff+1);
                    } break;
                    case R.id.normal: {
                        DIFFICULTY = DIFFICULTY_NORMAL;
                        diff = 500;
                        button_difficulty.setText(R.string.normal);
                        tvInfo.setText(R.string.difficulty_normal);
                        answer = (int)(Math.random()*diff+1);
                    } break;
                    case R.id.hard: {
                        DIFFICULTY = DIFFICULTY_HARD;
                        diff = 1000;
                        button_difficulty.setText(R.string.hard);
                        tvInfo.setText(R.string.difficulty_hard);
                        answer = (int)(Math.random()*diff+1);
                    } break;
                    case R.id.impossible: {
                        DIFFICULTY = DIFFICULTY_IMPOSSIBLE;
                        diff = 999999;
                        button_difficulty.setText(R.string.impossible);
                        tvInfo.setText(R.string.difficulty_impossible);
                        answer = (int)(Math.random()*diff+1);
                    } break;
                }
                return true;
            }
        });
        popupMenu.show();
    }
}
