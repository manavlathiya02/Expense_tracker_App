package com.example.Expense_Tracker_App_alephys.Model;


import jakarta.persistence.*;
import jakarta.persistence.Id;


import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private double amount;
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Enumerated(EnumType.STRING)
    private Category category;

    // Constructors, getters, and setters for get and set value of the field
    public Transaction() {}

    public Transaction(String description, double amount, LocalDate date, TransactionType type, Category category) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.type = type;
        this.category = category;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public double getAmount() { return amount; }

    public void setAmount(double amount) { this.amount = amount; }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }

    public TransactionType getType() { return type; }

    public void setType(TransactionType type) { this.type = type; }

    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }


}
