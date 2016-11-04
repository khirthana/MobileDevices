/*
 * CSCI4100U Mobile Devices
 * Assignment 1
 *
 * Team Members: Khirthana Subramanian - 100453865
 *               Jaina Patel - 100523188
 *
 * AskQuestion activity: displays questions and returns the answer depending which button is pressed
 */
package com.example.a100453865.csci4100u_assignment1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AskQuestion extends AppCompatActivity {

    String result;
    String[] questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_question);

        questions= getResources().getStringArray(R.array.questions);

        //question is displayed on textView (question_text) on AskQuestion Layout
        Intent callingIntent = getIntent();
        int question_id = callingIntent.getIntExtra("n",0);

        TextView question_text = (TextView)findViewById(R.id.questionText);
        question_text.setText(questions[question_id]);

    }

    //if yes button is clicked
    public void yesButton(View v) {
        result="yes";

        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",result);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }

    //if no button is clicked
    public void noButton(View v) {
        result="no";

        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",result);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}
