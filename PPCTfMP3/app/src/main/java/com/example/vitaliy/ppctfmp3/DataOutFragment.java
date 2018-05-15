package com.example.vitaliy.ppctfmp3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DataOutFragment extends Fragment {
    private TextView textView;

    final static String textViewKey = "TEXTVIEW_OUT_TEXT";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data_out, container, false);

        textView = view.findViewById(R.id.textViewOut);

        if (savedInstanceState != null) {
            String savedText = savedInstanceState.getString(textViewKey);
            textView.setText(savedText);
        }

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(textViewKey, textView.getText().toString());

        super.onSaveInstanceState(outState);
    }

    public void setMessage(String message) {
        textView.setText(message);
    }

}
