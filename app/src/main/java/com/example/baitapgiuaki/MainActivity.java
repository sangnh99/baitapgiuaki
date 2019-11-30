package com.example.baitapgiuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtName, edtAge, edtAddress;
    ListView listView;
    Button btnAdd;
    ArrayList<String> myArray;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = (EditText) findViewById(R.id.edt_name);
        edtAge = (EditText) findViewById(R.id.edt_age);
        edtAddress = (EditText) findViewById(R.id.edt_address);

        listView = (ListView) findViewById(R.id.listView);
        btnAdd = (Button) findViewById(R.id.btn_1);
        btnAdd.setOnClickListener(this);

        myArray = new ArrayList<String>();
        listView = (ListView) findViewById(R.id.listView);
        arrayAdapter
                = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myArray);

        listView.setAdapter(arrayAdapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1:

                if (TextUtils.isEmpty(edtAge.getText().toString()) || TextUtils.isEmpty(edtName.getText()) || TextUtils.isEmpty(edtAddress.getText())) {
                    Toast.makeText(this, "Vui long nhap day du thong tin", Toast.LENGTH_SHORT).show();

                } else if (!TextUtils.isEmpty(edtAge.getText().toString())) {
                    int Age = Integer.parseInt(edtAge.getText().toString());
                    if (Age < 1 || Age > 99) {
                        Toast.makeText(this, "Nhap tuoi tu 1 den 99", Toast.LENGTH_SHORT).show();
                        edtAge.setText("");


                    }

                    String name = edtName.getText().toString();
                    String age = edtAge.getText().toString();
                    String address = edtAddress.getText().toString();

                    myArray.add(name);
                    myArray.add(age);
                    myArray.add(address);
                    arrayAdapter.notifyDataSetChanged();
                }
        }
    }
}