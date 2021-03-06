package com.vsahin.moneycim.View.SpendingList;

import androidx.recyclerview.widget.DiffUtil;

import com.vsahin.moneycim.Model.Pojo.Spending;

import java.util.List;

/**
 * Created by Volkan Şahin on 2.09.2017.
 */

class SpendingDiffCallback extends DiffUtil.Callback {

    private final List<Spending> oldSpendingList;
    private final List<Spending> newSpendingList;

    SpendingDiffCallback(List<Spending> oldSpendingList, List<Spending> newSpendingList) {
        this.oldSpendingList = oldSpendingList;
        this.newSpendingList = newSpendingList;
    }

    @Override
    public int getOldListSize() {
        return oldSpendingList.size();
    }

    @Override
    public int getNewListSize() {
        return newSpendingList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldSpendingList.get(oldItemPosition).getRawSpending().getId() ==
                newSpendingList.get(newItemPosition).getRawSpending().getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final Spending oldSpending = oldSpendingList.get(oldItemPosition);
        final Spending newSpending = newSpendingList.get(newItemPosition);

        return oldSpending.isSame(newSpending);
    }
}
