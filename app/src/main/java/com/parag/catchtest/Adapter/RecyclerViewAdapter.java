package com.parag.catchtest.Adapter;

/**
 * Created by parag on 1/08/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parag.catchtest.Helper_Classes.DataObject;
import com.parag.catchtest.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView
        .Adapter<RecyclerViewAdapter
        .DataObjectHolder> {
private static String LOG_TAG = "RecyclerViewAdapter";
private ArrayList<DataObject> mDataset;
private static MyClickListener myClickListener;

public static class DataObjectHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener {
    TextView title;
    TextView subTitle;

    public DataObjectHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        subTitle = (TextView) itemView.findViewById(R.id.subTitle);
        Log.i(LOG_TAG, "Adding Listener");
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        myClickListener.onItemClick(getAdapterPosition(), v);
    }
}

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public RecyclerViewAdapter(ArrayList<DataObject> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_row, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.title.setText(mDataset.get(position).getTitle());
        holder.subTitle.setText(mDataset.get(position).getSubTitle());
    }

    public void addItem(DataObject dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

public interface MyClickListener {
    public void onItemClick(int position, View v);
}
}