package csci4100u.travellogger_project_khirthanasubramanian_and_jainapatel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Add_note extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
    }

    //when add button is pressed, new note is created
    public void add_note(View view){

    }

    //when cancel button is pressed, new note is cancelled, display notes
    public void cancel_note(View view){
        Intent i = new Intent(Add_note.this, Notes.class);
        startActivity(i);
    }
}
