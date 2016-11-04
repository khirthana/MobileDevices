/*
 *  use the query function in the database helper to find all products

o Create a function to display a product (showProduct)
-The function takes a Product as an argument
-The name, description, and price for the first product found is displayed in their respective text fields
-The price is submitted to a web service to find the corresponding price in BitCoin
-The BitCoin price is displayed in the corresponding text field


o Once the products are loaded, call showProduct() with the first product


o When “Next” is clicked, call showProduct() with the next product
-If there are no further products, disable the “Next” button


o When “Prev” is clicked, call showProduct() with the previous product
-If there are no earlier products, disable the “Previous” button


o When “Delete” is clicked, call the database helper function to delete the product
- query the database again to get all of the products again


o When “Add New Product” is selected (from the menu), invoke the AddProductActivity

 */

package com.example.a100453865.asmt2_khirthanasubramanian_and_jaina_patel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BrowseProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_products_activity);
    }
}
