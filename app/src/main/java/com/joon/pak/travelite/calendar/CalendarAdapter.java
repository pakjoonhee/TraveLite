package com.joon.pak.travelite.calendar;

/**
 * Created by joonheepak on 10/3/16.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joon.pak.travelite.R;
import com.joon.pak.travelite.data.TripData;

import java.util.ArrayList;


public class CalendarAdapter extends RecyclerView.Adapter<CalendarHolder> {
    ArrayList<TripData> tripData;
    Context context;

    public CalendarAdapter(Context context, ArrayList<TripData> tripData){

        this.tripData = tripData;
        this.context = context;
    }

    @Override
    public CalendarHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calendar_views, parent, false);
        return new CalendarHolder(view);
        //create a variable and then return that.

    }

    @Override
    public void onBindViewHolder(final CalendarHolder holder, final int position) {

        //use which one based on which createviewholder is chosen
        final TripData tripInfo = tripData.get(position);
        final String month = tripInfo.getMonthOfDay();
        final String day = tripInfo.getNumberDay();
        final String monthDay = month + day;
        holder.theMonth.setText(month);
        holder.theDay.setText(day);
        holder.theDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("monthday", monthDay);

                RightSideFragment fragment = new RightSideFragment();
                fragment.setArguments(bundle);

                ((FragmentActivity)context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment2, fragment)
                        .commit();
            }
        });
        holder.theMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("monthday", monthDay);

                RightSideFragment fragment = new RightSideFragment();
                fragment.setArguments(bundle);

                ((FragmentActivity)context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment2, fragment)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return tripData.size();
    }
}

