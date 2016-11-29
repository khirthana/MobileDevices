/*
    CSCI4100U Project - TravelLogger

    Team Members: Khirthana Subramanian(100453865) and Jaina Patel(100523188)

    Add_note: get user input for new note & creates new note

 */
package csci4100u.travellogger_project_khirthanasubramanian_and_jainapatel;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class Add_note extends AppCompatActivity {
    Note new_note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        //start background music
        Intent svc=new Intent(this, BackgroundMusic.class);
        startService(svc);
    }

    //when add button is pressed, new note is created
    public void add_note(View view){

        //get data entered by user
        EditText note_name = (EditText)findViewById(R.id.noteName);
        EditText note_content  = (EditText)findViewById(R.id.noteContent);

        String noteName=note_name.getText().toString();
        String noteContent = note_content.getText().toString();

        //if field is empty
        if (noteName.equalsIgnoreCase("")||noteContent.equalsIgnoreCase("")) {
            Toast.makeText(this, "enter note name & note content",
                    Toast.LENGTH_LONG);
        } else {
            //create new note
            new_note=new Note(noteName,noteContent);

            //return note added
            Intent returnIntent = new Intent();
            returnIntent.putExtra("newNote",  (Serializable) new_note);

            setResult(Activity.RESULT_OK,returnIntent);
            finish();
        }

    }

    //when cancel button is pressed, new note is cancelled, display notes
    public void cancel_note(View view){
        //clear textfields
        EditText note_name = (EditText)findViewById(R.id.noteName);
        EditText note_content  = (EditText)findViewById(R.id.noteContent);

        note_name.getText().clear();
        note_content.getText().clear();


        //return to display notes
        Intent i = new Intent(Add_note.this, Notes.class);
        startActivity(i);
    }

    //menu is created
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    //when menu item is selected, the appropriate activity is started
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent i = new Intent(Add_note.this,Home.class);
                startActivity(i);
                return true;
            case R.id.nav_notes:
                Intent i2 = new Intent(Add_note.this,Notes.class);
                startActivity(i2);
                return true;
            case R.id.nav_wishist:
                Intent i3 = new Intent(Add_note.this,Wishlist.class);
                startActivity(i3);
                return true;
            case R.id.nav_instructions:
                Intent i4 = new Intent(Add_note.this,Instructions.class);
                startActivity(i4);
                return true;
            case R.id.nav_about_us:
                Intent i5 = new Intent(Add_note.this,AboutUs.class);
                startActivity(i5);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
