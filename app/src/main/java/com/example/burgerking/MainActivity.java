/*
  Copyright 2019 Luca Steingen
 */

package com.example.burgerking;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // Define Java Variables:
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);                                                         // onCreate (Guarantee user-friendliness)
        setContentView(R.layout.activity_main);                                                     // Set the activity to be used.

        // Link Java Variables to Layout-Elements:
        btn1 = findViewById(R.id.btnViewOrder);                                                     // Link UI-Element (via it's ID "btnViewOrder") to the Java variable "btn1".

        // Recycler View:
        recyclerView = findViewById(R.id.rv_main);                                                  // 1.0) Link UI-Element (via it's ID "rv_main") to the Java variable "recyclerView".
        layoutManager = new LinearLayoutManager(this);                                      // 2.1) Create new LayoutManager.
        recyclerView.setLayoutManager(layoutManager);                                               // 2.2) Assign LayoutManager to the RecyclerView it should manage.
        ProductAdapter productAdapter = new ProductAdapter();                                       // 3.1) Create new Object of the class "ProductAdapter" called 'productAdapter'.
        productAdapter.setData(KingDatabase.getAllProducts());                                      // 3.2) Call the method "setData()" in the class "ProductAdapter" and pass this method all product objects from the KingDatabase.
        recyclerView.setAdapter(productAdapter);                                                    // 3.3) Assign the custom adapter object 'productAdapter' to the RecyclerView.

        // Explicit intent to 'Order.java':
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Order.class);                   // Define intent (exists only inside the method) and which other activity to go to.
                startActivity(intent);                                                              // Execution
            }
        });
    }
}