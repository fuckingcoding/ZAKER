package mdzz.com.first_of_mdzz.ui.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


import mdzz.com.first_of_mdzz.ui.fragment.FunFragment;
import mdzz.com.first_of_mdzz.widget.NoScrollViewPager;
import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.adapter.Mainadapter;
import mdzz.com.first_of_mdzz.ui.fragment.HomeFragment;
import mdzz.com.first_of_mdzz.ui.fragment.MyFragment;
import mdzz.com.first_of_mdzz.ui.fragment.NewsFragment;
import mdzz.com.first_of_mdzz.utils.ToastHelper;

public class MainActivity extends AppCompatActivity implements MainContract.IMainView, ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener
        , View.OnClickListener {
    private int INTERVAL_OF_TWO_CLICK_TO_QUIT = 1000;

    private Context mContext = this;
    //SlidingPaneLayout布局
    private SlidingPaneLayout slidingPaneLayout_main;
    //覆盖及被覆盖层
    private LinearLayout layout_covered;
    private LinearLayout layout_slider;
    //自定义viewpager
    private NoScrollViewPager mViewPager;
    //底部导航
    private RadioGroup mRadioGroup;
    //未选中图片资源
    private int[] unselectedIconIds = {R.mipmap.ic_tab_news_gray,
            R.mipmap.ic_tab_home_gray, R.mipmap.ic_tab_fun_gray,
            R.mipmap.ic_tab_my_gray};
    //选中图片资源
    private int[] selectedIconIds = {R.mipmap.ic_tab_news_red,
            R.mipmap.ic_tab_home_red, R.mipmap.ic_tab_fun_red,
            R.mipmap.ic_tab_my_red};

    private List<Fragment> fragmentList = new ArrayList<>();

    //初始化适配器
    private Mainadapter mainadapter;

    private LinearLayout linearLayout_covered_centre, linearLayout_covered_share, linearLayout_covered_login, linearLayout_covered_back;

    private long mLastPressBackTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment();
        initView();
        selectPage(0);
        initSlidinglayout();

    }

    //初始化SlidingPanelayout
    private void initSlidinglayout() {
        slidingPaneLayout_main = (SlidingPaneLayout) findViewById(R.id.slidingpanelayout_main);
        //被覆盖层初始化
        layout_covered = (LinearLayout) findViewById(R.id.layout_covered);

        //滑动层初始化
        layout_slider = (LinearLayout) findViewById(R.id.layout_slider);
        linearLayout_covered_centre = (LinearLayout) findViewById(R.id.linearLayout_covered_centre);
        linearLayout_covered_share = (LinearLayout) findViewById(R.id.linearLayout_covered_share);
        linearLayout_covered_login = (LinearLayout) findViewById(R.id.linearLayout_covered_login);
        linearLayout_covered_back = (LinearLayout) findViewById(R.id.linearLayout_covered_back);
        //滑动层按钮的点击事件
        linearLayout_covered_centre.setOnClickListener(this);
        linearLayout_covered_share.setOnClickListener(this);
        linearLayout_covered_login.setOnClickListener(this);
        linearLayout_covered_back.setOnClickListener(this);

        //设置covered层的显示宽度，该宽度决定了Slider层的剩余的宽度
        ViewGroup.LayoutParams params = layout_covered.getLayoutParams();
        params.width = getResources().getDisplayMetrics().widthPixels * 2 / 3;
        layout_covered.setLayoutParams(params);
        //设置滑动层的渐隐颜色
        slidingPaneLayout_main.setSliderFadeColor(Color.parseColor("#22000000"));
        //实现slider与Covered两个层的缩放效果
        slidingPaneLayout_main.setPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                //slider层上头像随着滑动隐藏不见
                //  imageView_slider_face.setAlpha(1 - slideOffset);
                //实现slider层的缩小效果（xy轴心点、xy方向的缩放比例）
                ViewCompat.setScaleX(layout_slider, 1 - slideOffset * 0.1f);
                ViewCompat.setScaleY(layout_slider, 1 - slideOffset * 0.1f);
                //实现covered层的放大效果（xy轴心点、xy方向的缩放比例）
                ViewCompat.setPivotX(layout_covered, 0);
                ViewCompat.setScaleX(layout_covered, slideOffset);
                ViewCompat.setScaleY(layout_covered, slideOffset);
            }

            @Override
            public void onPanelOpened(View panel) {
            }

            @Override
            public void onPanelClosed(View panel) {
            }
        });
    }

    //初始化radiobutton，viewpager
    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        mViewPager = (NoScrollViewPager) findViewById(R.id.viewPager_main);
        mRadioGroup.setOnCheckedChangeListener(this);
        mViewPager.setOnPageChangeListener(this);
    }

    //初始化fragment
    private void initFragment() {
        NewsFragment newsFragment = new NewsFragment();
        HomeFragment homeFragmen = new HomeFragment();
        FunFragment funFragment = new FunFragment();
        MyFragment myFragment = new MyFragment();

        fragmentList.add(newsFragment);
        fragmentList.add(homeFragmen);
        fragmentList.add(funFragment);
        fragmentList.add(myFragment);

        mainadapter = new Mainadapter(getSupportFragmentManager(), fragmentList);
        mViewPager = (NoScrollViewPager) findViewById(R.id.viewPager_main);
        mViewPager.setAdapter(mainadapter);

    }

    //选中对应radiobutton时的颜色及图片变化
    private void selectPage(int position) {
        for (int i = 0; i < mRadioGroup.getChildCount(); i++) {
            Drawable gray = getResources().getDrawable(unselectedIconIds[i]);

            gray.setBounds(0, 0, gray.getMinimumWidth(),
                    gray.getMinimumHeight());
            RadioButton child = (RadioButton) mRadioGroup.getChildAt(i);
            child.setCompoundDrawables(null, gray, null, null);
            child.setTextColor(getResources().getColor(
                    R.color.dark_gray));
        }
        mViewPager.setCurrentItem(position, false);
        Drawable yellow = getResources().getDrawable(selectedIconIds[position]);
        yellow.setBounds(0, 0, yellow.getMinimumWidth(),
                yellow.getMinimumHeight());
        RadioButton select = (RadioButton) mRadioGroup.getChildAt(position);
        select.setCompoundDrawables(null, yellow, null, null);
        select.setTextColor(getResources().getColor(
                R.color.yellow));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        selectPage(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    //radiobutton选中对应的viewpager页
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.btn_home:
                selectPage(0);
                break;
            case R.id.btn_classify:
                selectPage(1);
                break;
            case R.id.btn_discover: //
                selectPage(2);
                break;
            case R.id.btn_me: //
                selectPage(3);
                break;
        }

    }

    //滑动层（被覆盖层）的点击事件
    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.linearLayout_covered_centre:
                Toast.makeText(mContext, "点击了个人中心", Toast.LENGTH_SHORT).show();
                break;
            case R.id.linearLayout_covered_share:
                Toast.makeText(mContext, "点击了分享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.linearLayout_covered_login:
                Toast.makeText(mContext, "点击了登录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.linearLayout_covered_back:
                Toast.makeText(mContext, "点击了个人退出", Toast.LENGTH_SHORT).show();
                break;
            default:
        }

    }


    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - mLastPressBackTime < INTERVAL_OF_TWO_CLICK_TO_QUIT) {

            finish();
        } else {
            ToastHelper.showToast(this, "再次按下返回键将退出应用!", Toast.LENGTH_SHORT);

            //Toast.makeText(this, "再次按下返回键将退出应用！", Toast.LENGTH_SHORT).show();
            mLastPressBackTime = System.currentTimeMillis();
        }
    }

}
