package mdzz.com.first_of_mdzz.ui.main.subscriber.SubItemMvp;

import android.util.Log;

import mdzz.com.first_of_mdzz.bean.subscibe.FashionBean;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

/**
 * Created by apple on 16/11/18.
 * Eemil:635727195@qq.com
 */

public class SubItemFragmentPresenter implements SubItemFragmentContract.ISubItemPresenter {
    private SubItemFragmentContract.ISubItemModel model ;
    private SubItemFragmentContract.ISubItemView view;

    public SubItemFragmentPresenter(SubItemFragmentContract.ISubItemView view) {
        this.model =new SubItemFragmentModel();
        this.view = view;
    }



    @Override
    public void getBean(String s) {
        Observable<FashionBean> observable = model.getBean(s);
        Log.i(TAG, "getFashionBean: "+"eqeqeqe");
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<FashionBean>() {
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(FashionBean bean) {
                        Log.i(TAG, "onNext: bean.");
                        view.getData(bean);

                    }
                });
    }
}
