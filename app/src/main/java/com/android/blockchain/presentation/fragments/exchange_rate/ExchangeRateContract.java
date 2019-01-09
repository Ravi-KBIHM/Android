package com.android.blockchain.presentation.fragments.exchange_rate;

import android.support.v4.util.Pair;

import com.android.blockchain.presentation.rules.BaseModel;
import com.android.blockchain.presentation.rules.BasePresenter;
import com.android.blockchain.presentation.rules.BaseView;

import java.util.List;
import java.util.Map;

import info.blockchain.api.exchangerates.Currency;
import rx.Observable;

/**
 * @author Ravi Kumar
 */
public interface ExchangeRateContract {
    interface ExchangeRateView extends BaseView<ExchangeRatePresenter> {
        void showProgress();
        void dismissProgress();
        void showErrorToast();
        void setExchangeRates(final List<Pair<String, Currency>> data);

        void setFromExchange(final String exchangeCode, final double value);
        void setToExchange(final String exchangeCode, final double value);
    }
    interface ExchangeRatePresenter extends BasePresenter {
        void setTargetCurrencyInKey(final String keyLabel);
        void calculateExchange(final double valueFrom);
        void changeExchangeSide();
    }
    interface ExchangeRateModel extends BaseModel {
        Observable<Map<String, Currency>> getExchangeRates();
    }
}
