package mdzz.com.first_of_mdzz.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.ui.fragment.drag.DragHolderCallBack;
import mdzz.com.first_of_mdzz.ui.fragment.drag.RecycleCallBack;


/**
 * Author: zhuwt
 * Date: 2016/6/21 18:07
 * Description: 说明
 * PackageName: com.ancun.autopack.ProjectAdapter
 * Copyright: 杭州存网络科技有限公司
 **/
public class DragAdapter extends RecyclerView.Adapter<DragAdapter.DragHolder> {

    private List<String> list;

    private RecycleCallBack mRecycleClick;
    public SparseArray<Integer> show = new SparseArray<>();
    private Context mContext;
    public DragAdapter(RecycleCallBack click, List<String> data,Context mContext) {
        this.list = data;
        this.mRecycleClick = click;
        mContext=this.mContext;
    }

    public void setData(List<String> data) {
        this.list = data;
    }

    @Override
    public DragHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.project_item, parent, false);
        return new DragHolder(view, mRecycleClick);
    }

    @Override
    public void onBindViewHolder(final DragHolder holder, final int position) {
        holder.text.setText(list.get(position));
        switch(holder.text.getText().toString()){
            case "时尚频道":
                holder.icon.setImageResource(R.mipmap.ic_fasion);
                break;
            case "国内头条":
                holder.icon.setImageResource(R.mipmap.ic_inland_news);
                break;
            case "国际头条":
                holder.icon.setImageResource(R.mipmap.ic_international_news);
                break;
            case "娱乐八卦":
                holder.icon.setImageResource(R.mipmap.ic_bagua);
                break;
            case "汽车频道":
                holder.icon.setImageResource(R.mipmap.ic_car);
                break;
            case "财经新闻":
                holder.icon.setImageResource(R.mipmap.ic_money);
                break;
            case "体育频道":
                holder.icon.setImageResource(R.mipmap.ic_sports);
                break;
            case "互联网":
                holder.icon.setImageResource(R.mipmap.ic_internet);
                break;
            case "电影资讯":
                holder.icon.setImageResource(R.mipmap.ic_movie);
                break;
            default:
        }
       // if (null == show.get(position))
           // holder.del.setVisibility(View.INVISIBLE);
       // else
           // holder.del.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class DragHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener, DragHolderCallBack {

        public TextView text;
        public ImageView del,icon;
        public RelativeLayout item;
        private RecycleCallBack mClick;

        public DragHolder(View itemView, RecycleCallBack click) {
            super(itemView);
            mClick = click;
            item = (RelativeLayout) itemView.findViewById(R.id.item);
            text = (TextView) itemView.findViewById(R.id.text);
            del = (ImageView) itemView.findViewById(R.id.del);
            icon=(ImageView)itemView.findViewById(R.id.icon);
            item.setOnClickListener(this);
            //del.setOnClickListener(this);

        }

        @Override
        public void onSelect() {
            show.clear();
            show.put(getAdapterPosition(), getAdapterPosition());
            itemView.setBackgroundColor(Color.LTGRAY);
           //del.setVisibility(View.VISIBLE);
        }

        @Override
        public void onClear() {
            itemView.setBackgroundResource(R.drawable.right_bottom_view);

            notifyDataSetChanged();
        }

        @Override
        public void onClick(View v) {
            if (null != mClick) {
                show.clear();
                mClick.itemOnClick(getAdapterPosition(), v);
            }
        }
    }
}
