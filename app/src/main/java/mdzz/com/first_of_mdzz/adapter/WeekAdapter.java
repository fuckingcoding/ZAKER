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
import mdzz.com.first_of_mdzz.bean.week.WeekendsBean;
import mdzz.com.first_of_mdzz.utils.RecyclerViewAdapterHelper;
import mdzz.com.first_of_mdzz.utils.ToastHelper;

/**
 * Created by acer on 2016/11/20.
 */

public class WeekAdapter extends RecyclerViewAdapterHelper<WeekendsBean> {
     private WeekRecyclerClickListener listener;
    public WeekAdapter(Context context, List<WeekendsBean> list,WeekRecyclerClickListener listener) {
        super(context, list);
        this.listener = listener;
    }


     public interface WeekRecyclerClickListener{
         void onWeekItemClick(int position);
     }
    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType) {

        View view  =mInflater.inflate(R.layout.layout_item_weekrecycler,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder holder, final int position) {

        String title = mList.get(position).getTitle();
        String s_title = mList.get(position).getS_title();

        String url = mList.get(position).getThumbnail_medias().get(0).getUrl();
        ((MyViewHolder)holder).tv_title.setText(title);
        ((MyViewHolder)holder).tv_content.setText(s_title);
        ImageView iv_item = ((MyViewHolder) holder).iv_item;
        Glide.with(mContext).load(url).into(iv_item);


        ((MyViewHolder)holder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onWeekItemClick(position);

            }
        });
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
       ImageView iv_item;
        TextView tv_title ,tv_content;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv_item = (ImageView) itemView.findViewById(R.id.iv_week);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title_week);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content_week);
        }
    }
}
