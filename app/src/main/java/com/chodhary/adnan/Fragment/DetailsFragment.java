package com.chodhary.adnan.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chodhary.adnan.Model.Donor;
import com.chodhary.adnan.R;

public class DetailsFragment extends Fragment {

    TextView name,group,phone,address;

    public DetailsFragment() {
        // Required empty public constructor
    }

    public static DetailsFragment newInstance(String param1, String param2) {
        DetailsFragment fragment = new DetailsFragment();
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
        View view=inflater.inflate(R.layout.fragment_details, container, false);
        name=view.findViewById(R.id.name_tv);
        group=view.findViewById(R.id.blood_group_tv);
        phone=view.findViewById(R.id.phone_tv);
        address=view.findViewById(R.id.address_tv);

        Bundle bundle = this.getArguments();
        Donor donor=new Donor();
        if (bundle != null) {
            donor = (Donor) bundle.getSerializable("donor");
            name.setText(donor.getName());
            group.setText(donor.getGroup());
            phone.setText(donor.getPhone());
            address.setText(donor.getAddress());
        }


        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ph=phone.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+ph));
                startActivity(intent);
            }
        });
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        return view;
    }
}