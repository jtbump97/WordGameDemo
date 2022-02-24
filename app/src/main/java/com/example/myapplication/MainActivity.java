package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    int check;
    WordGame wordGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        TextView tv = (TextView) findViewById(R.id.textView);
        wordGame = new WordGame(tv,getApplicationContext());

    }

    public void onClick(View v) {

        String word = "";
        ArrayList<EditText> t = new ArrayList<EditText>();

        t.add(((EditText)findViewById(R.id.textbox1)));
        word =  word + t.get(0).getText();

        t.add(((EditText)findViewById(R.id.textbox2)));
        word =  word + t.get(0).getText();

        t.add(((EditText)findViewById(R.id.textbox3)));
        word =  word + t.get(0).getText();

        t.add(((EditText)findViewById(R.id.textbox4)));
        word =  word + t.get(0).getText();

        t.add(((EditText)findViewById(R.id.textbox5)));
        word =  word + t.get(0).getText();


        wordGame.setWord(word);
        if(wordGame.checkWord(t) == 5){
            String solution = wordGame.getSolution();
            Intent intent = new Intent(this,WinActivity.class);
            intent.putExtra("solutions",solution);
            startActivity(intent);
        }

    }
}