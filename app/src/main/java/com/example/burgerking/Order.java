/*
  Copyright 2019 Luca Steingen
 */

package com.example.burgerking;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.TextView;
import java.util.ArrayList;
import android.os.Bundle;

public class Order extends AppCompatActivity {
    // Define Java Variables:
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private TextView txt1;
    private double total = 0.00;
    private ArrayList<Product> orderedProducts = KingDatabase.getAllOrderedProducts();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);                                                         // onCreate (Guarantee user-friendliness)
        setContentView(R.layout.activity_order);                                                    // Set the activity to be used.

        // Link Java Variables to Layout-Elements:
        txt1 = findViewById(R.id.txtPrice);                                                         // Link UI-Element (via it's ID "txtPrice") to the Java variable "txt1".

        // Recycler View:
        recyclerView = findViewById(R.id.rv_order);                                                 // 1.0) Link UI-Element (via it's ID "rv_main") to the Java variable "RV".
        layoutManager = new LinearLayoutManager(this);                                      // 2.1) Create new Layout Manager
        recyclerView.setLayoutManager(layoutManager);                                               // 2.2) Assign Layout Manager to the RecyclerView it should manage.
        OrderAdapter orderAdapter = new OrderAdapter();                                             // 3.1) Create new Object of the class "OrderAdapter" called 'orderAdapter'.
        orderAdapter.setData(orderedProducts);                                                      // 3.2) Call the method "setData()" in the class "OrderAdapter" and pass this method all ordered product objects from the KingDatabase.
        recyclerView.setAdapter(orderAdapter);                                                      // 3.3) Assign the custom adapter object 'orderAdapter' to the RecyclerView.

        // Calculate Total Sum:
        for (int i = 0; i < orderedProducts.size(); i++) {
            total = total + (orderedProducts.get(i).getPrice() * orderedProducts.get(i).getAmount());
        }
        txt1.setText("$ " + String.format("%.2f", total));
    }
}