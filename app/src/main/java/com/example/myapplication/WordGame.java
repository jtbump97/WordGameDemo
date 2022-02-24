package com.example.myapplication;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class WordGame extends AppCompatActivity {

    ArrayList<Character> word;
    ArrayList<Character> solution;
    ArrayList<Character> choices;
    TextView tv;

    public WordGame(TextView tv, Context c){
        word = new ArrayList<>();
        solution = new ArrayList<>();
        choices = new ArrayList<>();
        String solutionString = c.getString(R.string.answer);
        for(int i = 0; i <solutionString.length()-1; i++) {
            solution.add(solutionString.charAt(i));
        }
        this.tv = tv;
        choices.addAll(Arrays.asList('A','B','C','D','E','F','G','H',
                'I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'));
        tv.setText("Remaining Letters: " + choices.toString());

    }

    public int checkWord(ArrayList<EditText> editText){

        int check = 0;
        for(int i = 0; i < word.size(); i++){
            Character letter = word.get(i);
            if(solution.get(i) == letter){
                check++;
                editText.get(i).setBackgroundColor(Color.GREEN);
            }
            else if(solution.contains(letter)){
                editText.get(i).setBackgroundColor(Color.YELLOW);
            }
            else{
                editText.get(i).setBackgroundColor(Color.RED);
                while(choices.remove(letter)) {}
                tv.setText("Remaining Letters: " + choices.toString());
            }

        }
        return check;

    }

    public void setWord(String word){
        this.word.clear();
        for(int i = 0; i <word.length();i++){
            this.word.add(word.charAt(i));
        }
    }

    public String getSolution(){
        String stringSolution = "";
        for(int i = 0; i < solution.size(); i++){
            stringSolution = stringSolution + solution.get(i);
        }
        return stringSolution;
    }
}
