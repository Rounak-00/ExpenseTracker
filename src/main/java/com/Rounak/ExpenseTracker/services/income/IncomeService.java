package com.Rounak.ExpenseTracker.services.income;

import com.Rounak.ExpenseTracker.dto.IncomeDTO;
import com.Rounak.ExpenseTracker.entity.Income;

import java.util.List;

public interface IncomeService {
    Income postIncome(IncomeDTO incomeDTO);
    List<Income> getAllIncomes();
    Income getIncomeById(Long id);
    Income updateIncome(Long id, IncomeDTO incomeDTO);
    void deleteIncome(Long id);
}
