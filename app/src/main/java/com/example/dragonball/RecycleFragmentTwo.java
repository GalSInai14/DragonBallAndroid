package com.example.dragonball;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class RecycleFragmentTwo extends Fragment {

    private ArrayList<DataModel> dataSet;

    private RecyclerView recycleView;
    private LinearLayoutManager layoutManager;
    private CustomAdapter addapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycle_two, container, false);
        recycleView = view.findViewById(R.id.my_recycler_view);

        layoutManager = new LinearLayoutManager(getContext()); // new GridLayoutManager
        recycleView.setLayoutManager(layoutManager);

        recycleView.setItemAnimator(new DefaultItemAnimator());

        dataSet = new ArrayList<DataModel>();

        for(int i=0 ; i<MyData.nameArr.length ; i++)
        {
            dataSet.add(new DataModel(
                    MyData.nameArr[i],
                    MyData.shortDescriptionArr[i],
                    MyData.drawableArr[i],
                    MyData.idArr[i]

            ));
        }

        addapter = new CustomAdapter(dataSet);
        recycleView.setAdapter(addapter);
        return view;
    }
}