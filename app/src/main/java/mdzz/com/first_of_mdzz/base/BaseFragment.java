package mdzz.com.first_of_mdzz.base;

import android.app.Fragment;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import mdzz.com.first_of_mdzz.R;

/**
 * Created by acer on 2016/11/15.
 */

public class BaseFragment extends Fragment{
    private Toolbar toolbar;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }


    void  initToolBar(View rootView,@IdRes int id ,String title,boolean hasDisplayHome){
        toolbar = (Toolbar) rootView.findViewById(id);
        setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle(title);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();

        if(hasDisplayHome){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }
}
