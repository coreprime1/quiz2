package com.dreamyards.topquiz2.controller;

import static com.dreamyards.topquiz2.controller.MainActivity2.SHARED_PREFERENCE_GAME_USER;
import static com.dreamyards.topquiz2.controller.MainActivity2.SHARED_PREFERENCE_GAME_USER_NAME;
import static com.dreamyards.topquiz2.controller.MainActivity2.SHARED_PREFERENCE_GAME_USER_SCORE;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamyards.topquiz2.R;

public class MainActivity extends AppCompatActivity {

    private EditText mEdt_Play;
    private TextView mTxt_Play;
    private Button mBtn_Play;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdt_Play = findViewById(R.id.main_edt_name);
        mTxt_Play = findViewById(R.id.mai_tv_greeting);
        mBtn_Play = findViewById(R.id.main_btn_play);

        mBtn_Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("USERNAME", mEdt_Play.getText().toString());
                startActivityForResult(intent, 22);
                finish();

                SharedPreferences mSharedPreferences = getSharedPreferences(  SHARED_PREFERENCE_GAME_USER
                        , MODE_PRIVATE);
                int score = mSharedPreferences.getInt(SHARED_PREFERENCE_GAME_USER_SCORE, -1);
                String username = mSharedPreferences.getString(SHARED_PREFERENCE_GAME_USER_NAME, "Zero");

                System.out.println("TESTCODE : int "+score+"  username"+username);
                Log.e("TESTCODE","int "+score+"  username"+username);

                Toast.makeText( MainActivity.this, "username "+username+" le score "+score,
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }
}