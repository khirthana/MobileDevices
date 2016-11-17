 /*
 *When “Save” is clicked, call function on database helper to insert new product using values from the text fields,
 * clear the text fields,
 * then stop the activity (returning to BrowseProductsActivity)
 */

package com.example.a100453865.asmt2_khirthanasubramanian_and_jaina_patel;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


 public class AddProductActivity extends AppCompatActivity {

     ProductDBHelper dtbs;
     EditText eName, eDesc, ePrice;
     Button btnAdd;


     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.add_product_activity);
         dtbs = new ProductDBHelper(this);

         eName = (EditText) findViewById(R.id.editName);
         eDesc = (EditText) findViewById(R.id.editDesc);
         ePrice = (EditText) findViewById(R.id.editPrice);
         btnAdd = (Button) findViewById(R.id.button);

         AddData();
     }

     public void AddData () {
         btnAdd.setOnClickListener(
                 new View.OnClickListener(){
                     public void onClick(View v) {
                         dtbs.addData(eName.getText().toString(), eDesc.getText().toString(), ePrice.getText().toString());
                         Toast.makeText(AddProductActivity.this, "Data Added", Toast.LENGTH_LONG).show();
                        /*
                        boolean isAdded = dtbs.addData(eName.getText().toString(), eDesc.getText().toString(), Double.parseDouble(ePrice.getText().toString()));


                        if (isAdded == true)
                            Toast.makeText(AddProductActivity.this, "Data Added", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddProductActivity.this, "Data not added", Toast.LENGTH_LONG).show();
                        */

                     }
                 }
         );
     }




 }

