package com.example.Expense_Tracker_App_alephys.Service;

import com.example.Expense_Tracker_App_alephys.Model.Category;
import com.example.Expense_Tracker_App_alephys.Model.Transaction;
import com.example.Expense_Tracker_App_alephys.Model.TransactionType;
import com.example.Expense_Tracker_App_alephys.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getTransactionsByMonth(int year, int month) {
        return transactionRepository.findByMonth(year, month);
    }

    public Map<Category, Double> getMonthlySummary(int year, int month) {
        List<Transaction> transactions = getTransactionsByMonth(year, month);

        return transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getCategory,
                        Collectors.summingDouble(Transaction::getAmount)
                ));
    }

    public double getMonthlyBalance(int year, int month) {
        List<Transaction> transactions = getTransactionsByMonth(year, month);

        double income = transactions.stream()
                .filter(t -> t.getType() == TransactionType.INCOME)
                .mapToDouble(Transaction::getAmount)
                .sum();

        double expenses = transactions.stream()
                .filter(t -> t.getType() == TransactionType.EXPENSE)
                .mapToDouble(Transaction::getAmount)
                .sum();

        return income - expenses;
    }
    public List<Transaction> saveAllTransactions(List<Transaction> transactions) {
        return transactionRepository.saveAll(transactions);
    }

}
