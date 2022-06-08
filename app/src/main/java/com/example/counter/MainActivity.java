package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button Zero;
    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";
    private TextView Text_reply;
    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mShowCount = findViewById(R.id.show_count);
        Zero = findViewById(R.id.button_Zero);
        Text_reply = findViewById(R.id.Text_reply);

    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
        if (mCount != 0)
            Zero.setBackgroundColor(Color.YELLOW);
    }

    public void Zero(View view) {
        mCount = 0;
        mShowCount.setText(Integer.toString(mCount));
        Zero.setBackgroundColor(Color.BLUE);
    }

    public void show_Toast(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE, Integer.toString(mCount));
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void onActivityResult(int requestCODE, int resultCODE, Intent data) {
        super.onActivityResult(requestCODE, resultCODE, data);
        if (requestCODE == TEXT_REQUEST) {
            if (resultCODE == RESULT_OK) {
                String replying = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                Text_reply.setText(replying);
            }
        }
    }
}