/*
    CSCI4100U Project - TravelLogger

    Team Members: Khirthana Subramanian(100453865) and Jaina Patel(100523188)

    Notes: display list of notes

 */
package csci4100u.travellogger_project_khirthanasubramanian_and_jainapatel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.name;
import static android.R.attr.selectable;

public class Notes extends AppCompatActivity {
    protected NoteDBHelper db;
    List<Note> list;
    public static final int RESULT =1;
    public static final int RESULT2 =2;
    Intent svc;
    Note selected_note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        //start background music
        svc=new Intent(this, BackgroundMusic.class);
        startService(svc);
    }



    protected void onStart() {
        super.onStart();

        db = new NoteDBHelper(this);
        list = db.getAllNotes();

        List<String> strings = new ArrayList<>(list.size());
        for (Note object : list) {
            strings.add(object.getNote_name());
        }

        //display notes to ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, strings);


        ListView listview = (ListView) findViewById(R.id.notelist);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                selected_note=list.get(position);
                Intent intent = new Intent(Notes.this,ShowNote.class);
                intent.putExtra("selected_note",  (Serializable) selected_note);
                startActivityForResult(intent,RESULT2);
            }
        });

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
                Intent i = new Intent(Notes.this,Home.class);
                startActivity(i);
                return true;
            case R.id.nav_notes:
                Intent i2 = new Intent(Notes.this,Notes.class);
                startActivity(i2);
                return true;
            case R.id.nav_wishist:
                Intent i3 = new Intent(Notes.this,Wishlist.class);
                startActivity(i3);
                return true;
            case R.id.nav_instructions:
                Intent i4 = new Intent(Notes.this,Instructions.class);
                startActivity(i4);
                return true;
            case R.id.nav_about_us:
                Intent i5 = new Intent(Notes.this,AboutUs.class);
                startActivity(i5);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void onStop() {
        super.onStop();
    }

    //when add image is pressed, Add_note is started to create new note
    public void add_note(View view){
        Intent i = new Intent(Notes.this, Add_note.class);
        startActivityForResult(i,RESULT);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT) {
            if(resultCode == Activity.RESULT_OK){
                //add new note
                Note new_note= (Note) data.getSerializableExtra("newNote");
                list.add(new_note);
                db.addNote(new_note.getNote_name(),new_note.getNote_content());
                Toast.makeText(
                        getApplicationContext(), new_note.getNote_name()+
                                " note is added", Toast.LENGTH_LONG).show();
            }
        }
        else if (requestCode == RESULT2) {
            if(resultCode == Activity.RESULT_OK){
                String action=data.getStringExtra("action");

                //update note
                if(action.equals("update")){
                    int id=selected_note.getId();
                    String name=data.getStringExtra("name");
                    String content=data.getStringExtra("content");
                    db.updateNote(id,name,content);
                    Toast.makeText(
                            getApplicationContext(), name+
                            " note is updated", Toast.LENGTH_LONG).show();
                }
                //delete note
                else if(action.equals("delete")){
                    int id=selected_note.getId();
                    list.remove(selected_note);
                    db.deleteNote( Integer.toString(id));
                    Toast.makeText(
                            getApplicationContext(), selected_note.getNote_name()+
                                    " note is deleted", Toast.LENGTH_LONG).show();
                }

            }
        }
    }

}