package mdzz.com.first_of_mdzz.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.bean.fun.BannerBean;
import mdzz.com.first_of_mdzz.bean.fun.ItemsBean;
import mdzz.com.first_of_mdzz.utils.RecyclerViewAdapterHelper;

/**
 * Created by acer on 2016/11/17.
 */

public class FunRecyclerAdapter extends RecyclerViewAdapterHelper<Object> {
  private  FunOnClickListener listener ;
    public FunRecyclerAdapter(Context context, List list,FunOnClickListener listener) {
        super(context, list);
        this.listener = listener;

    }
    public interface  FunOnClickListener{
        void OnClick(int position);
    }

    @Override
    public int getItemViewType(int position) {
        Log.e("TAG", "getItemViewType: "+mList.size());
        if(mList.get(position) instanceof BannerBean){
            return  0;
        }else {
            return 1;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType) {
        View view =null;
        if(viewType==1){
             view = mInflater.inflate(R.layout.layout_item_recycler_fun, parent, false);
            Log.e("TAGGG", "onCreateMyViewHolder: " );
            return  new MyViewHolder1(view);
        }else {
             view  = mInflater.inflate(R.layout.layout_item2_recycler_fun,parent,false);
            return new MyViewHolder2(view);
        }
    }
    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if(holder instanceof  MyViewHolder1){
            String m_url = ((ItemsBean) mList.get(position)).getPic().getUrl();
            String title = ((ItemsBean) mList.get(position)).getTitle();
            String content = ((ItemsBean) mList.get(position)).getContent();

            ImageView iv_item_fun1 = ((MyViewHolder1) holder).iv_item_fun1;
            ((MyViewHolder1) holder).tv_item_fun1.setText(title);
            ((MyViewHolder1) holder).tv_item_fun2.setText(content);
            Glide.with(mContext).load(m_url)
                    .asBitmap()
                    .error(R.mipmap.ic_load_error)
                    .placeholder(R.mipmap.ic_mdzz)
                    .dontAnimate()
                    .into(iv_item_fun1);

            ((MyViewHolder1) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnClick(position);
                }
            });
        }else{
            String m_url = ((BannerBean) mList.get(position)).getUrl();

            ImageView iv_item_fun2 = ((MyViewHolder2) holder).iv_item_fun2;
            Glide.with(mContext).load(m_url).fitCenter().into(iv_item_fun2);

        }

    }

    class MyViewHolder1 extends RecyclerView.ViewHolder{
        ImageView iv_item_fun1;
        TextView tv_item_fun1,tv_item_fun2;
        public MyViewHolder1(View itemView) {
            super(itemView);
            iv_item_fun1 = (ImageView) itemView.findViewById(R.id.iv_recycler_item1);
            tv_item_fun1 = (TextView) itemView.findViewById(R.id.tv1_item_fun);
            tv_item_fun2 = (TextView) itemView.findViewById(R.id.tv2_item_fun);
        }
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder{
         ImageView iv_item_fun2 ;
        public MyViewHolder2(View itemView) {
            super(itemView);
            iv_item_fun2 = (ImageView) itemView.findViewById(R.id.iv_recycler_item2);
        }
    }
}
