package com.example.bleweight.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.bleweight.MainActivity;
import com.example.bleweight.R;


public class BlankOrderFragment extends Fragment implements
        View.OnClickListener {
Button btn_new_order;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blank_order, container, false);
        initViews( v);
        return v;
    }

    private void initViews(View v) {
        btn_new_order =  v.findViewById(R.id.new_order_firstpage);
        btn_new_order.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.new_order_firstpage:
                ((MainActivity) getActivity()).showNoProduct();
                break;
        }
    }

}
