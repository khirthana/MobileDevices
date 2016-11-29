package csci4100u.travellogger_project_khirthanasubramanian_and_jainapatel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Instructions extends AppCompatActivity {

 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        //start background music
        Intent svc=new Intent(this, BackgroundMusic.class);
        startService(svc);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent i = new Intent(Instructions.this,Home.class);
                startActivity(i);
                return true;
            case R.id.nav_notes:
                Intent i2 = new Intent(Instructions.this,Notes.class);
                startActivity(i2);
                return true;
            case R.id.nav_wishist:
                Intent i3 = new Intent(Instructions.this,Wishlist.class);
                startActivity(i3);
                return true;
            case R.id.nav_instructions:
                Intent i4 = new Intent(Instructions.this,Instructions.class);
                startActivity(i4);
                return true;
            case R.id.nav_about_us:
                Intent i5 = new Intent(Instructions.this,AboutUs.class);
                startActivity(i5);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
