package com.beoptimist.android.adhkar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class finished_morning extends AppCompatActivity {

    ImageButton back;
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished_morning);

        String today = new SimpleDateFormat("dd MMM, yyyy", Locale.getDefault()).format(new Date());

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(finished_morning.this, MainActivity.class);
                startActivity(intent);
            }
        });

        date = findViewById(R.id.date);
        date.setText(today);
    }
}
