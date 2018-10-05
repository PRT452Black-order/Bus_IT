package com.example.cdu_nb.bus_it;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.VH> {

    List<Ticket> list;
    Context context;

    public RecyclerAdapter(List<Ticket> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public RecyclerAdapter.VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerAdapter.VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.mycardview, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.VH holder, int position) {
        holder.name.setText(list.get(position).route);
        holder.loc.setText(list.get(position).date);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView name;
        TextView loc;

        public VH(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.list_title);
            loc = (TextView) itemView.findViewById(R.id.list_desc);
        }

    }
}

