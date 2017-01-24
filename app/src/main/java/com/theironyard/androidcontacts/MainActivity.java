package com.theironyard.androidcontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener{

    ArrayAdapter<String> contacts;

    ListView list;
    EditText  name;
    EditText number;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list =(ListView) findViewById(R.id.listView);
        name = (EditText) findViewById(R.id.name);
        number = (EditText) findViewById(R.id.number);
        addButton = (Button) findViewById(R.id.addButton);

        contacts = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(contacts);

        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);


    }

    @Override
    public void onClick(View view) {
        String contact = name.getText().toString();
        String contactNum = number.getText().toString();
        contacts.add(contact + " - " + contactNum);
        name.setText(" ");
        number.setText(" ");

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
        String contact = contacts.getItem(position);
        contacts.remove(contact);
        return true;
    }
}
