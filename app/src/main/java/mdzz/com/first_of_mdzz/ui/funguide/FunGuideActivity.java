package mdzz.com.first_of_mdzz.ui.funguide;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.config.Constant;
import mdzz.com.first_of_mdzz.database.PreUtils;
import mdzz.com.first_of_mdzz.ui.selectposition.SelectCityActivity;
import mdzz.com.first_of_mdzz.utils.ToastHelper;

public class FunGuideActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv_city;
   private LinearLayout lin_fun1,lin_fun2,lin_fun3,lin_fun4,lin_fun5,lin_fun6;
     private Toolbar toolbar;
    private Context mContext = this;
    private String citystring="北京";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_guide);

        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_funguide);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("分类");
        toolbar.setTitleTextColor(Color.WHITE);
        actionBar.setDisplayHomeAsUpEnabled(true);

        tv_city = (TextView) findViewById(R.id.tv_fun_guide);
        lin_fun1 = (LinearLayout) findViewById(R.id.linear_fun1);
        lin_fun2 = (LinearLayout) findViewById(R.id.linear_fun2);
        lin_fun3 = (LinearLayout) findViewById(R.id.linear_fun3);
        lin_fun4 = (LinearLayout) findViewById(R.id.linear_fun4);
        lin_fun5 = (LinearLayout) findViewById(R.id.linear_fun5);
        lin_fun6 = (LinearLayout) findViewById(R.id.linear_fun6);
        tv_city.setOnClickListener(this);
        lin_fun1.setOnClickListener(this);
        lin_fun2.setOnClickListener(this);
        lin_fun3.setOnClickListener(this);
        lin_fun4.setOnClickListener(this);
        lin_fun5.setOnClickListener(this);
        lin_fun6.setOnClickListener(this);

        citystring = PreUtils.readStrting(mContext,Constant.PRE_KEY);
        if(!TextUtils.isEmpty(citystring)){
            tv_city.setText("定位："+citystring);
        }

    }

    //actionbar home键监听
    @Override
    public boolean onSupportNavigateUp() {

        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent();
        switch (view.getId()){

            case R.id.tv_fun_guide:

                intent.setClass(this, SelectCityActivity.class);
                startActivityForResult(intent, Constant.REQUEST_FUNGUIDE);
                break;
            case R.id.linear_fun1:
                //intent.putExtra(Constant.KEY_FUN_URL,);
                intent.putExtra(Constant.KEY_FUN_CITY,citystring);
                intent.putExtra(Constant.KEY_FUN_URLINT,0);
                setResult(Constant.RESULT_FUNGUIDE,intent);
                finish();
                break;
            case R.id.linear_fun2 :
                intent.putExtra(Constant.KEY_FUN_CITY,citystring);
                intent.putExtra(Constant.KEY_FUN_URLINT,1);
                setResult(Constant.RESULT_FUNGUIDE,intent);
                finish();
                break;
            case R.id.linear_fun3:
                intent.putExtra(Constant.KEY_FUN_CITY,citystring);
                intent.putExtra(Constant.KEY_FUN_URLINT,4);
                setResult(Constant.RESULT_FUNGUIDE,intent);
                finish();

                break;
            case R.id.linear_fun4 :
                intent.putExtra(Constant.KEY_FUN_CITY,citystring);
                intent.putExtra(Constant.KEY_FUN_URLINT,10);
                setResult(Constant.RESULT_FUNGUIDE,intent);

                finish();
                break;
            case R.id.linear_fun5:
                intent.putExtra(Constant.KEY_FUN_CITY,citystring);
                intent.putExtra(Constant.KEY_FUN_URLINT,9);
                setResult(Constant.RESULT_FUNGUIDE,intent);
                finish();
                break;
            case R.id.linear_fun6 :
                intent.putExtra(Constant.KEY_FUN_CITY,citystring);
                intent.putExtra(Constant.KEY_FUN_URLINT,3);
                setResult(Constant.RESULT_FUNGUIDE,intent);
                finish();
                break;

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==Constant.REQUEST_FUNGUIDE&resultCode==Constant.RESULT_POSITION){
             citystring = data.getStringExtra(Constant.KEY_CITY);
            PreUtils.writeString(mContext,Constant.PRE_KEY,citystring);
            tv_city.setText("定位："+citystring);
            ToastHelper.showToast(mContext,citystring);
        }
    }
}
