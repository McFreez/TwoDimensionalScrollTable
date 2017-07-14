package example.com.twodimensionscrolltable;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import example.com.twodimensionscrolltable.adapters.AttributesAdapter;
import example.com.twodimensionscrolltable.adapters.DataAdapter;
import example.com.twodimensionscrolltable.adapters.DaysAdapter;

import example.com.twodimensionscrolltable.table.AttributesScrollView;
import example.com.twodimensionscrolltable.table.DataRecyclerView;
import example.com.twodimensionscrolltable.table.DataVerticalScrollView;
import example.com.twodimensionscrolltable.table.DaysRecyclerView;

public class MainActivity extends AppCompatActivity {

    private static final int ATTRIBUTES_COUNT = 50;
    private static final int DAYS_COUNT = 100;

    private AttributesAdapter attributesAdapter;
    private DaysAdapter daysAdapter;
    private DataAdapter dataAdapter;

    private AttributesScrollView attributesScrollView;
    private LinearLayout attributesContainer;
    private DataRecyclerView dataRecyclerView;
    private DaysRecyclerView daysRecyclerView;
    private DataVerticalScrollView dataVerticalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager layoutManager_data = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager_days = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        attributesContainer = (LinearLayout) findViewById(R.id.attributes_container);

        dataRecyclerView = (DataRecyclerView) findViewById(R.id.rv_data);
        dataRecyclerView.setLayoutManager(layoutManager_data);

        daysRecyclerView = (DaysRecyclerView) findViewById(R.id.rv_days);
        daysRecyclerView.setLayoutManager(layoutManager_days);

        dataVerticalScrollView = (DataVerticalScrollView) findViewById(R.id.data_vertical_scroll);

        attributesScrollView = (AttributesScrollView) findViewById(R.id.attributes_scroll);

        attributesScrollView.synchronizeScrollWith(dataVerticalScrollView);
        dataVerticalScrollView.synchronizeScrollingWith(attributesScrollView);

        dataRecyclerView.synchronizeScrollingWith(daysRecyclerView);
        daysRecyclerView.synchronizeScrollingWith(dataRecyclerView);

        daysAdapter = new DaysAdapter(DAYS_COUNT);
        daysRecyclerView.setAdapter(daysAdapter);

        dataAdapter = new DataAdapter(DAYS_COUNT, ATTRIBUTES_COUNT, this);
        dataRecyclerView.setAdapter(dataAdapter);

        List<String> attributes = new ArrayList<>();
        for(int i = 0; i < ATTRIBUTES_COUNT; i++){
            attributes.add("Attribute " + i);
        }
        attributesAdapter = new AttributesAdapter(this, attributes, attributesContainer);

    }

}
