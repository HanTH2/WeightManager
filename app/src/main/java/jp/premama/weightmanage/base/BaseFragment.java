package jp.premama.weightmanage.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import jp.premama.weightmanage.listenners.MainActivityListener;

/**
 * Created by HanTH2 on 8/19/2016.
 */
abstract public class BaseFragment extends Fragment {
    protected MainActivityListener mMainActivityListener;
    protected Activity mCurrentActivity;
    protected Context mContext;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCurrentActivity = getActivity();
        mMainActivityListener = (MainActivityListener)activity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (!hasFooterLayout()){

        }
    }

    abstract protected void initView(View view);

    abstract protected boolean hasFooterLayout();


}
