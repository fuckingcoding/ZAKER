package mdzz.com.first_of_mdzz.bean.Weather;

import java.util.List;

/**
 * Created by apple on 16/11/11.
 * Eemil:635727195@qq.com
 */

public class WeatherBean {


    /**
     * desc : OK
     * status : 1000
     * data : {"wendu":"10","ganmao":"虽然温度适宜但风力较大，仍较易发生感冒，体质较弱的朋友请注意适当防护。","forecast":[{"fengxiang":"北风","fengli":"4-5级","high":"高温 12℃","type":"晴","low":"低温 8℃","date":"11日星期五"},{"fengxiang":"北风","fengli":"4-5级","high":"高温 14℃","type":"晴","low":"低温 9℃","date":"12日星期六"},{"fengxiang":"南风","fengli":"4-5级","high":"高温 14℃","type":"多云","low":"低温 6℃","date":"13日星期天"},{"fengxiang":"北风","fengli":"5-6级","high":"高温 11℃","type":"晴","low":"低温 1℃","date":"14日星期一"},{"fengxiang":"北风","fengli":"4-5级","high":"高温 9℃","type":"晴","low":"低温 2℃","date":"15日星期二"}],"yesterday":{"fl":"5-6级","fx":"西南风","high":"高温 11℃","type":"小雨","low":"低温 6℃","date":"10日星期四"},"aqi":"39","city":"大连"}
     */

    private String desc;
    private int status;
    /**
     * wendu : 10
     * ganmao : 虽然温度适宜但风力较大，仍较易发生感冒，体质较弱的朋友请注意适当防护。
     * forecast : [{"fengxiang":"北风","fengli":"4-5级","high":"高温 12℃","type":"晴","low":"低温 8℃","date":"11日星期五"},{"fengxiang":"北风","fengli":"4-5级","high":"高温 14℃","type":"晴","low":"低温 9℃","date":"12日星期六"},{"fengxiang":"南风","fengli":"4-5级","high":"高温 14℃","type":"多云","low":"低温 6℃","date":"13日星期天"},{"fengxiang":"北风","fengli":"5-6级","high":"高温 11℃","type":"晴","low":"低温 1℃","date":"14日星期一"},{"fengxiang":"北风","fengli":"4-5级","high":"高温 9℃","type":"晴","low":"低温 2℃","date":"15日星期二"}]
     * yesterday : {"fl":"5-6级","fx":"西南风","high":"高温 11℃","type":"小雨","low":"低温 6℃","date":"10日星期四"}
     * aqi : 39
     * city : 大连
     */

    private DataBean data;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String wendu;
        private String ganmao;
        /**
         * fl : 5-6级
         * fx : 西南风
         * high : 高温 11℃
         * type : 小雨
         * low : 低温 6℃
         * date : 10日星期四
         */

        private YesterdayBean yesterday;
        private String aqi;
        private String city;
        /**
         * fengxiang : 北风
         * fengli : 4-5级
         * high : 高温 12℃
         * type : 晴
         * low : 低温 8℃
         * date : 11日星期五
         */

        private List<ForecastBean> forecast;

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public String getAqi() {
            return aqi;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            private String fl;
            private String fx;
            private String high;
            private String type;
            private String low;
            private String date;

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }
        }

        public static class ForecastBean {
            private String fengxiang;
            private String fengli;
            private String high;
            private String type;
            private String low;
            private String date;

            public String getFengxiang() {
                return fengxiang;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public String getFengli() {
                return fengli;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }
        }
    }
}
