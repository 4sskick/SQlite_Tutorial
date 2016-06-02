package com.nightroomcreation.sqlite;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Administrator on 02-Jun-16.
 */
public class DetailAdapter extends ArrayAdapter<String> {

    //resource gonna belayout for listItems
    public DetailAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    public DetailAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
