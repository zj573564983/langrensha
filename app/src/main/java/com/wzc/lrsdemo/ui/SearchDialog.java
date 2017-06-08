package com.wzc.lrsdemo.ui;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.wzc.lrsdemo.R;

import static com.wzc.lrsdemo.base.App.showToast;

public class SearchDialog extends Dialog implements View.OnClickListener {
    private Context context;
    private int theme;
    public SearchDialog(Context context,int theme){
        super(context,theme);
        this.context=context;
        this.theme=theme;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home_searchdialog);

        ImageView confirmView =(ImageView)findViewById(R.id.confirm);
        confirmView.setOnClickListener(this);
        ImageView disView =(ImageView)findViewById(R.id.dissmiss);
        disView.setOnClickListener(this);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.dissmiss:
                this.dismiss();
                break;
            case R.id.confirm:
                showToast("search a house");
                break;
        }
    }
}
