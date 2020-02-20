package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //0 is golden and 1 is copper
    int activeplayer=0;
    String target;
    boolean m=false;
    int count=0;

    int [] gamestate={2,2,2,2,2,2,2,2,2};
    int [][] winningPosition = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void dropIn(View view){

        ImageView image5 = (ImageView)view;
         target=image5.getTag().toString();

        if(gamestate[Integer.parseInt(target)]==2) {
            gamestate[Integer.parseInt(target)]=activeplayer;
            image5.setTranslationY(-1000f);
            if (activeplayer == 0) {
                image5.setImageResource(R.drawable.g1);
                count++;
                activeplayer = 1;
            } else {
                image5.setImageResource(R.drawable.copper2);
                count++;
                activeplayer = 0;
            }

            image5.animate().translationYBy(1000f).rotation(360).setDuration(500);
            for(int[] x:winningPosition){
                if(gamestate[x[0]]== gamestate[x[1]] &&  gamestate[x[1]]==gamestate[x[2]] && gamestate[x[0]]!=2){
                    if(x[0]==0){
                        Toast.makeText(this, "Congratulations..! Player 1 has won the game", Toast.LENGTH_SHORT).show();
                        m=true;
                    }
                    else{
                        Toast.makeText(this, "Congratulations..! Player 2 has won the game", Toast.LENGTH_SHORT).show();
                        m=true;
                    }
                }
            }
            if(m==true) {
                for (int i = 0; i < 9; i++) {
                    gamestate[i] = -1;
                }
            }
            if(count==9){
                    Toast.makeText(this, "It's a Tie!! Try Again ;)", Toast.LENGTH_SHORT).show();
                }


        }


    }

    public void clickMe(View view){
        activeplayer=0;
        m=false;
        count=0;
        GridLayout g =(GridLayout)findViewById(R.id.grid);
        for(int i=0;i<9;i++){
            gamestate[i]=2;
        }
        for(int j=0;j<g.getChildCount();j++){
            ((ImageView)g.getChildAt(j)).setImageResource(0);
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
