/*
 * CSCI4100U Mobile Devices
 * Assignment 1
 *
 * Team Members: Khirthana Subramanian - 100453865
 *               Jaina Patel - 100523188
 *
 *  MainMenu Activity contains a start button;
 *  when clicked it displays AskQuestion activity & record answers to display summary at end
 */
package com.example.a100453865.csci4100u_assignment1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {
    int question_number=0;
    int size_q=0;


    int n_yes;
    int n_no;

    String summary_text;

    public static final int RESULT =1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        String[] array = getResources().getStringArray(R.array.questions);
        size_q=array.length;
    }

    //AskQuestion activity is started & expect result from activity in return
    public void question(){
        Intent i1 = new Intent(MainMenu.this, AskQuestion.class);
        i1.putExtra("n", question_number);
        startActivityForResult(i1, RESULT);
    }

    //if start button is clicked
    public void startButton(View view){
        question();
    }

    //when all questions are answered, summary activity is started
    public void summary(){
        summary_text= getString(R.string.summary)+"\n"+getString(R.string.total_yes)+Integer.toString(n_yes)+"\n"+getString(R.string.total_no)+Integer.toString(n_no);
        Intent summary = new Intent(MainMenu.this, Summary.class);
        summary.putExtra("content", summary_text);
        startActivity(summary);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT) {
            if(resultCode == Activity.RESULT_OK){

                String result=data.getStringExtra("result");

                if(result.equals("yes")){
                    n_yes++;
                }
                else if(result.equals("no")){
                    n_no++;
                }

                question_number++;

                //if there is questions left to display then askQuestion activity is started again
                if(question_number<size_q) {
                    question();
                }
                else{//if all questions are displayed and answered then summary will be displayed
                    summary();
                }

            }
        }
    }

}