package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Earthquake currentEarthquake = getItem(position);

        TextView magTextView = (TextView) listItemView.findViewById(R.id.mag);
        magTextView.setText(currentEarthquake.getMag());

        TextView cityTextViw = (TextView) listItemView.findViewById(R.id.city);
        cityTextViw.setText(currentEarthquake.getCity());

        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        TextView dateTextView = (TextView)listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        dateTextView.setText(formattedDate);

        TextView timeTextView = (TextView)listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        dateTextView.setText(formattedTime);

        return listItemView;
    }

    private String formatDate(Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
