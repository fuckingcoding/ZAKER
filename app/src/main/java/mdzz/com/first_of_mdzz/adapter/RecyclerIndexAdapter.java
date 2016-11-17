package mdzz.com.first_of_mdzz.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.List;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.bean.ItemBean;
import mdzz.com.first_of_mdzz.utils.BitmapCircleTransformation;
import mdzz.com.first_of_mdzz.utils.RecyclerViewAdapterHelper;

/**
 * Created by StevenWang on 16/10/28.
 */

public class RecyclerIndexAdapter extends RecyclerViewAdapterHelper<ItemBean> implements SectionIndexer {

    public RecyclerIndexAdapter(Context mContext, List<ItemBean> list) {
        super(mContext, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_recyclerview_position, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            int firstPosition = getPositionForSection(getSectionForPosition(position));
            if (firstPosition == position) {
                ((MyViewHolder) holder).textView_item_firstletter.setVisibility(View.VISIBLE);
                ((MyViewHolder) holder).textView_item_firstletter.setText(mList.get(position)
                        .getFirstLetter());
            } else {
                ((MyViewHolder) holder).textView_item_firstletter.setVisibility(View.GONE);
            }

            ((MyViewHolder) holder).textView_item_username.setText(mList.get(position)
                    .getUsername());

            Glide.with(mContext)
                    .load(mList.get(position).getIconUrl())
                    .transform(new BitmapCircleTransformation(mContext))
                    .into(((MyViewHolder) holder).imageView_item_icon);
        }
    }

    @Override
    public Object[] getSections() {
        return new Object[0];
    }

    @Override
    public int getSectionForPosition(int position) {
        return mList.get(position).getFirstLetter().charAt(0);
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        for (int i = 0; i < mList.size(); i++) {
            if (mList.get(i).getFirstLetter().charAt(0) == sectionIndex) {
                return i;
            }
        }
        return -1;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView_item_firstletter;
        private TextView textView_item_username;
        private ImageView imageView_item_icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView_item_firstletter = (TextView) itemView.findViewById(R.id
                    .textView_item_firstletter);
            textView_item_username = (TextView) itemView.findViewById(R.id.textView_item_username);
            imageView_item_icon = (ImageView) itemView.findViewById(R.id.imageView_item_icon);
        }
    }
}
