package jp.premama.weightmanage.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import jp.premama.weightmanage.R;
import jp.premama.weightmanage.base.BaseFragmentActivity;
import jp.premama.weightmanage.constant.Constants;
import jp.premama.weightmanage.fragment.AdviceFragment;
import jp.premama.weightmanage.fragment.BabyConditionFragment;
import jp.premama.weightmanage.fragment.BirthDayFragment;
import jp.premama.weightmanage.fragment.ChartFragment;
import jp.premama.weightmanage.fragment.ExperienceFragment;
import jp.premama.weightmanage.listenners.MainActivityListener;

/**
 * Created by HanTH2 on 8/25/2016.
 */
public class ManageWeightActivity extends BaseFragmentActivity implements View.OnClickListener, MainActivityListener {
    private RadioButton mBtnBabyCondition, mBtnBirthDay, mBtnChart;
    private RadioGroup mLayoutFooter;
    private Constants.TAG_TYPE mCurrentTab = Constants.TAG_TYPE.TAG_NONE;
    private Toolbar mToolbar;

    @Override
    protected Fragment onCreateMainFragment(Bundle savedInstancesState) {
        mCurrentTab = Constants.TAG_TYPE.TAG_BABY_CONDITION;
        return BabyConditionFragment.newInstance();
    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.layoutContent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_manage);
        initView();
    }

    private void initView() {
        mBtnBabyCondition = (RadioButton) findViewById(R.id.btn_baby_condition);
        mBtnBirthDay = (RadioButton) findViewById(R.id.btn_birth_day);
        mBtnChart = (RadioButton) findViewById(R.id.btn_chart);
        mLayoutFooter = (RadioGroup) findViewById(R.id.layoutFooter);
        mToolbar = (Toolbar)findViewById(R.id.toolbar);

        //setSupportActionBar(mToolbar);
        //mToolbar.setTitleTextColor(Color.WHITE);
        //mToolbar.setSubtitleTextColor(Color.WHITE);
        mBtnBabyCondition.setOnClickListener(this);
        mBtnBirthDay.setOnClickListener(this);
        mBtnChart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_baby_condition:
                BabyConditionFragment babyConditionFragment = BabyConditionFragment.newInstance();
                showFragmentWithClearStack(babyConditionFragment);
                mCurrentTab = Constants.TAG_TYPE.TAG_BABY_CONDITION;
                break;
            case R.id.btn_chart:
                BirthDayFragment birthDayFragment = BirthDayFragment.newInstance();
                showFragmentWithClearStack(birthDayFragment);
                mCurrentTab = Constants.TAG_TYPE.TAG_BIRTH_DATE;
                break;
            case R.id.btn_birth_day:
                ChartFragment chartFragment = ChartFragment.newInstance();
                showFragmentWithClearStack(chartFragment);
                mCurrentTab = Constants.TAG_TYPE.TAG_CHART;
                break;
            case R.id.btn_advice:
                AdviceFragment adviceFragment = AdviceFragment.newInstance();
                showFragment(adviceFragment);
                hideFooterLayout();
                //mCurrentTab = Constants.TAG_TYPE.TAG_ADVICE;
                break;
            case R.id.btn_experience:
                ExperienceFragment experienceFragment = ExperienceFragment.newInstance();
                showFragment(experienceFragment);
                hideFooterLayout();
                //mCurrentTab = Constants.TAG_TYPE.TAG_EXPERIENCE;
            default:
                break;
        }
    }

    @Override
    public void showFooterLayout() {
        mLayoutFooter.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideFooterLayout() {
        mLayoutFooter.setVisibility(View.GONE);
    }
}
