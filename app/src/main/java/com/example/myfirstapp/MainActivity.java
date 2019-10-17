package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        TextView showCountTextView = findViewById(R.id.textView);
        String countString = showCountTextView.getText().toString();
        int count = Integer.parseInt(countString);

        count++;

        showCountTextView.setText(String.format(Locale.getDefault(), "%d", count));
    }

    public void decrement(View view) {
        TextView showCountTextView = findViewById(R.id.textView);
        String countString = showCountTextView.getText().toString();
        int count = Integer.parseInt(countString);

        if (count > 0) {
            count--;
        } else {
            Toast myToast = Toast.makeText(this, "Number cannot be smaller than 0", Toast.LENGTH_SHORT);
            myToast.show();
        }

        showCountTextView.setText(String.format(Locale.getDefault(), "%d", count));
    }

    private static final String TOTAL_COUNT = "total_count";

    public void randomNumber(View view) {
        // Create an Intent to start the second activity
        Intent randomIntent = new Intent(this, SecondActivity.class);

        TextView showCountTextView = findViewById(R.id.textView);
        String countString = showCountTextView.getText().toString();
        int count = Integer.parseInt(countString);

        // Add the count to the extras for the Intent.
        randomIntent.putExtra(TOTAL_COUNT, count);
        // Start the new activity.
        startActivity(randomIntent);
    }
}
