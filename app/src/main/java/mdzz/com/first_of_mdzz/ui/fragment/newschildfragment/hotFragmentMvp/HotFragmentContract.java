package mdzz.com.first_of_mdzz.ui.fragment.newschildfragment.hotFragmentMvp;

import mdzz.com.first_of_mdzz.base.IBaseModel;
import mdzz.com.first_of_mdzz.base.IBasePresenter;
import mdzz.com.first_of_mdzz.base.IBaseView;
import mdzz.com.first_of_mdzz.bean.hot.HotBean;
import rx.Observable;

/**
 * Created by apple on 16/11/19.
 * Eemil:635727195@qq.com
 */

public class HotFragmentContract {
    public    interface  IHotModel extends IBaseModel {
        Observable<HotBean> getBean(String s);
    }

    public    interface  IHotPresenter extends IBasePresenter {
        void getBean(String s);
    }

    public    interface  IHotView extends IBaseView {
        void getData(HotBean bean);
    }
}
