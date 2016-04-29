package com.lighthouse.awfulandroid.activities.interview_activities;


import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.lighthouse.awfulandroid.R;
import com.lighthouse.awfulandroid.http.ForecastListener;
import com.lighthouse.awfulandroid.http.ForecastService;
import com.lighthouse.awfulandroid.models.Forecast;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ActivityListFragment extends ListFragment {

    private final String[] activities = {"Lorem Ipsum", "Weather"};

    @Inject
    ForecastService forecastService;

    @Bind(R.id.activities_list)
    ListView activitiesList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity_list, container, false);
        ButterKnife.bind(this, view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, activities);
        activitiesList.setAdapter(adapter);
        activitiesList.setOnItemClickListener((parent, row, position, id) -> {
            if(position == 1) {
                forecastService.getForecastFor("22.2", "90.0", new ForecastListener() {
                    @Override
                    public void onForecastLoaded(Forecast forecast) {
                        Toast.makeText(getActivity(), forecast.getCurrently().getIcon() + "\r", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onForecastFailed(Exception e) {

                    }
                });
            }
        });
        if(view != null) {
            return view;
        }

        return null;
    }
}
