package com.example.bhealthy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

//The Adapter manages and feeds the data to the recycler view. Each recyclerView should have its own adapter
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private final LinkedList<Integer> foodImageList;
    private LayoutInflater mInflater; //Creates a view from an XML file

    //The view holder feeds data from the adapter to the recyclerView
    //It also holds the data for the views you are working with in the recycler view
    public class FoodViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {


        public final ImageView wordItemView; //Holds the textview you are going to work with
        final FoodAdapter mAdapter; //Holds the  adapter
  //      public ThreadLocal<Integer> setImageResource;

        public FoodViewHolder(@NonNull View itemView, FoodAdapter adapter) {

            super(itemView);
            wordItemView = itemView.findViewById(R.id.food_item);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) { //listens for clicks on views
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in mWordList.
            Integer element = foodImageList.get(mPosition);
            // Change the word in the mWordList.
          //  foodImageList.set(mPosition, "Clicked! ");
            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();
        }
    }

    //These methods need to be overrode and they are used to manage data within the adapter. These are essential for the adapter to work

    //Inflates the viewHolder with the right xml view and provides the right adapter
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.food_item,
                parent, false);

        return new FoodViewHolder(mItemView, this);
    }

    //Changes data/text for the view in question
    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Integer mCurrent = foodImageList.get(position); //Gets data for the given position
        holder.wordItemView.setImageResource(mCurrent); //Gets the view from the viewHolder and sets

    }

    //Returns the numbers of views/items the recyclerView needs to show
    @Override
    public int getItemCount() {
        return foodImageList.size();
    }

    //This is the constructor for foodAdapter, and as such, it sets the values for the variables worked on
    public FoodAdapter(Context context, LinkedList<Integer> foodImageList){
        mInflater = LayoutInflater.from(context); //Initiates an xml view on specific context. In other words, a context its provided and the method allows the initiation of an xml for that ideal context
        this.foodImageList = foodImageList; //Initiates the word list

    }
}
