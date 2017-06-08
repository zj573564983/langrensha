package com.wzc.lrsdemo.ui;

import android.app.Dialog;
import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.wzc.lrsdemo.R;

import static com.wzc.lrsdemo.base.App.showToast;

public class HelpDialog extends Dialog implements View.OnClickListener {
    private Context context;
    private int theme;
    public HelpDialog(Context context,int theme){
        super(context,theme);
        this.context=context;
        this.theme=theme;
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.instruction:
                showToast("instructions");
                break;
            case R.id.dict:
                showToast("dictionary");
                break;
            case R.id.close:
                this.dismiss();
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home_helpdialog);

        ImageView closeView=(ImageView)findViewById(R.id.close);
        closeView.setOnClickListener(this);

        ImageView insView=(ImageView)findViewById(R.id.instruction);
        insView.setOnClickListener(this);

        ImageView dicView=(ImageView)findViewById(R.id.dict);
        dicView.setOnClickListener(this);
    }
}
