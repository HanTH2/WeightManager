package jp.premama.weightmanage.fragment.tab_menu;

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
public class BirthDayFragment extends BaseFragment {
    public static BirthDayFragment instance;

    public static BirthDayFragment newInstance(){
        if (instance == null){
            instance = new BirthDayFragment();
        }
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_birth_day, container, false);
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
