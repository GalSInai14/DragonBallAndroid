package com.example.dragonball;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>  {
    private ArrayList<DataModel> dataSet;

    public CustomAdapter(ArrayList<DataModel> dataSet) {
        this.dataSet = dataSet;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder  {
        CardView cardView;
        TextView textViewName;
        TextView textViewShortDescription;
        ImageView imageViewIcon;

        public MyViewHolder (View itemView)
        {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
            textViewName = ( TextView) itemView.findViewById(R.id.nameTextViewCL);
            textViewShortDescription = ( TextView) itemView.findViewById(R.id.textViewShortDedcriptionCL);
            imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);

        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext() ).inflate(R.layout.cards_layout, parent ,false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int listPosition) {
        TextView textViewName = viewHolder.textViewName;
        TextView textViewVersion = viewHolder.textViewShortDescription;
        ImageView imageView = viewHolder.imageViewIcon;
        CardView cardView = viewHolder.cardView;

        textViewName.setText(dataSet.get(listPosition).getName());
        textViewVersion.setText(dataSet.get(listPosition).getShortDescription());
        imageView.setImageResource(dataSet.get(listPosition).getImage());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                int num = listPosition;
                String position = String.valueOf(num);
                bundle.putString("position",position);
                Navigation.findNavController(view).navigate(R.id.action_recycleFragmentTwo_to_characterDetailFragment, bundle);

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


}
