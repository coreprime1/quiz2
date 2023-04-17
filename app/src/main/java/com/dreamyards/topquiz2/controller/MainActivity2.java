package com.dreamyards.topquiz2.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dreamyards.topquiz2.R;
import com.dreamyards.topquiz2.model.Question;

import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private TextView txtQuestion;
    private Button btnReponse1;
    private Button btnReponse2;
    private Button btnReponse3;

    private Question mQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");

        mQuestion = new Question("Qui est le créateur d'Android ?",
                Arrays.asList(
                        "Andy Rubin",
                        "Steve Wozniak",
                        "Jake Wharton"
                ),
                0);

        txtQuestion = findViewById(R.id.game_activity_textview_question);

        btnReponse1 = findViewById(R.id.game_activity_button_1);
        btnReponse1.setOnClickListener(this::onClick);
        btnReponse2 = findViewById(R.id.game_activity_button_2);
        btnReponse2.setOnClickListener(this::onClick);
        btnReponse3 = findViewById(R.id.game_activity_button_3);
        btnReponse3.setOnClickListener(this::onClick);



        txtQuestion.setText(mQuestion.getQuestion());
        btnReponse1.setText(mQuestion.getChoixPossible().get(0));
        btnReponse2.setText(mQuestion.getChoixPossible().get(1));
        btnReponse3.setText(mQuestion.getChoixPossible().get(2));
    }

    @Override
    public void onClick(View v) {

    }
}