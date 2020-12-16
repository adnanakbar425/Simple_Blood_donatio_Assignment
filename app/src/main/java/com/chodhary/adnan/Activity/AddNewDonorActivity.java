package com.chodhary.adnan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chodhary.adnan.Model.Donor;
import com.chodhary.adnan.R;

import static com.chodhary.adnan.Activity.MainActivity.donorArrayList;

public class AddNewDonorActivity extends AppCompatActivity {

    private EditText name,phone,address,group;
    private String mName,mPhone,mAddress,mGroup;
    private Button AddBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_donor);
        name=findViewById(R.id.username_tv);
        phone=findViewById(R.id.phone_et);
        address=findViewById(R.id.address_et);
        group=findViewById(R.id.blood_et);
        AddBtn=findViewById(R.id.add_btn);

        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mName=name.getText().toString().trim();
                mPhone=phone.getText().toString().trim();
                mAddress=address.getText().toString().trim();
                mGroup=group.getText().toString().trim();

                if(TextUtils.isEmpty(mName)){
                    name.setError("enter name");
                }
                else if(TextUtils.isEmpty(mPhone)){
                    phone.setError("enter phone");
                }
                else if(TextUtils.isEmpty(mAddress)){
                    address.setError("enter address");
                }
                else if(TextUtils.isEmpty(mGroup)){
                    group.setError("enter blood group");
                }
                else{
                    donorArrayList.add(new Donor(mName,mPhone,mAddress,mGroup));
                    Toast.makeText(AddNewDonorActivity.this, "New donor added", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });


    }
}