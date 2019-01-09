package com.android.blockchain.presentation.rules;

/**
 * @author Ravi Kumar
 */
public interface BaseView<P extends BasePresenter> {
    void setPresenter(final P presenter);
}
