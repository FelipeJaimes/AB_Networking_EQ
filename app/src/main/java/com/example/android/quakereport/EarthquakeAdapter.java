package com.example.android.quakereport;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;

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

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getmMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

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

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
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
        if (location.contains(" of ")) {
            String formatedLocation = location.substring(index + 4);
            return formatedLocation;
        } else {
            return location;
        }

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
