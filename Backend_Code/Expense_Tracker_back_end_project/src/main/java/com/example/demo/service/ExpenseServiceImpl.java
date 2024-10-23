package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Expense;
import com.example.demo.repository.ExpenseRepository;
@Service
public class ExpenseServiceImpl implements ExpenseService{

	 @Autowired
	    private ExpenseRepository expenseRepo;

	    @Override
	    public Expense saveExpense(Expense expense) {
	        return expenseRepo.save(expense);
	    }

	    @Override
	    public List<Expense> getAllExpenses() {
	        return expenseRepo.findAll();
	    }

	    @Override
	    public Expense getExpenseById(int id) {
	        return expenseRepo.findById(id).get();
	    }

	    @Override
	    public Expense updateExpense(int id, Expense expense) {
		
	        Expense existingExpense = getExpenseById(id);
	        existingExpense.setCategory(expense.getCategory());
	        existingExpense.setAmount(expense.getAmount());
	        existingExpense.setComments(expense.getComments());
	        return expenseRepo.save(existingExpense);
	    }

	    @Override
	    public String deleteExpense(int id) {
	        Expense expense = expenseRepo.findById(id).get();
	        if(expense!=null) {
	        expenseRepo.delete(expense);
	        return "Expense deleted successfully.";
	        }
			return "somethig wrong";
	    }
}
