package com.mesum.recyclerviewjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    //Props needed for contructor intialization
    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;
    private String itemText;

    public WordListAdapter(Context context, LinkedList<String> wordList){

        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;

    }

   class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
       //val props
       public final TextView wordItemView;
       final WordListAdapter mAdapter;
       //WordViewHolder constructor
       public WordViewHolder(View itemView, WordListAdapter adapter){
           super(itemView);
           wordItemView = itemView.findViewById(R.id.word);
           this.mAdapter = adapter;
           itemView.setOnClickListener(this);
       }

       @Override
       public void onClick(View v) {
           //gets item postion
           int mPosition = getLayoutPosition();
           //gets item
           String elements = mWordList.get(mPosition);
           //changes wordlist item with clicked
           mWordList.set(mPosition, "Clicked" + elements);
           mAdapter.notifyDataSetChanged();

       }
   }

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mItemView = mInflater.inflate(R.layout.word_list_item, parent, false);
        return new WordViewHolder(mItemView, this);

    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);

    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}
