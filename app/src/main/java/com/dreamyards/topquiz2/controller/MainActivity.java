package com.dreamyards.topquiz2.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
                startActivity(intent);
            }
        });
    }
}