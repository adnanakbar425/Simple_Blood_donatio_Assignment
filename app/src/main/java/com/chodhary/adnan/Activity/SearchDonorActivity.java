package com.chodhary.adnan.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.chodhary.adnan.Adapter.DonorAdapter;
import com.chodhary.adnan.Model.Donor;
import com.chodhary.adnan.R;

import java.util.ArrayList;

import static com.chodhary.adnan.Activity.MainActivity.donorArrayList;


public class SearchDonorActivity extends AppCompatActivity {

    public DonorAdapter donorAdapter;
    private RecyclerView recyclerView;
    EditText serchInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_donor);

        serchInput = findViewById(R.id.tv_search);
        recyclerView=findViewById(R.id.search_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(SearchDonorActivity.this));


        serchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            //This function will execute when text is changed in the text field
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() == 0) {
                    donorAdapter = new DonorAdapter(SearchDonorActivity.this, donorArrayList);
                    recyclerView.setAdapter(donorAdapter);
                    donorAdapter.notifyDataSetChanged();
                } else {
                    //This array list only contains the booking objects containing the searched names
                    ArrayList<Donor> clone = new ArrayList<>();
                    for (Donor element : donorArrayList) {
                        if (element.getName().toLowerCase().contains(s.toString().toLowerCase())) {
                            clone.add(element);
                        }
                    }
                    donorAdapter = new DonorAdapter(SearchDonorActivity.this, clone);
                    recyclerView.setAdapter(donorAdapter);
                    donorAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}