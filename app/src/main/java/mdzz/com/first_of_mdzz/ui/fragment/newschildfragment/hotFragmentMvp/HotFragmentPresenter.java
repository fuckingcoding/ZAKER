package mdzz.com.first_of_mdzz.ui.fragment.newschildfragment.hotFragmentMvp;

import mdzz.com.first_of_mdzz.bean.hot.HotBean;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by apple on 16/11/19.
 * Eemil:635727195@qq.com
 */

public class HotFragmentPresenter implements HotFragmentContract.IHotPresenter {
    private HotFragmentContract.IHotModel model ;
    private HotFragmentContract.IHotView view;

    public HotFragmentPresenter(HotFragmentContract.IHotView view) {
        this.model =new HotFragmentModel();
        this.view = view;
    }
    @Override
    public void getBean(String s) {

        Observable<HotBean> observable = model.getBean(s);

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HotBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(HotBean bean) {

                        view.getData(bean);

                    }
                });
    }
}
