package com.example.Expense_Tracker_App_alephys;

import com.example.Expense_Tracker_App_alephys.Model.Category;
import com.example.Expense_Tracker_App_alephys.Model.Transaction;
import com.example.Expense_Tracker_App_alephys.Model.TransactionType;
import com.example.Expense_Tracker_App_alephys.Repository.TransactionRepository;
import com.example.Expense_Tracker_App_alephys.Service.TransactionService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/file") // Base path for all endpoints in this controller
public class TransactionCon {

    @Autowired
    private TransactionService transactionService;


    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCSV(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }

        List<Transaction> transactions = new ArrayList<>();

        try (
                Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim())
        ) {
            for (CSVRecord record : csvParser) {
                String description = record.get("description");
                double amount = Double.parseDouble(record.get("amount"));
                LocalDate date = LocalDate.parse(record.get("date"));
                TransactionType type = TransactionType.valueOf(record.get("type").toUpperCase());
                Category category = Category.valueOf(record.get("category").toUpperCase());

                Transaction transaction = new Transaction(description, amount, date, type, category);
                transactions.add(transaction);
            }

            transactionRepository.saveAll(transactions);
            return ResponseEntity.ok("Uploaded and saved " + transactions.size() + " transactions");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error parsing CSV: " + e.getMessage());
        }
    }
}
