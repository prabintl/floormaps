package com.example.tutorialspoint7.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.content.Intent;

import com.example.tutorialspoint7.myapplication.Adapters.MainAdapter;
import com.example.tutorialspoint7.myapplication.Model.MyModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<MyModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white,null));
        setSupportActionBar(toolbar);

        list = new ArrayList<>();
        list.add(new MyModel(R.color.colorAccent,"Tower Block", R.drawable.towerblock));
        list.add(new MyModel(R.color.colorAccent,"Lecture Block", R.drawable.ukblock));
        list.add(new MyModel(R.color.colorAccent,"Canteen", R.drawable.canteen));
        list.add(new MyModel(R.color.colorAccent,"Outdoor", R.drawable.outdoor));



        mainAdapter = new MainAdapter(list);
        /*mainAdapter.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
        mainAdapter.setOnItemClickListener(new MainAdapter.ClickListener(){
            @Override
            public void onItemClick(int position, View v) {
                switch (position) {
                    case 0:

                        Toast.makeText(v.getContext(), "Tower Block", Toast.LENGTH_LONG).show();
                    case 1:
                        Toast.makeText(v.getContext(), "UK Block", Toast.LENGTH_LONG).show();
                    case 2:
                        Toast.makeText(v.getContext(), "Canteen Area", Toast.LENGTH_LONG).show();
                    case 3:
                        Toast.makeText(v.getContext(), "Outdoor", Toast.LENGTH_LONG).show();
                }
            }
        });
        recyclerView = findViewById(R.id.mainRecycler);
        recyclerView.setAdapter(mainAdapter);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}
