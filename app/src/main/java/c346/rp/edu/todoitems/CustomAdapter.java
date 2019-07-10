package c346.rp.edu.todoitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import c346.rp.edu.todoitems.R;
import c346.rp.edu.todoitems.listOfItem;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<listOfItem> itemList;

    public CustomAdapter(Context context, int resource,
                         ArrayList<listOfItem> objects){
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        itemList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvName = rowView.findViewById(R.id.textViewItem);
        TextView tvDate = rowView.findViewById(R.id.textViewDate);

        // Obtain the Android Version information based on the position
        listOfItem currentItem = itemList.get(position);

        // Set values to the TextView to display the corresponding information
        tvName.setText(currentItem.getItem());
        tvDate.setText(currentItem.getDateString());

        return rowView;
    }
}
