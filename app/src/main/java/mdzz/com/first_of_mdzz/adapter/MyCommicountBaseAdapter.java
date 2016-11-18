package mdzz.com.first_of_mdzz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.bean.home.TopicBean;


/**
 * Created by Administrator on 2016/11/16 0016.
 */

public class MyCommicountBaseAdapter extends BaseAdapter {
    private List<TopicBean.DataBean.ListBean> mlist;
    private Context mContext;

    public MyCommicountBaseAdapter(List<TopicBean.DataBean.ListBean> mlist, Context mContext) {
        this.mlist = mlist;
        this.mContext = mContext;
        mInflater=LayoutInflater.from(mContext);
    }

    private LayoutInflater mInflater = null;
    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int i) {
        return mlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            holder = new ViewHolder();
            view = mInflater.inflate(R.layout.item_fragment_topic,null);
            holder.img = (ImageView) view.findViewById(R.id.item_topic_imageview);
            holder.textView_title = (TextView) view.findViewById(R.id.item_topic_textview_title);
            holder.textView_stitle = (TextView) view.findViewById(R.id.item_topic_textview_stitle);
            view.setTag(holder);

        }else{
            holder = (ViewHolder) view.getTag();
        }
        Glide.with(mContext).load(mlist.get(i).getPic()).into(holder.img);
        holder.textView_title.setText(mlist.get(i).getTitle());
        holder.textView_stitle.setText(mlist.get(i).getStitle());
        return view;
    }
    class ViewHolder{
        public ImageView img;
        public TextView textView_title;
        public TextView textView_stitle;
    }
}
