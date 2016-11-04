/*
 * CSCI4100U Mobile Devices
 * Assignment 1
 *
 * Team Members: Khirthana Subramanian - 100453865
 *               Jaina Patel - 100523188
 *
 * Summary activity: displays the summary of yes/no answers from questions
 */
package com.example.a100453865.csci4100u_assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //summary layout is shown and the number of yes/no answers are displayed on textView (sumarry_text)
        setContentView(R.layout.activity_summary);

        Intent callingIntent = getIntent();
        String content= callingIntent.getStringExtra("content");

        TextView summary_text = (TextView) findViewById(R.id.summaryText);
        summary_text.setText(content);
    }
}
