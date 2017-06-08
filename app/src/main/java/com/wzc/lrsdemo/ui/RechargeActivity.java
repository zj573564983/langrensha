package com.wzc.lrsdemo.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wzc.lrsdemo.R;

import static com.wzc.lrsdemo.base.App.showToast;

public class RechargeActivity extends AppCompatActivity implements View.OnClickListener {

    public  Button tvPay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home_recharge);
        init();
    }
    private void init()
    {
        tvPay=(Button)findViewById(R.id.tvPay);
        tvPay.setClickable(false);
        tvPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("pay");
            }
        });

//        views[0]=(View)findViewById(R.id.coinback1);
//        views[1]=(View)findViewById(R.id.coinback2);
//        views[2]=(View)findViewById(R.id.coinback3);
//        views[3]=(View)findViewById(R.id.coinback4);
//        views[4]=(View)findViewById(R.id.coinback5);
//        views[5]=(View)findViewById(R.id.coinback6);
//        for(int i=0;i<5;i++)
//        {
//            views[i].setOnClickListener(this);
//        }

    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.coinback1:
            case R.id.coinback2:
            case R.id.coinback3:
            case R.id.coinback4:
            case R.id.coinback5:
            case R.id.coinback6:
                tvPay.setBackgroundColor(Color.parseColor("#ffbe00"));
//                tvPay.setTextColor(Color.parseColor("2e2a3a"));
                tvPay.setClickable(true);
                break;
        }
    }
}
