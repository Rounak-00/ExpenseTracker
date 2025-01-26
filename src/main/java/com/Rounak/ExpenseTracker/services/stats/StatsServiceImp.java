package com.Rounak.ExpenseTracker.services.stats;

import com.Rounak.ExpenseTracker.dto.GraphDTO;
import com.Rounak.ExpenseTracker.dto.StatsDTO;
import com.Rounak.ExpenseTracker.entity.Expense;
import com.Rounak.ExpenseTracker.entity.Income;
import com.Rounak.ExpenseTracker.repository.ExpenseRepository;
import com.Rounak.ExpenseTracker.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
@RequiredArgsConstructor
public class StatsServiceImp implements StatsService {
    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;

    public GraphDTO getChartData(){
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(27);
        GraphDTO graphDTO = new GraphDTO();

        graphDTO.setExpensesList(expenseRepository.findByDateBetween(startDate, endDate));
        graphDTO.setIncomeList(incomeRepository.findByDateBetween(startDate, endDate));

        return graphDTO;
    }

    public StatsDTO getStats(){
        Double totalIncome = incomeRepository.sumAllAmounts();
        Double totalExpense = expenseRepository.sumAllAmounts();
        Optional<Income> optionalIncome = incomeRepository.findFirstByOrderByDateDesc();
        Optional<Expense> optionalExpense = expenseRepository.findFirstByOrderByDateDesc();

        StatsDTO statsDTO = new StatsDTO();
        optionalIncome.ifPresent(statsDTO::setLastIncome);
        optionalExpense.ifPresent(statsDTO::setLastExpense);
        statsDTO.setExpense(totalExpense);
        statsDTO.setIncome(totalIncome);

        statsDTO.setBalance(totalIncome-totalExpense);
        List<Income> incomeList = incomeRepository.findAll();
        List<Expense> expenseList = expenseRepository.findAll();

        OptionalDouble minIncome = incomeList.stream().mapToDouble(Income::getAmount).min();
        OptionalDouble maxIncome = incomeList.stream().mapToDouble(Income::getAmount).max();

        OptionalDouble minExpense = expenseList.stream().mapToDouble(Expense::getAmount).min();
        OptionalDouble maxExpense = expenseList.stream().mapToDouble(Expense::getAmount).max();

        statsDTO.setMaxExpense(maxExpense.isPresent()? maxExpense.getAsDouble():null);
        statsDTO.setMinExpense(minExpense.isPresent()? minExpense.getAsDouble():null);

        statsDTO.setMinIncome(minIncome.isPresent()? minIncome.getAsDouble():null);
        statsDTO.setMaxIncome(maxIncome.isPresent()? maxIncome.getAsDouble():null);

        return statsDTO;
    }
}
