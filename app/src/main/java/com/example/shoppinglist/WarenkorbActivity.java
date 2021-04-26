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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warenkorb);

    }
    public void listAllitems(){
        //TextView textView = findViewById(R.id.twWarenkorbanzeige);
        //for(Items item : DashboardActivity.items) {
          //  textView.append("Name: " + item.getName() + " " + "Menge: " + item.getQuantity() +"\n");
        //}
    }

}