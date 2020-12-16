package com.chodhary.adnan.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chodhary.adnan.Activity.AddNewDonorActivity;
import com.chodhary.adnan.Activity.SearchDonorActivity;
import com.chodhary.adnan.R;

public class AddNewDonorFragment extends Fragment {

    private Button add,search;

    public AddNewDonorFragment() {
        // Required empty public constructor
    }

    public static AddNewDonorFragment newInstance(String param1, String param2) {
        AddNewDonorFragment fragment = new AddNewDonorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_new_donor, container, false);

        add=view.findViewById(R.id.add_btn_);
        search=view.findViewById(R.id.search_btn);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), AddNewDonorActivity.class);
                startActivity(intent);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), SearchDonorActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}