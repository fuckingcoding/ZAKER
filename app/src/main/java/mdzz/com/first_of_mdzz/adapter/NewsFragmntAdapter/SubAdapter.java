package mdzz.com.first_of_mdzz.adapter.NewsFragmntAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.bean.subscibe.FashionBean;
import mdzz.com.first_of_mdzz.utils.RecyclerViewAdapterHelper;

import static android.content.ContentValues.TAG;


/**
 * Created by apple on 16/11/17.
 * Eemil:635727195@qq.com
 */

public class SubAdapter extends RecyclerViewAdapterHelper<FashionBean.DataBean.ArticlesBean> {
    public interface IOnItemClickListener{
        void onclick(int position);
    }
    private Context context;
    private String url;
    private String  mCurPage;
    private IOnItemClickListener itemClickListener;
    public SubAdapter(Context context, List<FashionBean.DataBean.ArticlesBean> list, IOnItemClickListener itemClickListener) {
        super(context, list);
        this.context=context;
        this.itemClickListener=itemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType) {

        View view=mInflater.inflate(R.layout.item_recycleview_sub,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder holder, final int position) {

       // List<FashionBean.DataBean.ArticlesBean> articles =mList.get(position).get
        if(mList.get(position).getTitle()!=null&&mList.get(position).getAuther_name()!=null){
            if(holder instanceof ViewHolder){
                ((ViewHolder) holder).textView_sub_title.setText(mList.get(position).getTitle());
                ((ViewHolder) holder).textView_sub_author.setText(mList.get(position).getAuther_name());
                url=mList.get(0).getThumbnail_pic();
                mCurPage=mList.get(position).getPage();
                Log.i(TAG, "onBindMyViewHolder: "+url);
//                Glide.with(context).load(url)
//                        .placeholder(R.mipmap.ic_launcher)//设置站位图
//                        .error (R.mipmap.ic_launcher)//加载失败的图片
//                        .centerCrop()//拉伸属性
//                        .into(((ViewHolder) holder).imageView_sub);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemClickListener.onclick(position);
                    }
                });
           }
        }



    }
    class ViewHolder extends RecyclerView.ViewHolder{
      private TextView textView_sub_title,textView_sub_author;

        public ViewHolder(View itemView) {
            super(itemView);
            textView_sub_title=(TextView)itemView.findViewById(R.id.textview_subrecyleview_title);
            textView_sub_author=(TextView)itemView.findViewById(R.id.textview_subrecycleview_author);

        }

    }
}
