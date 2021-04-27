package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.String.valueOf;

public class WarenkorbActivity extends ListActivity {
    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> listItems=new ArrayList<String>();
    ArrayList<Items> currentItemsInList = DashboardActivity.items;

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;

    //RECORDING HOW MANY TIMES THE BUTTON HAS BEEN CLICKED
    int clickCounter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warenkorb);
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        setListAdapter(adapter);

        fillList();

    }
    //METHOD WHICH WILL HANDLE DYNAMIC INSERTION
    public void fillList() {
        if(currentItemsInList.isEmpty()){
            String userMessage = "Du hast aktuell keine waren hinzugefügt :(";
            listItems.add(userMessage);
        }
        for(Items item : currentItemsInList){
            String itemName = item.getName();
            String itemQuantity = valueOf(item.getQuantity());
            String shop = item.getShop();
            String fullItem = "Laden: " + shop + " " + itemName + " " + itemQuantity + " Stück";
            listItems.add(fullItem);
            adapter.notifyDataSetChanged();
        }


    }

    public void addBtn(View v){
        Intent intent = new Intent(WarenkorbActivity.this, DashboardActivity.class);
        startActivity(intent);
    }

}