package com.example.Expense_Tracker_App_alephys.Controller;
import com.example.Expense_Tracker_App_alephys.Model.Category;
import com.example.Expense_Tracker_App_alephys.Model.Transaction;
import com.example.Expense_Tracker_App_alephys.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/monthly")
    public Map<Category, Double> getMonthlySummary(@RequestParam int year, @RequestParam int month) {
        return transactionService.getMonthlySummary(year, month);
    }

    @GetMapping("/monthly-balance")
    public double getMonthlyBalance(@RequestParam int year, @RequestParam int month) {
        return transactionService.getMonthlyBalance(year, month);
    }






}
