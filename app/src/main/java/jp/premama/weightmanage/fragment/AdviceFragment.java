package jp.premama.weightmanage.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import jp.premama.weightmanage.R;
import jp.premama.weightmanage.base.BaseFragment;

/**
 * Created by HanTH2 on 8/25/2016.
 */
public class AdviceFragment extends BaseFragment {
    public static AdviceFragment instance;
    private FrameLayout mFrTopBarBack;

    public static AdviceFragment newInstance(){
        if (instance == null){
            instance = new AdviceFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_advice, container, false);
        initView(view);
        initData();
        return view;
    }

    @Override
    protected void initView(View view) {
        mFrTopBarBack = (FrameLayout)view.findViewById(R.id.fr_top_bar_back);
    }

    @Override
    protected void initData() {
        mMainActivityListener.hideTopBarLayout();
        mFrTopBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
                mMainActivityListener.showFooterLayout();
            }
        });
    }

    @Override
    protected boolean hasFooterLayout() {
        return true;
    }
}
