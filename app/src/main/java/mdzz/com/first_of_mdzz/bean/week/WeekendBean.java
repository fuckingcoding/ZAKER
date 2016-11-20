package mdzz.com.first_of_mdzz.bean.week;

/**
 * Created by acer on 2016/11/19.
 */

public  class WeekendBean {
    /**
     * content_url : http://wlwap.myzaker.com/?model=actDetail&pk=575d24a47f780b645e000140&cate_id=4
     * share_url : http://wlwap.myzaker.com/?model=actDetailShare&pk=575d24a47f780b645e000140
     * weeken_type : activity
     * order_url : http://wl.myzaker.com/l.php?need_login=Y&need_user_info=Y&pk=575d24a47f780b645e000140&cate_id=4
     * order_text : 我想去
     */

    private String content_url;
    private String share_url;
    private String weeken_type;
    private String order_url;
    private String order_text;

    public String getContent_url() {
        return content_url;
    }

    public void setContent_url(String content_url) {
        this.content_url = content_url;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getWeeken_type() {
        return weeken_type;
    }

    public void setWeeken_type(String weeken_type) {
        this.weeken_type = weeken_type;
    }

    public String getOrder_url() {
        return order_url;
    }

    public void setOrder_url(String order_url) {
        this.order_url = order_url;
    }

    public String getOrder_text() {
        return order_text;
    }

    public void setOrder_text(String order_text) {
        this.order_text = order_text;
    }
}