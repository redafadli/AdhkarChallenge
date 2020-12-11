package com.beoptimist.android.adhkar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;



public class page222 extends AppCompatActivity {

    Button button;
    ImageButton back;
    View left,right;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page222);

        back = findViewById(R.id.back);
        button = findViewById(R.id.button);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(page222.this, MainActivity.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter += 1;
                if (counter == 10) {
                    Intent intent = new Intent(page222.this, finished_evening.class);
                    Log.v("page222", "Next page is " + intent);
                    startActivity(intent);
                }
                display(counter);
            }
        });

        right = findViewById(R.id.view_right);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(page222.this, page221.class);
                startActivity(intent);
            }
        });
    }
    private void display(int number) {
        TextView TextView = findViewById(R.id.counter);
        TextView.setText("" + number);
    }
}
