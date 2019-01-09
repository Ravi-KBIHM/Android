package com.android.blockchain.presentation.rules;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.blockchain.presentation.MainActivity;

/**
 * @author Ravi Kumar
 */
public abstract class BaseFragment extends Fragment {

    protected MainActivity activity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.activity = (MainActivity) activity;
            this.activity.setTitle(screenName());
        } catch (ClassCastException e) {
            throw new RuntimeException("This fragment should have Activity instance");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        this.activity.setTitle(screenName());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(layoutRes(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI();
        initPresenter();
    }

    //This method recommend call in onViewCreated() | initUI()
    @SuppressWarnings("unchecked")
    protected @Nullable <T extends View> T findView(@IdRes int viewId) {
        final View fragmentView = getView();
        if (fragmentView != null)
            return (T) fragmentView.findViewById(viewId);
        else return null;
    }

    protected abstract @StringRes int screenName();
    protected abstract @LayoutRes int layoutRes();
    protected abstract void initUI();
    protected abstract void initPresenter();
}
