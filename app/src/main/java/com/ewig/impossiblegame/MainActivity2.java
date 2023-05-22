package com.ewig.impossiblegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    Button buttonEntry;
    Intent toGame;
    EditText nameInput;
    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        buttonEntry=findViewById(R.id.buttonEntry);
        nameInput=findViewById(R.id.nameInput);
        userName="No Name";

    }
    public void enter(View view){
        userName = nameInput.getText().toString();
        toGame=new Intent(MainActivity2.this,MainActivity.class);
        toGame.putExtra("name",userName);
        startActivity(toGame);

    }
}