package com.jorgesys.parallaxwlistview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.jorgesys.parallaxwlistview.Item;
import com.jorgesys.parallaxwlistview.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    private ListView listView;
    private View heroImageView;
    private int MAX_ITEMS = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        heroImageView = findViewById(R.id.heroImageView);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listHeader = inflater.inflate(R.layout.list_header, null);

        /* Add list view header */
        listView.addHeaderView(listHeader);

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                //No action!
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                /* Check if the first item is already reached to top.*/
                if (listView.getFirstVisiblePosition() == 0) {
                    View firstChild = listView.getChildAt(0);
                    int topY = 0;
                    if (firstChild != null) {
                        topY = firstChild.getTop();
                    }
                    heroImageView.setY(topY * 0.5f);
                }
            }
        });

        /* Populate the ListView */
        ArrayList<Item> Itemslist = new ArrayList<>();
        Item item;
        for (int i = 0; i < MAX_ITEMS; i++) {
            item = new Item("Android Item " + i, "With a team of two Android developers, the company has relied on fast tools like Android Studio to build rich new features, which have helped make Robinhood the highest-rated stock brokerage app on Google Play. ");
            Itemslist.add(item);
        }
        ListAdapter adapter = new ListAdapter(this, Itemslist);
        listView.setAdapter(adapter);
    }
}