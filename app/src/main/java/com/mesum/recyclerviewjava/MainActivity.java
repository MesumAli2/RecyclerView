package com.mesum.recyclerviewjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity  {

      private final LinkedList<String> myWordList = new LinkedList<>();
      private RecyclerView mRecyclerView;
      private WordListAdapter mAdapter;
      private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i =0; i < 20; i ++){
            
            myWordList.addLast("Word " + i  );
        }

      mRecyclerView = findViewById(R.id.recyclerView);
      mAdapter = new WordListAdapter(this, myWordList);
      mRecyclerView.setAdapter(mAdapter);
      mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
      floatingActionButton = findViewById(R.id.addBtn);

      floatingActionButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              int wordListSize = myWordList.size();
              //Add a new word to the wordList.
              myWordList.addLast("+ Word "+wordListSize);
              mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
              mRecyclerView.smoothScrollToPosition(wordListSize);
          }
      });


    }

}