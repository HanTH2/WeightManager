package jp.premama.weightmanage.listenners;

/**
 * Created by HanTH2 on 8/19/2016.
 */
public interface MainActivityListener {

    void showFooterLayout();

    void hideFooterLayout();

    void showAdviceFragment();

    void showExperienceFragment();

    void exitMain();

    void removeTopFragmentContext();

    void displayTitleTopBar(String title);

    void hideTopBarLayout();
}
