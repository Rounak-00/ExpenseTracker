package com.Rounak.ExpenseTracker.repository;
import com.Rounak.ExpenseTracker.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

    List<Income> findByDateBetween(LocalDate start, LocalDate end);

    @Query("Select Sum(i.amount) from Income i")
    Double sumAllAmounts();

    Optional<Income> findFirstByOrderByDateDesc();
}
