package com.beoptimist.android.adhkar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class page24 extends AppCompatActivity {

    Button button;
    ImageButton back;
    View left,right;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page24);


        back = findViewById(R.id.back);
        button = findViewById(R.id.button);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(page24.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter == 0) {
                    counter += 1;
                    display(counter);
                    Intent intent = new Intent(page24.this, page25.class);
                    startActivity(intent);
                }
            }
        });

        left = findViewById(R.id.view_left);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(page24.this, page25.class);
                startActivity(intent);
            }
        });
        right = findViewById(R.id.view_right);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(page24.this, page23.class);
                startActivity(intent);
            }
        });
    }
    private void display ( int number){
        TextView TextView = findViewById(R.id.counter);
        TextView.setText("" + number);
    }
}
