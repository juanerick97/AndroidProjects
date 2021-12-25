package com.example.bhealthy;

import static android.widget.GridLayout.HORIZONTAL;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private LinkedList<Integer> foodImageList = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private FoodAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_menu);
/*
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                int wordListSize = foodImageList.size();
                // Add a new word to the wordList.
                foodImageList.addLast("Word " + wordListSize);
                // Notify the adapter, that the data has changed.
                mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
                // Scroll to the bottom.
                mRecyclerView.smoothScrollToPosition(wordListSize);
            }
        });
*/

        foodImageList.addLast(R.drawable.a);
        foodImageList.addLast(R.drawable.b);
        foodImageList.addLast(R.drawable.c);
        foodImageList.addLast(R.drawable.breakfast);
        foodImageList.addLast(R.drawable.f);
        foodImageList.addLast(R.drawable.a);


        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.food_grid);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new FoodAdapter(this, foodImageList);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3, RecyclerView.VERTICAL, false));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
