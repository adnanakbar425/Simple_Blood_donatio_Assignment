package com.chodhary.adnan.Adapter;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.chodhary.adnan.Fragment.DetailsFragment;
import com.chodhary.adnan.Model.Donor;
import com.chodhary.adnan.R;

import java.util.ArrayList;

public class DonorAdapter extends RecyclerView.Adapter<DonorAdapter.MyViewHolder>{

    Activity activity;
    ArrayList<Donor> donorArrayList;

    public DonorAdapter(Activity activity, ArrayList<Donor> historyArrayList) {
        this.activity = activity;
        this.donorArrayList = historyArrayList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(activity).inflate(R.layout.single_donor_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String name = donorArrayList.get(position).getName();
        String group = donorArrayList.get(position).getGroup();


        holder.name.setText(name);
        holder.group.setText(group);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transection = activity.getFragmentManager().beginTransaction();
                DetailsFragment fragment = new DetailsFragment();

                Bundle bundle = new Bundle();
                bundle.putSerializable("donor", donorArrayList.get(position));
                fragment.setArguments(bundle);

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment).addToBackStack(null).commit();

            }
        });


    }

    @Override
    public int getItemCount() {
        return donorArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
    TextView name, group;
    RelativeLayout layout;

        public MyViewHolder(@NonNull View itemView) {
        super(itemView);

            name = (TextView) itemView.findViewById(R.id.donor_name);
            group = (TextView) itemView.findViewById(R.id.blood_group);
            layout = (RelativeLayout) itemView.findViewById(R.id.list_relative);
        }
    }
}
