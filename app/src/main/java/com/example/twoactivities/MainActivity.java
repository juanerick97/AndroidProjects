package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName(); //This Tag seems to get the name of the current class
    public static final String EXTRA_MESSAGE = "com.example.twoactivities.extra.MESSAGE";
    public EditText mMessageEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);

    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button Clicked!"); //This method takes in the name of the current class and the message "Button Clicked"
        Intent intent = new Intent(this, SecondActivity.class); //This is how the system knows which activity to lunch
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent); //intent provides the startActivity method with the activity that it needs to lunch
    }


}