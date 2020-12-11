package com.beoptimist.android.adhkar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;



public class page21 extends AppCompatActivity {

    ImageButton back;
    Button button;
    TextView text_right, text_left;
    View left,right, tutorial_left, tutorial_right;
    int counter = 0;
    private Boolean firstTime = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page21);

        back = findViewById(R.id.back);
        button = findViewById(R.id.button);
        tutorial_left = findViewById(R.id.view_left_tutorial);
        tutorial_right = findViewById(R.id.view_right_tutorial);
        text_right = findViewById(R.id.text_view_tutorial1);
        text_left = findViewById(R.id.text_view_tutorial2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(page21.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter == 0){
                    counter +=1;
                    display(counter);
                    Intent intent = new Intent(page21.this, page22.class);
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
