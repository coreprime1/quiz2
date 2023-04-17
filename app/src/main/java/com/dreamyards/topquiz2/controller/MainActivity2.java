package com.dreamyards.topquiz2.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamyards.topquiz2.R;
import com.dreamyards.topquiz2.model.Question;
import com.dreamyards.topquiz2.model.User;

import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    public static final String SHARED_PREFERENCE_GAME_USER = "GAME_USER";
    public static final String SHARED_PREFERENCE_GAME_USER_NAME = "GAME_USER_NAME";
    public static final String SHARED_PREFERENCE_GAME_USER_SCORE = "GAME_USER_SCORE";
    private TextView txtQuestion;
    private Button btnReponse1;
    private Button btnReponse2;
    private Button btnReponse3;
    private SharedPreferences mSharedPreferences;

    private Question mQuestion;

    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");

        mUser = new User();
        mUser.setsName(username);

        mSharedPreferences = getSharedPreferences(  SHARED_PREFERENCE_GAME_USER
                , MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(SHARED_PREFERENCE_GAME_USER_NAME, mUser.getsName());
        editor.putInt(SHARED_PREFERENCE_GAME_USER_SCORE, mUser.getScore());
        editor.apply();


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
        int reponse = 0;
        if (v.getId() == R.id.game_activity_button_1){
            reponse = 0;
        } else if (v.getId() == R.id.game_activity_button_2) {
            reponse = 1;
        } else {
            reponse = 2;
        }
        String message;
        if (reponse == mQuestion.getBonneReponse()){
            mUser.incrementScore();
            message = "Félicitation"+mUser.getsName()+" vous avez la bonne question";
        } else{
            message = "Malheureusement"+mUser.getsName()+" vous n'avez pas la bonne question";
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}