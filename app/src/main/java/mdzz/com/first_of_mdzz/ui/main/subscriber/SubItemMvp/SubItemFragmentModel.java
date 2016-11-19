package mdzz.com.first_of_mdzz.ui.main.subscriber.SubItemMvp;

import mdzz.com.first_of_mdzz.bean.subscibe.FashionBean;
import mdzz.com.first_of_mdzz.http.HttpUtils;
import mdzz.com.first_of_mdzz.http.IRetrofitInterface;
import rx.Observable;

/**
 * Created by apple on 16/11/18.
 * Eemil:635727195@qq.com
 */

public class SubItemFragmentModel implements SubItemFragmentContract.ISubItemModel {
    @Override
    public Observable<FashionBean> getBean(String s) {


        IRetrofitInterface retrofitInterface = HttpUtils.getInstance().getRetrofitInterface();
        Observable<FashionBean> observable = retrofitInterface.getFashionBean(s);
        return observable;
    }
}
