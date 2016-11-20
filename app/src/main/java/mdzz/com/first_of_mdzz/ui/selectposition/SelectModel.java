package mdzz.com.first_of_mdzz.ui.selectposition;

import java.util.Map;

import mdzz.com.first_of_mdzz.bean.position.PositionBean;
import mdzz.com.first_of_mdzz.bean.week.WeekBean;
import mdzz.com.first_of_mdzz.http.HttpUtils;
import mdzz.com.first_of_mdzz.http.IRetrofitInterface;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by acer on 2016/11/18.
 */

public class SelectModel implements SelectContract.ISelectModel {
    @Override
    public Observable<PositionBean> getPositionBean(Map<String, String> map) {

        IRetrofitInterface retrofitInterface = HttpUtils.getInstance().getRetrofitInterface();
        Observable<PositionBean> observable = retrofitInterface.getPositionBean(map);

        return observable;
    }




}
