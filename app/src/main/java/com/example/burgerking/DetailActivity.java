/*
  Copyright 2019 Luca Steingen
 */

package com.example.burgerking;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DetailActivity extends AppCompatActivity {
    // Define Java Variables:
    private TextView txt1, txt2, txt3, txt4;
    private Button btn1, btn2, btn3;
    private ImageView img1;
    private int amount, intentID;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);                                                         // onCreate (Guarantee user-friendliness)
        setContentView(R.layout.activity_detail);                                                   // Set the activity to be used.

        // Explicit Intent handling:
        Intent intent = getIntent();                                                                // Get the intent that was used to travel to this activity.
        intentID = intent.getIntExtra("productID", 0);                            // Get the extra passed data (the 'productID' of the selected product).
        product = KingDatabase.getProductById(intentID);                                            // Get the according 'product object' from the database, depending of the passed 'productID' ('intendID').

        // Link Java Variables to Layout-Elements:
        txt1 = findViewById(R.id.txtName);                                                          // Link UI-Element (via it's ID "txtName") to the Java variable "txt1".
        txt2 = findViewById(R.id.txtPrice);                                                         // Link UI-Element (via it's ID "txtPrice") to the Java variable "txt2".
        txt3 = findViewById(R.id.txtDescription);                                                   // Link UI-Element (via it's ID "txtDescription") to the Java variable "txt3".                                                        // Link UI-Element (via it's ID "txtAuthor") to the Java variable "txt3".
        txt4 = findViewById(R.id.txtAmount);                                                        // Link UI-Element (via it's ID "txtAmount") to the Java variable "txt4".
        btn1 = findViewById(R.id.btnMinus);                                                         // Link UI-Element (via it's ID "btnMinus") to the Java variable "btn1".
        btn2 = findViewById(R.id.btnPlus);                                                          // Link UI-Element (via it's ID "btnPlus") to the Java variable "btn2".
        btn3 = findViewById(R.id.btnAdd);                                                           // Link UI-Element (via it's ID "btnAdd") to the Java variable "btn3".
        img1 = findViewById(R.id.imgProduct);                                                       // Link UI-Element (via it's ID "imgProduct") to the Java variable "img1".

        // Set values to show the data of the selected product:
        txt1.setText(product.getName());                                                            // Assign 'name' data to the of the selected product.
        txt2.setText("$ " + String.format("%.2f", product.getPrice()));                             // Assign 'price' data to the of the selected product.
        txt3.setText(product.getDescription());                                                     // Assign 'description' data to the of the selected product.
        txt4.setText("0");                                                                          // Set default amount to zero.
        img1.setImageResource(product.getImageDrawableId());                                        // We we learn about loading images from the internet in a later week.

        btn1.setOnClickListener(new View.OnClickListener() {                                        // - Button
            @Override
            public void onClick(View view) {
                if (amount > 0) {                                                                   // So there can't be a negative amount.
                    amount = amount -1;                                                             // Calculate -1
                    txt4.setText(Integer.toString(amount));                                         // Show that value on screen.
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {                                        // + Button
            @Override
            public void onClick(View view) {
                amount = amount +1;                                                                 // Calculate +1
                txt4.setText(Integer.toString(amount));                                             // Show that value on screen.
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {                                        // Add Button
            @Override
            public void onClick(View view) {
                product.setAmount(product.getAmount() + amount);                                    // Add the selected amount to the current amount. (Change in database)
            }                                                                                       // This way I can be sure, there is always one amount for each existing product.
        });
    }
}