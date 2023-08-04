package com.carlosreal.ocadrink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView Dice;
    Button RandomBox, DiceButton;
    private Random RandomDice;
    private int TotalChanges = 20;
    private Handler HandlerDice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dice = findViewById(R.id.DiceImg);
        RandomBox = findViewById(R.id.RandBoxButton);
        RandomDice = new Random();

        Dice.setOnClickListener(view -> RollDice());

        RandomBox.setOnClickListener(view -> {
            Intent RandomIntent = new Intent(this, RandomboxActivity.class);
            startActivity(RandomIntent);
        });
    }

    private void RollDice() {
        // Desactivar el botón mientras se realiza la animación

        // Obtener una serie de valores aleatorios durante la animación
        final int[] DiceValues = new int[20];
        for (int i = 0; i < DiceValues.length; i++) {
            DiceValues[i] = RandomDice.nextInt(6) + 1;
        }

        // Crear la animación con una duración de 100ms por cada valor aleatorio
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

/*    public void RollDice(){
        Dice.setEnabled(false);
        AnimateDiceRoll(0);
    }*/

/*    public void AnimateDiceRoll(final int CurrentRoll){
        if (CurrentRoll < 20) { // Rolling 20 times before showing the final result
            // Update the image with a random value
            int DiceValue = RandomDice.nextInt(6) + 1;
            int DrawableId = getResources().getIdentifier("dice" + DiceValue, "drawable", getPackageName());
            Dice.setImageResource(DrawableId);

            // Schedule the next change after a short delay (100ms)
            new CountDownTimer(100, 100) {
                public void onFinish() {
                    AnimateDiceRoll(CurrentRoll + 1);
                }

                public void onTick(long millisUntilFinished) {
                    // Do nothing
                }
            }.start();
        } else {
            // After rolling is done, show the final random result
            int DiceValue = RandomDice.nextInt(6) + 1;
            int DrawableId = getResources().getIdentifier("dice" + DiceValue, "drawable", getPackageName());
            Dice.setImageResource(DrawableId);

            // Enable the button after the rolling process is complete
            Dice.setEnabled(true);
        }

    }*/
}