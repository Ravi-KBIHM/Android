package com.android.blockchain.domain;

import com.android.blockchain.presentation.fragments.exchange_rate.ExchangeRateContract;
import com.android.blockchain.presentation.utils.Constants;

import java.util.Map;

import info.blockchain.api.exchangerates.Currency;
import info.blockchain.api.exchangerates.ExchangeRates;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author Ravi Kumar
 */

public final class BlockChainRepository implements ExchangeRateContract.ExchangeRateModel {

    @Override
    public Observable<Map<String, Currency>> getExchangeRates() {
        return Observable.fromCallable(() -> ExchangeRates.getTicker(Constants.API_KEY))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread());
    }
}
