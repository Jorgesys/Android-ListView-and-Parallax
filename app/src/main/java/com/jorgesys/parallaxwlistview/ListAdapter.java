package com.jorgesys.parallaxwlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jorgesys on 05/04/2014.
 */

 public class ListAdapter extends BaseAdapter {

        private ArrayList<Item> items;
        private Context context;

        public ListAdapter(Context context, ArrayList<Item> items) {
            this.context = context;
            this.items = items;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // inflate the layout.
            if (convertView == null) {
                convertView = LayoutInflater.from(context).
                        inflate(R.layout.item_row, parent, false);
            }
            Item currentItem = (Item) getItem(position);

            TextView textViewItemName = (TextView)convertView.findViewById(R.id.title);
            TextView textViewItemDescription = (TextView)convertView.findViewById(R.id.description);
            textViewItemName.setText(currentItem.getName());
            textViewItemDescription.setText(currentItem.getDescription());

            return convertView;
        }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) { return items.get(position); }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
