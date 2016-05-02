package com.lighthouse.awfulandroid.ui.activities.instructions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lighthouse.awfulandroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InstructionPageFragment extends Fragment {

    public static final String ARG_PAGE_NUMBER = "PAGE_NUMBER";
    public static final String ARG_PAGE_TEXT = "PAGE_TEXT";
    public static final String ARG_PAGE_BACKGROUND_COLOR = "BACKGROUND_COLOR";

    private int pageNumber;
    private String pageText;
    private int backgroundColor;

    @Bind(R.id.instruction_page_text)
    TextView instructionPage;
    @Bind(R.id.instruction_page_content)
    RelativeLayout instructionPageContainer;

    public static InstructionPageFragment create(int pageNumber, String text, int color) {
        InstructionPageFragment page = new InstructionPageFragment();
        Bundle args = new Bundle();
        args.putInt("PAGE_NUMBER", pageNumber);
        args.putString("PAGE_TEXT", text);
        args.putInt("BACKGROUND_COLOR", color);
        page.setArguments(args);

        return page;
    }

    public InstructionPageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.pageNumber = getArguments().getInt(ARG_PAGE_NUMBER);
        this.pageText = getArguments().getString(ARG_PAGE_TEXT);
        this.backgroundColor = getArguments().getInt(ARG_PAGE_BACKGROUND_COLOR);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_instruction_page, container, false);
        ButterKnife.bind(this, view);

        instructionPage.setText(pageText);
        instructionPageContainer.setBackgroundColor(backgroundColor);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
