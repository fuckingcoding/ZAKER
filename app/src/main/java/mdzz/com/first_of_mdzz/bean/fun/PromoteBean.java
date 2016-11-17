package mdzz.com.first_of_mdzz.bean.fun;

/**
 * Created by acer on 2016/11/17.
 */

public  class PromoteBean {
    //轮播条
    /**
     * pk : 5825bef59490cb2322000094
     * promotion_img : http://zkres.myzaker.com/img_upload/editor/img_upload/20161115/up_1479194751_49412_W1242H530S194233.jpg
     * img_height : 530
     * img_width : 1242
     * title :
     * end_time : 1484064000
     * type : web
     * pop_type :
     * hide_mask : Y
     * ads_stat_url : http://adm.myzaker.com/ads_stat.php?ads_id=5825bef59490cb2322000094&position=weekend_promotion
     * start_time : 1478880000
     * web : {"url":"http://m.zkshop.myzaker.com/?need_user_info=Y","type":"","need_user_info":"N"}
     * tag_info : {"type":"img","text":"独家","image_url":"http://zkres.myzaker.com/data/image/mark/dujia_2x.png","img_height":"26","img_width":"46"}
     * article : {"pk":"58245e789490cbd35f00006e","title":"跨界纸艺女神 用一张纸雕琢整个世界","app_ids":"12112","date":"2016-11-18 00:00:00","auther_name":"ZAKER生活家","weburl":"http://iphone.myzaker.com/l.php?l=58245e789490cbd35f00006e","is_full":"NO","content":"","full_url":"http://iphone.myzaker.com/zaker/article_mongo.php?app_id=12112&pk=58245e789490cbd35f00006e&m=1478780396","type":"web3","special_info":{"open_type":"web3","need_user_info":"Y","web_url":"http://iphone.myzaker.com/zaker/ad_article.php?_id=5824659b9490cbc65f00005f&title=%E8%B7%A8%E7%95%8C%E7%BA%B8%E8%89%BA%E5%A5%B3%E7%A5%9E+%E7%94%A8%E4%B8%80%E5%BC%A0%E7%BA%B8%E9%9B%95%E7%90%A2%E6%95%B4%E4%B8%AA%E4%B8%96%E7%95%8C&open_type=web3&_appid=androidphone&need_userinfo=Y&url=http%3A%2F%2Fiphone.myzaker.com%2Fzaker%2Farticle_car.php%3Fpk%3D582413b69490cbba5f000030%26target%3Dweb3%26article_pk%3D58245e789490cbd35f00006e","show_jingcai":"N"}}
     */

    private String pk;
    private String promotion_img;
    private String img_height;
    private String img_width;
    private String title;
    private String end_time;
    private String type;
    private String pop_type;
    private String hide_mask;
    private String ads_stat_url;
    private String start_time;
    private WebBean web;
    private TagInfoBean tag_info;
    private ArticleBeanX article;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getPromotion_img() {
        return promotion_img;
    }

    public void setPromotion_img(String promotion_img) {
        this.promotion_img = promotion_img;
    }

    public String getImg_height() {
        return img_height;
    }

    public void setImg_height(String img_height) {
        this.img_height = img_height;
    }

    public String getImg_width() {
        return img_width;
    }

    public void setImg_width(String img_width) {
        this.img_width = img_width;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPop_type() {
        return pop_type;
    }

    public void setPop_type(String pop_type) {
        this.pop_type = pop_type;
    }

    public String getHide_mask() {
        return hide_mask;
    }

    public void setHide_mask(String hide_mask) {
        this.hide_mask = hide_mask;
    }

    public String getAds_stat_url() {
        return ads_stat_url;
    }

    public void setAds_stat_url(String ads_stat_url) {
        this.ads_stat_url = ads_stat_url;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public WebBean getWeb() {
        return web;
    }

    public void setWeb(WebBean web) {
        this.web = web;
    }

    public TagInfoBean getTag_info() {
        return tag_info;
    }

    public void setTag_info(TagInfoBean tag_info) {
        this.tag_info = tag_info;
    }

    public ArticleBeanX getArticle() {
        return article;
    }

    public void setArticle(ArticleBeanX article) {
        this.article = article;
    }

    public static class WebBean {
        /**
         * url : http://m.zkshop.myzaker.com/?need_user_info=Y
         * type :
         * need_user_info : N
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

    public static class TagInfoBean {
        /**
         * type : img
         * text : 独家
         * image_url : http://zkres.myzaker.com/data/image/mark/dujia_2x.png
         * img_height : 26
         * img_width : 46
         */

        private String type;
        private String text;
        private String image_url;
        private String img_height;
        private String img_width;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getImg_height() {
            return img_height;
        }

        public void setImg_height(String img_height) {
            this.img_height = img_height;
        }

        public String getImg_width() {
            return img_width;
        }

        public void setImg_width(String img_width) {
            this.img_width = img_width;
        }
    }

    public static class ArticleBeanX {
        /**
         * pk : 58245e789490cbd35f00006e
         * title : 跨界纸艺女神 用一张纸雕琢整个世界
         * app_ids : 12112
         * date : 2016-11-18 00:00:00
         * auther_name : ZAKER生活家
         * weburl : http://iphone.myzaker.com/l.php?l=58245e789490cbd35f00006e
         * is_full : NO
         * content :
         * full_url : http://iphone.myzaker.com/zaker/article_mongo.php?app_id=12112&pk=58245e789490cbd35f00006e&m=1478780396
         * type : web3
         * special_info : {"open_type":"web3","need_user_info":"Y","web_url":"http://iphone.myzaker.com/zaker/ad_article.php?_id=5824659b9490cbc65f00005f&title=%E8%B7%A8%E7%95%8C%E7%BA%B8%E8%89%BA%E5%A5%B3%E7%A5%9E+%E7%94%A8%E4%B8%80%E5%BC%A0%E7%BA%B8%E9%9B%95%E7%90%A2%E6%95%B4%E4%B8%AA%E4%B8%96%E7%95%8C&open_type=web3&_appid=androidphone&need_userinfo=Y&url=http%3A%2F%2Fiphone.myzaker.com%2Fzaker%2Farticle_car.php%3Fpk%3D582413b69490cbba5f000030%26target%3Dweb3%26article_pk%3D58245e789490cbd35f00006e","show_jingcai":"N"}
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
        private String type;
        private SpecialInfoBeanX special_info;

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public SpecialInfoBeanX getSpecial_info() {
            return special_info;
        }

        public void setSpecial_info(SpecialInfoBeanX special_info) {
            this.special_info = special_info;
        }

        public static class SpecialInfoBeanX {
            /**
             * open_type : web3
             * need_user_info : Y
             * web_url : http://iphone.myzaker.com/zaker/ad_article.php?_id=5824659b9490cbc65f00005f&title=%E8%B7%A8%E7%95%8C%E7%BA%B8%E8%89%BA%E5%A5%B3%E7%A5%9E+%E7%94%A8%E4%B8%80%E5%BC%A0%E7%BA%B8%E9%9B%95%E7%90%A2%E6%95%B4%E4%B8%AA%E4%B8%96%E7%95%8C&open_type=web3&_appid=androidphone&need_userinfo=Y&url=http%3A%2F%2Fiphone.myzaker.com%2Fzaker%2Farticle_car.php%3Fpk%3D582413b69490cbba5f000030%26target%3Dweb3%26article_pk%3D58245e789490cbd35f00006e
             * show_jingcai : N
             */

            private String open_type;
            private String need_user_info;
            private String web_url;
            private String show_jingcai;

            public String getOpen_type() {
                return open_type;
            }

            public void setOpen_type(String open_type) {
                this.open_type = open_type;
            }

            public String getNeed_user_info() {
                return need_user_info;
            }

            public void setNeed_user_info(String need_user_info) {
                this.need_user_info = need_user_info;
            }

            public String getWeb_url() {
                return web_url;
            }

            public void setWeb_url(String web_url) {
                this.web_url = web_url;
            }

            public String getShow_jingcai() {
                return show_jingcai;
            }

            public void setShow_jingcai(String show_jingcai) {
                this.show_jingcai = show_jingcai;
            }
        }
    }
}