package com.example.tictactoev2;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Board gameEngine;
    private int s1 = 0;
    private int s2 = 0;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.gameEngine = new Board();
        this.updateScore();
    }

    public void onClick(View v) {
        String viewId = getResources().getResourceName(v.getId());
        int id = viewId.charAt(28) - '0';
        int x = ((id - 1) / 3);
        int y = ((id - 1) % 3);
        this.handleMove(x,y);
    }

    public void updateScore() {
        TextView view = findViewById(R.id.textView);
        view.setText(String.valueOf(s1) + " - " + String.valueOf(s2));
    }

    public void handleMove(int x, int y) {
        if(gameEngine.getElt(x,y) == ' ') {
            char res1 = gameEngine.play(x,y);
            Log.d("Game", res1 + "");
            if(res1 != ' ') {
                this.handleEnd(res1);
            }

            char res2 = gameEngine.computer();
            Log.d("Game", res2 + "");
            if(res2 != ' ') {
                this.handleEnd(res2);
            }
        }
        this.updateButtons();
    }

    public void handleEnd(char c) {
        String msg = (c == 'T') ? "Game Ended. Tie" : "Game Ended. " + c + " wins";
        if(c == 'T') {
            this.s1 += 1;
            this.s2 += 1;
        }
        else if(c == 'X') {
            this.s1 += 1;
        }
        else {
            this.s2 += 1;
        }

        if (c == 'T') {
            this.clearGame();
        }
        this.updateScore();
        new AlertDialog.Builder(this).setTitle("Tic Tac Toe")
                .setMessage(msg)
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss( DialogInterface dialog ) {
                        Log.d("Game", "Here");
                        clearGame();
                    }
                }).show();
    }

    public void clearGame() {
        gameEngine.newGame();
        this.updateButtons();
    }

    public void updateButtons() {
        Button button1 = findViewById(R.id.b1);
        button1.setText(gameEngine.getElt(0,0) + "");
        if(gameEngine.getElt(0,0) == 'X') button1.setTextColor(Color.RED);
        else if(gameEngine.getElt(0,0) == 'O') button1.setTextColor(Color.BLUE);
        Button button2 = findViewById(R.id.b2);
        button2.setText(gameEngine.getElt(0,1) + "");
        if(gameEngine.getElt(0,1) == 'X') button2.setTextColor(Color.RED);
        else if(gameEngine.getElt(0,1) == 'O') button2.setTextColor(Color.BLUE);
        Button button3 = findViewById(R.id.b3);
        button3.setText(gameEngine.getElt(0,2) + "");
        if(gameEngine.getElt(0,2) == 'X') button3.setTextColor(Color.RED);
        else if(gameEngine.getElt(0,2) == 'O') button3.setTextColor(Color.BLUE);
        Button button4 = findViewById(R.id.b4);
        button4.setText(gameEngine.getElt(1,0) + "");
        if(gameEngine.getElt(1,0) == 'X') button4.setTextColor(Color.RED);
        else if(gameEngine.getElt(1,0) == 'O') button4.setTextColor(Color.BLUE);
        Button button5 = findViewById(R.id.b5);
        button5.setText(gameEngine.getElt(1,1) + "");
        if(gameEngine.getElt(1,1) == 'X') button5.setTextColor(Color.RED);
        else if(gameEngine.getElt(1,1) == 'O') button5.setTextColor(Color.BLUE);
        Button button6 = findViewById(R.id.b6);
        button6.setText(gameEngine.getElt(1,2) + "");
        if(gameEngine.getElt(1,2) == 'X') button6.setTextColor(Color.RED);
        else if(gameEngine.getElt(1,2) == 'O') button6.setTextColor(Color.BLUE);
        Button button7 = findViewById(R.id.b7);
        button7.setText(gameEngine.getElt(2,0) + "");
        if(gameEngine.getElt(2,0) == 'X') button7.setTextColor(Color.RED);
        else if(gameEngine.getElt(2,0) == 'O') button7.setTextColor(Color.BLUE);
        Button button8 = findViewById(R.id.b8);
        button8.setText(gameEngine.getElt(2,1) + "");
        if(gameEngine.getElt(2,1) == 'X') button8.setTextColor(Color.RED);
        else if(gameEngine.getElt(2,1) == 'O') button8.setTextColor(Color.BLUE);
        Button button9 = findViewById(R.id.b9);
        button9.setText(gameEngine.getElt(2,2) + "");
        if(gameEngine.getElt(2,2) == 'X') button9.setTextColor(Color.RED);
        else if(gameEngine.getElt(2,2) == 'O') button9.setTextColor(Color.BLUE);
    }
}
