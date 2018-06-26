package com.example.mr_alex.mygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class playerVSplayer extends AppCompatActivity {

    TextView tvPlayer_1, tvPlayer_2;
    TextView etPlayer_1, etPlayer_2;
    Button button_delete, button_enter;
    Button button_delete_, button_enter_;
    Button button_difficulty, button_difficulty_;

    int diff = 100;
    int answer;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_vs_player);

        tvPlayer_1 = findViewById(R.id.tvPlayer_1);
        tvPlayer_2 = findViewById(R.id.tvPlayer_2);
        etPlayer_1 = findViewById(R.id.etPlayer_1);
        etPlayer_2 = findViewById(R.id.etPlayer_2);

        button_delete = findViewById(R.id.button_delete);
        button_enter = findViewById(R.id.button_enter);
        button_delete_ = findViewById(R.id.button_delete_);
        button_enter_ = findViewById(R.id.button_enter_);
        button_difficulty = findViewById(R.id.button_difficulty);
        button_difficulty_ = findViewById(R.id.button_difficulty_);

        button_difficulty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(playerVSplayer.this, button_difficulty);
                popupMenu.getMenuInflater().inflate(R.menu.difficulty_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.easy: {
                                diff = 100;
                                button_difficulty.setText(getString(R.string.easy));
                                tvPlayer_1.setText(getString(R.string.difficulty_easy));
                                tvPlayer_2.setText(getString(R.string.difficulty_easy));
                                answer = (int)(Math.random()*diff+1);
                            }
                            break;
                            case R.id.normal: {
                                diff = 500;
                                button_difficulty.setText(getString(R.string.normal));
                                tvPlayer_1.setText(getString(R.string.difficulty_normal));
                                tvPlayer_2.setText(getString(R.string.difficulty_normal));
                                answer = (int)(Math.random()*diff+1);
                            }
                            break;
                            case R.id.hard: {
                                diff = 1000;
                                button_difficulty.setText(getString(R.string.hard));
                                tvPlayer_1.setText(getString(R.string.difficulty_hard));
                                tvPlayer_2.setText(getString(R.string.difficulty_hard));
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

        button_difficulty_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(playerVSplayer.this, button_difficulty_);
                popupMenu.getMenuInflater().inflate(R.menu.difficulty_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.easy: {
                                diff = 100;
                                button_difficulty_.setText(getString(R.string.easy));
                                tvPlayer_1.setText(getString(R.string.difficulty_easy));
                                tvPlayer_2.setText(getString(R.string.difficulty_easy));
                                answer = (int)(Math.random()*diff+1);
                            }
                            break;
                            case R.id.normal: {
                                diff = 500;
                                button_difficulty_.setText(getString(R.string.normal));
                                tvPlayer_1.setText(getString(R.string.difficulty_normal));
                                tvPlayer_2.setText(getString(R.string.difficulty_normal));
                                answer = (int)(Math.random()*diff+1);
                            }
                            break;
                            case R.id.hard: {
                                diff = 1000;
                                button_difficulty_.setText(getString(R.string.hard));
                                tvPlayer_1.setText(getString(R.string.difficulty_hard));
                                tvPlayer_2.setText(getString(R.string.difficulty_hard));
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

        tvPlayer_1.setText(getString(R.string.app_name));
        tvPlayer_2.setText(getString(R.string.app_name));

        gameFinished = false;
    }

    public void onClick (View v) {
        if (!gameFinished) {
            switch (v.getId()) {
                case R.id.num_1: {
                    setTvInput1('1');
                }
                break;
                case R.id.num_2: {
                    setTvInput1('2');
                }
                break;
                case R.id.num_3: {
                    setTvInput1('3');
                }
                break;
                case R.id.num_4: {
                    setTvInput1('4');
                }
                break;
                case R.id.num_5: {
                    setTvInput1('5');
                }
                break;
                case R.id.num_6: {
                    setTvInput1('6');
                }
                break;
                case R.id.num_7: {
                    setTvInput1('7');
                }
                break;
                case R.id.num_8: {
                    setTvInput1('8');
                }
                break;
                case R.id.num_9: {
                    setTvInput1('9');
                }
                break;
                case R.id.num_0: {
                    if (!etPlayer_1.getText().toString().equals("0")) {
                        setTvInput1('0');
                    }
                }
                break;
                case R.id.num_1_: {
                    setTvInput2('1');
                }
                break;
                case R.id.num_2_: {
                    setTvInput2('2');
                }
                break;
                case R.id.num_3_: {
                    setTvInput2('3');
                }
                break;
                case R.id.num_4_: {
                    setTvInput2('4');
                }
                break;
                case R.id.num_5_: {
                    setTvInput2('5');
                }
                break;
                case R.id.num_6_: {
                    setTvInput2('6');
                }
                break;
                case R.id.num_7_: {
                    setTvInput2('7');
                }
                break;
                case R.id.num_8_: {
                    setTvInput2('8');
                }
                break;
                case R.id.num_9_: {
                    setTvInput2('9');
                }
                break;
                case R.id.num_0_: {
                    if (!etPlayer_2.getText().toString().equals("0")) {
                        setTvInput2('0');
                    }
                }
                break;
            }
        }
        switch (v.getId()) {
            case R.id.button_delete: {
                if (!gameFinished) {
                    etPlayer_1.setText(R.string.empty);
                } else {
                    playagain_no();
                }
            }
            break;
            case R.id.button_enter: {
                if (!gameFinished) {
                    compare1(etPlayer_1.getText().toString());
                    etPlayer_1.setText(R.string.empty);
                } else {
                    playagain_yes();
                }
            }
            break;
            case R.id.button_delete_: {
                if (!gameFinished) {
                    etPlayer_2.setText(R.string.empty);
                } else {
                    playagain_no();
                }
            }
            break;
            case R.id.button_enter_: {
                if (!gameFinished) {
                    compare2(etPlayer_2.getText().toString());
                    etPlayer_2.setText(R.string.empty);
                } else {
                    playagain_yes();
                }
            }
            break;
            default: break;
        }
    }

    private void setTvInput1 (char ch){
        String strInput;
        if (!etPlayer_1.getText().toString().equals("0")){
            strInput = etPlayer_1.getText().toString() + ch;
        } else {
            strInput = "" + ch;
        }
        if (strInput.length() <= 6) {
            etPlayer_1.setText(strInput);
        } else {
            Toast.makeText(this,getString(R.string.overflow), Toast.LENGTH_SHORT).show();
        }
    }

    private void setTvInput2 (char ch){
        String strInput;
        if (!etPlayer_2.getText().toString().equals("0")){
            strInput = etPlayer_2.getText().toString() + ch;
        } else {
            strInput = "" + ch;
        }
        if (strInput.length() <= 6) {
            etPlayer_2.setText(strInput);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.overflow), Toast.LENGTH_LONG);
            View toastView = toast.getView();
            toastView.setRotation(180);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();
        }
    }

    private void playagain_yes () {
        answer = (int) (Math.random() * diff+1);

        tvPlayer_1.setText(getString(R.string.app_name));
        button_delete.setText(getString(R.string.num_delete));
        button_enter.setText(getString(R.string.num_enter));
        tvPlayer_2.setText(getString(R.string.app_name));
        button_delete_.setText(getString(R.string.num_delete));
        button_enter_.setText(getString(R.string.num_enter));

        gameFinished = false;
    }

        private void playagain_no () {
         /*  Intent mainMenu = new Intent(this, mainMenu.class);
            startActivity(mainMenu);*/
            finish();
        }


    private void compare1 (String str) {
        if (!etPlayer_1.getText().toString().equals("")) {
            if (!gameFinished) {
                int inp = Integer.parseInt(str);

                if (inp > answer) {
                    tvPlayer_1.setText(getString(R.string.less_than_input));
                }

                if (inp < answer) {
                    tvPlayer_1.setText(getString(R.string.greater_than_input));
                }

                if (inp == answer) {
                    tvPlayer_1.setText(getString(R.string.player1_win));
                    tvPlayer_2.setText(getString(R.string.player2_lose));

                    setGameFinished();
                }
            }
        } else {
            Toast.makeText(this, getString(R.string.empty_field), Toast.LENGTH_SHORT).show();
        }
    }

    private void compare2 (String str){
        if (!etPlayer_2.getText().toString().equals("")) {
            if (!gameFinished) {
                int inp = Integer.parseInt(str);

                if (inp > answer) {
                    tvPlayer_2.setText(getString(R.string.less_than_input));
                }

                if (inp < answer) {
                    tvPlayer_2.setText(getString(R.string.greater_than_input));
                }

                if (inp == answer) {
                    tvPlayer_2.setText(getString(R.string.player2_win));
                    tvPlayer_1.setText(getString(R.string.player1_lose));

                    setGameFinished();
                }
            }
        } else {Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.empty_field), Toast.LENGTH_LONG);
            View toastView = toast.getView();
            toastView.setRotation(180);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();}
    }

    private void setGameFinished (){
        button_delete_.setText(getString(R.string.no));
        button_enter_.setText(getString(R.string.yes));
        button_delete.setText(getString(R.string.no));
        button_enter.setText(getString(R.string.yes));

        gameFinished = true;
    }
}
