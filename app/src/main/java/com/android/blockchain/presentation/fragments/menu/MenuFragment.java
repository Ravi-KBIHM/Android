package com.android.blockchain.presentation.fragments.menu;

import android.view.View;

import com.android.blockchain.R;
import com.android.blockchain.presentation.fragments.exchange_rate.ExchangeRateFragment;
import com.android.blockchain.presentation.rules.BaseFragment;

/**
 * @author Ravi Kumar
 */
public final class MenuFragment extends BaseFragment implements MenuContract.MenuView, View.OnClickListener {

    private MenuContract.MenuPresenter presenter;

    @Override
    protected int screenName() {
        return R.string.app_name;
    }

    @Override
    protected int layoutRes() {
        return R.layout.fragment_menu;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void initUI() {
        findView(R.id.llExchangeRate_FM).setOnClickListener(this);
    }

    @Override
    protected void initPresenter() {
        new MenuPresenter(this);
    }

    @Override
    public void setPresenter(MenuContract.MenuPresenter presenter) {
        this.presenter = presenter;
        this.presenter.subscribe();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.llExchangeRate_FM:
                presenter.openExchangeRate();
                break;
        }
    }


    @Override
    public void showExchangeRate() {
        activity.replaceFragment(new ExchangeRateFragment(), true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.presenter.unsubscribe();
    }
}
