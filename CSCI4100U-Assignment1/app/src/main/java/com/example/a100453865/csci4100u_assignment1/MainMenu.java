package com.example.a100453865.csci4100u_assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    String[] questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        questions = getResources().getStringArray(R.array.questions);
    }


    //if start button is clicked in main layout then AskQuestion layout is displayed
    public void questionLayout(View v) {
        setContentView(R.layout.activity_ask_question);

        //question is displayed on AskQuestion layout textView
        TextView textView = (TextView)findViewById(R.id.questionTextView);

        textView.setText(questions[0]);
    }
}
