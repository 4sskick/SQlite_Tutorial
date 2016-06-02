package com.nightroomcreation.sqlite;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 02-Jun-16.
 */
public class DetailAdapter extends ArrayAdapter<Person> {

    Context context;
    int resource;
    List<Person> textString;

    //resource gonna belayout for listItems
    public DetailAdapter(Context context, int resource, List<Person> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.textString = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View root = convertView;

        if (root == null) {
            LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
            root = layoutInflater.inflate(resource, parent, false);

            TextView textName = (TextView) root.findViewById(R.id.txt_item_name);
            TextView textAddress = (TextView) root.findViewById(R.id.txt_item_address);

            textName.setText(textString.get(position).getName());
            textAddress.setText(textString.get(position).getAddress());
        }

        return root;
    }
}
