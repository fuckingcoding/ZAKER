package mdzz.com.first_of_mdzz.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.bean.home.SportBean;
import mdzz.com.first_of_mdzz.config.Constant;
import mdzz.com.first_of_mdzz.ui.web.WebActivity;
import mdzz.com.first_of_mdzz.ui.web.WebNewActivity;
import mdzz.com.first_of_mdzz.utils.BitmapCircleTransformation;

/**
 * Created by Administrator on 2016/11/19 0019.
 */

public class MySportAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    private Context mContext;
    private List<SportBean.DataBean.PostsBean> posts;
    private LayoutInflater mLayoutInflater;
    public static final int TYPE1 = 0;
    public static final int TYPE2 = 1;
    public static final int TYPE3 = 2;
    public static final int TYPE4 = 3;
    private int i;

    public MySportAdapter(Context mContext, List<SportBean.DataBean.PostsBean> posts) {
        this.mContext = mContext;
        this.posts = posts;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemViewType(int position) {
        SportBean.DataBean.PostsBean.AdditionalInfoBean additionalInfo = posts.get(position).getAdditionalInfo();
        List<SportBean.DataBean.PostsBean.MediasBean> medias = posts.get(position).getMedias();
        if(additionalInfo!=null){
            return TYPE2;
        }else if(additionalInfo==null&&medias.size()==0){
            return TYPE1;
        }else if(additionalInfo==null&&medias.size()>=1){
            return TYPE3;
        }else{
            return TYPE4;
        }


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType){
            case TYPE1:
                view=mLayoutInflater.inflate(R.layout.item_home_nopic,parent,false);
                return new ViewHolder1(view);
            case TYPE2:
                view=mLayoutInflater.inflate(R.layout.item_home_txtpic,parent,false);
                return new ViewHolder2(view);
            case TYPE3:
                view=mLayoutInflater.inflate(R.layout.item_home_onepic,parent,false);
                return new ViewHolder3(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof ViewHolder1){
            Glide.with(mContext).load(posts.get(position).getAuther().getIcon()).transform(new BitmapCircleTransformation(mContext)).into(((ViewHolder1) holder).iv);
            ((ViewHolder1) holder).txt_head.setText(posts.get(position).getAuther().getName());
            ((ViewHolder1) holder).text_time.setText(posts.get(position).getDate());
            ((ViewHolder1) holder).text_content.setText(posts.get(position).getContent());
            ((ViewHolder1) holder).tv_eye.setText(posts.get(position).getCommentCount());
            ((ViewHolder1) holder).tv_topic.setText(posts.get(position).getHotNum());
            ((ViewHolder1) holder).tv_like.setText(posts.get(position).getLikeNum());
        }else if(holder instanceof ViewHolder2){
            Glide.with(mContext).load(posts.get(position).getAuther().getIcon()).transform(new BitmapCircleTransformation(mContext)).into(((ViewHolder2) holder).iv_head);
            Glide.with(mContext).load(posts.get(position).getAdditionalInfo().getPic()).into(((ViewHolder2) holder).iv_pic);
            ((ViewHolder2) holder).tv_name.setText(posts.get(position).getAuther().getName());
            ((ViewHolder2) holder).tv_time.setText(posts.get(position).getDate());
            ((ViewHolder2) holder).tv_title.setText(posts.get(position).getContent());
            ((ViewHolder2) holder).tv_content.setText(posts.get(position).getAdditionalInfo().getTitle());
            ((ViewHolder2) holder).tv_comment.setText(posts.get(position).getCommentCount());
            ((ViewHolder2) holder).tv_hot.setText(posts.get(position).getHotNum());
            ((ViewHolder2) holder).tv_like.setText(posts.get(position).getLikeNum());
        }else if(holder instanceof ViewHolder3){
            Glide.with(mContext).load(posts.get(position).getAuther().getIcon()).transform(new BitmapCircleTransformation(mContext)).into(((ViewHolder3) holder).iv_head);
            Glide.with(mContext).load(posts.get(position).getMedias().get(0).getUrl()).into(((ViewHolder3) holder).iv_url);
            ((ViewHolder3) holder).tv_head.setText(posts.get(position).getAuther().getName());
            ((ViewHolder3) holder).tv_time.setText(posts.get(position).getDate());
            ((ViewHolder3) holder).tv_title.setText(posts.get(position).getContent());
            ((ViewHolder3) holder).tv_commit.setText(posts.get(position).getCommentCount());
            ((ViewHolder3) holder).tv_hot.setText(posts.get(position).getHotNum());
            ((ViewHolder3) holder).tv_like.setText(posts.get(position).getLikeNum());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String weburl = posts.get(position).getWeburl();
                Intent intent = new Intent(mContext, WebNewActivity.class);
                intent.putExtra(Constant.WEB_URL,weburl);
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
    class ViewHolder1 extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView txt_head,text_time,text_content,tv_eye,tv_topic,tv_like;
        public ViewHolder1(View itemView) {
            super(itemView);
            iv= (ImageView) itemView.findViewById(R.id.sport_nopic_iv_head);
            txt_head = (TextView) itemView.findViewById(R.id.sport_nopic_tv_name);
            text_time = (TextView) itemView.findViewById(R.id.sport_nopic_tv_usertime);
            text_content = (TextView) itemView.findViewById(R.id.sport_nopic_tv_content);
            tv_eye = (TextView) itemView.findViewById(R.id.item_sport_tv_comment);
            tv_topic = (TextView) itemView.findViewById(R.id.item_sport_tv_hot);
            tv_like = (TextView) itemView.findViewById(R.id.item_sport_tv_like);
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder{
        ImageView iv_head,iv_pic;
        TextView tv_name,tv_time,tv_title,tv_content,tv_comment,tv_hot,tv_like;
        public ViewHolder2(View itemView) {
            super(itemView);
            iv_head = (ImageView) itemView.findViewById(R.id.topic_iv_icon);
            iv_pic = (ImageView) itemView.findViewById(R.id.topic_iv_url);
            tv_name = (TextView) itemView.findViewById(R.id.topic_tv_name);
            tv_time = (TextView) itemView.findViewById(R.id.topic_tv_time);
            tv_title = (TextView) itemView.findViewById(R.id.topic_tv_title);
            tv_content = (TextView) itemView.findViewById(R.id.topic_tv_content);
            tv_comment = (TextView) itemView.findViewById(R.id.topic_tv_eye);
            tv_hot = (TextView) itemView.findViewById(R.id.topic_tv_topic);
            tv_like = (TextView) itemView.findViewById(R.id.topic_tv_like);

        }
    }
    class ViewHolder3 extends RecyclerView.ViewHolder{
        ImageView iv_head,iv_url;
        TextView tv_head,tv_time,tv_title,tv_commit,tv_hot,tv_like;
        public ViewHolder3(View itemView) {
            super(itemView);
            iv_head = (ImageView) itemView.findViewById(R.id.home_onepic_iv_head);
            iv_url = (ImageView) itemView.findViewById(R.id.home_onepic_iv_url);
            tv_head = (TextView) itemView.findViewById(R.id.home_onepic_tv_name);
            tv_time = (TextView) itemView.findViewById(R.id.home_onepic_tv_time);
            tv_title = (TextView) itemView.findViewById(R.id.home_onepic_tv_title);
            tv_commit = (TextView) itemView.findViewById(R.id.home_onepic_tv_commint);
            tv_hot = (TextView) itemView.findViewById(R.id.home_onepic_tv_hot);
            tv_like = (TextView) itemView.findViewById(R.id.home_onepic_tv_like);
        }
    }
}
