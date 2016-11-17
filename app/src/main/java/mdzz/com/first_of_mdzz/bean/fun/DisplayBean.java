package mdzz.com.first_of_mdzz.bean.fun;

/**
 * Created by acer on 2016/11/17.
 */

public  class DisplayBean {
    /**
     * pk : 5744243b9490cb1361000083
     * title : ZAKER 俱乐部
     * pic : {"url":"http://zkres.myzaker.com/img_upload/editor/img_upload/20161012/up_1476267604_76065_W384H206S24167.png","w":"384","h":"206","m_url":"http://actres.myzaker.com/img/201611/aHR0cDovL3prcmVzLm15emFrZXIuY29tL2ltZ191cGxvYWQvZWRpdG9yL2ltZ191cGxvYWQvMjAxNjEwMTIvdXBfMTQ3NjI2NzYwNF83NjA2NV9XMzg0SDIwNlMyNDE2Ny5wbmc=_400.jpg"}
     * click_stat_url : http://wl.myzaker.com/?c=action_stat&m=display_click&pk=5744243b9490cb1361000083
     * type : web
     * web : {"url":"http://iphone.myzaker.com/zaker/hd_center.php","type":"","need_user_info":"Y"}
     */

    private String pk;
    private String title;
    private PicBeanX pic;
    private String click_stat_url;
    private String type;
    private WebBeanX web;

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

    public PicBeanX getPic() {
        return pic;
    }

    public void setPic(PicBeanX pic) {
        this.pic = pic;
    }

    public String getClick_stat_url() {
        return click_stat_url;
    }

    public void setClick_stat_url(String click_stat_url) {
        this.click_stat_url = click_stat_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public WebBeanX getWeb() {
        return web;
    }

    public void setWeb(WebBeanX web) {
        this.web = web;
    }

    public static class PicBeanX {
        /**
         * url : http://zkres.myzaker.com/img_upload/editor/img_upload/20161012/up_1476267604_76065_W384H206S24167.png
         * w : 384
         * h : 206
         * m_url : http://actres.myzaker.com/img/201611/aHR0cDovL3prcmVzLm15emFrZXIuY29tL2ltZ191cGxvYWQvZWRpdG9yL2ltZ191cGxvYWQvMjAxNjEwMTIvdXBfMTQ3NjI2NzYwNF83NjA2NV9XMzg0SDIwNlMyNDE2Ny5wbmc=_400.jpg
         */

        private String url;
        private String w;
        private String h;
        private String m_url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getW() {
            return w;
        }

        public void setW(String w) {
            this.w = w;
        }

        public String getH() {
            return h;
        }

        public void setH(String h) {
            this.h = h;
        }

        public String getM_url() {
            return m_url;
        }

        public void setM_url(String m_url) {
            this.m_url = m_url;
        }
    }

    public static class WebBeanX {
        /**
         * url : http://iphone.myzaker.com/zaker/hd_center.php
         * type :
         * need_user_info : Y
         */

        private String url;
        private String type;
        private String need_user_info;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getNeed_user_info() {
            return need_user_info;
        }

        public void setNeed_user_info(String need_user_info) {
            this.need_user_info = need_user_info;
        }
    }
}