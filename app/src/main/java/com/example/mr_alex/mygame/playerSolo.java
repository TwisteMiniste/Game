package com.example.mr_alex.mygame;

import android.content.Intent;
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

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_solo);

        tvInfo = findViewById(R.id.tvInfo);
        tvInput = findViewById(R.id.tvInput);
        button_delete = findViewById(R.id.button_delete);
        button_enter = findViewById(R.id.button_enter);
        button_difficulty = findViewById(R.id.button_difficulty);

        button_difficulty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(playerSolo.this, button_difficulty);
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
                            }
                            break;
                            case R.id.normal: {
                                diff = 500;
                                button_difficulty.setText(getString(R.string.normal));
                                tvInfo.setText(getString(R.string.difficulty_normal));
                                answer = (int)(Math.random()*diff+1);
                            }
                            break;
                            case R.id.hard: {
                                diff = 1000;
                                button_difficulty.setText(getString(R.string.hard));
                                tvInfo.setText(getString(R.string.difficulty_hard));
                                answer = (int)(Math.random()*diff+1);
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

        tvInfo.setText(getResources().getString(R.string.app_name));
        button_delete.setText(getResources().getString(R.string.num_delete));
        button_enter.setText(getResources().getString(R.string.num_enter));

        gameFinished = false;
    }

    private void playagain_no () {
      /*  Intent mainMenu = new Intent(this, mainMenu.class);
        startActivity(mainMenu);*/
        finish();
    }

    private void compare (String str){
        if (!tvInput.getText().toString().equals("")) {
            if (!gameFinished) {
                int inp = Integer.parseInt(str);

                if (inp > answer) {
                    tvInfo.setText(getResources().getString(R.string.less_than_input));
                }

                if (inp < answer) {
                    tvInfo.setText(getResources().getString(R.string.greater_than_input));
                }

                if (inp == answer) {
                    gameFinished = true;

                    tvInfo.setText(getResources().getString(R.string.win));

                    button_delete.setText(getResources().getString(R.string.no));
                    button_enter.setText(getResources().getString(R.string.yes));
                }
            }
        } else {Toast.makeText(this,getString(R.string.empty_field), Toast.LENGTH_SHORT).show();}
    }
}
