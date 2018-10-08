package com.example.cdu_nb.bus_it;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class HistoryFrag extends Fragment {

    View myview;
    RecyclerView recyclerView;
//    RecyclerAdapter recyclerAdapter;
    List<Ticket> list;

    public HistoryFrag(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, @Nullable Bundle savedInstanceState) {
        myview=inflater.inflate(R.layout.history,container,false);
        recyclerView=(RecyclerView) myview.findViewById(R.id.recycler_view);
        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(list, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerAdapter);

        return myview;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list = new ArrayList<>();
        list.add(new Ticket("Route: 4",  "Fare: $3", "Date: 04/10/2018"));
        list.add(new Ticket("Route: 9", "Fare: $3","Date: 05/10/2018"));
    }
}
