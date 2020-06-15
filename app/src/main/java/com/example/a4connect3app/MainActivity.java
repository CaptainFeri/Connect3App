package com.example.a4connect3app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //0:yellow , 1:red , 2:empty

    int[] board_states = {2,2,2,2,2,2,2,2,2};
    int[][] win_statuse = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameActivity = true;

    TextView winnerTextView;
    Button playAgainBtn;


    int user_term = 0;

    public void tapTooChoose(View view){

        winnerTextView = findViewById(R.id.winnerTextView);
        winnerTextView.setVisibility(View.INVISIBLE);
        playAgainBtn = findViewById(R.id.playAgainBtn);
        playAgainBtn.setVisibility(View.INVISIBLE);

        ImageView item = (ImageView) view;
        int item_select = Integer.parseInt(item.getTag().toString());


        for (int[] select : win_statuse){
            if (board_states[select[0]] == board_states[select[1]] &
                    board_states[select[1]] == board_states[select[2]] &
                    board_states[select[0]] == board_states[select[2]] &
                    board_states[select[0]] != 2){
                gameActivity = false;
                if (user_term == 0){
                    winnerTextView.setText("yellow won the Game !");
                    winnerTextView.setVisibility(View.VISIBLE);
                    playAgainBtn.setVisibility(View.VISIBLE);
                }
                else {
                    winnerTextView.setText("Red won the Game !");
                    winnerTextView.setVisibility(View.VISIBLE);
                    playAgainBtn.setVisibility(View.VISIBLE);
                }
            }
        }

        if(user_term == 0 & board_states[item_select] == 2 & gameActivity){
            item.setImageResource(R.drawable.red);
            item.setTranslationY(-1500);
            item.animate().translationYBy(1500).rotation(3600).setDuration(1000);
            board_states[item_select] = user_term;
            user_term = 1;
        }else if (user_term == 1 & board_states[item_select] == 2 & gameActivity){
            item.setImageResource(R.drawable.yellow4);
            item.setTranslationY(-1500);
            item.animate().translationYBy(1500).rotation(3600).setDuration(1000);
            board_states[item_select] = user_term;
            user_term = 0;
        }
    }

    public void playAgain(View view){

        GridLayout gridLayout = this.<GridLayout>findViewById(R.id.gridLayout_connet3);
        winnerTextView = findViewById(R.id.winnerTextView);
        winnerTextView.setVisibility(View.INVISIBLE);
        playAgainBtn = findViewById(R.id.playAgainBtn);
        playAgainBtn.setVisibility(View.INVISIBLE);

        for (int i = 0 ; i <board_states.length ; i++){
             board_states[i] = 2;
         }

         for ( int i = 0 ; i<gridLayout.getChildCount();i++){
             ImageView child = (ImageView) gridLayout.getChildAt(i);
             child.setImageDrawable(null);
         }
         gameActivity = true;
         winnerTextView.setVisibility(View.INVISIBLE);
         playAgainBtn.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        winnerTextView = findViewById(R.id.winnerTextView);
        winnerTextView.setVisibility(View.INVISIBLE);
        playAgainBtn = findViewById(R.id.playAgainBtn);
        playAgainBtn.setVisibility(View.INVISIBLE);
    }
}
