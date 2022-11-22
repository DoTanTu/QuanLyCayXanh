package com.example.quanlycayxanh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MenuList extends AppCompatActivity {
    private ListView listView;
    private GreenTreeAdapter adapter;
    private String greenTreeId;
    private List<GreenTree> list;

    Button button_edit, button_insert,button_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_green_trees);

        button_delete = (Button) findViewById(R.id.delete_computer);
        button_edit = (Button)findViewById(R.id.edit_computer);
        button_insert = (Button)findViewById(R.id.new_computer);

        button_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectUpdate();
            }
        });

        button_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectNew();
            }
        });

        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectDelete();
            }
        });
        listView = (ListView) findViewById(R.id.lvComputer);
        GreenTreeDAO dao = new GreenTreeDAO(this);
        list = dao.getAllComputer();
        adapter = new GreenTreeAdapter(this,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                GreenTree cmp = list.get(i);
                greenTreeId = cmp.getId();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        GreenTreeDAO dao = new GreenTreeDAO(this);
        List<GreenTree> updateList = dao.getAllComputer();

        list.clear();
        for (GreenTree item : updateList) {
            list.add(item);
        }

        adapter.notifyDataSetChanged();
    }
    public void redirectNew(){
        Intent intent = new Intent(MenuList.this, DetailActivity.class);
        startActivity(intent);
    }
    public void redirectUpdate(){
        Intent intent = new Intent(MenuList.this, DetailActivity.class);
        if(greenTreeId == null) {
            Toast.makeText(this, "Computer id must be selected", Toast.LENGTH_SHORT).show();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("id", greenTreeId);
        intent.putExtra("data", bundle);
        startActivity(intent);
    }
    public void redirectDelete(){
        Intent intent = new Intent(MenuList.this, DetailActivity.class);
        if(greenTreeId == null) {
            Toast.makeText(this, "Computer id must be selected", Toast.LENGTH_SHORT).show();
            return;
        }
        GreenTreeDAO dao  = new GreenTreeDAO(this);
        dao.delete(greenTreeId);
        greenTreeId = null;
        onResume();
        Toast.makeText(this, "Computer was delete", Toast.LENGTH_SHORT).show();

    }
}