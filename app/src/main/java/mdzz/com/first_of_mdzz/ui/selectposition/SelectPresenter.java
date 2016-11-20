package mdzz.com.first_of_mdzz.ui.selectposition;

import java.util.Map;

import mdzz.com.first_of_mdzz.bean.position.PositionBean;
import mdzz.com.first_of_mdzz.bean.week.WeekBean;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by acer on 2016/11/18.
 */

public class SelectPresenter implements SelectContract.ISelectPresenter {
     private SelectModel model ;
     private SelectContract.ISelectView view;

    public SelectPresenter(SelectContract.ISelectView view) {
        this.model  = new SelectModel();
        this.view = view;
    }

    @Override
    public void getPositionBean(Map<String, String> map) {

        Observable<PositionBean> observable = model.getPositionBean(map);

        observable.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PositionBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PositionBean bean) {
                       view.getPosotionBean(bean);
                    }
                });
    }


}
