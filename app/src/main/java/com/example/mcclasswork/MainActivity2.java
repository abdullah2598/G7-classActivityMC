package com.example.mcclasswork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView rc=findViewById(R.id.rec);
        DB dbHelper=new DB(this);

        ArrayList<Dua> list=dbHelper.getAllStudent();

        if(list.isEmpty())
        {
            Toast.makeText(this, "list is empty", Toast.LENGTH_SHORT).show();
        }
        duaAdapter adapters=new duaAdapter(list,this)   ;
        rc.setAdapter(adapters);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        rc.setLayoutManager(layoutManager);

    }
}