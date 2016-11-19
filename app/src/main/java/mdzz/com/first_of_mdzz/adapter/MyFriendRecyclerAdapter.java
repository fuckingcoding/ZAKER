package mdzz.com.first_of_mdzz.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.bean.home.FriendBean;
import mdzz.com.first_of_mdzz.utils.BitmapCircleTransformation;

/**
 * Created by Administrator on 2016/11/17 0017.
 */

public class MyFriendRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<FriendBean.DataBean.ListBean> friendlist;
    private Context mContext;
    private LayoutInflater layoutInflater;
    public static final int TYPE1 = 0;
    public static final int TYPE2 = 1;
    public static final int TYPE3 = 2;
    public static final int TYPE4 = 3;
    public static final int TYPE5 = 4;

    @Override
    public int getItemViewType(int position) {

        int size = friendlist.get(position).getMedias().size();
        if (size == 0) {
            return TYPE1;
        } else if (size == 2) {
            return TYPE2;
        } else if(size==1){
            return TYPE3;
        }else if(size>=3){
            return TYPE4;
        }else{
            return TYPE5;
        }

    }

    public MyFriendRecyclerAdapter(List<FriendBean.DataBean.ListBean> friendlist, Context mContext) {
        this.friendlist = friendlist;
        this.mContext = mContext;
        layoutInflater =LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType){
            case TYPE1:
                view=layoutInflater.inflate(R.layout.item_fragment_frined_pictxt,parent,false);
                return new ViewHolder1(view);
            case TYPE2:
                view=layoutInflater.inflate(R.layout.item_fragment_friend_pictwo, parent, false);
                return new ViewHolder2(view);
            case TYPE4:
                view = layoutInflater.inflate(R.layout.item_fragment_picthree, parent, false);
                return new ViewHolder3(view);
            case TYPE3:
                view = layoutInflater.inflate(R.layout.item_fragment_friend_picone,parent,false);
                return new ViewHolder4(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof ViewHolder1){
            FriendBean.DataBean.ListBean.QuoteBean quote = friendlist.get(position).getQuote();
            if(quote!=null){
                if(friendlist.get(position).getQuote().getMedias().size()!=0) {
                    Glide.with(mContext).load(friendlist.get(position).getQuote().getMedias().get(0).getUrl()).into(((ViewHolder1) holder).iv_url);
                }else{
                    ((ViewHolder1) holder).iv_url.setImageResource(R.mipmap.ic_launcher);
                }
                ((ViewHolder1)holder).tv_title.setText(friendlist.get(position).getQuote().getContent());
                Glide.with(mContext).load(friendlist.get(position).getAuther().getIcon()).transform(new BitmapCircleTransformation(mContext)).into(((ViewHolder1)holder).iv_head);
                Glide.with(mContext).load(friendlist.get(position).getAuther().getUserFlag().get(0).getPic()).into(((ViewHolder1)holder).iv_userflag);
                ((ViewHolder1)holder).tv_username.setText(friendlist.get(position).getAuther().getName());
                ((ViewHolder1)holder).tv_usertime.setText(friendlist.get(position).getDate());
                ((ViewHolder1)holder).tv_text.setText(friendlist.get(position).getActionText());
                ((ViewHolder1)holder).tv_content.setText(friendlist.get(position).getContent());
            }else{
                position++;
            }


        }else if(holder instanceof ViewHolder2){
            Glide.with(mContext).load(friendlist.get(position).getAuther().getIcon()).transform(new BitmapCircleTransformation(mContext)).into(((ViewHolder2)holder).iv_head_two);
            Glide.with(mContext).load(friendlist.get(position).getAuther().getUserFlag().get(0).getPic()).into(((ViewHolder2)holder).iv_userflag_two);
            Glide.with(mContext).load(friendlist.get(position).getOpenInfo().getPost().getMedias().get(0).getUrl()).into(((ViewHolder2)holder).iv_url_two);
            Glide.with(mContext).load(friendlist.get(position).getOpenInfo().getPost().getMedias().get(1).getUrl()).into(((ViewHolder2)holder).iv_url_second_two);
            ((ViewHolder2)holder).tv_username_two.setText(friendlist.get(position).getAuther().getName());
            ((ViewHolder2)holder).tv_usertime_two.setText(friendlist.get(position).getDate());
            ((ViewHolder2)holder).tv_text_two.setText(friendlist.get(position).getActionText());
            ((ViewHolder2)holder).tv_content_two.setText(friendlist.get(position).getContent());
        }else if(holder instanceof ViewHolder3){
            Glide.with(mContext).load(friendlist.get(position).getAuther().getIcon()).transform(new BitmapCircleTransformation(mContext)).into(((ViewHolder3)holder).iv_head_three);
            Glide.with(mContext).load(friendlist.get(position).getAuther().getUserFlag().get(0).getPic()).into(((ViewHolder3)holder).iv_userflag_three);
            Glide.with(mContext).load(friendlist.get(position).getOpenInfo().getPost().getMedias().get(0).getUrl()).into(((ViewHolder3)holder).iv_url_three);
            Glide.with(mContext).load(friendlist.get(position).getOpenInfo().getPost().getMedias().get(1).getUrl()).into(((ViewHolder3)holder).iv_url_second_three);
            Glide.with(mContext).load(friendlist.get(position).getOpenInfo().getPost().getMedias().get(2).getUrl()).into(((ViewHolder3)holder).iv_url_third_three);
            ((ViewHolder3)holder).tv_username_three.setText(friendlist.get(position).getAuther().getName());
            ((ViewHolder3)holder).tv_usertime_three.setText(friendlist.get(position).getDate());
            ((ViewHolder3)holder).tv_text_three.setText(friendlist.get(position).getActionText());
            ((ViewHolder3)holder).tv_content_three.setText(friendlist.get(position).getContent());



        }else if(holder instanceof ViewHolder4){
            Glide.with(mContext).load(friendlist.get(position).getAuther().getIcon()).transform(new BitmapCircleTransformation(mContext)).into(((ViewHolder4)holder).iv_head_new);
            Glide.with(mContext).load(friendlist.get(position).getAuther().getUserFlag().get(0).getPic()).into(((ViewHolder4)holder).iv_userflag_new);
            Glide.with(mContext).load(friendlist.get(position).getOpenInfo().getPost().getMedias().get(0).getUrl()).into(((ViewHolder4)holder).iv_url_new);
            ((ViewHolder4)holder).tv_username_new.setText(friendlist.get(position).getAuther().getName());
            ((ViewHolder4)holder).tv_usertime_new.setText(friendlist.get(position).getDate());
            ((ViewHolder4)holder).tv_text_new.setText(friendlist.get(position).getActionText());
            ((ViewHolder4)holder).tv_content_new.setText(friendlist.get(position).getContent());
        }

    }

    @Override
    public int getItemCount() {
        return friendlist.size();
    }
    class ViewHolder1 extends RecyclerView.ViewHolder{
        ImageView iv_head,iv_userflag,iv_url;
        TextView tv_username,tv_usertime,tv_text,tv_content,tv_title;
        public ViewHolder1(View itemView) {
            super(itemView);
            iv_head= (ImageView) itemView.findViewById(R.id.item_friend_head);
            iv_userflag= (ImageView) itemView.findViewById(R.id.item_friend_iv_userflag);
            iv_url = (ImageView) itemView.findViewById(R.id.item_friend_iv_url);
            tv_username = (TextView) itemView.findViewById(R.id.item_friend_tv_username);
            tv_usertime = (TextView) itemView.findViewById(R.id.item_friend_tv_usertime);
            tv_text = (TextView) itemView.findViewById(R.id.item_friend_tv_text);
            tv_content = (TextView) itemView.findViewById(R.id.item_friend_tv_content);
            tv_title = (TextView) itemView.findViewById(R.id.item_friend_tv_title);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder{
        ImageView iv_head_two,iv_userflag_two,iv_url_two,iv_url_second_two;
        TextView tv_username_two,tv_usertime_two,tv_text_two,tv_content_two;

        public ViewHolder2(View itemView) {
            super(itemView);
            iv_head_two= (ImageView) itemView.findViewById(R.id.item_friend_head_pictwo);
            iv_userflag_two = (ImageView) itemView.findViewById(R.id.item_friend_iv_userflag_pictwo);
            iv_url_two = (ImageView) itemView.findViewById(R.id.item_friend_iv_url_pictwo_one);
            iv_url_second_two = (ImageView) itemView.findViewById(R.id.item_friend_iv_url_pictwo_two);
            tv_username_two = (TextView) itemView.findViewById(R.id.item_friend_tv_username_pictwo);
            tv_usertime_two = (TextView) itemView.findViewById(R.id.item_friend_tv_usertime_two);
            tv_text_two = (TextView) itemView.findViewById(R.id.item_friend_tv_text_two);
            tv_content_two = (TextView) itemView.findViewById(R.id.item_friend_tv_content_pictwo);
        }
    }
    class ViewHolder3 extends RecyclerView.ViewHolder{
        ImageView iv_head_three,iv_userflag_three,iv_url_three,iv_url_second_three,iv_url_third_three;
        TextView tv_username_three,tv_usertime_three,tv_text_three,tv_content_three;

        public ViewHolder3(View itemView) {
            super(itemView);
            iv_head_three = (ImageView) itemView.findViewById(R.id.item_friend_head_picthree);
            iv_userflag_three = (ImageView) itemView.findViewById(R.id.item_friend_iv_userflag_picthree);
            iv_url_three = (ImageView) itemView.findViewById(R.id.item_friend_iv_url_picthree_one);
            iv_url_second_three = (ImageView) itemView.findViewById(R.id.item_friend_iv_url_picthree_two);
            iv_url_third_three = (ImageView) itemView.findViewById(R.id.item_friend_iv_url_picthree_three);
            tv_username_three = (TextView) itemView.findViewById(R.id.item_friend_tv_username_picthree);
            tv_usertime_three = (TextView) itemView.findViewById(R.id.item_friend_tv_usertime_three);
            tv_text_three = (TextView) itemView.findViewById(R.id.item_friend_tv_text_three);
            tv_content_three = (TextView) itemView.findViewById(R.id.item_friend_tv_content_picthree);

        }
    }
    class ViewHolder4 extends RecyclerView.ViewHolder{
        ImageView iv_head_new,iv_userflag_new,iv_url_new;
        TextView  tv_username_new,tv_usertime_new,tv_text_new,tv_content_new;

        public ViewHolder4(View itemView) {
            super(itemView);
            iv_head_new = (ImageView) itemView.findViewById(R.id.item_friend_iv_new_head);
            iv_userflag_new = (ImageView) itemView.findViewById(R.id.item_friend_iv_new_userflag);
            iv_url_new = (ImageView) itemView.findViewById(R.id.item_friend_iv_new_url);
            tv_username_new = (TextView) itemView.findViewById(R.id.item_friend_tv_new_username);
            tv_usertime_new = (TextView) itemView.findViewById(R.id.item_friend_tv_new_usertime);
            tv_text_new = (TextView) itemView.findViewById(R.id.item_friend_tv_new_text);
            tv_content_new = (TextView) itemView.findViewById(R.id.item_friend_tv_new_content);
        }
    }
}
