package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE); //intents work sort of like arraylist where you can access the contents using keys.
                                                                            // MainActivity.EXTRA_MESSAGE provides the getStringExtra with a key of the string in question
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);
    }


    public void returnReply(View view) {
    }
}