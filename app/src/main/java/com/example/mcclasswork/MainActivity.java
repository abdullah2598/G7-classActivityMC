package com.example.mcclasswork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=findViewById(R.id.adddua);
        Button dataa=findViewById(R.id.dataa);
        EditText dua=findViewById(R.id.dua);
        EditText count=findViewById(R.id.count);
        EditText date=findViewById(R.id.date);
        DB d=new DB(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String duat=dua.getText().toString();
                String countt=count.getText().toString();
                String date1=date.getText().toString();
                Boolean b=d.insertStd(duat,countt,date1);
                if(!b)
                {
                    Toast.makeText(MainActivity.this, "dua not added", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "dua added", Toast.LENGTH_SHORT).show();

                }
            }
        });

        dataa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });


    }
}