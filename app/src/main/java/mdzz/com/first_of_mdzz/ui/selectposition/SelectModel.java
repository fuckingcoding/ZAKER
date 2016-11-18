package mdzz.com.first_of_mdzz.ui.selectposition;

import java.util.Map;

import mdzz.com.first_of_mdzz.bean.position.PositionBean;
import mdzz.com.first_of_mdzz.http.HttpUtils;
import mdzz.com.first_of_mdzz.http.IRetrofitInterface;
import rx.Observable;

/**
 * Created by acer on 2016/11/18.
 */

public class SelectModel implements SelectContract.ISelectModel {
    @Override
    public Observable<PositionBean> getPositionBean(Map<String, String> map) {

        IRetrofitInterface retrofitInterface = HttpUtils.getInstance().getRetrofitInterface();
        Observable<PositionBean> bean = retrofitInterface.getPositionBean(map);

        return bean;
    }
}
