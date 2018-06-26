package com.example.mr_alex.mygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mainMenu extends AppCompatActivity {

    public final int easy = 100;
    public final int normal = 500;
    public final int hard = 1000;

    Button playerSolo;
    Button playerVScomp;
    Button playerVSplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        playerSolo = findViewById(R.id.playerSolo);
        playerVScomp = findViewById(R.id.playerVScomp);
        playerVSplayer = findViewById(R.id.playerVSplayer);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.playerSolo:
                Intent intentSolo = new Intent(this, playerSolo.class);
                startActivity(intentSolo);
              //  finish();
                break;
            case R.id.playerVScomp:
                Intent intentPvE = new Intent(this, playerVScomp.class);
                startActivity(intentPvE);
              //  finish();
                break;
            case R.id.playerVSplayer:
                Intent intentPvP = new Intent(this, playerVSplayer.class);
                startActivity(intentPvP);
             //   finish();
                break;
        }
    }
}
