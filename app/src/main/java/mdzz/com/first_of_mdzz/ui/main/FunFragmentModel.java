package mdzz.com.first_of_mdzz.ui.main;

import java.util.Map;

import mdzz.com.first_of_mdzz.bean.fun.PlayBean;
import mdzz.com.first_of_mdzz.http.HttpUtils;
import mdzz.com.first_of_mdzz.http.IRetrofitInterface;
import rx.Observable;

/**
 * Created by acer on 2016/11/15.
 */

public class FunFragmentModel implements  FunFragmentContract.IFunModel {


    @Override
    public Observable<PlayBean> getPlayBean(Map<String, String> map) {

        IRetrofitInterface retrofitInterface = HttpUtils.getInstance().getRetrofitInterface();
        Observable<PlayBean> observable = retrofitInterface.getPlayBean(map);
        return observable;
    }
}
