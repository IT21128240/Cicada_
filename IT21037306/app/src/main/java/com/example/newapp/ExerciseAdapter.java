package com.example.newapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ViewHolder> {

    //creating objects
    ExerciseData[] exerciseData;
    String[] urls;
    Context context;

    //creating overloaded constructor and assign variables
    public ExerciseAdapter(ExerciseData[] exerciseData, MainActivity activity , String []urls) {
        this.exerciseData = exerciseData;
        this.context = activity;
        this.urls = urls;
    }
    //override onCreateViewHolder method
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.ex_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    //override onBindViewHolder method
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ExerciseData myExerciseDataList = exerciseData[position];
        holder.textViewName.setText(myExerciseDataList.getExerciseName());
        holder.textViewDate.setText(myExerciseDataList.getExerciseDescription());
        holder.exerciseImage.setImageResource(myExerciseDataList.getExerciseImage());

        //if user touch an image a toast will be shown which exercise it that
        holder.exerciseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, holder.textViewName.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        //bind url clicks on click to watch a video and created implicit intent
        holder.url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(urls[holder.getAdapterPosition()]));
                context.startActivity(intent);
            }
        });

    }


    //override getItemCount method
    @Override
    public int getItemCount() {
        return exerciseData.length;
    }

    //show all type of exercise in home page
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView exerciseImage;
        TextView textViewName;
        TextView textViewDate;
        TextView url;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            exerciseImage = itemView.findViewById(R.id.imageview);
            textViewName = itemView.findViewById(R.id.textName);
            textViewDate = itemView.findViewById(R.id.textdate);
            url = itemView.findViewById(R.id.textLink);

        }
    }
}


