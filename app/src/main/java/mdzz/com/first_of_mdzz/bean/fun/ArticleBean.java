package mdzz.com.first_of_mdzz.bean.fun;

/**
 * Created by acer on 2016/11/17.
 */

public  class ArticleBean {
    /**
     * pk : 58291bf19490cb4421000038
     * title : 吃土的“罪魁祸首”就是它，网购 app 是怎样掏空你的钱包的？
     * app_ids : 12266
     * date :
     * auther_name : 爱范儿
     * weburl : http://iphone.myzaker.com/l.php?l=58291bf19490cb4421000038
     * is_full : NO
     * content :
     * full_url : http://iphone.myzaker.com/zaker/article_mongo.php?app_id=12266&pk=58291bf19490cb4421000038&m=1479092204
     * special_info : {"show_jingcai":"N"}
     */

    private String pk;
    private String title;
    private String app_ids;
    private String date;
    private String auther_name;
    private String weburl;
    private String is_full;
    private String content;
    private String full_url;
    private ArticleBean.SpecialInfoBean special_info;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getApp_ids() {
        return app_ids;
    }

    public void setApp_ids(String app_ids) {
        this.app_ids = app_ids;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuther_name() {
        return auther_name;
    }

    public void setAuther_name(String auther_name) {
        this.auther_name = auther_name;
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }

    public String getIs_full() {
        return is_full;
    }

    public void setIs_full(String is_full) {
        this.is_full = is_full;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFull_url() {
        return full_url;
    }

    public void setFull_url(String full_url) {
        this.full_url = full_url;
    }

    public ArticleBean.SpecialInfoBean getSpecial_info() {
        return special_info;
    }

    public void setSpecial_info(ArticleBean.SpecialInfoBean special_info) {
        this.special_info = special_info;
    }

    public static class SpecialInfoBean {
        /**
         * show_jingcai : N
         */

        private String show_jingcai;

        public String getShow_jingcai() {
            return show_jingcai;
        }

        public void setShow_jingcai(String show_jingcai) {
            this.show_jingcai = show_jingcai;
        }
    }
}