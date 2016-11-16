package com.example.a100453865.asmt2_khirthanasubramanian_and_jaina_patel;


public class Product {

    int product_id;
    String product_name;
    String product_desc;
    double price;


    public Product (){

    }

    public Product (int product_id,String product_name, String product_desc, double price){
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_desc = product_desc;
        this.price = price;
    }

    void setProduct_id(int id){this.product_id=id;}

    void setProduct_name(String name){this.product_name=name;}

    void setProduct_desc(String desc){this.product_desc=desc;}

    void setPrice(double product_price){this.price=product_price;}

    public int getProduct_id(){return product_id;}

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public double getPrice() {
        return price;
    }
}

