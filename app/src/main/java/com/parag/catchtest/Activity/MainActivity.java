package com.parag.catchtest.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.parag.catchtest.Adapter.RecyclerViewAdapter;
import com.parag.catchtest.Helper_Classes.DataObject;
import com.parag.catchtest.Helper_Classes.HttpHandler;
import com.parag.catchtest.Helper_Classes.JSONResponse;
import com.parag.catchtest.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    SwipeRefreshLayout mSwipeRefreshLayout;
    private ProgressDialog pDialog;
    DataObject obj;ArrayList results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    // Initialise all the views and methods

    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        refreshPage();
        Toast.makeText(MainActivity.this,"Please swipe down to refresh",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    // Perform actions on Refresh to load data into the list

    public void refreshPage() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        mSwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        new GetContent().execute();
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }
        );
    }

    // Asynchronously download the data into the list

    // Important: Lazy Loading can also be done on the data if it had images
    // As all the data is in text format and is taking 1 second to load normal
    // AsyncTask is performed on the JSON object

    private class GetContent extends AsyncTask<Void, Void, Void> {

        // This will run on UI thread

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        // This will run on Background thread

        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler sh = new HttpHandler();
            String url = "https://raw.githubusercontent.com/catchnz/android-test/master/data/data.json";
            String jsonStr = sh.makeServiceCall(url);

            // Parse the JSON Data

            JSONResponse jr = new JSONResponse();
            results = jr.parseJSON(jsonStr);
            return null;
        }

        // After loading the data disable progress dialog and render the data

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (pDialog.isShowing())
                pDialog.dismiss();
            mLayoutManager = new LinearLayoutManager(MainActivity.this);
            mRecyclerView.setLayoutManager(mLayoutManager);
            mAdapter = new RecyclerViewAdapter(results);
            mRecyclerView.setAdapter(mAdapter);

            setClickListener();
        }
    }

    // Setting onClickListener() on the Recycler View

    private void setClickListener() {
        ((RecyclerViewAdapter) mAdapter).setOnItemClickListener(new RecyclerViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent i = new Intent(MainActivity.this, Description.class);
                i.putExtra("id",position);
                startActivity(i);
            }
        });
    }

}


