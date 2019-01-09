package com.android.blockchain.presentation.fragments.menu;

/**
 * @author Ravi Kumar
 */
public final class MenuPresenter implements MenuContract.MenuPresenter {

    private MenuContract.MenuView view;

    MenuPresenter(MenuContract.MenuView view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        this.view = null;
    }

    @Override
    public void openExchangeRate() {
        if (this.view != null)
            this.view.showExchangeRate();
    }
}
