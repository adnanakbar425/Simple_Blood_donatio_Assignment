package com.chodhary.adnan.Activity;

import android.os.Bundle;
import android.view.Menu;

import com.chodhary.adnan.Model.Donor;
import com.chodhary.adnan.R;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Donor> donorArrayList;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        donorArrayList =new ArrayList<>();


        donorArrayList.add(new Donor("Eman","0310712","Lhr","B+"));
        donorArrayList.add(new Donor("Fatima","031071","Lhr1","A-"));
        donorArrayList.add(new Donor("Nimra","031071","Lhr2","AB+"));
        donorArrayList.add(new Donor("Uzba","0310712","Lhr3","O+"));
        donorArrayList.add(new Donor("Iqra","031","Lhr4","O-"));
        donorArrayList.add(new Donor("Laiba","031","Lhr5","AB+"));
        donorArrayList.add(new Donor("Maria","0310712","Lhr6","AB-"));
        donorArrayList.add(new Donor("Javeria","0310712","Lhr7","A+"));
        donorArrayList.add(new Donor("Ujala","0310712","Lhr8","B-"));
        donorArrayList.add(new Donor("Eman2","0310712","Lhr9","O+"));
        donorArrayList.add(new Donor("Eman3","031071","Lhr10","B+"));



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_list, R.id.nav_details, R.id.nav_add_new)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}