/*
 *When “Save” is clicked, call function on database helper to insert new product using values from the text fields,
 * clear the text fields,
 * then stop the activity (returning to BrowseProductsActivity)
 */

package com.example.a100453865.asmt2_khirthanasubramanian_and_jaina_patel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AddProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_product_activity);
    }
}
