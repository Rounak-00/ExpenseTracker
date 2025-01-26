package com.Rounak.ExpenseTracker.dto;

import com.Rounak.ExpenseTracker.entity.Expense;
import com.Rounak.ExpenseTracker.entity.Income;
import lombok.Data;

@Data
public class StatsDTO {

    private Double income;
    private Double expense;

    private Income lastIncome;
    private Expense lastExpense;

    private Double balance;
    private Double minIncome;
    private Double maxIncome;
    private Double minExpense;
    private Double maxExpense;

}
