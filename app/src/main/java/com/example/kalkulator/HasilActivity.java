package com.example.kalkulator;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class HasilActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        // Initialize ListView
        listView = findViewById(R.id.listView);

        // Initialize adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        // Set adapter to ListView
        listView.setAdapter(adapter);

        // Load history data
        loadData();
    }

    private void loadData() {
        // Get history data from DataManager
        List<String> historyList = DataManager.getHistoryData(this);

        // Clear adapter before adding new data
        adapter.clear();

        // Add history items to adapter
        adapter.addAll(historyList);

        // Notify adapter that the data set has changed
        adapter.notifyDataSetChanged();
    }
}
