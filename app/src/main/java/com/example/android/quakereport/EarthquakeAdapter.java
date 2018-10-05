package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public static final String LOG_TAG = "EarthquakeAdapter";

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Earthquake currentEarthquake = getItem(position);

        TextView magTextView = listItemView.findViewById(R.id.mag);
        magTextView.setText(formatMagnitude(currentEarthquake.getMag()));

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magCircle = (GradientDrawable) magTextView.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
        int magColor = getMagColor(currentEarthquake.getMag());
        // Set the color on the magnitude circle
        magCircle.setColor(magColor);

        TextView positionTextView = listItemView.findViewById(R.id.location);
        positionTextView.setText(formatLocation(currentEarthquake.getCity())[0]);

        TextView cityTextView = listItemView.findViewById(R.id.city);
        cityTextView.setText(formatLocation(currentEarthquake.getCity())[1]);

        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        TextView dateTextView = listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        dateTextView.setText(formattedDate);

        TextView timeTextView = listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeTextView.setText(formattedTime);

        return listItemView;
    }

    private int getMagColor(double magnitude){
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String[] formatLocation(String location) {
        String[] strings;
        if (location.contains(LOCATION_SEPARATOR)) {
            strings = location.split(LOCATION_SEPARATOR);
            strings[0] = strings[0] + LOCATION_SEPARATOR;
        } else {
            strings = new String[]{getContext().getString(R.string.near_the), location};
        }
        return strings;
    }

    private String formatMagnitude(double mag) {
        DecimalFormat inputFormat = new DecimalFormat("0.0");
        return inputFormat.format(mag);
    }
}
