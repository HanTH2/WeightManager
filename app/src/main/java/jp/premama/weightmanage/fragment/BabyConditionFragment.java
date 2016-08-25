package jp.premama.weightmanage.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import jp.premama.weightmanage.R;
import jp.premama.weightmanage.base.BaseFragment;

/**
 * Created by HanTH2 on 8/19/2016.
 */
public class BabyConditionFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = BabyConditionFragment.class.getSimpleName();
    private static BabyConditionFragment instance;
    private Button mBtnAdvice, mBtnExperience;

    public static BabyConditionFragment newInstance() {
        if (instance == null) {
            instance = new BabyConditionFragment();
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
        View view = inflater.inflate(R.layout.fragment_baby_condition, container, false);
        initView(view);
        return view;
    }

    private void initView(View view){
        mBtnAdvice = (Button)view.findViewById(R.id.btn_advice);
        mBtnExperience = (Button)view.findViewById(R.id.btn_experience);

        mBtnAdvice.setOnClickListener(this);
        mBtnExperience.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_advice:
                break;
            case R.id.btn_experience:
                break;
            default:
                break;
        }
    }
}
