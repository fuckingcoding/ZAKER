package mdzz.com.first_of_mdzz.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.base.BaseFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class SubscriberFragment extends BaseFragment {


    public SubscriberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_subscriber, container, false);
    }

}
