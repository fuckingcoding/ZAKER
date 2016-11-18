package mdzz.com.first_of_mdzz.bean;

/**
 * Created by acer on 2016/11/17.
 */

public class SelectBean {
   //定位地点的bean

    private String username;
    private String pinyin;
    private String firstLetter;
    private String iconUrl;

    public SelectBean() {
    }

    public SelectBean(String username, String iconUrl, String firstLetter, String pinyin) {
        this.username = username;
        this.iconUrl = iconUrl;
        this.firstLetter = firstLetter;
        this.pinyin = pinyin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Override
    public String toString() {
        return "SelectBean{" +
                "username='" + username + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", firstLetter='" + firstLetter + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                '}';
    }
}
