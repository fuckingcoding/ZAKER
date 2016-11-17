package mdzz.com.first_of_mdzz.bean.fun;

/**
 * Created by acer on 2016/11/17.
 */

public  class InfoBean {
    //下一条
    /**
     * next_url : http://wl.myzaker.com/?_appid=AndroidPhone&_v=6.5&_version=6.52&c=columns&city=dalian&p=1&skey=YToxOntzOjg6ImhvbWVwYWdlIjtkOjAuMjAxNjExMTE0MjI7fQ%3D%3D
     * page : 0
     * show_category : N
     */

    private String next_url;
    private String page;
    private String show_category;

    public String getNext_url() {
        return next_url;
    }

    public void setNext_url(String next_url) {
        this.next_url = next_url;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getShow_category() {
        return show_category;
    }

    public void setShow_category(String show_category) {
        this.show_category = show_category;
    }
}