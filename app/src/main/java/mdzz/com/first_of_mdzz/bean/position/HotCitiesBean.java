package mdzz.com.first_of_mdzz.bean.position;

/**
 * Created by acer on 2016/11/18.
 */

public class HotCitiesBean {
    /**
     * province_code : 22
     * city_code : beijing
     * city_name : 北京
     * letter : 热
     */

    private String province_code;
    private String city_code;
    private String city_name;
    private String letter;

    public String getProvince_code() {
        return province_code;
    }

    public void setProvince_code(String province_code) {
        this.province_code = province_code;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
}