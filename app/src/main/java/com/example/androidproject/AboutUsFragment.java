package com.example.androidproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class AboutUsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.aboutus_fragment, container, false);

        return root;
    }
}
