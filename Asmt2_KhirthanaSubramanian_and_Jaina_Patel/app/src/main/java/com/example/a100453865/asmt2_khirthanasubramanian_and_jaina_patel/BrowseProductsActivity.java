package com.example.a100453865.asmt2_khirthanasubramanian_and_jaina_patel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class BrowseProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_products_activity);

        //textfields are set to uneditable
        EditText editName= (EditText) findViewById(R.id.editName);
        editName.setEnabled(false);

        EditText editDescription= (EditText) findViewById(R.id.editDescription);
        editDescription.setEnabled(false);

        EditText editPriceDollar= (EditText) findViewById(R.id.editPriceDollar);
        editPriceDollar.setEnabled(false);

        EditText editPriceBitcoin= (EditText) findViewById(R.id.editPriceBitcoin);
        editPriceBitcoin.setEnabled(false);

        // use the query function in the database helper to find all products

        //Once the products are loaded, call showProduct() with the first produc
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    //when 'Add New Product' is selected from menu, AddProductActivity is started
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(BrowseProductsActivity.this,AddProductActivity.class);
        startActivity(i);
        return true;

    }

    //function to display a product; takes a Product as an argument
    void showProduct(Product p){

        /*-The name, description, and price for the first product found is displayed in their respective text fields

        -The price is submitted to a web service to find the corresponding price in BitCoin

        -The BitCoin price is displayed in the corresponding text field*/


    }
    //when prev button is clicked, calls showProduct() with the previous product
    public void prevProduct(View view){

        //If there are no earlier products, “Previous” button is disabled
    }

    //when next button is clicked, calls showProduct() with the next product
    public void nextProduct(View view){

        //If there are no further products, “Next” button is disabled
    }

    //when delete button is clicked, calls the database helper function to delete the product
    public void deleteProduct(View view){

    }

}
