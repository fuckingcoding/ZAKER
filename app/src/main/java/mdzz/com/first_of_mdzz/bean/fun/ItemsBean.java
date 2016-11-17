package mdzz.com.first_of_mdzz.bean.fun;

/**
 * Created by acer on 2016/11/17.
 */

public  class ItemsBean {
    /**
     * pk : 582928d89490cb5821000051
     * title : 网购App是怎样掏空你钱包的
     * tag :
     * content : 吃土的“罪魁祸首”就是它
     * share_content : 吃土的“罪魁祸首”就是它
     * pic : {"url":"http://zkres.myzaker.com/img_upload/editor/img_upload/20161114/up_1479094864_50357_W750H420S51121.jpg","w":"750","h":"420","m_url":"http://actres.myzaker.com/img/201611/aHR0cDovL3prcmVzLm15emFrZXIuY29tL2ltZ191cGxvYWQvZWRpdG9yL2ltZ191cGxvYWQvMjAxNjExMTQvdXBfMTQ3OTA5NDg2NF81MDM1N19XNzUwSDQyMFM1MTEyMS5qcGc=_400.jpg"}
     * tpl_cell_style : over_pic
     * click_stat_url : http://wl.myzaker.com/?c=action_stat&m=column_item_click&cate_id=5822c7669490cb5764000032&pk=582928d89490cb5821000051
     * type : a
     * article : {"pk":"58291bf19490cb4421000038","title":"吃土的\u201c罪魁祸首\u201d就是它，网购 app 是怎样掏空你的钱包的？","app_ids":"12266","date":"","auther_name":"爱范儿","weburl":"http://iphone.myzaker.com/l.php?l=58291bf19490cb4421000038","is_full":"NO","content":"","full_url":"http://iphone.myzaker.com/zaker/article_mongo.php?app_id=12266&pk=58291bf19490cb4421000038&m=1479092204","special_info":{"show_jingcai":"N"}}
     */

    private String pk;
    private String title;
    private String tag;
    private String content;
    private String share_content;
    private PicBean pic;
    private String tpl_cell_style;
    private String click_stat_url;
    private String type;
    private ArticleBean article;

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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    public PicBean getPic() {
        return pic;
    }

    public void setPic(PicBean pic) {
        this.pic = pic;
    }

    public String getTpl_cell_style() {
        return tpl_cell_style;
    }

    public void setTpl_cell_style(String tpl_cell_style) {
        this.tpl_cell_style = tpl_cell_style;
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

    public ArticleBean getArticle() {
        return article;
    }

    public void setArticle(ArticleBean article) {
        this.article = article;
    }




}