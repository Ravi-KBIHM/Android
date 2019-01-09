package com.android.blockchain.presentation.fragments.menu;

import com.android.blockchain.presentation.rules.BaseModel;
import com.android.blockchain.presentation.rules.BasePresenter;
import com.android.blockchain.presentation.rules.BaseView;

/**
 * @author Ravi Kumar
 */
public interface MenuContract {
    interface MenuView extends BaseView<MenuPresenter> {
        void showExchangeRate();
    }
    interface MenuPresenter extends BasePresenter {
        void openExchangeRate();
    }
    interface MenuModel extends BaseModel {

    }
}
