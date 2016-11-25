package csci4100u.travellogger_project_khirthanasubramanian_and_jainapatel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Notes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
    }

    //when add image is pressed, Add_note is started to create new note
    public void add_Note(View view){
        Intent i = new Intent(Notes.this, Add_note.class);

        //showMapIntent.putExtra("location", query);

        startActivity(i);
    }
}
