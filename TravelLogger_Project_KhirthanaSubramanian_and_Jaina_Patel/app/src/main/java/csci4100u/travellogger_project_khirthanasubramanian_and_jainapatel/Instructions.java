package csci4100u.travellogger_project_khirthanasubramanian_and_jainapatel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Instructions extends AppCompatActivity {

 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

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
                Intent i = new Intent(Intructions.this,Home.class);
                //i.putExtra("list", (Serializable) product_list);
                startActivity(i);
                return true;
            case R.id.nav_notes:
                Intent i2 = new Intent(Intructions.this,Notes.class);
                //i2.putExtra("list", (Serializable) product_list);
                startActivity(i2);
                return true;
            case R.id.nav_wishist:
                Intent i3 = new Intent(Intructions.this,Wishlist.class);
                startActivity(i3);
                return true;
            case R.id.nav_instructions:
                Intent i4 = new Intent(Intructions.this,Instructions.class);
                startActivity(i4);
                return true;
            case R.id.nav_about_us:
                Intent i5 = new Intent(Intructions.this,AboutUs.class);
                startActivity(i5);
                return true;
            case R.id.nav_settings:
                Intent i6 = new Intent(Intructions.this,About.class);
                startActivity(i6);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
