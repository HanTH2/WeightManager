package jp.premama.weightmanage.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import jp.premama.weightmanage.R;
import jp.premama.weightmanage.base.BaseFragmentActivity;
import jp.premama.weightmanage.constant.Constants;
import jp.premama.weightmanage.fragment.AdviceFragment;
import jp.premama.weightmanage.fragment.tab_menu.BabyConditionFragment;
import jp.premama.weightmanage.fragment.tab_menu.BirthDayFragment;
import jp.premama.weightmanage.fragment.tab_menu.ChartFragment;
import jp.premama.weightmanage.fragment.ExperienceFragment;
import jp.premama.weightmanage.listenners.BackPressListener;
import jp.premama.weightmanage.listenners.MainActivityListener;

/**
 * Created by HanTH2 on 8/25/2016.
 */
public class ManageWeightActivity extends BaseFragmentActivity implements View.OnClickListener, MainActivityListener {
    private RadioButton mBtnBabyCondition, mBtnBirthDay, mBtnChart;
    private RadioGroup mLayoutFooter;
    private Constants.TAG_TYPE_MENU mCurrentTab = Constants.TAG_TYPE_MENU.TAG_NONE;
    private Constants.TAG_TYPE_DETAIL mCurrentTabDetail = Constants.TAG_TYPE_DETAIL.TAG_NONE;
    private TextView mTvToolTitleBar;
    private RelativeLayout mRlActionBar;

    @Override
    protected Fragment onCreateMainFragment(Bundle savedInstancesState) {
        mCurrentTab = Constants.TAG_TYPE_MENU.TAG_BABY_CONDITION;
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
        initData();
    }

    private void initView() {
        mBtnBabyCondition = (RadioButton) findViewById(R.id.btn_baby_condition);
        mBtnBirthDay = (RadioButton) findViewById(R.id.btn_birth_day);
        mBtnChart = (RadioButton) findViewById(R.id.btn_chart);
        mLayoutFooter = (RadioGroup) findViewById(R.id.layoutFooter);
        mTvToolTitleBar = (TextView) findViewById(R.id.tv_top_bar_title);
        mRlActionBar = (RelativeLayout)findViewById(R.id.toolbar);

//        setSupportActionBar(mToolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        mToolbar.setTitleTextColor(Color.WHITE);
//        mToolbar.setSubtitleTextColor(Color.WHITE);
        mBtnBabyCondition.setOnClickListener(this);
        mBtnBirthDay.setOnClickListener(this);
        mBtnChart.setOnClickListener(this);
    }

    private void initData(){
        if (mRlActionBar.getVisibility() == View.GONE){
            mRlActionBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_baby_condition:
                if (mCurrentTab != Constants.TAG_TYPE_MENU.TAG_BABY_CONDITION){
                    if (mCurrentTabDetail == Constants.TAG_TYPE_DETAIL.TAG_ADVICE){
                        showAdviceFragment();
                    }else if (mCurrentTabDetail == Constants.TAG_TYPE_DETAIL.TAG_EXPERIENCE){
                        showExperienceFragment();
                    }else {
                        BabyConditionFragment babyConditionFragment = BabyConditionFragment.newInstance();
                        showFragmentWithClearStack(babyConditionFragment);
                        mCurrentTab = Constants.TAG_TYPE_MENU.TAG_BABY_CONDITION;
                    }
                }
                break;
            case R.id.btn_birth_day:
                if (mCurrentTab != Constants.TAG_TYPE_MENU.TAG_BIRTH_DATE) {
                    BirthDayFragment birthDayFragment = BirthDayFragment.newInstance();
                    showFragmentWithClearStack(birthDayFragment);
                    mCurrentTab = Constants.TAG_TYPE_MENU.TAG_BIRTH_DATE;
                }
                break;
            case R.id.btn_chart:
                if (mCurrentTab != Constants.TAG_TYPE_MENU.TAG_CHART) {
                    ChartFragment chartFragment = ChartFragment.newInstance();
                    showFragmentWithClearStack(chartFragment);
                    mCurrentTab = Constants.TAG_TYPE_MENU.TAG_CHART;
                }
                break;
            default:
                break;
        }
    }

    private static final long EXIT_INTERVAL = 2000L;
    private long exitTimer = Long.MIN_VALUE;
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0){
            FragmentManager fm = getSupportFragmentManager();
            if (mFragmentTagStack.size() > 0){
                Fragment f = fm.findFragmentByTag(mFragmentTagStack.peek());
                if (f instanceof BackPressListener){
                    if (((BackPressListener)f).onBackPress()){
                        return true;
                    }
                }
            }
            boolean tryFinish = false;
            if (mFragmentTagStack.size() == 1){
                tryFinish = true;
            }

            if (tryFinish){
                if ((exitTimer + EXIT_INTERVAL) < System.currentTimeMillis()){
                    //Toast.makeText(this, "Tap back button again to exit app", Toast.LENGTH_SHORT).show();
                    exitTimer = System.currentTimeMillis();
                }else {
                    finish();
                }
                return true;
            }else {
                return super.dispatchKeyEvent(event);
            }
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    public void showFooterLayout() {
        mLayoutFooter.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideFooterLayout() {
        mLayoutFooter.setVisibility(View.GONE);
    }

    @Override
    public void exitMain() {
        this.finish();
    }

    @Override
    public void removeTopFragmentContext() {
        getFragmentManager().popBackStack();
        mFragmentTagStack.pop();
    }

    @Override
    public void hideTopBarLayout() {
        mRlActionBar.setVisibility(View.GONE);
    }

    @Override
    public void displayTitleTopBar(String title) {
        mTvToolTitleBar.setText(title);
    }

    @Override
    public void showAdviceFragment() {
        AdviceFragment adviceFragment = AdviceFragment.newInstance();
        //showFragmentWithClearStack(adviceFragment);
        showFragment(adviceFragment);
        mCurrentTabDetail = Constants.TAG_TYPE_DETAIL.TAG_ADVICE;
    }

    @Override
    public void showExperienceFragment() {
        ExperienceFragment experienceFragment = ExperienceFragment.newInstance();
        showFragment(experienceFragment);
        //showFragmentWithClearStack(experienceFragment);
        mCurrentTabDetail = Constants.TAG_TYPE_DETAIL.TAG_EXPERIENCE;
    }
}
