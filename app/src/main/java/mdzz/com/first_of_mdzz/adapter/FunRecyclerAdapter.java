package mdzz.com.first_of_mdzz.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileDescriptor;
import java.util.List;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.bean.fun.BannerBean;
import mdzz.com.first_of_mdzz.utils.RecyclerViewAdapterHelper;

/**
 * Created by acer on 2016/11/17.
 */

public class FunRecyclerAdapter<Object> extends RecyclerViewAdapterHelper {



    public FunRecyclerAdapter(Context context, List list) {
        super(context, list);
    }


    @Override
    public int getItemViewType(int position) {
        java.lang.Object object = mList.get(position);
        if(object instanceof BannerBean){
            return  0;
        }else {
            return 1;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType) {

        if(viewType==1){
            View view = mInflater.inflate(R.layout.layout_item_recycler_fun, parent, false);
            return  new MyViewHolder1(view);
        }else {
            View view  = mInflater.inflate(R.layout.layout_item2_recycler_fun,parent,false);
            return new MyViewHolder2(view);
        }

    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder holder, int position) {

    }


    class MyViewHolder1 extends RecyclerView.ViewHolder{
        ImageView iv_item_fun1;
        //TextView tv_item
        public MyViewHolder1(View itemView) {
            super(itemView);
            iv_item_fun1 = (ImageView) itemView.findViewById(R.id.iv_recycler_item1);
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
