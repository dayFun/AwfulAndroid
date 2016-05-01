package com.lighthouse.awfulandroid.ui.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lighthouse.awfulandroid.AwfulAndroidApp;
import com.lighthouse.awfulandroid.R;
import com.lighthouse.awfulandroid.http.ForecastService;
import com.lighthouse.awfulandroid.ui.activities.ForecastActivity;
import com.lighthouse.awfulandroid.ui.activities.LoremIpsumActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class ActivityListFragment extends Fragment {

    private final String[] ACTIVITIES_LIST = {"Lorem Ipsum", "Weather"};

    @Inject
    ForecastService forecastService;

    @Bind(R.id.activities_list)
    ListView activitiesList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AwfulAndroidApp.get(getActivity()).getComponent().inject(this);

        View view = inflater.inflate(R.layout.fragment_activity_list, container, false);
        ButterKnife.bind(this, view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, ACTIVITIES_LIST);
        activitiesList.setAdapter(adapter);

        return view;
    }

    @OnItemClick(R.id.activities_list)
    public void onItemClick(int position) {
        if(position == 0) {
            LoremIpsumActivity.startActivity(getActivity());
        }

        if (position == 1) {
            ForecastActivity.startActivity(getActivity());
        }
    }
}
