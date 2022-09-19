package com.example.atvdd1_componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    GridView gridView;
    String[] numbers= {"One","Two","Three","Four","Five","Seven","Eight","Nine","Ten"};
    int[] ImagemTeam = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,
            R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,R.drawable.ten};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        gridView = findViewById(R.id.gridy);

        MainAdapter adapter = new MainAdapter(SecondActivity.this,numbers,ImagemTeam);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"You Clicked"+numbers[+i],Toast.LENGTH_SHORT).show();
            }
        });

    }
}