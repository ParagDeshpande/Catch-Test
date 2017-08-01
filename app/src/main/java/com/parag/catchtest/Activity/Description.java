package com.parag.catchtest.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.parag.catchtest.Helper_Classes.DataObject;
import com.parag.catchtest.Helper_Classes.JSONResponse;
import com.parag.catchtest.R;

import java.util.ArrayList;

public class Description extends AppCompatActivity {
    int id;
    ArrayList results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_description);

        // Checking the bundle data content

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            id = extras.getInt("id");
        }

        TextView description = (TextView) findViewById(R.id.description);

        // Important:
        // Results is made static so that only 1 instance is created and its value will be the
        // same throughout the application.

        results = JSONResponse.results;
        DataObject obj = (DataObject) results.get(id);
        String content = obj.getContent();
        description.setText(content);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
