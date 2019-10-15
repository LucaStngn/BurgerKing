/*
  Copyright 2019 Luca Steingen
 */

package com.example.burgerking;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {        // Inherit from the class "RecyclerView" with an adapter that adapts to our custom ViewHolder 'ProductViewHolder'.
    private ArrayList<Product> list;                                                                // DATA: Create ArrayList of 'Product Objects', called 'list'.

    public class ProductViewHolder extends RecyclerView.ViewHolder {                                // Custom ViewHolder (inherited from the default ViewHolder) that represents one item in the RecyclerView. It doesn't have data when it's first constructed. We assign the data in onBindViewHolder.
        // Define Java Variables:
        public TextView txt1, txt2;
        public Button btn1, btn2, btn3;
        public View viw1;
        public ImageView img1;
        public ProductViewHolder(View v) {                                                          // This constructor is used in onCreateViewHolder.
            super(v);                                                                               // Runs the constructor for the ViewHolder superclass.
            viw1 = v;                                                                               // View needed later for the explicit intent.
            img1 = v.findViewById(R.id.imgPhoto);                                                   // Link UI-Element (via it's ID "imgPhoto") to the Java variable "img1".
            txt1 = v.findViewById(R.id.txtName);                                                    // Link UI-Element (via it's ID "txtName") to the Java variable "txt1".
            txt2 = v.findViewById(R.id.txtPrice);                                                   // Link UI-Element (via it's ID "txtPrice") to the Java variable "txt2".
            btn1 = v.findViewById(R.id.btnMinus);                                                   // Link UI-Element (via it's ID "btnMinus") to the Java variable "btn1".
            btn2 = v.findViewById(R.id.btnPlus);                                                    // Link UI-Element (via it's ID "btnPlus") to the Java variable "btn2".
            btn3 = v.findViewById(R.id.btnAdd);                                                     // Link UI-Element (via it's ID "btnAdd") to the Java variable "btn3".
        }
    }

    // Give data to the adapter:
    public void setData(ArrayList<Product> allProducts) {
        list = allProducts;                                                                         // Assign all the product objects from the KingDatabase to the ArrayList of product objects.
    }

    // Function 1/3: Create new views (The 'chunks'):
    @NonNull @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product, parent, false);  // Create a new view from the layout file 'product'. (One of these views represents one chunk)
        return new ProductViewHolder(view);                                                                          // Create an instance of my custom ViewHolder for this 'product' view.
    }

    // Function 2/3: Replace the contents of all RecyclerView elements (Gets executed for every RecyclerView element):
    public void onBindViewHolder(@NonNull ProductViewHolder holder, final int position) {           // CustomViewHolder
        final Product productAtPosition = list.get(position);                                       // Get the ID of the current RecyclerView element.
        holder.txt1.setText(productAtPosition.getName());                                           // Assign 'name' data to the view elements inside the RecyclerView.
        holder.txt2.setText("$ " + String.format("%.2f", productAtPosition.getPrice()));            // Assign 'price' data to the view elements inside the RecyclerView.
        holder.img1.setImageResource(productAtPosition.getImageDrawableId());                       // Assign 'image' data to the view elements inside the RecyclerView.

        // Explicit intent to 'DetailActivity.java':
        holder.viw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context C = view.getContext();                                                      // We need to get the context of the view that has been clicked on, to be able to use it's "startActivity()" method. (Activity Classes have that automatically, as they are subclasses of the "Context Class", but our "ProductAdapter Class" doesn't have that. So we need to "import" the context first.
                Intent intent = new Intent(C, DetailActivity.class);                                // Define intent (exists only inside the method) and which other activity to go to.
                intent.putExtra("productID", productAtPosition.getProductID());               // Key: 'productID' is the identifier. Value: is the productID, of the product that has been clicked on. (Pass Data)
                C.startActivity(intent);                                                            // Execution.
            }
        });
    }

    // Function 3/3: Return the amount of items in the dataset:
    @Override
    public int getItemCount() {
        return list.size();
    }
}