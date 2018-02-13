package com.example.android.quakereport;

import android.content.Context;
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


    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitudeTextView.setText(formatMagnitude(currentEarthquake.getmMagnitude()));

        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
        locationTextView.setText(formatLocation(currentEarthquake.getmLocation()));

        TextView locationOffsetTextView = (TextView) listItemView.findViewById(R.id.locationOffset);
        locationOffsetTextView.setText(formatLocationOffset(currentEarthquake.getmLocation()));

        Date dateTime = new Date(currentEarthquake.getmDate());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        dateTextView.setText(formatDate(dateTime));

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
        timeTextView.setText(formatTime(dateTime));

        return listItemView;

    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String date = dateFormatter.format(dateObject);
        return date;
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("hh" + ":" + "mm a");
        String time = dateFormatter.format(dateObject);
        return time;
    }

    private String formatLocation(String location) {

        int index = location.indexOf(" of ");
        String formatedLocation = location.substring(index + 4);
        return formatedLocation;

    }

    private String formatLocationOffset(String location) {

        String formatedLocationOffset;
        if (location.contains(" of ")) {
            int index = location.indexOf(" of ");
            formatedLocationOffset = location.substring(0, index + 3);
            return formatedLocationOffset;
        } else {
            formatedLocationOffset = getContext().getString(R.string.Near_off);
            return formatedLocationOffset;
        }

    }

    private String formatMagnitude(double decimal) {
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(decimal);
        return output;
    }

}
