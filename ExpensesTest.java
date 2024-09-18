package expenses;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExpensesTest {

	//define instance of expenses class for testing
	Expenses expenses;
	
	@BeforeEach
	void setUp() throws Exception {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//initialize expenses class
		this.expenses = new Expenses();
		
		//initialize individual expenses and add directly for testing
		Expense expense = new Expense(12, 2.34);
		this.expenses.getMonthlyExpenses().add(expense);
		
		expense = new Expense(10, 98.34);
		this.expenses.getMonthlyExpenses().add(expense);
		
		expense = new Expense(2, 44.00);
		this.expenses.getMonthlyExpenses().add(expense);
		
		expense = new Expense(12, 12.01);
		this.expenses.getMonthlyExpenses().add(expense);
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
    
	}
	
	@Test
	void testAddExpense() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//initially confirm size of monthly expenses
		assertEquals(4, this.expenses.getMonthlyExpenses().size(), "The initial count of monthly expenses is incorrect. The expected answer is 4.");
		
		//add new individual expense
		Expense expense = new Expense(3, 4.34);
		this.expenses.addExpense(expense);
				
		//confirm new size of monthly expenses
		assertEquals(5, this.expenses.getMonthlyExpenses().size(), "After adding an expense, the count of monthly expenses is incorrect. The expected answer is 5.");
		//confirm added expense is correct
		//it should have the correct month and expense amount
		//this relies on equals method in expense class
		assertEquals(expense, this.expenses.getMonthlyExpenses().get(4), "New expense not added correctly to list of monthly expenses.");
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
		
		
		// TODO insert 2 additional test cases
        // Hint(s): Create additional expense objects and add to monthly expenses
		// #1 Add an expense with zero amount
		Expense newExpense1 = new Expense(12, 0.00);
		this.expenses.addExpense(newExpense1);
		assertEquals(6, this.expenses.getMonthlyExpenses().size(), "After adding an expense, the count of monthly expenses is incorrect. The expected answer is 6.");
		// #2 Add an expense for the same month that already exist in the list
		Expense newExpense2 = new Expense(3, 20.00);
		this.expenses.addExpense(newExpense2);
		assertEquals(7, this.expenses.getMonthlyExpenses().size(), "After adding an expense, the count of monthly expenses is incorrect. The expected answer is 7.");
		// #3 Add an expense that exactly the same as the one of the expense that already exist in the list
		Expense newExpense3 = new Expense(3, 4.34);
		this.expenses.addExpense(newExpense3);
		assertEquals(8, this.expenses.getMonthlyExpenses().size(), "After adding an expense, the count of monthly expenses is incorrect. The expected answer is 8.");

	}
	
	@Test
	void testAddExpenses() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//initially confirm size of monthly expenses
		assertEquals(4, this.expenses.getMonthlyExpenses().size(), "The initial count of monthly expenses is incorrect. The expected answer is 4.");
				
		//manually create list of expense maps 
		List<Map<Integer, Double>> expenseList = new ArrayList<Map<Integer, Double>>();
		
		//create and add individual expense maps
		Map<Integer, Double> entry = new HashMap<Integer, Double>();
		entry.put(3, 4.34);
		expenseList.add(entry);
		
		entry = new HashMap<Integer, Double>();
		entry.put(6, 1000.00);
		expenseList.add(entry);
		
		entry = new HashMap<Integer, Double>();
		entry.put(6, 604.56);
		expenseList.add(entry);
		
		//add list of expense maps 
		this.expenses.addExpenses(expenseList);
		
		//confirm new size of monthly expenses
		assertEquals(7, this.expenses.getMonthlyExpenses().size(), "After adding an expense, the count of monthly expenses is incorrect. The expected answer is 7.");
		
		//confirm added expense is correct
		//it should have the correct month and expense amount
		//this relies on equals method in expense class
		assertEquals(new Expense(3, 4.34), this.expenses.getMonthlyExpenses().get(4), "An expense from the list of expenses was not added correctly to list of monthly expenses.");

		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////

		
		// TODO insert 2 additional test cases
        // Hint(s): Confirm other added expenses are correct
		// #1 Confirm all the added expenses are correct
		// Assert that the first~seventh expense in the list is correctly added
		assertEquals(new Expense(12, 2.34), this.expenses.getMonthlyExpenses().get(0), "An expense from the list of expenses was not added correctly to list of monthly expenses.");
		assertEquals(new Expense(10, 98.34), this.expenses.getMonthlyExpenses().get(1), "An expense from the list of expenses was not added correctly to list of monthly expenses.");
		assertEquals(new Expense(2, 44), this.expenses.getMonthlyExpenses().get(2), "An expense from the list of expenses was not added correctly to list of monthly expenses.");
		assertEquals(new Expense(12, 12.01), this.expenses.getMonthlyExpenses().get(3), "An expense from the list of expenses was not added correctly to list of monthly expenses.");
		assertEquals(new Expense(3, 4.34), this.expenses.getMonthlyExpenses().get(4), "An expense from the list of expenses was not added correctly to list of monthly expenses.");
		assertEquals(new Expense(6, 1000), this.expenses.getMonthlyExpenses().get(5), "An expense from the list of expenses was not added correctly to list of monthly expenses.");
		assertEquals(new Expense(6, 604.56), this.expenses.getMonthlyExpenses().get(6), "An expense from the list of expenses was not added correctly to list of monthly expenses.");

		// #2 Insert a new expense record that exactly same as the one that already in the list, then confirm if the record is added correctly
		// Create a new entry and add it to a new list of expenses
		entry = new HashMap<Integer, Double>();
		entry.put(6, 604.56);
		List<Map<Integer, Double>> expenseList_2 = new ArrayList<Map<Integer, Double>>();
		expenseList_2.add(entry);
		// Add the new list of expenses to the existing list
		this.expenses.addExpenses(expenseList_2);
		// Assert that the newly added expense (duplicate) is correctly added
		assertEquals(new Expense(6, 604.56), this.expenses.getMonthlyExpenses().get(7), "An expense from the list of expenses was not added correctly to list of monthly expenses.");

		// #3 Insert a new expense record with the expense is 0
		// Create a new entry with an expense amount of 0 and add it to a new list of expenses
		entry = new HashMap<Integer, Double>();
		entry.put(12, 0.0);
		List<Map<Integer, Double>> expenseList_3 = new ArrayList<Map<Integer, Double>>();
		expenseList_3.add(entry);
		// Add the new list of expenses to the existing list
		this.expenses.addExpenses(expenseList_3);
		// Assert that the expense with an amount of 0 is correctly added
		assertEquals(new Expense(12, 0), this.expenses.getMonthlyExpenses().get(8), "An expense from the list of expenses was not added correctly to list of monthly expenses.");
	}
}
