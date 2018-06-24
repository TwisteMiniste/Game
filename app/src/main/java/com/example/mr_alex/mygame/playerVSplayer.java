package com.example.mr_alex.mygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class playerVSplayer extends AppCompatActivity {

    TextView tvPlayer_1, tvPlayer_2;
    TextView etPlayer_1, etPlayer_2;
    Button
    num_1,
    num_2,
    num_3,
    num_4,
    num_5,
    num_6,
    num_7,
    num_8,
    num_9,
    num_0,
    button_delete,
    button_enter;
    Button
    num_1_,
    num_2_,
    num_3_,
    num_4_,
    num_5_,
    num_6_,
    num_7_,
    num_8_,
    num_9_,
    num_0_,
    button_delete_,
    button_enter_;

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
        num_1 = findViewById(R.id.num_1);
        num_2 = findViewById(R.id.num_2);
        num_3 = findViewById(R.id.num_3);
        num_4 = findViewById(R.id.num_4);
        num_5 = findViewById(R.id.num_5);
        num_6 = findViewById(R.id.num_6);
        num_7 = findViewById(R.id.num_7);
        num_8 = findViewById(R.id.num_8);
        num_9 = findViewById(R.id.num_9);
        num_0 = findViewById(R.id.num_0);
        button_delete = findViewById(R.id.button_delete);
        button_enter = findViewById(R.id.button_enter);

        answer = (int)(Math.random()*diff);

        tvPlayer_1.setText(getResources().getString(R.string.app_name));
        tvPlayer_2.setText(getResources().getString(R.string.app_name));

        gameFinished = false;
    }

    public void onClick1(View v) {
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
                    playagain_yes1();
                }
            }
            break;
            default:
                break;
        }
    }

    public void onClick2(View v) {
        if (!gameFinished) {
            switch (v.getId()) {
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
                    playagain_yes2();
                }
            }
            break;
            default:
                break;
        }
    }

    private void setTvInput1 (char ch){
        String strInput1;
        if (!etPlayer_1.getText().toString().equals("0")){
            strInput1 = etPlayer_1.getText().toString() + ch;
        } else {
            strInput1 = "" + ch;
        }
        if (strInput1.length() <= 6) {
            etPlayer_1.setText(strInput1);
        } else {
            Toast.makeText(this,"Слишком большое число!", Toast.LENGTH_SHORT).show();
        }
    }

    private void setTvInput2 (char ch){
        String strInput2;
        if (!etPlayer_2.getText().toString().equals("0")){
            strInput2 = etPlayer_2.getText().toString() + ch;
        } else {
            strInput2 = "" + ch;
        }
        if (strInput2.length() <= 6) {
            etPlayer_2.setText(strInput2);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Слишком большое число!", Toast.LENGTH_LONG);
            View toastView = toast.getView();
            toastView.setRotation(180);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();
        }
    }

    private void playagain_yes1 () {
        answer = (int) (Math.random() * diff);

        tvPlayer_1.setText(getResources().getString(R.string.app_name));
        button_delete.setText(getResources().getString(R.string.num_delete));
        button_enter.setText(getResources().getString(R.string.num_enter));
        /*tvPlayer_2.setText(getResources().getString(R.string.app_name));
        button_delete_.setText(getResources().getString(R.string.num_delete));
        button_enter_.setText(getResources().getString(R.string.num_enter));
*/
        gameFinished = false;
    }

    private void playagain_yes2 () {
        answer = (int) (Math.random() * diff);

     /*   tvPlayer_1.setText(getResources().getString(R.string.app_name));
        button_delete.setText(getResources().getString(R.string.num_delete));
        button_enter.setText(getResources().getString(R.string.num_enter));*/
        tvPlayer_2.setText(getResources().getString(R.string.app_name));
        button_delete_.setText(getResources().getString(R.string.num_delete));
        button_enter_.setText(getResources().getString(R.string.num_enter));

        gameFinished = false;
    }

    private void playagain_no () {
        Intent mainMenu = new Intent(this, mainMenu.class);
        startActivity(mainMenu);
        finish();
    }

    private void compare1 (String str) {
        if (!etPlayer_1.getText().toString().equals("")) {
            if (!gameFinished) {
                int inp = Integer.parseInt(str);

                if (inp > answer) {
                    tvPlayer_1.setText(getResources().getString(R.string.less_than_input));
                }

                if (inp < answer) {
                    tvPlayer_1.setText(getResources().getString(R.string.greater_than_input));
                }

                if (inp == answer) {
                    tvPlayer_1.setText(getResources().getString(R.string.player1_win));
          //          tvPlayer_2.setText(getResources().getString(R.string.player2_lose));

                    button_delete.setText(getResources().getString(R.string.no));
                    button_enter.setText(getResources().getString(R.string.yes));
                //    button_delete_.setText(getResources().getString(R.string.no));
                  //  button_enter_.setText(getResources().getString(R.string.yes));

                    gameFinished = true;
                }
            }
        } else {
            Toast.makeText(this, "Пустое поле!", Toast.LENGTH_SHORT).show();
        }
    }

    private void compare2 (String str){
        if (!etPlayer_2.getText().toString().equals("")) {
            if (!gameFinished) {
                int inp = Integer.parseInt(str);

                if (inp > answer) {
                    tvPlayer_2.setText(getResources().getString(R.string.less_than_input));
                }

                if (inp < answer) {
                    tvPlayer_2.setText(getResources().getString(R.string.greater_than_input));
                }

                if (inp == answer) {
                    tvPlayer_2.setText(getResources().getString(R.string.player2_win));
             //       tvPlayer_1.setText(getResources().getString(R.string.player1_lose));

                    button_delete_.setText(getResources().getString(R.string.no));
                    button_enter_.setText(getResources().getString(R.string.yes));
                //    button_delete.setText(getResources().getString(R.string.no));
                  //  button_enter.setText(getResources().getString(R.string.yes));

                    gameFinished = true;
                }
            }
        } else {Toast toast = Toast.makeText(getApplicationContext(), "Пустое поле!", Toast.LENGTH_LONG);
            View toastView = toast.getView();
            toastView.setRotation(180);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();}
    }
}
