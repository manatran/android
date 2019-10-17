package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        showRandomNumber();
    }

    private static final String TOTAL_COUNT = "total_count";

    private void showRandomNumber() {
        TextView randomView = findViewById(R.id.textview_random);
        TextView headingView = findViewById(R.id.textview_label);

        // Get the count from the intent extras
        int count = getIntent().getIntExtra(TOTAL_COUNT, 0);

        // Generate the random number
        Random random = new Random();
        int randomInt = 0;
        if (count > 0) {
            randomInt = random.nextInt(count);
        }

        // Display the random number
        randomView.setText(String.format(Locale.getDefault(), "%d", randomInt));
        // Update the heading text
        headingView.setText(getString(R.string.random_heading, count));
    }
}
