package com.example.a100453865.asmt2_khirthanasubramanian_and_jaina_patel;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BrowseProductsActivity extends AppCompatActivity {

    ProductDBHelper productdb=null;

    List<Product> allProducts=null;

    int product_position=0;

    Product current;

    Button button_prev;
    Button button_next;

    Context context2;

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
        productdb= new ProductDBHelper(this);

        //insert test data
        productdb.addData("Dell Laptop", "For home and home office","350.00");
        productdb.addData("Acer Laptop","Most compact laptop", "300.00");

        // load the test data into a local array list
        allProducts= productdb.getAllData();

        //If there are no earlier products, “Previous” button is disabled
        if(product_position==0) {
            button_prev= (Button) findViewById(R.id.button_prev);;
            button_prev.setEnabled(false);
        }
        else{
            button_prev.setEnabled(true);
        }


        //If there are no further products, “Next” button is disabled
        if(product_position== allProducts.size()-1) {
            button_next= (Button) findViewById(R.id.button_next);;
            button_next.setEnabled(false);
        }
        else{
            button_next.setEnabled(true);
        }

        //display first product
        getProduct(0);
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

    void getProduct(int position){
        //call showProduct() to display product information
        product_position=position;

        while (product_position < allProducts.size()&&product_position>=0) {
            current = allProducts.get(product_position);
            showProduct(current);
        }
    }

    //function to display a product; takes a Product as an argument
    void showProduct(Product p){
        float priceBTC=0;

        //The name, description, and price for the first product found is displayed in their respective text fields
        EditText nameField = (EditText)findViewById(R.id.editName);
        EditText descField = (EditText)findViewById(R.id.editDescription);
        EditText priceField = (EditText)findViewById(R.id.editPriceDollar);
        nameField.setText(p.getProduct_name());
        descField.setText(p.getProduct_desc());
        priceField.setText(String.valueOf(p.getPrice()));

        //The price is submitted to a web service to find the corresponding price in BitCoin
        priceBTC=convertToBitCoin(p.getPrice());

        //The BitCoin price is displayed in the corresponding text field
        EditText BTCField = (EditText)findViewById(R.id.editPriceBitcoin);
        BTCField.setText(String.valueOf(priceBTC));
    }

    public float convertToBitCoin(double CAD_price) {

        float BTC_price=0;
        String value;
        try {
           value= new GetBTCvalue(this).execute("").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return BTC_price;
    }

    private class GetBTCvalue extends AsyncTask<String, Void, String> {
        String BTC_url = "https://blockchain.info/tobtc?currency=CAD&value=49.99";
        private Exception exception = null;

        public GetBTCvalue(Context context) {
            context2 = context;
        }

        @Override
        protected String doInBackground(String... params) {
            String line = null;

            try {
                URL url = new URL(BTC_url);
                HttpURLConnection conn;
                conn = (HttpURLConnection) url.openConnection();
                int result = conn.getResponseCode();

                if (result == HttpURLConnection.HTTP_OK) {
                    InputStream in = conn.getInputStream();
                    BufferedReader bf = new BufferedReader(new InputStreamReader(in));
                    line = bf.readLine();
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            return line;
        }

        @Override
        protected void onPostExecute(String result) {
        }
    }


    //when prev button is clicked, calls showProduct() with the previous product
    public void prevProduct(View view){
        if(product_position>0){
            getProduct(product_position--);
        }

    }

    //when next button is clicked, calls showProduct() with the next product
    public void nextProduct(View view){
        if(product_position<allProducts.size()) {
            getProduct(product_position++);
        }
    }

    //when delete button is clicked, calls the database helper function to delete the product using product id
    public void deleteProduct(View view){
        //delete current product
        productdb.deleteData(current.getProduct_id());

        //display toast message when product deleted
        Toast.makeText(BrowseProductsActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();

        // use the query function in the database helper to find all products
        productdb= new ProductDBHelper(this);

        // load the test data into a local array list
        allProducts= productdb.getAllData();

        //first product in database is displayed
        getProduct(0);


    }

}
