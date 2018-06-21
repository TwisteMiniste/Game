package com.example.mr_alex.mygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class playerSolo extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;

    int answer;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_solo);

        tvInfo = findViewById(R.id.textView);
        etInput = findViewById(R.id.editText);
        bControl = findViewById(R.id.button);

        answer = (int)(Math.random()*100);

        gameFinished = false;
    }

    public void onClick(View v) {
        if (etInput.getText().length() != 0) {
            if (!gameFinished) {
                int inp = Integer.parseInt(etInput.getText().toString());

                if (inp > answer) {
                    tvInfo.setText(getResources().getString(R.string.less_than_input));
                }

                if (inp < answer) {
                    tvInfo.setText(getResources().getString(R.string.greater_than_input));
                }

                if (inp == answer) {
                    tvInfo.setText(getResources().getString(R.string.win));
                    bControl.setText(getResources().getString(R.string.play_again));

                    gameFinished = true;
                }
            }
            else {
                answer = (int) (Math.random() * 100);

                bControl.setText(getResources().getString(R.string.input_value));
                tvInfo.setText(getResources().getString(R.string.app_name));

                gameFinished = false;
            }
            etInput.setText("");
        }
        else {
            Toast.makeText(this,"Пустое поле!",Toast.LENGTH_SHORT).show();tvInfo.setText(getResources().getString(R.string.error));}
    }
}
