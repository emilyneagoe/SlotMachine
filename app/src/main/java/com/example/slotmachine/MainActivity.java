package com.example.slotmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private LinearLayout grid;
    private TextView pointDisplay;
    private Drawable strawberryImage;
    private Drawable grapeImage;
    private Drawable cherryImage;
    private Drawable pearImage;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    public UpdateGame update;
    public UpdateGame2 update2;
    public UpdateGame3 update3;
    public Handler handler;
    public boolean on;
    public int imageChosen;
    public int imageChosen2;
    public int imageChosen3;
    public int points;
    private SeekBar speedBar;
    public int speed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        speedBar = findViewById(R.id.speedBar);
        strawberryImage = getDrawable(R.drawable.strawberry);
        grapeImage = getDrawable(R.drawable.grape);
        cherryImage = getDrawable(R.drawable.cherry);
        pearImage = getDrawable(R.drawable.pear);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        pointDisplay = findViewById(R.id.pointDisplay);
        imageChosen = 1;
        imageChosen2 = 1;
        imageChosen3 = 1;
        points = 0;
        speed = 1;
        update = new UpdateGame();
        update2 = new UpdateGame2();
        update3 = new UpdateGame3();
        handler = new Handler();

        speedBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                speed = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void helpPressed(View v) {
        Intent i = new Intent(this, HelpActivity.class);
        startActivity(i);
    }


    public void startPressed(View v) {
        if (on)  {
            on = false;
            handler.removeCallbacks(update);
            handler.removeCallbacks(update2);
            handler.removeCallbacks(update3);

            if (imageChosen == 1) {
                if (imageChosen2 == 1) {
                    if (imageChosen3 == 1) {
                        points = points + 100;

                    }
                }
            }

            if (imageChosen == 2) {
                if (imageChosen2 == 2) {
                    if (imageChosen3 == 2) {
                        points = points + 100;

                    }
                }
            }

            if (imageChosen == 3) {
                if (imageChosen2 == 3) {
                    if (imageChosen3 == 3) {
                        points = points + 100;

                    }
                }
            }

            if (imageChosen == 4) {
                if (imageChosen2 == 4) {
                    if (imageChosen3 == 4) {
                        points = points + 100;

                    }
                }
            }

            pointDisplay.setText(points + "");
        }  else {
            on = true;
            handler.postDelayed(update, 100 * speed);
            handler.postDelayed(update2, 50 * speed);
            handler.postDelayed(update3, 25 * speed);
        }
    }


    public class UpdateGame implements Runnable {
        public void run() {
            if (imageChosen == 1) imageView1.setImageDrawable(strawberryImage);
            else if (imageChosen == 2) imageView1.setImageDrawable(grapeImage);
            else if (imageChosen == 3) imageView1.setImageDrawable(cherryImage);
            else if (imageChosen == 4) imageView1.setImageDrawable(pearImage);
            imageChosen = imageChosen + 1;
            if (imageChosen == 5) imageChosen = 1;
            handler.postDelayed(update, 100 * speed);
        }
    }

    public class UpdateGame2 implements Runnable {

        public void run() {
            if (imageChosen2 == 1) imageView2.setImageDrawable(strawberryImage);
            else if (imageChosen2 == 2) imageView2.setImageDrawable(grapeImage);
            else if (imageChosen2 == 3) imageView2.setImageDrawable(cherryImage);
            else if (imageChosen2 == 4) imageView2.setImageDrawable(pearImage);
            imageChosen2 = imageChosen2 + 1;
            if (imageChosen2 == 5) imageChosen2 = 1;
            handler.postDelayed(update2,50 * speed);
        }

    }

    public class UpdateGame3 implements Runnable {

        public void run() {
            if (imageChosen3 == 1) imageView3.setImageDrawable(strawberryImage);
            else if (imageChosen3 == 2) imageView3.setImageDrawable(grapeImage);
            else if (imageChosen3 == 3) imageView3.setImageDrawable(cherryImage);
            else if (imageChosen3 == 4) imageView3.setImageDrawable(pearImage);
            imageChosen3 = imageChosen3 + 1;
            if (imageChosen3 == 5) imageChosen3 = 1;
            handler.postDelayed(update3,25 * speed);
        }

    }

}
