package com.android.blockchain.presentation.fragments.exchange_rate.adapter;

import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.blockchain.R;
import com.android.blockchain.presentation.rules.IRecyclerItemClickListener;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import info.blockchain.api.exchangerates.Currency;

/**
 * @author Ravi Kumar
 */
final class ExchangeRateVH extends RecyclerView.ViewHolder {

    private TextView label, sell, buy;
    private NumberFormat numberFormat = DecimalFormat.getInstance();
    private String keyLabel;

    private final IRecyclerItemClickListener<String> itemClickListener;

    ExchangeRateVH(View itemView, final IRecyclerItemClickListener<String> itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;

        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(15);

        label = itemView.findViewById(R.id.tvExchangeLabel_LIER);
        sell = itemView.findViewById(R.id.tvSellValue_LIER);
        buy = itemView.findViewById(R.id.tvBuyValue_LIER);

        itemView.setOnClickListener(view -> this.itemClickListener.selectItem(keyLabel, getAdapterPosition()));
    }

    void bind(final Pair<String, Currency> currencyPair, final boolean isSelected) {
        itemView.setSelected(isSelected);
        keyLabel = currencyPair.first;

        if (currencyPair.second != null) {
            label.setText(String.format("%s (%s)", keyLabel, currencyPair.second.getSymbol()));
        }
        if (currencyPair.second != null) {
            sell.setText(numberFormat.format(currencyPair.second.getSell().doubleValue()));
        }
        if (currencyPair.second != null) {
            buy.setText(numberFormat.format(currencyPair.second.getBuy().doubleValue()));
        }
    }
}
