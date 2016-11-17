package mdzz.com.first_of_mdzz.ui.main;

import java.util.Map;

import mdzz.com.first_of_mdzz.base.IBaseModel;
import mdzz.com.first_of_mdzz.base.IBasePresenter;
import mdzz.com.first_of_mdzz.base.IBaseView;
import mdzz.com.first_of_mdzz.bean.PlayBean;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by acer on 2016/11/15.
 */

public class FunFragmentContract {


    public    interface  IFunModel extends IBaseModel{
        Observable<PlayBean> getPlayBean(Map<String ,String> map);
    }

    public    interface  IFunPresenter extends IBasePresenter{
       void getPlayBean(Map<String ,String> map);
    }

    public    interface  IFunView extends IBaseView{
            void getData(PlayBean bean);
    }

}
