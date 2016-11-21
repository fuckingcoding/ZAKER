package mdzz.com.first_of_mdzz.ui.main;

import mdzz.com.first_of_mdzz.bean.Weather.WeatherBean;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by apple on 16/11/21.
 * Eemil:635727195@qq.com
 */

public class MainActivityWeatherPresenter implements MainActivityWeatherContract.IWeatherPresenter {
    private MainActivityWeatherContract.IWeatherModel mWeatherModel;
    private MainActivityWeatherContract.IWeatherView mWeatherView;

    public MainActivityWeatherPresenter( MainActivityWeatherContract.IWeatherView mWeatherView) {
        this.mWeatherModel =new MainActivityWeatherModel();
        this.mWeatherView = mWeatherView;
    }

    @Override
    public void loadNetwirkData(String city) {
        mWeatherModel.getBeanObservable(city)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WeatherBean>() {
                    @Override
                    public void onCompleted() {
                        mWeatherView.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mWeatherView.showErrorInfo("获取数据失败");
                        mWeatherView.hideProgress();
                    }

                    @Override
                    public void onNext(WeatherBean weatherBean) {
                        mWeatherView.loadNetworkData(weatherBean);
                    }

                    @Override
                    public void onStart() {
                        super.onStart();
                        mWeatherView.showProgress();
                    }
                });
    }
}
