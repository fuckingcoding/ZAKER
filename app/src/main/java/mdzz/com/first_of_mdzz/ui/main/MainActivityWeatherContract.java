package mdzz.com.first_of_mdzz.ui.main;

import mdzz.com.first_of_mdzz.base.IBaseModel;
import mdzz.com.first_of_mdzz.base.IBasePresenter;
import mdzz.com.first_of_mdzz.base.IBaseView;
import mdzz.com.first_of_mdzz.bean.Weather.WeatherBean;
import rx.Observable;

/**
 * Created by apple on 16/11/21.
 * Eemil:635727195@qq.com
 */

public class MainActivityWeatherContract {
    public interface IWeatherModel extends IBaseModel{
        Observable<WeatherBean> getBeanObservable(String city);
    }

    public interface IWeatherPresenter extends IBasePresenter {
        void loadNetwirkData( String city);
    }

    public interface IWeatherView  extends IBaseView{
        void showProgress();
        void hideProgress();
        void showErrorInfo(String msg);
        WeatherBean loadNetworkData( WeatherBean weatherBean);

    }
}
