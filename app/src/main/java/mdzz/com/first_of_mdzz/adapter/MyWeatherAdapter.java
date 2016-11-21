package mdzz.com.first_of_mdzz.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.bean.Weather.WeatherBean;
import mdzz.com.first_of_mdzz.utils.BaseAdapterHelper;


/**
 * Created by apple on 16/11/11.
 * Eemil:635727195@qq.com
 */

public class MyWeatherAdapter extends BaseAdapterHelper<WeatherBean.DataBean.ForecastBean> {
    public MyWeatherAdapter(Context context, List<WeatherBean.DataBean.ForecastBean> list) {
        super(context, list);
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
       ViewHolder holder=null;
        if(convertView==null){
            convertView=mInflater.inflate(R.layout.item_weather_listview,parent,false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        WeatherBean.DataBean.ForecastBean bean=mList.get(position);
        holder.textView_item_date.setText(bean.getDate());
        holder.textView_item_weatherTemp.setText(bean.getHigh()+"--"+bean.getLow());
        holder.textView_item_wind.setText(bean.getFengli()+"--"+bean.getFengxiang());
        holder.textView_item_weather.setText(bean.getType());
        int resId=getWeatherIcon(bean.getType());
        holder.imageView_item_weatherIcon.setImageResource(resId);
        return convertView;
    }

    class ViewHolder {
        private ImageView imageView_item_weatherIcon;
        private TextView textView_item_date;
        private TextView textView_item_weatherTemp;
        private TextView textView_item_wind;
        private TextView textView_item_weather;

        public ViewHolder(View convertView) {
            imageView_item_weatherIcon = ((ImageView) convertView.findViewById(R.id
                    .imageView_item_weatherIcon));
            textView_item_date = ((TextView) convertView.findViewById(R.id
                    .textView_item_date));
            textView_item_weatherTemp = ((TextView) convertView.findViewById(R.id
                    .textView_item_weatherTemp));
            textView_item_wind = ((TextView) convertView.findViewById(R.id
                    .textView_item_wind));
            textView_item_weather = ((TextView) convertView.findViewById(R.id
                    .textView_item_weather));
        }
    }


    /**
     * 根据天气状态返回有关天气图片的id
     *
     * @param weather
     * @return
     */
    private int getWeatherIcon(String weather) {
        if (weather.equals("多云") || weather.equals("多云转阴") || weather.equals("多云转晴")) {
            return R.mipmap.biz_plugin_weather_duoyun;
        } else if (weather.equals("中雨") || weather.equals("中到大雨")) {
            return R.mipmap.biz_plugin_weather_zhongyu;
        } else if (weather.equals("雷阵雨")) {
            return R.mipmap.biz_plugin_weather_leizhenyu;
        } else if (weather.equals("阵雨") || weather.equals("阵雨转多云")) {
            return R.mipmap.biz_plugin_weather_zhenyu;
        } else if (weather.equals("暴雪")) {
            return R.mipmap.biz_plugin_weather_baoxue;
        } else if (weather.equals("暴雨")) {
            return R.mipmap.biz_plugin_weather_baoyu;
        } else if (weather.equals("大暴雨")) {
            return R.mipmap.biz_plugin_weather_dabaoyu;
        } else if (weather.equals("大雪")) {
            return R.mipmap.biz_plugin_weather_daxue;
        } else if (weather.equals("大雨") || weather.equals("大雨转中雨")) {
            return R.mipmap.biz_plugin_weather_dayu;
        } else if (weather.equals("雷阵雨冰雹")) {
            return R.mipmap.biz_plugin_weather_leizhenyubingbao;
        } else if (weather.equals("晴")) {
            return R.mipmap.biz_plugin_weather_qing;
        } else if (weather.equals("沙尘暴")) {
            return R.mipmap.biz_plugin_weather_shachenbao;
        } else if (weather.equals("特大暴雨")) {
            return R.mipmap.biz_plugin_weather_tedabaoyu;
        } else if (weather.equals("雾") || weather.equals("霾") || weather.equals("雾霾")) {
            return R.mipmap.biz_plugin_weather_wu;
        } else if (weather.equals("小雪")) {
            return R.mipmap.biz_plugin_weather_xiaoxue;
        } else if (weather.equals("小雨")) {
            return R.mipmap.biz_plugin_weather_xiaoyu;
        } else if (weather.equals("阴")) {
            return R.mipmap.biz_plugin_weather_yin;
        } else if (weather.equals("雨夹雪")) {
            return R.mipmap.biz_plugin_weather_yujiaxue;
        } else if (weather.equals("阵雪")) {
            return R.mipmap.biz_plugin_weather_zhenxue;
        } else if (weather.equals("中雪")) {
            return R.mipmap.biz_plugin_weather_zhongxue;
        } else {
            return R.mipmap.biz_plugin_weather_duoyun;
        }
    }

}

