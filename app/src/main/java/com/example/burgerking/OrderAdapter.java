/*
  Copyright 2019 Luca Steingen
 */

package com.example.burgerking;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {              // Inherit from the class "RecyclerView" with an adapter that adapts to our custom ViewHolder 'OrderViewHolder'.
    private ArrayList<Product> list = new ArrayList<>();                                            // DATA: Create ArrayList of 'Product Objects', called 'list'.

    public class OrderViewHolder extends RecyclerView.ViewHolder {                                  // Custom ViewHolder (inherited from the default ViewHolder) that represents one item in the RecyclerView. It doesn't have data when it's first constructed. We assign the data in onBindViewHolder.
        // Define Java Variables:
        public TextView txt1, txt2, txt3;
        public ImageView img1;
        public View viw1;
        public OrderViewHolder(View v) {                                                            // This constructor is used in onCreateViewHolder.
            super(v);                                                                               // Runs the constructor for the ViewHolder superclass
            viw1 = v;                                                                               // View needed later for the explicit intent.
            txt1 = v.findViewById(R.id.txtName);                                                    // Link UI-Element (via it's ID "txtName") to the Java variable "txt1".
            txt2 = v.findViewById(R.id.txtAmount);                                                  // Link UI-Element (via it's ID "txtAmount") to the Java variable "txt2".
            txt3 = v.findViewById(R.id.txtPrice);                                                   // Link UI-Element (via it's ID "txtPrice") to the Java variable "txt3".
            img1 = v.findViewById(R.id.imgPhoto);                                                   // Link UI-Element (via it's ID "imgPhoto") to the Java variable "img1".
        }
    }

    // Give data to the adapter:
    public void setData(ArrayList<Product> allOrderedProducts) {
        list = allOrderedProducts;                                                                  // Assign all the ordered product objects from the KingDatabase to the ArrayList of product objects.
    }

    // Function 1/3: Create new views (The 'chunks'):
    @NonNull @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order, parent, false);    // Create a new view from the layout file 'order'. (One of this view represents one chunk)
        return new OrderViewHolder(view);                                                                            // Create an instance of my custom ViewHolder for this 'product' view.
    }

    // Function 2/3: Replace the contents of all RecyclerView elements (Gets executed for every RecyclerView element):
    public void onBindViewHolder(@NonNull OrderViewHolder holder, final int position) {             // CustomViewHolder
        Product productAtPosition = list.get(position);                                             // Get the ID of the current view.
        holder.txt1.setText(productAtPosition.getName());                                           // Assign 'name' data to the view elements inside the RecyclerView.
        holder.txt2.setText("x " + productAtPosition.getAmount());                                  // Assign 'amount' data to the view elements inside the RecyclerView.
        holder.txt3.setText("$ " + String.format("%.2f", productAtPosition.getPrice()));            // Assign 'price' data to the view elements inside the RecyclerView.
        holder.img1.setImageResource(productAtPosition.getImageDrawableId());                       // Assign 'image' data to the view elements inside the RecyclerView.
    }

    // Function 3/3: Return the amount of items in the dataset:
    @Override
    public int getItemCount() {
        return list.size();
    }
}