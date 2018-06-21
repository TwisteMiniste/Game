package com.example.mr_alex.mygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class playerVSplayer extends AppCompatActivity {

    TextView tvPlayer1;
    EditText etPlayer1;
    Button bControl1;
    TextView tvPlayer2;
    EditText etPlayer2;
    Button bControl2;

    int answer;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_vs_player);

        tvPlayer1 = findViewById(R.id.tvPlayer_1);
        tvPlayer2 = findViewById(R.id.tvPlayer2);
        etPlayer1 = findViewById(R.id.etPlayer1);
        etPlayer2 = findViewById(R.id.etPlayer2);
        bControl1 = findViewById(R.id.bControl1);
        bControl2 = findViewById(R.id.bControl2);

        answer = (int) (Math.random() * 100);

        gameFinished = false;
    }

    public void onClick(View v) {
        if ((etPlayer1.getText().length() != 0) || (etPlayer2.getText().length() != 0)) {
            if (!gameFinished) {
                int inp1 = Integer.parseInt(etPlayer1.getText().toString());
                int inp2 = Integer.parseInt(etPlayer2.getText().toString());

                if (inp1 > answer) {
                    tvPlayer1.setText(getResources().getString(R.string.less_than_input));
                }
                if (inp2 > answer) {
                    tvPlayer2.setText(getResources().getString(R.string.less_than_input));
                }

                if (inp1 < answer) {
                    tvPlayer1.setText(getResources().getString(R.string.greater_than_input));
                }
                if (inp2 < answer) {
                    tvPlayer2.setText(getResources().getString(R.string.greater_than_input));
                }

                if (inp1 == answer) {
                    tvPlayer1.setText(getResources().getString(R.string.player1_win));
                    tvPlayer2.setText(getResources().getString(R.string.player2_lose));

                    gameFinished = true;
                }
                if (inp2 == answer) {
                    tvPlayer1.setText(getResources().getString(R.string.player1_lose));
                    tvPlayer2.setText(getResources().getString(R.string.player2_win));

                    gameFinished = true;
                }
            } else {
                if ((etPlayer1.getText().length() != 0) || (etPlayer2.getText().length() != 0) || (etPlayer1.getText().length() == 0) || (etPlayer2.getText().length() == 0)) {
                    answer = (int) (Math.random() * 100);

                    tvPlayer1.setText(getResources().getString(R.string.app_name));
                    tvPlayer2.setText(getResources().getString(R.string.app_name));

                    gameFinished = false;
                }
                etPlayer1.setText("");
                etPlayer2.setText("");
            }
        } else {
            if (gameFinished) {
                if (etPlayer1.getText().length() == 0) {
                    tvPlayer1.setText(getResources().getString(R.string.player1_empty));
                }
                if (etPlayer2.getText().length() == 0) {
                    tvPlayer2.setText(getResources().getString(R.string.player2_empty));
                }
            }
        }
    }
}
