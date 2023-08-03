package com.carlosreal.ocadrink;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
        RandomDice = new Random();
        HandlerDice = new Handler();

        Dice.setOnClickListener(view -> {
            RollDice();
        });

        RandomBox.setOnClickListener(view -> {
            Intent RandomIntent = new Intent(this, RandomboxActivity.class);
            startActivity(RandomIntent);
        });
    }

    private void RollDice() {
        // Desactivar el botón mientras se realiza la animación
        Dice.setEnabled(false);

        // Obtener una serie de valores aleatorios durante la animación
        final int[] DiceValues = new int[20];
        for (int i = 0; i < DiceValues.length; i++) {
            DiceValues[i] = RandomDice.nextInt(6) + 1;
        }

        // Crear la animación con una duración de 500ms por cada valor aleatorio
        final int animationDuration = 100;
        final Animation.AnimationListener animationListener = new Animation.AnimationListener() {
            int CurrentIndex = 0;

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                CurrentIndex++;
                if (CurrentIndex < DiceValues.length) {
                    // Actualizar la imagen con el siguiente valor aleatorio
                    int drawableId = getResources().getIdentifier("dice" + DiceValues[CurrentIndex], "drawable", getPackageName());
                    Dice.setImageResource(drawableId);

                    // Iniciar la siguiente animación
                    Dice.startAnimation(animation);
                } else {
                    // Habilitar el botón nuevamente después de la animación
                    Dice.setEnabled(true);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        };

        final Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        rotateAnimation.setDuration(animationDuration);
        rotateAnimation.setAnimationListener(animationListener);
        Dice.startAnimation(rotateAnimation);
    }

/*    public void RollDice(View view){
        view.setEnabled(false);
        AnimateDiceRoll();
    }*/

/*    public void AnimateDiceRoll(){
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
    }*/
}