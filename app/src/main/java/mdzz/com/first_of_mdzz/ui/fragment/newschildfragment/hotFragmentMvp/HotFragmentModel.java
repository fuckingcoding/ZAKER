package mdzz.com.first_of_mdzz.ui.fragment.newschildfragment.hotFragmentMvp;

import mdzz.com.first_of_mdzz.bean.hot.HotBean;
import mdzz.com.first_of_mdzz.http.HttpUtils;
import mdzz.com.first_of_mdzz.http.IRetrofitInterface;
import rx.Observable;

/**
 * Created by apple on 16/11/19.
 * Eemil:635727195@qq.com
 */

public class HotFragmentModel implements HotFragmentContract.IHotModel {
    @Override
    public Observable<HotBean> getBean(String s) {
        IRetrofitInterface retrofitInterface = HttpUtils.getInstance().getRetrofitInterface();
        Observable<HotBean> observable = retrofitInterface.getHotBean(s);
        return observable;
    }
}
