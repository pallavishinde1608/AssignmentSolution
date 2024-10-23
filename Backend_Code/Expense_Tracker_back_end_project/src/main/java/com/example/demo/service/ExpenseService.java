package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Expense;

public interface ExpenseService {
	public  Expense saveExpense(Expense expense);
	public  List<Expense> getAllExpenses();
	public   Expense getExpenseById(int id);
	public   Expense updateExpense(int id, Expense expense);
	public   String deleteExpense(int id);
}
