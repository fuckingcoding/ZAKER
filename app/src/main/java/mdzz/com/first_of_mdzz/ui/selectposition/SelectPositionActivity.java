package mdzz.com.first_of_mdzz.ui.selectposition;

import android.content.Context;
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

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.adapter.RecyclerIndexAdapter;
import mdzz.com.first_of_mdzz.bean.ItemBean;
import mdzz.com.first_of_mdzz.utils.ChineseToPinyinHelper;
import mdzz.com.first_of_mdzz.utils.DividerItemDecoration;
import mdzz.com.first_of_mdzz.widget.LetterIndexerView;

public class SelectPositionActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Context mContext = this;
    private TextView textView_dialog;
    private RecyclerView recyclerView_main;
    private LetterIndexerView letterIndexerView_main;
    private RecyclerIndexAdapter mAdapter = null;
    private List<ItemBean> mTotalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_position);

        //initData();

        //sortData();

        initView();
    }

//    private void initData() {
//        String[] arrUsernames = getResources().getStringArray(R.array.arrUsernames);
//        String[] arrIconUrls = getResources().getStringArray(R.array.arrIconUrl);
//
//        for (int i = 0; i < arrIconUrls.length; i++) {
//
//            ItemBean itemBean = new ItemBean();
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

//    private void sortData() {
//        Collections.sort(mTotalList, new Comparator<ItemBean>() {
//            @Override
//            public int compare(ItemBean lhs, ItemBean rhs) {
//                return lhs.getPinyin().toLowerCase().compareTo(rhs.getPinyin().toLowerCase());
//            }
//        });
//    }


    private void initView() {
        textView_dialog = (TextView) findViewById(R.id.textView_dialog);
        recyclerView_main = (RecyclerView) findViewById(R.id.recyclerView_main);
        letterIndexerView_main = (LetterIndexerView) findViewById(R.id.letterIndexerView_main);

        recyclerView_main.setHasFixedSize(true);
        recyclerView_main.setItemAnimator(new DefaultItemAnimator());
        recyclerView_main.addItemDecoration(new DividerItemDecoration(mContext,
                DividerItemDecoration.VERTICAL_LIST));

        mAdapter = new RecyclerIndexAdapter(mContext, mTotalList);
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
}
