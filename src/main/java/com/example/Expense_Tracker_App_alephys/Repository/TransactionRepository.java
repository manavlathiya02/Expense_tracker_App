package com.example.Expense_Tracker_App_alephys.Repository;

import com.example.Expense_Tracker_App_alephys.Model.Transaction;
import com.example.Expense_Tracker_App_alephys.Model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    List<Transaction> findByDateBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT t FROM Transaction t WHERE YEAR(t.date) = :year AND MONTH(t.date) = :month")
    List<Transaction> findByMonth(@Param("year") int year, @Param("month") int month);

    List<Transaction> findByType(TransactionType type);
}
