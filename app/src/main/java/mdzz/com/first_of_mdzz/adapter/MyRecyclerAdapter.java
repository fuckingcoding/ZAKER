package mdzz.com.first_of_mdzz.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.bean.home.ChoiceBean;

/**
 * Created by Administrator on 2016/11/17 0017.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>{
    private List<ChoiceBean.DataBean.PostsBean> posts;
    private Context mContext;
    private LayoutInflater mInflater;

    public MyRecyclerAdapter(List<ChoiceBean.DataBean.PostsBean> posts, Context mContext) {
        this.posts = posts;
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_fragment_choice, parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(mContext).load(posts.get(position).getAuther().getIcon()).into(holder.img_choice);
        Glide.with(mContext).load(posts.get(position).getThumbnailMedias().get(0).getUrl()).into(holder.img_url);
        holder.tv_username.setText(posts.get(position).getAuther().getName());
        holder.tv_userTime.setText(posts.get(position).getDate());
        holder.tv_kinds.setText(posts.get(position).getSpecialInfo().getDiscussionTitle());
        holder.tv_content.setText(posts.get(position).getContent());
        holder.tv_comment.setText(posts.get(position).getCommentCount());
        holder.tv_hot.setText(posts.get(position).getHotNum());
        holder.tv_like.setText(posts.get(position).getLikeNum());

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img_choice,img_url;
        TextView tv_username,tv_userTime,tv_kinds,tv_content,tv_comment,tv_hot,tv_like;
        public MyViewHolder(View view) {
            super(view);
            img_choice= (ImageView) view.findViewById(R.id.item_choice_imageview);
            img_url = (ImageView) view.findViewById(R.id.item_choice_iv_url);
            tv_username = (TextView) view.findViewById(R.id.item_choice_tv_username);
            tv_userTime = (TextView) view.findViewById(R.id.item_choice_tv_usertime);
            tv_kinds = (TextView) view.findViewById(R.id.item_choice_tv_kinds);
            tv_content = (TextView) view.findViewById(R.id.item_choice_tv_content);
            tv_comment = (TextView) view.findViewById(R.id.item_choice_tv_comment);
            tv_hot = (TextView) view.findViewById(R.id.item_choice_tv_hot);
            tv_like = (TextView) view.findViewById(R.id.item_choice_tv_like);

        }

    }

}
