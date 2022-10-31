package com.example.testapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    private Context context;
    Activity activity;
    private ArrayList meal_id, food_title, food_name, food_quantity, food_calories;

    CustomAdapter(Activity activity, Context context, ArrayList meal_id, ArrayList food_title, ArrayList food_name,
                  ArrayList food_quantity, ArrayList food_calories){
        this.activity = activity;
        this.context = context;
        this.meal_id = meal_id;
        this.food_title = food_title;
        this.food_name = food_name;
        this.food_quantity = food_quantity;
        this.food_calories = food_calories;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvMealID.setText(String.valueOf(meal_id.get(position)));
        holder.tvMeal.setText(String.valueOf(food_title.get(position)));
        holder.tvFoodName.setText(String.valueOf(food_name.get(position)));
        holder.tvQuantity.setText(String.valueOf(food_quantity.get(position)));
        holder.tvCalories.setText(String.valueOf(food_calories.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(meal_id.get(position)));
                intent.putExtra("meal_title", String.valueOf(food_title.get(position)));
                intent.putExtra("food_name", String.valueOf(food_name.get(position)));
                intent.putExtra("quantity", String.valueOf(food_quantity.get(position)));
                intent.putExtra("calories", String.valueOf(food_calories.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return meal_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvMealID, tvMeal, tvFoodName, tvQuantity, tvCalories;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvMealID = itemView.findViewById(R.id.tvMealID);
            tvMeal = itemView.findViewById(R.id.tvTitle);
            tvFoodName = itemView.findViewById(R.id.tvFoodName);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
            tvCalories = itemView.findViewById(R.id.tvCalories);

            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
