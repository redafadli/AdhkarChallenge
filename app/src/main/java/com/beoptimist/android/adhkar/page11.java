package com.beoptimist.android.adhkar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class page11 extends AppCompatActivity {

    Button button;
    View left, tutorial_left, tutorial_right;
    TextView text_right, text_left;
    ImageButton back;
    int counter = 0;
    private Boolean firstTime = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page11);


        button = findViewById(R.id.button);
        back = findViewById(R.id.back);
        left = findViewById(R.id.view_left);
        tutorial_left = findViewById(R.id.view_left_tutorial);
        tutorial_right = findViewById(R.id.view_right_tutorial);
        text_right = findViewById(R.id.text_view_tutorial1);
        text_left = findViewById(R.id.text_view_tutorial2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(page11.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter == 0) {
                    counter += 1;
                    display(counter);
                    Intent intent = new Intent(page11.this, page12.class);
                    startActivity(intent);
                }
            }
        });

        tutorial_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tutorial_right.setVisibility(View.INVISIBLE);
                tutorial_left.setVisibility(View.INVISIBLE);
                text_left.setVisibility(View.INVISIBLE);
                text_right.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(page11.this, page12.class);
                startActivity(intent);
            }
        });

        tutorial_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tutorial_right.setVisibility(View.INVISIBLE);
                tutorial_left.setVisibility(View.INVISIBLE);
                text_left.setVisibility(View.INVISIBLE);
                text_right.setVisibility(View.INVISIBLE);
            }
        });

        if (firstTime == null) {
            SharedPreferences mPreferences = this.getSharedPreferences("first_time", Context.MODE_PRIVATE);
            firstTime = mPreferences.getBoolean("firstTime", true);
            if (firstTime) {
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putBoolean("firstTime", false);
                editor.apply();
                tutorial();
            }else{
                tutorial_disappear();
            }
        }


    }
    private void display(int number) {
        TextView TextView = findViewById(R.id.counter);
        TextView.setText("" + number);
    }


    public void tutorial(){
        tutorial_right.setVisibility(View.VISIBLE);
        tutorial_left.setVisibility(View.VISIBLE);
        text_left.setVisibility(View.VISIBLE);
        text_right.setVisibility(View.VISIBLE);
    }

    public void tutorial_disappear(){
        tutorial_right.setVisibility(View.INVISIBLE);
        tutorial_left.setVisibility(View.INVISIBLE);
        text_left.setVisibility(View.INVISIBLE);
        text_right.setVisibility(View.INVISIBLE);
    }
}
