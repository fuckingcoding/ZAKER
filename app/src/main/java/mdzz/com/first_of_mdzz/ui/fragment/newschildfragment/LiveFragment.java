package mdzz.com.first_of_mdzz.ui.fragment.newschildfragment;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.base.BaseFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class LiveFragment extends BaseFragment {

private WebView webView_liveFragment;
private String webstring="http://iphone.myzaker.com/zaker/live_list.php?need_user_info=Y";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_live, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        webView_liveFragment=(WebView)view.findViewById(R.id.webview_livefragment);
        initWeb();
    }

    private void initWeb() {
        webView_liveFragment.loadUrl(webstring);

        webView_liveFragment.getSettings().setJavaScriptEnabled(true);
        webView_liveFragment.getSettings().setSupportZoom(true);
        webView_liveFragment.getSettings().setBuiltInZoomControls(true);
        webView_liveFragment.getSettings().setUseWideViewPort(true);
        webView_liveFragment.setVerticalScrollBarEnabled(false);
        webView_liveFragment.setHorizontalScrollBarEnabled(false);
        webView_liveFragment.setWebViewClient(new WebViewClient(){

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
                 getActivity().finish();
                webView_liveFragment.scrollTo(0,0);
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.menu_web,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        webView_liveFragment.stopLoading();
        ((ViewGroup)webView_liveFragment.getParent()).removeView(webView_liveFragment);
        webView_liveFragment.removeAllViews();
        webView_liveFragment.clearCache(true);
        webView_liveFragment.clearHistory();
        webView_liveFragment.destroy();
        super.onDestroy();
    }
}

