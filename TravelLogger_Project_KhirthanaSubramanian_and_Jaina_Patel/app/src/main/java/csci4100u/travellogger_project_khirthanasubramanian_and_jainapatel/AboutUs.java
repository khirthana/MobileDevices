/*
    CSCI4100U Project - TravelLogger

    Team Members: Khirthana Subramanian(100453865) and Jaina Patel(100523188)

    AboutUs: dispay information about developers

 */
package csci4100u.travellogger_project_khirthanasubramanian_and_jainapatel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class AboutUs extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent i = new Intent(AboutUs.this,Home.class);
                //i.putExtra("list", (Serializable) product_list);
                startActivity(i);
                return true;
            case R.id.nav_notes:
                Intent i2 = new Intent(AboutUs.this,Notes.class);
                //i2.putExtra("list", (Serializable) product_list);
                startActivity(i2);
                return true;
            case R.id.nav_wishist:
                Intent i3 = new Intent(AboutUs.this,Wishlist.class);
                startActivity(i3);
                return true;
            case R.id.nav_instructions:
                Intent i4 = new Intent(AboutUs.this,About.class);
                startActivity(i4);
                return true;
            case R.id.nav_about_us:
                Intent i5 = new Intent(AboutUs.this,AboutUs.class);
                startActivity(i5);
                return true;
            case R.id.nav_settings:
                Intent i6 = new Intent(AboutUs.this,About.class);
                startActivity(i6);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}


