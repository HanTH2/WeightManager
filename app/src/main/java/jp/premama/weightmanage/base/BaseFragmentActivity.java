package jp.premama.weightmanage.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.Stack;

/**
 * Created by HanTH2 on 8/19/2016.
 */
abstract public class BaseFragmentActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {
    protected final Stack<String> mFragmentTagStack = new Stack<>();

    abstract protected Fragment onCreateMainFragment(Bundle savedInstancesState);

    abstract protected int getFragmentContainerId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showFragment(onCreateMainFragment(null));
        getSupportFragmentManager().addOnBackStackChangedListener(this);
    }

    public void showFragmentWithClearStack(Fragment f){
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        mFragmentTagStack.clear();
        showFragment(f);
    }

    public void showFragment(Fragment f){
        String tag = f.getClass().getName() + getNextPositionOfFragment(f.getClass().getName());
        final FragmentManager fm = getSupportFragmentManager();
        final FragmentTransaction ft = fm.beginTransaction();
        if (mFragmentTagStack.size() > 0){
            final Fragment ff = fm.findFragmentByTag(mFragmentTagStack.peek());
            ft.hide(ff);
        }
        ft.add(getFragmentContainerId(), f, tag);
        ft.show(f);
        ft.addToBackStack(tag);
        ft.commit();
        mFragmentTagStack.add(tag);
    }

    @Override
    public void onBackStackChanged() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() == mFragmentTagStack.size()){
            return;
        }
        if (mFragmentTagStack.size() > 1){
            FragmentTransaction ft = fm.beginTransaction();
            String tag = mFragmentTagStack.pop();
            if (fm.findFragmentByTag(tag) != null){
                ft.remove(fm.findFragmentByTag(tag));
            }
            ft.commit();
        }
    }

    private int getNextPositionOfFragment(String tag){
        int pos = 0;
        if (mFragmentTagStack.size() > 0){
            for (String stackTag : mFragmentTagStack){
                if (stackTag.contains(tag)){
                    pos ++;
                }
            }
        }
        return pos;
    }
}
