package jp.premama.weightmanage.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.premama.weightmanage.R;
import jp.premama.weightmanage.base.BaseFragment;

/**
 * Created by HanTH2 on 8/19/2016.
 */
public class ChartFragment extends BaseFragment {
    public static ChartFragment instance;

    public static ChartFragment newInstance(){
        if (instance == null){
            instance = new ChartFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart, container, false);
        return view;
    }
}
