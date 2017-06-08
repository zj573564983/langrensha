package com.wzc.lrsdemo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wzc.lrsdemo.R;

import static com.wzc.lrsdemo.base.App.showToast;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{

    public void onClick(View v){
        switch (v.getId()){
            case R.id.home_setting_black:
                black();
                break;
            case R.id.home_setting_update:
                showToast("暂无可用更新");
                break;
            case R.id.home_setting_about:
                about();
                break;
        }
    }

    public void black(){
        Intent i=new Intent(SettingActivity.this, BlackList.class);
        startActivity(i);
    }
    public void about(){
        Intent intent=new Intent(SettingActivity.this,AboutActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home_setting);

    }
}
