package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class WarenkorbActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private  RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warenkorb);
        ArrayList<ExampleItem> exampleItems = new ArrayList<>();
        exampleItems.add(new ExampleItem(R.drawable.ic_baseline_fastfood_24,"Line 1", "Line 2"));
        exampleItems.add(new ExampleItem(R.drawable.ic_baseline_architecture_24,"Line 3", "Line 4"));
        exampleItems.add(new ExampleItem(R.drawable.ic_android,"Line 5", "Line 6"));
        //Intent intent = getIntent();
        //Bundle args = intent.getBundleExtra("BUNDLE");
        mRecyclerView.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleItems);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }
    public void listAllitems(){
        //TextView textView = findViewById(R.id.twWarenkorbanzeige);
        //for(Items item : DashboardActivity.items) {
          //  textView.append("Name: " + item.getName() + " " + "Menge: " + item.getQuantity() +"\n");
        //}
    }

}