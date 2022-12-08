package com.example.dragonball;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CharacterDetailFragment extends Fragment {


    TextView name;
    ImageView image;
    TextView desc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_detail, container, false);
        name = view.findViewById(R.id.TextNameCD);
        desc = view.findViewById(R.id.TextLongDescription);
        image = view.findViewById(R.id.imageViewCD);

        String characterPos;
        characterPos = getArguments().getString("position");
        int loc;
        loc = Integer.parseInt(characterPos);

        name.setText(MyData.nameArr[loc]);
        desc.setText(MyData.longDescriptionArr[loc]);
        image.setImageResource(MyData.drawableArr[loc]);

        return view;
    }
}