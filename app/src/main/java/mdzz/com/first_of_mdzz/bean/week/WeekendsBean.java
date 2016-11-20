package mdzz.com.first_of_mdzz.bean.week;

import java.util.List;

/**
 * Created by acer on 2016/11/19.
 */

public  class WeekendsBean {
    /**
     * pk : 575d24a47f780b645e000140
     * source : 要出发
     * redis_score : 2534277981.202
     * title : 隐居乡里·云上石屋
     * date : 2016-05-01 00:00:00
     * tag : 周边游
     * contacts : [{"tel_text":"400-118-1166"}]
     * cate_id : 4
     * category_name : 度假
     * thumbnail_medias : [{"type":"image","id":"575d24a27f780b645e00012a","url":"http://actres.myzaker.com/img/201606/575d24a27f780b645e00012a_800.jpg","m_url":"http://actres.myzaker.com/img/201606/575d24a27f780b645e00012a_400.jpg","w":"960","h":"400"}]
     * time_str : 进行中
     * author_name : 要出发-北京
     * address : 北京市房山区周口店镇黄山店村坡峰岭景区内
     * pos_str : 北京市房山区周口店镇黄山店村坡峰岭景区内
     * price : 960元
     * content :
     * share_content : 隐居乡里·云上石屋隐居乡里·云上石屋，特色隐居之旅云上石屋坐落于京郊房山区黄山店村北坡峰岭景区内。房...
     * share_url : http://wlwap.myzaker.com/?model=actDetailShare&pk=575d24a47f780b645e000140
     * full_url : http://wl.myzaker.com/?c=activity_detail&pk=575d24a47f780b645e000140
     * open_type : weekend
     * weekend : {"content_url":"http://wlwap.myzaker.com/?model=actDetail&pk=575d24a47f780b645e000140&cate_id=4","share_url":"http://wlwap.myzaker.com/?model=actDetailShare&pk=575d24a47f780b645e000140","weeken_type":"activity","order_url":"http://wl.myzaker.com/l.php?need_login=Y&need_user_info=Y&pk=575d24a47f780b645e000140&cate_id=4","order_text":"我想去"}
     * tpl_cell_style : s_follow_pic
     * s_title : 北京市房山区周口店镇黄山店村坡峰岭景区内
     * list_title : 住长城脚下当代顶级建筑
     北京长城脚下的公社
     */

    private String pk;
    private String source;
    private String redis_score;
    private String title;
    private String date;
    private String tag;
    private String cate_id;
    private String category_name;
    private String time_str;
    private String author_name;
    private String address;
    private String pos_str;
    private String price;
    private String content;
    private String share_content;
    private String share_url;
    private String full_url;
    private String open_type;
    private WeekendBean weekend;
    private String tpl_cell_style;
    private String s_title;
    private String list_title;
    private List<ContactsBean> contacts;
    private List<ThumbnailMediasBean> thumbnail_medias;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRedis_score() {
        return redis_score;
    }

    public void setRedis_score(String redis_score) {
        this.redis_score = redis_score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCate_id() {
        return cate_id;
    }

    public void setCate_id(String cate_id) {
        this.cate_id = cate_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getTime_str() {
        return time_str;
    }

    public void setTime_str(String time_str) {
        this.time_str = time_str;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPos_str() {
        return pos_str;
    }

    public void setPos_str(String pos_str) {
        this.pos_str = pos_str;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getShare_content() {
        return share_content;
    }

    public void setShare_content(String share_content) {
        this.share_content = share_content;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getFull_url() {
        return full_url;
    }

    public void setFull_url(String full_url) {
        this.full_url = full_url;
    }

    public String getOpen_type() {
        return open_type;
    }

    public void setOpen_type(String open_type) {
        this.open_type = open_type;
    }

    public WeekendBean getWeekend() {
        return weekend;
    }

    public void setWeekend(WeekendBean weekend) {
        this.weekend = weekend;
    }

    public String getTpl_cell_style() {
        return tpl_cell_style;
    }

    public void setTpl_cell_style(String tpl_cell_style) {
        this.tpl_cell_style = tpl_cell_style;
    }

    public String getS_title() {
        return s_title;
    }

    public void setS_title(String s_title) {
        this.s_title = s_title;
    }

    public String getList_title() {
        return list_title;
    }

    public void setList_title(String list_title) {
        this.list_title = list_title;
    }

    public List<ContactsBean> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactsBean> contacts) {
        this.contacts = contacts;
    }

    public List<ThumbnailMediasBean> getThumbnail_medias() {
        return thumbnail_medias;
    }

    public void setThumbnail_medias(List<ThumbnailMediasBean> thumbnail_medias) {
        this.thumbnail_medias = thumbnail_medias;
    }






}