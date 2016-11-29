/*
    CSCI4100U Project - TravelLogger

    Team Members: Khirthana Subramanian(100453865) and Jaina Patel(100523188)

    ShowNote: display selected note

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

public class ShowNote extends AppCompatActivity {
    Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_note);

        //start background music
        Intent svc=new Intent(this, BackgroundMusic.class);
        startService(svc);

        //get extras
        Intent callingIntent = getIntent();
        note= (Note) callingIntent.getSerializableExtra("selected_note");

        //display note name & note content
        EditText note_name = (EditText)findViewById(R.id.noteName);
        EditText note_content  = (EditText)findViewById(R.id.noteContent);

        note_name.setText(note.getNote_name());
        note_content.setText(note.getNote_content());
    }



        //when save button is pressed, changes in note is saved
        public void save_note(View view){
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

                //return user inputs for updated note
                Intent returnIntent = new Intent();
                returnIntent.putExtra("action","update");
                returnIntent.putExtra("name",noteName);
                returnIntent.putExtra("content",noteContent);

                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        }


        //when delete button is pressed, selected note is deleted
        public void delete_note(View view){
                Intent returnIntent = new Intent();
                returnIntent.putExtra("action","delete");
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
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
                Intent i = new Intent(ShowNote.this,Home.class);
                startActivity(i);
                return true;
            case R.id.nav_notes:
                Intent i2 = new Intent(ShowNote.this,Notes.class);
                startActivity(i2);
                return true;
            case R.id.nav_wishist:
                Intent i3 = new Intent(ShowNote.this,Wishlist.class);
                startActivity(i3);
                return true;
            case R.id.nav_instructions:
                Intent i4 = new Intent(ShowNote.this,Instructions.class);
                startActivity(i4);
                return true;
            case R.id.nav_about_us:
                Intent i5 = new Intent(ShowNote.this,AboutUs.class);
                startActivity(i5);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
