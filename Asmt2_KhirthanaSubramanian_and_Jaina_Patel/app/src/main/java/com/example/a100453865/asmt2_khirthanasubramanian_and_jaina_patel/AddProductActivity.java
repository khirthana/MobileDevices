/*
 * CSCI4100U Assignment2
 *   helper activity
 *
 * Team Members: Khirthana Subramanian(100453865) and Jaina Patel(100523188)
 *
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
     }


     public void saveProduct(View view){
         //When “Save” button is clicked, call function on database helper to insert new product using values from the text fields
         dtbs.addData(eName.getText().toString(), eDesc.getText().toString(), ePrice.getText().toString());
         Toast.makeText(AddProductActivity.this, "Data Added", Toast.LENGTH_LONG).show();

         // clear the text fields
         eName.getText().clear();
         eDesc.getText().clear();
         ePrice.getText().clear();

         //stop the activity (returning to BrowseProductsActivity)
         finish();
     }

     public void cancelButton(View view){
         //when cancel button is clicked, clear text fields and stop the activity (returning to BrowseProductsActivity)
         eName.getText().clear();
         eDesc.getText().clear();
         ePrice.getText().clear();
         finish();
     }
 }

