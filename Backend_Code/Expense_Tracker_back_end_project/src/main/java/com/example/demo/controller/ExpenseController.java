package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Expense;
import com.example.demo.service.ExpenseService;
@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping
public class ExpenseController {
	
	 @Autowired
	    private ExpenseService expenseService;

	    @PostMapping("/save")
	    public Expense addExpense(@RequestBody Expense expense) {
	        return expenseService.saveExpense(expense);
	    }

	    @GetMapping("/view")
	    public List<Expense> getAllExpenses() {
	        return expenseService.getAllExpenses();
	    }

	    @GetMapping("/viewbyid/{id}")
	    public Expense getExpenseById(@PathVariable int id) {
	        return expenseService.getExpenseById(id);
	    }

	    @PutMapping("/update/{id}")
	    public Expense updateExpense(@PathVariable int id, @RequestBody Expense expense) {
	        return expenseService.updateExpense(id, expense);
	    }

	    @DeleteMapping("/delete/{id}")
	    public String deleteExpense(@PathVariable int id) {
	        return expenseService.deleteExpense(id);
	    }
}
