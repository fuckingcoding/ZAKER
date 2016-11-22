package mdzz.com.first_of_mdzz.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.bean.hot.HotBean;
import mdzz.com.first_of_mdzz.utils.RecyclerViewAdapterHelper;

/**
 * Created by apple on 16/11/19.
 * Eemil:635727195@qq.com
 */

public class HotRecycleAdapter extends RecyclerViewAdapterHelper<HotBean.DataBean.ArticlesBean> {
    private static final int STATE1 = 0, STATE2 = 1, STATE3 = 3;
   private List<HotBean.DataBean.ArticlesBean.ThumbnailMediasBean> count;
    public interface IOnItemClickListener {
        void onclick(int position);
    }

    private IOnItemClickListener iOnItemClickListener;

    public HotRecycleAdapter(Context context, List<HotBean.DataBean.ArticlesBean> list, IOnItemClickListener iOnItemClickListener) {
        super(context, list);
        this.iOnItemClickListener = iOnItemClickListener;
    }

    @Override
    public int getItemViewType(int position) {

         count = mList.get(position).getThumbnail_medias();
//        final int T = 0;
//
//        if (count == null) {
//            return STATE1;
//        }
//        if (count.size() > 0 && count.size() < 3) {
//            return STATE2;
//        }
//        if (count.size() > 2) {
//            return STATE3;
//        }
//        return STATE2;
//    }

    return count==null?STATE1:(count.size()>0&&count.size()<3?STATE2:(count.size()>2?STATE3:null));
}
    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case STATE1:
                view = mInflater.inflate(R.layout.item_recycleview_hotfragment_no_pic, parent, false);
                return new ViewHolder1(view);
            case STATE2:
                view = mInflater.inflate(R.layout.item_recycleview_hotfragment_one_pic, parent, false);
                return new ViewHolder2(view);
            case STATE3:
                view = mInflater.inflate(R.layout.item_recycleview_hotfragment_more_pic, parent, false);
                return new ViewHolder3(view);
        }
        return null;
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder holder, final int position) {
      //  List<HotBean.DataBean.ArticlesBean> articles = mList.get(position).getData().getArticles();
        if(holder instanceof ViewHolder1){
            if(mList.get(position).getTitle()!=null&&mList.get(position).getAuther_name()!=null&&mList.get(position).getDate()!=null){
                ((ViewHolder1) holder).textview_title_nopic.setText(mList.get(position).getTitle());
                ((ViewHolder1) holder).textview_author_nopic.setText(mList.get(position).getAuther_name());
                ((ViewHolder1) holder).textview_time_nopic.setText(mList.get(position).getDate());
            }

        }
        if(holder instanceof ViewHolder2){
            ((ViewHolder2) holder).textview_title_onepic.setText(mList.get(position).getTitle());
            ((ViewHolder2) holder).textview_author_onepic.setText(mList.get(position).getAuther_name());
            ((ViewHolder2) holder).textview_time_onepic.setText(mList.get(position).getDate());
            if(mList.get(position).getThumbnail_medias().get(0).getUrl()!=null){
                final String oneimgurl=mList.get(position).getThumbnail_medias().get(0).getUrl();
                Glide.with(mContext).load(oneimgurl)
                        .placeholder(R.mipmap.ic_load_error)//设置站位图
                        .error (R.mipmap.ic_load_error)//加载失败的图片
                        .centerCrop()//拉伸属性
                        .into(((ViewHolder2) holder).imageview_onepic);
            }else{
                final String oneimgurl=mList.get(position).getThumbnail_medias().get(0).getRaw_url();
                Glide.with(mContext).load(oneimgurl)
                        .placeholder(R.mipmap.ic_load_error)//设置站位图
                        .error (R.mipmap.ic_load_error)//加载失败的图片
                        .centerCrop()//拉伸属性
                        .into(((ViewHolder2) holder).imageview_onepic);
            }

        }
        if(holder instanceof ViewHolder3){
            if(mList.get(position).getThumbnail_medias().get(0).getUrl()!=null&&mList.get(position).getThumbnail_medias().get(1).getUrl()!=null
                    &&mList.get(position).getThumbnail_medias().get(2).getUrl()!=null){
                final String moreimgurl1=mList.get(position).getThumbnail_medias().get(0).getUrl();
                final String moreimgurl2=mList.get(position).getThumbnail_medias().get(1).getUrl();
                final String moreimgurl3=mList.get(position).getThumbnail_medias().get(2).getUrl();
                Glide.with(mContext).load(moreimgurl1)
                        .placeholder(R.mipmap.ic_load_error)//设置站位图
                        .error (R.mipmap.ic_load_error)//加载失败的图片
                        .centerCrop()//拉伸属性

                        .into(((ViewHolder3) holder).imageview1_morepic);
                Glide.with(mContext).load(moreimgurl2)
                        .placeholder(R.mipmap.ic_load_error)//设置站位图
                        .error (R.mipmap.ic_load_error)//加载失败的图片
                        .centerCrop()//拉伸属性
                        .into(((ViewHolder3) holder).imageview2_morepic);
                Glide.with(mContext).load(moreimgurl3)
                        .placeholder(R.mipmap.ic_load_error)//设置站位图
                        .error (R.mipmap.ic_load_error)//加载失败的图片
                        .centerCrop()//拉伸属性
                        .into(((ViewHolder3) holder).imageview3_morepic);
            }else{

                final String moreimgurl1=mList.get(position).getThumbnail_medias().get(0).getRaw_url();
                final String moreimgurl2=mList.get(position).getThumbnail_medias().get(1).getRaw_url();
                final String moreimgurl3=mList.get(position).getThumbnail_medias().get(2).getRaw_url();
                Glide.with(mContext).load(moreimgurl1)
                        .placeholder(R.mipmap.ic_load_error)//设置站位图
                        .error (R.mipmap.ic_load_error)//加载失败的图片
                        .centerCrop()//拉伸属性
                        .into(((ViewHolder3) holder).imageview1_morepic);
                Glide.with(mContext).load(moreimgurl2)
                        .placeholder(R.mipmap.ic_load_error)//设置站位图
                        .error (R.mipmap.ic_load_error)//加载失败的图片
                        .centerCrop()//拉伸属性
                        .into(((ViewHolder3) holder).imageview2_morepic);
                Glide.with(mContext).load(moreimgurl3)
                        .placeholder(R.mipmap.ic_load_error)//设置站位图
                        .error (R.mipmap.ic_load_error)//加载失败的图片
                        .centerCrop()//拉伸属性
                        .into(((ViewHolder3) holder).imageview2_morepic);

            }
            if(mList.get(position).getTitle()!=null){
                ((ViewHolder3) holder).textview_title_morepic.setText(mList.get(position).getTitle());
            }else {
                ((ViewHolder3) holder).textview_title_morepic.setText("数据为空，请刷新");
            }

            }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iOnItemClickListener.onclick(position);
            }
        });
    }
    class ViewHolder1 extends RecyclerView.ViewHolder{
        private TextView textview_title_nopic,textview_author_nopic,textview_time_nopic;
        public ViewHolder1(View itemView) {
            super(itemView);
            textview_title_nopic=(TextView)itemView.findViewById(R.id.title_textview_item_recycleview_hot_nopic);
            textview_author_nopic=(TextView)itemView.findViewById(R.id.author_textview_item_recycleview_hot_nopic);
            textview_time_nopic=(TextView)itemView.findViewById(R.id.time_textview_item_recycleview_hot_nopic);
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder{
        private TextView textview_title_onepic,textview_author_onepic,textview_time_onepic;
        private ImageView imageview_onepic;
        public ViewHolder2(View itemView) {
            super(itemView);
            textview_title_onepic=(TextView)itemView.findViewById(R.id.title_textview_item_recycleview_hot_onepic);
            textview_author_onepic=(TextView)itemView.findViewById(R.id.author_textview_item_recycleview_hot_onepic);
            textview_time_onepic=(TextView)itemView.findViewById(R.id.time_textview_item_recycleview_hot_onepic);
            imageview_onepic=(ImageView)itemView.findViewById(R.id.image_item_recycleview_hot_onepic);
        }
    }

    class  ViewHolder3 extends RecyclerView.ViewHolder{
        private ImageView imageview1_morepic,imageview2_morepic,imageview3_morepic;
        private TextView textview_title_morepic;
        public ViewHolder3(View itemView) {
            super(itemView);
            imageview1_morepic=(ImageView)itemView.findViewById(R.id.image1_item_recycleview_hot_morepic);
            imageview2_morepic=(ImageView)itemView.findViewById(R.id.image2_item_recycleview_hot_morepic);
            imageview3_morepic=(ImageView)itemView.findViewById(R.id.image3_item_recycleview_hot_morepic);
            textview_title_morepic=(TextView)itemView.findViewById(R.id.title_textview_item_recycleview_hot_morepic);
        }
    }
}
