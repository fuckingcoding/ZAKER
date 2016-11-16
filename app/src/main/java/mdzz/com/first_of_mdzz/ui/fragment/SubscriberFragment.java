package mdzz.com.first_of_mdzz.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.adapter.DragAdapter;
import mdzz.com.first_of_mdzz.base.BaseFragment;
import mdzz.com.first_of_mdzz.ui.fragment.drag.DragItemCallBack;
import mdzz.com.first_of_mdzz.ui.fragment.drag.RecycleCallBack;


/**
 * A simple {@link Fragment} subclass.
 */
public class SubscriberFragment extends BaseFragment implements RecycleCallBack{


    private Context mContext;
    private RecyclerView mRecyclerView;
    private DragAdapter mAdapter;
    private ArrayList<String> mList;
    private ItemTouchHelper mItemTouchHelper;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext =context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_subscriber, container, false);

        mList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            mList.add("" + i);
        }
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycleview_subscriberfragment);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mAdapter = new DragAdapter(this, mList);
        mItemTouchHelper = new ItemTouchHelper(new DragItemCallBack(this));
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }
    @Override
    public void itemOnClick(int position, View view) {
        if (view.getId() == R.id.del) {
            mList.remove(position);
            mAdapter.setData(mList);
            mAdapter.notifyItemRemoved(position);
        } else {
            Toast.makeText(mContext, "当前点击的是" + position, Toast.LENGTH_SHORT).show();
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onMove(int from, int to) {
        synchronized (this) {
            if (from > to) {
                int count = from - to;
                for (int i = 0; i < count; i++) {
                    Collections.swap(mList, from - i, from - i - 1);
                }
            }
            if (from < to) {
                int count = to - from;
                for (int i = 0; i < count; i++) {
                    Collections.swap(mList, from + i, from + i + 1);
                }
            }
            mAdapter.setData(mList);
            mAdapter.notifyItemMoved(from, to);
            mAdapter.show.clear();
            mAdapter.show.put(to, to);
        }
    }
}
