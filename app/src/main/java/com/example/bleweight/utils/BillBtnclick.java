package com.example.bleweight.utils;

import android.graphics.Color;
import android.widget.Button;

import com.example.bleweight.R;


public class BillBtnclick {
    Button btnMobile;
    Button btnCash;
    Button btnShezhang;
   

    public BillBtnclick(Button btnMobile,
                        Button btnCash,
                        Button btnShezhang) {
        this.btnMobile = btnMobile;
        this.btnCash = btnCash;
        this.btnShezhang = btnShezhang;

    }

    public void clickbtnMobile() {
        btnMobile.setBackgroundResource(R.drawable.ripple_bg_bill_style);
        btnMobile.setTextColor(Color.parseColor("#FF00796B"));

        btnCash.setBackgroundResource(R.drawable.ripple_bg_bill_style_unselect);
        btnCash.setTextColor(Color.parseColor("#8A000000"));

        btnShezhang.setBackgroundResource(R.drawable.ripple_bg_bill_style_unselect);
        btnShezhang.setTextColor(Color.parseColor("#8A000000"));



    }


    public void clickbtnCash() {
        btnMobile.setBackgroundResource(R.drawable.ripple_bg_bill_style_unselect);
        btnMobile.setTextColor(Color.parseColor("#8A000000"));

        btnCash.setBackgroundResource(R.drawable.ripple_bg_bill_style);
        btnCash.setTextColor(Color.parseColor("#FF00796B"));

        btnShezhang.setBackgroundResource(R.drawable.ripple_bg_bill_style_unselect);
        btnShezhang.setTextColor(Color.parseColor("#8A000000"));

    }

    public void clickShezhang() {
        btnMobile.setBackgroundResource(R.drawable.ripple_bg_bill_style_unselect);
        btnMobile.setTextColor(Color.parseColor("#8A000000"));

        btnCash.setBackgroundResource(R.drawable.ripple_bg_bill_style_unselect);
        btnCash.setTextColor(Color.parseColor("#8A000000"));

        btnShezhang.setBackgroundResource(R.drawable.ripple_bg_bill_style);
        btnShezhang.setTextColor(Color.parseColor("#FF00796B"));

    }



}
