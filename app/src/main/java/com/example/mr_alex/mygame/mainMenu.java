package com.example.mr_alex.mygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mainMenu extends AppCompatActivity {

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
                break;
            case R.id.playerVScomp:
                Intent intentPvE = new Intent(this, playerVScomp.class);
                startActivity(intentPvE);
                break;
            case R.id.playerVSplayer:
                Intent intentPvP = new Intent(this, playerVSplayer.class);
                startActivity(intentPvP);
                break;
        }
    }
}
