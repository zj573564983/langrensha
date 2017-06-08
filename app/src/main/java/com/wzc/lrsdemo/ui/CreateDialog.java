package com.wzc.lrsdemo.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.wzc.lrsdemo.R;
import com.wzc.lrsdemo.agora.openacall.model.ConstantApp;
import com.wzc.lrsdemo.base.App;

import static com.wzc.lrsdemo.base.App.showToast;

public class CreateDialog extends Dialog implements View.OnClickListener {
    private Context context;
    private int theme;
    private static final String[] mod={"简单模式","高级模式"};
    private static final String[] level={"无限制","仅限5级以上玩家"};
    public CreateDialog(Context context,int theme){
        super(context,theme);
        this.context=context;
        this.theme=theme;
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home_createdialog);

        Spinner modspinner=(Spinner) findViewById(R.id.spinnermod);
        ArrayAdapter adapter=new ArrayAdapter(this.context,android.R.layout.simple_spinner_item,mod);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modspinner.setAdapter(adapter);
        modspinner.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        modspinner.setVisibility(View.VISIBLE);

        Spinner levelspinner = (Spinner) findViewById(R.id.spinnerlevel);
        ArrayAdapter  leveladapter = new ArrayAdapter<>(this.context,android.R.layout.simple_spinner_item,level);
        leveladapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelspinner.setAdapter(leveladapter);
        levelspinner.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        levelspinner.setVisibility(View.VISIBLE);

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
                easy();
                showToast("Create a house");
                break;
        }
    }
    public void easy(){
        //加入房间之前的参数
        String channel = "开发小组";
        App.mAudioSettings.mChannelName = channel;
        Intent i = new Intent(this.context, GameActivity.class);
        i.putExtra(ConstantApp.ACTION_KEY_CHANNEL_NAME, channel);
        context.startActivity(i);


//        startActivity(new Intent(activity, GameActivity.class));
    }
}
