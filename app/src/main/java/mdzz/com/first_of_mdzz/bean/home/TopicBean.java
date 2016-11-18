package mdzz.com.first_of_mdzz.bean.home;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16 0016.
 */

public class TopicBean {

    /**
     * stat : 1
     * msg : ok
     * data : {"title":"推荐话题","list":[{"pk":"246","title":"综合体育","stitle":"聚焦各项体育赛事","pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/08/08/57a8606b9490cbad2f00007f.png","large_pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/08/08/57a8606b9490cbad2f00007f.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=246","block_color":"","subscribe_count":"154675","post_count":"2681"},{"pk":"156","title":"数码脑残粉","stitle":"数码科技达人聚集地","pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3f8d9490cb187b0000f9.png","large_pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3f8d9490cb187b0000f9.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=156","block_color":"","subscribe_count":"322673","post_count":"19366"},{"pk":"168","title":"电影圈","stitle":"电影同好联盟","pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2015/07/15/55a5c62c9490cbac17000044.png","large_pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2015/07/15/55a5c62c9490cbac17000044.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=168","block_color":"","subscribe_count":"628675","post_count":"13479"},{"pk":"215","title":"健身房","stitle":"马甲线、人鱼线都在这里！","pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd40a89490cbea7a00016b.png","large_pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd40a89490cbea7a00016b.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=215","block_color":"","subscribe_count":"524734","post_count":"11925"},{"pk":"2","title":"颤抖吧吃货","stitle":"拥抱美食和吃货!","pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2015/06/04/55700ba69490cbc01a00008b.png","large_pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2015/06/04/55700ba69490cbc01a00008b.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=2","block_color":"","subscribe_count":"593886","post_count":"29895"},{"pk":"86","title":"女神转型记","stitle":"生活不止柴米油盐，还有裙子鞋子和包包","pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3fc19490cbff7a00013f.png","large_pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3fc19490cbff7a00013f.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=86","block_color":"","subscribe_count":"275821","post_count":"11581"},{"pk":"83","title":"懂小姐","stitle":"可能是ZAKER最火的社区","pic":"http://zkres.myzaker.com/data/image/dis_icon/special/zkdis_icon_0079.png","large_pic":"http://zkres.myzaker.com/data/image/dis_icon/special/zkdis_icon_0079.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=83","block_color":"","subscribe_count":"601702","post_count":"55570"},{"pk":"185","title":"汽车总动员","stitle":"随心所欲畅聊关于汽车的一切","pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3d4c9490cbee7a000101.png","large_pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3d4c9490cbee7a000101.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=185","block_color":"","subscribe_count":"565950","post_count":"12981"},{"pk":"161","title":"扎堆","stitle":"杂谈 ","pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2015/12/29/5681e9ff9490cb59030000c9.png","large_pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2015/12/29/5681e9ff9490cb59030000c9.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=161","block_color":"","subscribe_count":"397716","post_count":"43854"},{"pk":"178","title":"我们就爱倒腾APP","stitle":"分享你喜欢的\u201c爱屁屁\u201d","pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3fdd9490cbff7a000141.png","large_pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3fdd9490cbff7a000141.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=178","block_color":"","subscribe_count":"307663","post_count":"4265"}]}
     */

    @SerializedName("stat")
    private String stat;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private DataBean data;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : 推荐话题
         * list : [{"pk":"246","title":"综合体育","stitle":"聚焦各项体育赛事","pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/08/08/57a8606b9490cbad2f00007f.png","large_pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/08/08/57a8606b9490cbad2f00007f.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=246","block_color":"","subscribe_count":"154675","post_count":"2681"},{"pk":"156","title":"数码脑残粉","stitle":"数码科技达人聚集地","pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3f8d9490cb187b0000f9.png","large_pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3f8d9490cb187b0000f9.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=156","block_color":"","subscribe_count":"322673","post_count":"19366"},{"pk":"168","title":"电影圈","stitle":"电影同好联盟","pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2015/07/15/55a5c62c9490cbac17000044.png","large_pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2015/07/15/55a5c62c9490cbac17000044.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=168","block_color":"","subscribe_count":"628675","post_count":"13479"},{"pk":"215","title":"健身房","stitle":"马甲线、人鱼线都在这里！","pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd40a89490cbea7a00016b.png","large_pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd40a89490cbea7a00016b.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=215","block_color":"","subscribe_count":"524734","post_count":"11925"},{"pk":"2","title":"颤抖吧吃货","stitle":"拥抱美食和吃货!","pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2015/06/04/55700ba69490cbc01a00008b.png","large_pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2015/06/04/55700ba69490cbc01a00008b.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=2","block_color":"","subscribe_count":"593886","post_count":"29895"},{"pk":"86","title":"女神转型记","stitle":"生活不止柴米油盐，还有裙子鞋子和包包","pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3fc19490cbff7a00013f.png","large_pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3fc19490cbff7a00013f.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=86","block_color":"","subscribe_count":"275821","post_count":"11581"},{"pk":"83","title":"懂小姐","stitle":"可能是ZAKER最火的社区","pic":"http://zkres.myzaker.com/data/image/dis_icon/special/zkdis_icon_0079.png","large_pic":"http://zkres.myzaker.com/data/image/dis_icon/special/zkdis_icon_0079.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=83","block_color":"","subscribe_count":"601702","post_count":"55570"},{"pk":"185","title":"汽车总动员","stitle":"随心所欲畅聊关于汽车的一切","pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3d4c9490cbee7a000101.png","large_pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3d4c9490cbee7a000101.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=185","block_color":"","subscribe_count":"565950","post_count":"12981"},{"pk":"161","title":"扎堆","stitle":"杂谈 ","pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2015/12/29/5681e9ff9490cb59030000c9.png","large_pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2015/12/29/5681e9ff9490cb59030000c9.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=161","block_color":"","subscribe_count":"397716","post_count":"43854"},{"pk":"178","title":"我们就爱倒腾APP","stitle":"分享你喜欢的\u201c爱屁屁\u201d","pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3fdd9490cbff7a000141.png","large_pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3fdd9490cbff7a000141.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=178","block_color":"","subscribe_count":"307663","post_count":"4265"}]
         */

        @SerializedName("title")
        private String title;
        @SerializedName("list")
        private List<ListBean> list;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * pk : 246
             * title : 综合体育
             * stitle : 聚焦各项体育赛事
             * pic : http://disres.myzaker.com/img_upload/discussion/disicon/2016/08/08/57a8606b9490cbad2f00007f.png
             * large_pic : http://disres.myzaker.com/img_upload/discussion/disicon/2016/08/08/57a8606b9490cbad2f00007f.png
             * api_url : http://dis.myzaker.com/api/get_post.php?discussion_id=246
             * block_color :
             * subscribe_count : 154675
             * post_count : 2681
             */

            @SerializedName("pk")
            private String pk;
            @SerializedName("title")
            private String title;
            @SerializedName("stitle")
            private String stitle;
            @SerializedName("pic")
            private String pic;
            @SerializedName("large_pic")
            private String largePic;
            @SerializedName("api_url")
            private String apiUrl;
            @SerializedName("block_color")
            private String blockColor;
            @SerializedName("subscribe_count")
            private String subscribeCount;
            @SerializedName("post_count")
            private String postCount;

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

            public String getStitle() {
                return stitle;
            }

            public void setStitle(String stitle) {
                this.stitle = stitle;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getLargePic() {
                return largePic;
            }

            public void setLargePic(String largePic) {
                this.largePic = largePic;
            }

            public String getApiUrl() {
                return apiUrl;
            }

            public void setApiUrl(String apiUrl) {
                this.apiUrl = apiUrl;
            }

            public String getBlockColor() {
                return blockColor;
            }

            public void setBlockColor(String blockColor) {
                this.blockColor = blockColor;
            }

            public String getSubscribeCount() {
                return subscribeCount;
            }

            public void setSubscribeCount(String subscribeCount) {
                this.subscribeCount = subscribeCount;
            }

            public String getPostCount() {
                return postCount;
            }

            public void setPostCount(String postCount) {
                this.postCount = postCount;
            }
        }
    }
}
