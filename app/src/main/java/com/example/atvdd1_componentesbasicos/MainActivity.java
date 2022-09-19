package com.example.atvdd1_componentesbasicos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String[] TEAM = new String[]{
            "América Mineiro","Atalanta","Atlético Goianiense","São Paulo","Corinthians","Palmeiras","Santos"
    };

    MediaPlayer mediaPlayer;
    Spinner spinner;
    ToggleButton toggleButton;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> alunos = new ArrayList<>(Arrays.asList("Falcão","Junim","Isanio"));
        ListView listaDeAlunos = findViewById(R.id.activity_main_Lista_alunos);
        listaDeAlunos.setAdapter( new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,alunos));

        AutoCompleteTextView editText = findViewById(R.id.actv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,TEAM);
        editText.setAdapter(adapter);

        spinner = findViewById(R.id.spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
        spinner.setAdapter(adapter);

        button = findViewById(R.id.button);

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this,"Clique Longo",Toast.LENGTH_SHORT).show();
                chamaSecond();
                return false;
            }
        });
    }

    void chamaSecond() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,SecondActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void callClick(View view) {
        mediaPlayer = MediaPlayer.create(this,R.raw.hinosaopaulofc);
        mediaPlayer.start();
    }
}