package com.Rounak.ExpenseTracker.dto;

import com.Rounak.ExpenseTracker.entity.Expense;
import com.Rounak.ExpenseTracker.entity.Income;
import lombok.Data;

import java.util.List;

@Data
public class GraphDTO {
    private List<Expense> expensesList;
    private List<Income> incomeList;
}
