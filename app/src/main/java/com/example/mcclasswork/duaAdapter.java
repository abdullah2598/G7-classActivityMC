package com.example.mcclasswork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class duaAdapter extends RecyclerView.Adapter<duaAdapter.viewHolder> {

    ArrayList<Dua> list;
    Context context;
    //    create constructor of the both of the following will be used in the main class
    public duaAdapter(ArrayList<Dua> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public duaAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.duadesign,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Dua model=list.get(position);
        holder.stdrecname.setText(model.getName());
        holder.stdrecayats.setText(model.getCount());
        holder.stdrecparano.setText(model.getDate());



    }

// group 7
    // jab ho jay to last commit complete ho gai ha


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        //        cardview (which is our layout) ko hum idher hi inflate kar lety ha

        TextView stdrecname;
        TextView stdrecparano;
        TextView stdrecayats;



        public viewHolder(@NonNull View itemView) {
            super(itemView);
            stdrecname = itemView.findViewById(R.id.stdrecname);
            stdrecparano = itemView.findViewById(R.id.stdrecparano);
            stdrecayats = itemView.findViewById(R.id.stdrecayats);
        }
    }
}
