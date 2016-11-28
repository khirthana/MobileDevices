/*
    CSCI4100U Project - TravelLogger

    Team Members: Khirthana Subramanian(100453865) and Jaina Patel(100523188)

     Wishlist: displays wishlist

 */
package csci4100u.travellogger_project_khirthanasubramanian_and_jainapatel;



import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Wishlist extends AppCompatActivity {

    protected WishlistDBHelper db;
    List<MyWish> list;
    MyAdapter adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);
        db = new WishlistDBHelper(this);
        list = db.getAllWishes();
        adapt = new MyAdapter(this, R.layout.list_inner_view, list);
        ListView wishlist = (ListView) findViewById(R.id.listView1);
        wishlist.setAdapter(adapt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void addTaskNow(View v) {
        EditText t = (EditText) findViewById(R.id.editText1);
        String s = t.getText().toString();
        if (s.equalsIgnoreCase("")) {
            Toast.makeText(this, "enter the wish description first!!",
                    Toast.LENGTH_LONG);
        } else {
            MyWish wish = new MyWish(s, 0);
            db.addWish(wish);

            t.setText("");
            adapt.add(wish);
            adapt.notifyDataSetChanged();
        }
    }

    private class MyAdapter extends ArrayAdapter<MyWish> {
        Context context;
        List<MyWish> wList = new ArrayList<MyWish>();
        int layoutResourceId;
        public MyAdapter(Context context, int layoutResourceId,
                         List<MyWish> objects) {
            super(context, layoutResourceId, objects);
            this.layoutResourceId = layoutResourceId;
            this.wList = objects;
            this.context = context;
        }
        /**
         * This method will DEFINe what the view inside the list view will
         * finally look like Here we are going to code that the checkbox state
         * is the status of task and check box text is the task name
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CheckBox chk = null;
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.list_inner_view,
                        parent, false);
                chk = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(chk);
                chk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v;
                        MyWish changeTask = (MyWish) cb.getTag();
                        changeTask.setStatus(cb.isChecked() == true ? 1 : 0);
                        db.updateWish(changeTask);
                        Toast.makeText(
                                getApplicationContext(),
                                "Clicked on Checkbox: " + cb.getText() + " is "
                                        + cb.isChecked(), Toast.LENGTH_LONG)
                                .show();
                    }
                });
            } else {
                chk = (CheckBox) convertView.getTag();
            }
            MyWish current = wList.get(position);
            chk.setText(current.getTitle());
            chk.setChecked(current.getStatus() == 1 ? true : false);
            chk.setTag(current);
            return convertView;
        }
    }


}
