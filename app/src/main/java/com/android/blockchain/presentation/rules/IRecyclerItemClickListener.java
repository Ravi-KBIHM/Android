package com.android.blockchain.presentation.rules;

/**
 * @author Ravi Kumar
 */
public interface IRecyclerItemClickListener<T> {
    void selectItem(final T data, final int position);
}
