package com.example.cdu_nb.bus_it;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.example.cdu_nb.bus_it.MapActivity;

public class SearchBusFrag extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myview=inflater.inflate(R.layout.searchbus,container,false);
        OnClickListener listnr=new OnClickListener() {
            @Override
            public void onClick(View myview) {
//
                Intent intent = new Intent(getActivity(), MapActivity.class);
                startActivity(intent);

            }
        };


        CardView route4 =(CardView) myview.findViewById(R.id.cardview_route4);
        CardView route9 =(CardView) myview.findViewById(R.id.cardview_route9);
        route4.setOnClickListener(listnr);
        route9.setOnClickListener(listnr);
        return myview;
    }
}
