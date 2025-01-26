package com.Rounak.ExpenseTracker.services.income;

import com.Rounak.ExpenseTracker.dto.IncomeDTO;
import com.Rounak.ExpenseTracker.entity.Income;
import com.Rounak.ExpenseTracker.repository.IncomeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncomeServiceImplementation implements IncomeService {

    private final IncomeRepository incomeRepository;

    private Income saveOrUpdateIncome(Income income, IncomeDTO incomeDTO) {
        income.setTitle(incomeDTO.getTitle());
        income.setDate(incomeDTO.getDate());
        income.setAmount(incomeDTO.getAmount());
        income.setCategory(incomeDTO.getCategory());
        income.setDescription(incomeDTO.getDescription());

        return incomeRepository.save(income);
    }

    public Income postIncome(IncomeDTO incomeDTO) {
        return saveOrUpdateIncome(new Income(), incomeDTO);
    }

    public List<Income> getAllIncomes() {
        return incomeRepository.findAll().stream()
                .sorted(Comparator.comparing(Income::getDate).reversed())
                .collect(Collectors.toList());
    }

    public Income getIncomeById(Long id) {
        Optional<Income> income = incomeRepository.findById(id);
        if (income.isPresent()) {
            return income.get();
        }else {
            throw new EntityNotFoundException("Income not found id = "+id);
        }
    }

    public Income updateIncome(Long id, IncomeDTO incomeDTO) {
        Optional<Income> income = incomeRepository.findById(id);
        if (income.isPresent()) {
            return saveOrUpdateIncome(income.get(), incomeDTO);
        }else {
            throw new EntityNotFoundException("Income not found id = "+id);
        }
    }

    public void deleteIncome(Long id) {
        Optional<Income> income = incomeRepository.findById(id);
        if (income.isPresent()) {
            incomeRepository.deleteById(id);
        }else {
            throw new EntityNotFoundException("Income not found id = "+id);
        }
    }
}
