package mdzz.com.first_of_mdzz.ui.web;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.config.Constant;
import mdzz.com.first_of_mdzz.utils.ToastHelper;


public class WebActivity extends AppCompatActivity {
    private WebView webView;
    private String webstring; // 用来接收weburl的字符串
    private String title;
    private long backStartTime ,backEndTime;

   // private NewsInfoManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Intent intent = getIntent();
        webstring= intent.getStringExtra(Constant.WEB_URL);
        title =intent.getStringExtra(Constant.WEB_TITLE);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(title!=null){
            ToastHelper.showToast(this,title);
            actionBar.setTitle(title);
            toolbar.setTitleTextColor(Color.BLACK);
        }





        actionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                backEndTime = System.currentTimeMillis();
                if (backEndTime - backStartTime > 2000) {
                    //Toast.makeText(SaveActivity.this, "滚动", Toast.LENGTH_SHORT).show();
                    backStartTime = backEndTime;
                }else{
                   webView.scrollTo(0,0);
                }
            }
        });

        initView();
        initWeb();





//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private void initWeb() {

        webView.loadUrl(webstring);
    }


    private void initView() {

        webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                Log.e("TAG", "shouldOverrideUrlLoading: "+url);
                return true;
            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case android.R.id.home :
                finish();
                webView.scrollTo(0,0);
                break;
            case R.id.save:

                //long savecode = ((App) getApplication()).liteOrm.insert(myNewsBean);
//
//                if(savecode>0){
//                    Toast.makeText(this,"收藏成功",Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(this,"已经收藏过了~",Toast.LENGTH_SHORT).show();
//                }
//                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_web,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
       if (keyCode== KeyEvent.KEYCODE_BACK){
           if(webView.canGoBack()){
               webView.goBack();
                return true;
           }
       }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        webView.stopLoading();
        ((ViewGroup)webView.getParent()).removeView(webView);
        webView.removeAllViews();
        webView.clearCache(true);
        webView.clearHistory();
        webView.destroy();
        super.onDestroy();
    }


}
