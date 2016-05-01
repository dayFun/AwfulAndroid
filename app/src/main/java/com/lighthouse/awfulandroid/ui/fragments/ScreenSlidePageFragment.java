package com.lighthouse.awfulandroid.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lighthouse.awfulandroid.R;

public class ScreenSlidePageFragment extends Fragment {

    public static final String ARG_PAGE_NUMBER = "page";

    private int pageNumber;

    private ScreenSlidePageFragment() {}

    public static Fragment create(int pageNumber) {
        ScreenSlidePageFragment pageFragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE_NUMBER, pageNumber);
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.pageNumber = getArguments().getInt(ARG_PAGE_NUMBER);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = ((ViewGroup) inflater.inflate(R.layout.fragment_lorem_ipsump_page, container, false));

        TextView pageTitle = (TextView) rootView.findViewById(R.id.page_title);
        pageTitle.setText(String.valueOf(pageNumber));

        TextView pageText = (TextView) rootView.findViewById(R.id.page_text);
        setPageText(pageText);

        return rootView;
    }

    private void setPageText(TextView pageText) {
        switch(pageNumber) {
            case 0:
                pageText.setText(getString(R.string.lorem_ipsum_text_1));
                return;
            case 1:
                pageText.setText(getString(R.string.lorem_ipsum_text_2));
                return;
            case 2:
                pageText.setText(getString(R.string.lorem_ipsum_text_3));
                return;
            case 3:
                pageText.setText(getString(R.string.lorem_ipsum_text_4));
                return;
            case 4:
                pageText.setText(getString(R.string.lorem_ipsum_text_5));
                return;
            default:
                return;
        }
    }
}