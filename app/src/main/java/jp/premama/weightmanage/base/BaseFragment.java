package jp.premama.weightmanage.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import jp.premama.weightmanage.activity.MainActivity;
import jp.premama.weightmanage.activity.ManageWeightActivity;
import jp.premama.weightmanage.listenners.MainActivityListener;

/**
 * Created by HanTH2 on 8/19/2016.
 */
abstract public class BaseFragment extends Fragment {
    protected MainActivityListener mMainActivityListener;
    protected Activity mCurrentActivity;
    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCurrentActivity = getActivity();
        if (context instanceof Activity){
            mMainActivityListener = (MainActivityListener)context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
        if (mCurrentActivity instanceof ManageWeightActivity) {
            if (hasFooterLayout()) {
                mMainActivityListener.showFooterLayout();
            } else {
                mMainActivityListener.hideFooterLayout();
            }
        } else if (mCurrentActivity instanceof MainActivity) {
            // do something
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mCurrentActivity instanceof ManageWeightActivity) {
            if (!hasFooterLayout()) {
                mMainActivityListener.showFooterLayout();
            } else {
                mMainActivityListener.hideFooterLayout();
            }
            mMainActivityListener = null;
        } else if (mCurrentActivity instanceof MainActivity) {
            mMainActivityListener = null;
        }
    }

    abstract protected void initView(View view);

    abstract protected void initData();

    abstract protected boolean hasFooterLayout();


}
