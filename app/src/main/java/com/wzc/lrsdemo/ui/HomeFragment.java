package com.wzc.lrsdemo.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wzc.lrsdemo.R;
import com.wzc.lrsdemo.agora.openacall.model.ConstantApp;
import com.wzc.lrsdemo.base.App;
import com.wzc.lrsdemo.base.BaseFragment;
import com.wzc.lrsdemo.utils.GlideUtil;

/**
 * Created by Administrator on 2017/3/7.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private AppCompatActivity activity;
    private View root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = (AppCompatActivity) getActivity();
        root = inflater.inflate(R.layout.fragment_home, container, false);
        init();
        return root;
    }

    private void init() {
        Toolbar toolbar = (Toolbar) root.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.fragment_home);

        toolbar.findViewById(R.id.menu_home_setting).setOnClickListener(this);

        ImageView head_iv = (ImageView) root.findViewById(R.id.home_head_iv);
        GlideUtil.into(activity, R.mipmap.my_head, head_iv, GlideUtil.CIRCLE);

        root.findViewById(R.id.home_easy_iv).setOnClickListener(this);

        root.findViewById(R.id.home_help_iv).setOnClickListener(this);
        root.findViewById(R.id.fragment_home_recharge).setOnClickListener(this);
        root.findViewById(R.id.fragement_home_user).setOnClickListener(this);
        root.findViewById(R.id.home_create_iv).setOnClickListener(this);
        root.findViewById(R.id.home_search_iv).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_easy_iv:
                easy();
                break;
            case R.id.menu_home_setting:
                setting();
                break;
            case R.id.home_help_iv:
                showHelp();
                break;
            case R.id.fragment_home_recharge:
                recharge();
                break;
            case R.id.fragement_home_user:
                user();
                break;
            case R.id.home_create_iv:
                createHouse();
                break;
            case R.id.home_search_iv:
                searchHouse();
                break;
        }
    }

    public void easy() {
        //加入房间之前的参数
        String channel = "wzc25151";
        App.mAudioSettings.mChannelName = channel;
        Intent i = new Intent(activity, GameActivity.class);
        i.putExtra(ConstantApp.ACTION_KEY_CHANNEL_NAME, channel);
        startActivity(i);


//        startActivity(new Intent(activity, GameActivity.class));
    }
    public void setting(){
        Intent i = new Intent(activity, SettingActivity.class);
        startActivity(i);
    }
    public void recharge(){
        Intent i = new Intent(activity, RechargeActivity.class);
        startActivity(i);
    }
    public void user()
    {
        Intent i = new Intent(activity,UserActivity.class);
        startActivity(i);
    }
    public void showHelp(){
        Dialog dialog=new HelpDialog(activity,R.style.Theme_AppCompat_DayNight_Dialog);
        dialog.show();
    }
    public void createHouse(){
        Dialog dialog=new CreateDialog(activity,R.style.MyDialogStyle);
        dialog.show();
    }
    public void searchHouse()
    {
        Dialog dialog=new SearchDialog(activity,R.style.Theme_AppCompat_DayNight_Dialog);
        dialog.show();
    }
}
