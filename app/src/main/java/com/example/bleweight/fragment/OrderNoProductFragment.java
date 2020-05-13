package com.example.bleweight.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bleweight.MainActivity;
import com.example.bleweight.R;
import com.example.bleweight.utils.MultiPage;
import com.example.bleweight.utils.OrderPage;
import com.google.android.material.tabs.TabLayout;

import static com.google.android.material.tabs.TabLayout.MODE_SCROLLABLE;


public class OrderNoProductFragment extends Fragment {

    TabLayout tab_layout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_order_no_product, container, false);
        initviews(v);

        return v;
    }



    public void initviews(View v) {
        tab_layout = v.findViewById(R.id.tab_layout_order);
        //tab
        for (String page : OrderPage.getPageNames()) {
            tab_layout.addTab(tab_layout.newTab().setText(page));
        }
        tab_layout.setTabMode(MODE_SCROLLABLE);
        tab_layout.addOnTabSelectedListener((MainActivity)getActivity());
    }


    }
