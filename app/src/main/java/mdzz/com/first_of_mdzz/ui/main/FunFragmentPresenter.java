package mdzz.com.first_of_mdzz.ui.main;

import android.util.Log;

import java.util.List;
import java.util.Map;

import mdzz.com.first_of_mdzz.bean.fun.ColumnsBean;
import mdzz.com.first_of_mdzz.bean.fun.PlayBean;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by acer on 2016/11/15.
 */

public class FunFragmentPresenter implements  FunFragmentContract.IFunPresenter {
    private FunFragmentContract.IFunModel model ;
    private FunFragmentContract.IFunView view;

    public FunFragmentPresenter(FunFragmentContract.IFunView view) {
        model  = new FunFragmentModel();
        this.view = view;
    }

    @Override
    public void getPlayBean(Map<String, String> map) {
        Observable<PlayBean> observable = model.getPlayBean(map);
        observable.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Subscriber<PlayBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "onError: "+e );
                        StackTraceElement[] trace = e.getStackTrace();
                        for(int i =0 ;i<trace.length;i++){
                            Log.e("TAG", "onError: "+trace[i]);
                        }
                    }

                    @Override
                    public void onNext(PlayBean bean) {
                        bean.getData().getColumns();
                        List<ColumnsBean> columnsBeen = bean.getData().getColumns();
                        String title = bean.getData().getDisplay().get(0).getTitle();

                        String s = bean.getData().getInfo().getNext_url() + bean.getData().getInfo().getPage();
                        Log.e("TAG", "columnsBeen: "+columnsBeen.get(0).getBuild_banner());
                        Log.e("TAG", "getInfo: "+s);

                        Log.e("TAG", "getDisplay: "+title);
                        view.getData(bean);
                    }
                });



    }
}
