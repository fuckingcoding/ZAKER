package mdzz.com.first_of_mdzz.ui.selectposition;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.adapter.RecyclerIndexAdapter;
import mdzz.com.first_of_mdzz.bean.SelectBean;
import mdzz.com.first_of_mdzz.bean.position.CitiesBean;
import mdzz.com.first_of_mdzz.bean.position.HotCitiesBean;
import mdzz.com.first_of_mdzz.bean.position.LbsCityBean;
import mdzz.com.first_of_mdzz.bean.position.PositionBean;
import mdzz.com.first_of_mdzz.config.Constant;
import mdzz.com.first_of_mdzz.http.HttpUtils;
import mdzz.com.first_of_mdzz.utils.ChineseToPinyinHelper;
import mdzz.com.first_of_mdzz.utils.DividerItemDecoration;
import mdzz.com.first_of_mdzz.utils.ToastHelper;
import mdzz.com.first_of_mdzz.widget.LetterIndexerView;

public class SelectCityActivity extends AppCompatActivity  implements SelectContract.ISelectView,RecyclerIndexAdapter.IndexOnClickListener {

    private static final String TAG = "MainActivity";
    private Context mContext = this;

    private TextView textView_dialog;
    private RecyclerView recyclerView_main;
    private LetterIndexerView letterIndexerView_main;
    private RecyclerIndexAdapter mAdapter = null;
    private List<SelectBean> mTotalList = new ArrayList<>();
    private String city ="北京" ;
    private List<CitiesBean> list_cities;
    private List<HotCitiesBean> list_hotcities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_position);

        initData();

       // initBar();

        initView();
    }

    private void initBar() {
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("选择你所在的城市");

    }

    private void initData() {
        Map<String, String> map = HttpUtils.getPositionMap(city);
        SelectPresenter presenter = new SelectPresenter(this);
        presenter.getPositionBean(map);


    }

//    private void initData() {
//        String[] arrUsernames = getResources().getStringArray(R.array.arrUsernames);
//        String[] arrIconUrls = getResources().getStringArray(R.array.arrIconUrl);
//
//        for (int i = 0; i < arrIconUrls.length; i++) {
//
//            SelectBean itemBean = new SelectBean();
//            itemBean.setUsername(arrUsernames[i]);
//            itemBean.setIconUrl(arrIconUrls[i]);
//
//            //获取姓名的拼音和首字母
//            String pinyin = ChineseToPinyinHelper.getInstance().getPinyin(arrUsernames[i]);
//            itemBean.setPinyin(pinyin);
//            String firstLetter = pinyin.substring(0, 1).toUpperCase();
//
//            if (firstLetter.matches("[A-Z]")) {
//                itemBean.setFirstLetter(firstLetter);
//            } else {
//                itemBean.setFirstLetter("#");
//            }
//            mTotalList.add(itemBean);
//        }
//    }

    private void sortData() {
        Collections.sort(mTotalList, new Comparator<SelectBean>() {
            @Override
            public int compare(SelectBean lhs, SelectBean rhs) {
                return lhs.getPinyin().toLowerCase().compareTo(rhs.getPinyin().toLowerCase());
            }
        });
    }


    private void initView() {
        textView_dialog = (TextView) findViewById(R.id.textView_dialog);
        recyclerView_main = (RecyclerView) findViewById(R.id.recycler_position2);
        letterIndexerView_main = (LetterIndexerView) findViewById(R.id.letterIndexerView_main);

        recyclerView_main.setHasFixedSize(true);
        recyclerView_main.setItemAnimator(new DefaultItemAnimator());
        recyclerView_main.addItemDecoration(new DividerItemDecoration(mContext,
                DividerItemDecoration.VERTICAL_LIST));

        mAdapter = new RecyclerIndexAdapter(mContext, mTotalList,this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        recyclerView_main.setLayoutManager(layoutManager);
        recyclerView_main.setAdapter(mAdapter);

        letterIndexerView_main.setOnLetterClickedListener(textView_dialog, new LetterIndexerView
                .OnLetterClickedListener() {
            @Override
            public void onClick(String letter) {
                //让RecyclerView滚动到指定position
                int position = mAdapter.getPositionForSection(letter.charAt(0));
                Log.i(TAG, "----->>>>onClick: " + position);
                if (position >= 0) {
                    //recyclerView_main.scrollToPosition(position);

                    //layoutManager.scrollToPositionWithOffset(position , 0);

                    layoutManager.scrollToPosition(position);
                    //layoutManager.scrollToPositionWithOffset(position , 0);
                }
            }
        });
    }


    @Override
    public void getPosotionBean(PositionBean bean) {

        list_cities =bean.getData().getCities();
        list_hotcities = bean.getData().getHot_cities();
        LbsCityBean lbs_city = bean.getData().getLbs_city();
        transforBean();
        sortData();
        mAdapter.notifyDataSetChanged();
    }


    private void transforBean() {
        for(int i =0;i<list_hotcities.size();i++){
            SelectBean selectBean = new SelectBean();
            String city_name = list_hotcities.get(i).getCity_name();
           //String pinyin = ChineseToPinyinHelper.getInstance().getPinyin(city_name);

            //String firstLetter = pinyin.substring(0, 1).toUpperCase();

            selectBean.setPinyin("a");
            selectBean.setUsername(city_name);
            selectBean.setFirstLetter("热门城市");
            mTotalList.add(selectBean);
        }
        for(int i =0;i<list_cities.size();i++){
            SelectBean selectBean = new SelectBean();
            String city_name = list_cities.get(i).getCity_name();
            String pinyin = ChineseToPinyinHelper.getInstance().getPinyin(city_name);

            String firstLetter = pinyin.substring(0, 1).toUpperCase();
            selectBean.setFirstLetter(firstLetter);
            selectBean.setPinyin(pinyin);
            selectBean.setUsername(city_name);
            mTotalList.add(selectBean);
        }

        ToastHelper.showToast(this,mTotalList.size()+"");
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    //item 点击事件
    @Override
    public void OnClick(int position) {
        SelectBean bean = mTotalList.get(position);
        String cityname = bean.getUsername();
        Intent intent = new Intent();
        intent.putExtra(Constant.KEY_CITY,cityname);
        setResult(Constant.RESULT_POSITION,intent);
        finish();

    }
}
