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
    Note update_note;
    Note delete_note;
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


            //int id=0;
            String noteName=note_name.getText().toString();
            String noteContent = note_content.getText().toString();

            //if field is empty
            if (noteName.equalsIgnoreCase("")||noteContent.equalsIgnoreCase("")) {
                Toast.makeText(this, "enter note name & note content",
                        Toast.LENGTH_LONG);
            } else {
                //create new note
                update_note=new Note(noteName,noteContent);

                //return note added
                Intent returnIntent = new Intent();
                returnIntent.putExtra("updateNote",  (Serializable) update_note);
                returnIntent.putExtra("action","update");

                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        }


        //when delete button is pressed, selected note is deleted
        public void delete_note(View view){
            //get data entered by user
            EditText note_name = (EditText)findViewById(R.id.noteName);
            EditText note_content  = (EditText)findViewById(R.id.noteContent);


            //int id=0;
            String noteName=note_name.getText().toString();
            String noteContent = note_content.getText().toString();

            //if field is empty
            if (noteName.equalsIgnoreCase("")||noteContent.equalsIgnoreCase("")) {
                Toast.makeText(this, "enter note name & note content",
                        Toast.LENGTH_LONG);
            } else {
                //create new note
                delete_note=new Note(noteName,noteContent);

                //return note added
                Intent returnIntent = new Intent();
                returnIntent.putExtra("deleteNote",  (Serializable) delete_note);
                returnIntent.putExtra("action","delete");

                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
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
                //i.putExtra("list", (Serializable) product_list);
                startActivity(i);
                return true;
            case R.id.nav_notes:
                Intent i2 = new Intent(ShowNote.this,Notes.class);
                //i2.putExtra("list", (Serializable) product_list);
                startActivity(i2);
                return true;
            case R.id.nav_wishist:
                Intent i3 = new Intent(ShowNote.this,Wishlist.class);
                startActivity(i3);
                return true;
            case R.id.nav_instructions:
                Intent i4 = new Intent(ShowNote.this,About.class);
                startActivity(i4);
                return true;
            case R.id.nav_about_us:
                Intent i5 = new Intent(ShowNote.this,AboutUs.class);
                startActivity(i5);
                return true;
            case R.id.nav_settings:
                Intent i6 = new Intent(ShowNote.this,About.class);
                startActivity(i6);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
