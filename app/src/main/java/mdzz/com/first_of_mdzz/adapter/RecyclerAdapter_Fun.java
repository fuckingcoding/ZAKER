package mdzz.com.first_of_mdzz.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import mdzz.com.first_of_mdzz.utils.*;

/**
 * Created by acer on 2016/11/16.
 */

public class RecyclerAdapter_Fun<playbean> extends mdzz.com.first_of_mdzz.utils.RecyclerViewAdapterHelper{


    public RecyclerAdapter_Fun(Context context, List list) {
        super(context, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
}
