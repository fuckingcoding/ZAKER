package mdzz.com.first_of_mdzz.ui.selectposition;

import java.util.Map;

import mdzz.com.first_of_mdzz.base.IBaseModel;
import mdzz.com.first_of_mdzz.base.IBasePresenter;
import mdzz.com.first_of_mdzz.base.IBaseView;
import mdzz.com.first_of_mdzz.bean.position.PositionBean;
import mdzz.com.first_of_mdzz.bean.week.WeekBean;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by acer on 2016/11/18.
 */

public class SelectContract {

    public interface ISelectModel extends IBaseModel{
        Observable<PositionBean> getPositionBean( Map<String,String> map);


    }

     public interface ISelectPresenter extends IBasePresenter{
         void getPositionBean( Map<String,String> map);


    }

    public  interface ISelectView extends IBaseView{
        void getPosotionBean(PositionBean bean);


    }
}
