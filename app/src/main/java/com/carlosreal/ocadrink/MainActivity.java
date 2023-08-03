package com.carlosreal.ocadrink;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView Dice;
    Button RandomBox;
    private Random RandomDice;
    private Handler HandlerDice;
    private int DiceValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dice = findViewById(R.id.DiceImg);
        RandomBox = findViewById(R.id.RandBoxButton);
        HandlerDice = new Handler();

        RandomBox.setOnClickListener(view -> {
            Intent RandomIntent = new Intent(this, RandomboxActivity.class);
            startActivity(RandomIntent);
        });
    }

    public void RollDice(View view){
        view.setEnabled(false);
        AnimateDiceRoll();
    }

    public void AnimateDiceRoll(){
        HandlerDice.postDelayed(new Runnable() {
            @Override
            public void run() {
                RandomDice = new Random();
                DiceValue = RandomDice.nextInt(6) + 1;
                int drawableId = getResources().getIdentifier("dice" + DiceValue, "drawable", getPackageName());
                Dice.setImageResource(drawableId);

                if (DiceValue > 1) {
                    AnimateDiceRoll();
                } else {
                    findViewById(R.id.DiceImg).setEnabled(true);
                }
            }
        }, 100);
    }
}