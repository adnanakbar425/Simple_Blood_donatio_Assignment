package com.chodhary.adnan.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chodhary.adnan.Adapter.DonorAdapter;
import com.chodhary.adnan.R;

import static com.chodhary.adnan.Activity.MainActivity.donorArrayList;

public class ListFragment extends Fragment {

    public DonorAdapter donorAdapter;
    private RecyclerView recyclerView;



    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
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
        View view= inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView =view.findViewById(R.id.donor_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        donorAdapter = new DonorAdapter(getActivity(), donorArrayList);
        recyclerView.setAdapter(donorAdapter);
        donorAdapter.notifyDataSetChanged();

        return view;
    }
}