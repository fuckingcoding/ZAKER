package mdzz.com.first_of_mdzz.ui.main.subscriber.SubItemMvp;

import mdzz.com.first_of_mdzz.base.IBaseModel;
import mdzz.com.first_of_mdzz.base.IBasePresenter;
import mdzz.com.first_of_mdzz.base.IBaseView;
import mdzz.com.first_of_mdzz.bean.subscibe.FashionBean;
import rx.Observable;

/**
 * Created by apple on 16/11/18.
 * Eemil:635727195@qq.com
 */

public class SubItemFragmentContract {
    public    interface  ISubItemModel extends IBaseModel {
        Observable<FashionBean> getBean(String s);
    }

    public    interface  ISubItemPresenter extends IBasePresenter {
        void getBean(String s);
    }

    public    interface  ISubItemView extends IBaseView {
        void getData(FashionBean bean);
    }
}
