package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static ArrayList<Items> items = new ArrayList<Items>();
    String selectedShop;
    boolean firstStart = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        TextView tv = findViewById(R.id.tvGreeting);
        tv.setText("Welcome" + username + " !");
        loadDropDown();
    }
    public void loadDropDown() {
    Spinner spinner = (Spinner) findViewById(R.id.dropdownspinner);
    spinner.setOnItemSelectedListener(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.laden_array));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        if(firstStart){
            firstStart = !firstStart;
            selectedShop = getResources().getStringArray(R.array.laden_array)[pos];
        }else{
            Toast.makeText(getApplicationContext(),getResources().getStringArray(R.array.laden_array)[pos] , Toast.LENGTH_LONG).show();
            selectedShop = getResources().getStringArray(R.array.laden_array)[pos];
        }



    }

    public void checkIfEmpty(View view) {
        EditText itemQuantity = findViewById(R.id.editTextNumber);
        EditText itemName = findViewById(R.id.etItemName);
        String quantityText = itemQuantity.getText().toString();
        int quantity = 0;
         try{
             quantity = Integer.parseInt(quantityText);
        }
        catch (Exception e) {

        }
        String itemname = itemName.getText().toString();
        if(itemname.isEmpty() || itemQuantity.getText().toString().isEmpty()) {
            toastText("Es fehlt was");
        }else{
            Items newItem = new Items(selectedShop,itemname,quantity);
            items.add(newItem);
            toastText("Das Item " + itemname + " wurde" + quantity + "x hinzugefügt!");
            showItemsInList();
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void showItemsInList(){
        Log.i("WK","Warenkorb");
        for(Items item : items) {
            Log.i("Msg", "Itemstats: " + item.getName() + " " + item.getQuantity() + " " + item.getShop());
        }

    }

    public void toastText(String msg){
        Toast.makeText(getApplicationContext(),msg , Toast.LENGTH_LONG).show();

    }
    public void showShoppingCart(View view) {
        Intent intent = new Intent(DashboardActivity.this, WarenkorbActivity.class);
        startActivity(intent);
    }

}