package com.example.tiktaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    int activePlayer = 0;
    int []  gameState = {2,2,2,2,2,2,2,2,2};
    int [][] winPos  ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameActive = true;
    @SuppressLint("SetTextI18n")
    public void onTap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());


        if (!gameActive) {
            gameReset(view);

        }

        if (gameState[0]!=2 && gameState[1]!=2 && gameState[2]!=2 && gameState[3]!=2 && gameState[4]!=2 && gameState[5]!=2 && gameState[6]!=2 && gameState[7]!=2 && gameState[8]!=2 ){

            gameReset(view);
            TextView status = findViewById(R.id.Status);
            status.setText("Game Draw");
            status.setTextColor(Color.rgb(244,67,54));
        }

        else if (gameState[tappedImage] == 2){
            gameState[tappedImage] = activePlayer ;

            if (activePlayer == 0){
                img.setImageResource(R.drawable.ic_close);
                activePlayer = 1;
                TextView status = findViewById(R.id.Status);
                status.setText("Player2's Turn (Tap to Play)");
                status.setTextColor(Color.rgb(29,118,74));
            }
            else {
                img.setImageResource(R.drawable.ic_tick);
                activePlayer = 0;
                TextView status = findViewById(R.id.Status);
                status.setText("Player1's Turn (Tap to Play)");
                status.setTextColor(Color.rgb(244,67,54));
                }

        }

        for(int [] winPosition : winPos ){
            if (gameState[winPosition[0]]==gameState[winPosition[1]] &&
                    gameState[winPosition[1]]==gameState[winPosition[2]] &&
                        gameState[winPosition[0]]!=2){
                String winStr ;
                gameActive=false;
                if (gameState[winPosition[0]]==0){

                    winStr ="Player1 is Winner";

                }
                else{
                    winStr="Player2 is Winner";
                }
                TextView status = findViewById(R.id.Status);
                status.setText(winStr);
                status.setTextColor(Color.rgb(37,150,209));
            }
        }
    }

    public void gameReset(View view){
        activePlayer = 0;
        gameActive = true;
        for (int i = 0 ; i<gameState.length; i++) {
            gameState[i] = 2;
        }

        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}