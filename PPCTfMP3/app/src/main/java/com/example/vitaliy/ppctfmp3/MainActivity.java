package com.example.vitaliy.ppctfmp3;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements DataInFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(String str) {
        DataOutFragment fragment = (DataOutFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        if (fragment != null && fragment.isInLayout()) {
            fragment.setMessage(str);
        }

    }
}
