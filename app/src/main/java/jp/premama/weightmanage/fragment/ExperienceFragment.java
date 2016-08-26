package jp.premama.weightmanage.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.premama.weightmanage.R;
import jp.premama.weightmanage.base.BaseFragment;

/**
 * Created by HanTH2 on 8/25/2016.
 */
public class ExperienceFragment extends BaseFragment {
    public static ExperienceFragment instance;

    public static ExperienceFragment newInstance(){
        if (instance == null){
            instance = new ExperienceFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_experience, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected boolean hasFooterLayout() {
        return true;
    }
}
