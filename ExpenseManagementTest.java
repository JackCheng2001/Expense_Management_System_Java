import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import expenses.Expense;
import expenses.Expenses;

class ExpenseManagementTest {

	//define instance of expenses class for testing
	Expenses expenses;
	
	@BeforeEach
	void setUp() throws Exception {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		this.expenses = new Expenses();
		
		//initialize individual expenses and add for testing
		Expense expense = new Expense(12, 2.34);
		this.expenses.addExpense(expense);
		
		expense = new Expense(10, 98.34);
		this.expenses.addExpense(expense);
		
		expense = new Expense(2, 44.00);
		this.expenses.addExpense(expense);
		
		expense = new Expense(12, 12.01);
		this.expenses.addExpense(expense);
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
		
	}

	@Test
	void testGetMonthlyExpensesIntListOfExpense() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create list of expected monthly expense amounts
		List<Double> monthlyExpensesExpected = new ArrayList<Double>();
		monthlyExpensesExpected.add(98.34);
		
		//get actual monthly expense amounts for oct (10)
		List<Double> monthlyExpenses = ExpenseManagement.getMonthlyExpenses(10, this.expenses.getMonthlyExpenses());
		
		//confirm expected is equal to actual
		assertEquals(monthlyExpensesExpected, monthlyExpenses, "The expected list of monthly expenses for Oct. do not match the actual list of monthly expenses for Oct.");
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
		
		
		// TODO insert 2 additional test cases
        // Hint(s): Create additional lists of expected monthly expense amounts 
		// and compare to actual monthly expense amounts for particular months
		// #1 compare all the rest monthly expense to the expected monthly expense
		// Retrieve the list of expense amounts for December (month 12, 10 and 2)
		List<Double> monthlyExpenses_12 = ExpenseManagement.getMonthlyExpenses(12, this.expenses.getMonthlyExpenses());
		List<Double> monthlyExpenses_10 = ExpenseManagement.getMonthlyExpenses(10, this.expenses.getMonthlyExpenses());
		List<Double> monthlyExpenses_2 = ExpenseManagement.getMonthlyExpenses(2, this.expenses.getMonthlyExpenses());
		// Initialize expected expense lists for December, October, and February
		List<Double> monthlyExpensesExpected_12 = new ArrayList<Double>();
		List<Double> monthlyExpensesExpected_10 = new ArrayList<Double>();
		List<Double> monthlyExpensesExpected_2 = new ArrayList<Double>();
		// Add expected expenses to the expected lists
		monthlyExpensesExpected_12.add(2.34);
		monthlyExpensesExpected_12.add(12.01);
		monthlyExpensesExpected_10.add(98.34);
		monthlyExpensesExpected_2.add(44.0);
		// Assert that the actual expenses for December match the expected expenses
		assertEquals(monthlyExpensesExpected_12, monthlyExpenses_12, "The expected list of monthly expenses for Dec. do not match the actual list of monthly expenses for Oct.");
		// Assert that the actual expenses for October match the expected expenses
		assertEquals(monthlyExpensesExpected_10, monthlyExpenses_10, "The expected list of monthly expenses for Oct. do not match the actual list of monthly expenses for Oct.");
		// Assert that the actual expenses for February match the expected expenses
		assertEquals(monthlyExpensesExpected_2, monthlyExpenses_2, "The expected list of monthly expenses for Feb. do not match the actual list of monthly expenses for Oct.");

		//#2 Compare to the expected expense AFTER inserting a new expense to an existing month record
		// Add a new expense for December
		Expense expense = new Expense(12, 20.0);
		this.expenses.addExpense(expense);
		// Update the expected expenses list for December
		monthlyExpensesExpected_12.add(20.0);
		// Retrieve the updated list of expense amounts for December
		List<Double> monthlyExpenses_12_updated = ExpenseManagement.getMonthlyExpenses(12, this.expenses.getMonthlyExpenses());
		// Assert that the updated actual expenses for December match the updated expected expenses
		assertEquals(monthlyExpensesExpected_12, monthlyExpenses_12_updated, "The expected list of monthly expenses for Dec. do not match the actual list of monthly expenses for Oct.");
	}
	@Test
	void testGetMonthlyExpensesStringListOfExpense() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create list of expected monthly expense amounts
		List<Double> monthlyExpensesExpected = new ArrayList<Double>();
		monthlyExpensesExpected.add(98.34);
		
		//get actual monthly expense amounts for oct
		List<Double> monthlyExpenses = ExpenseManagement.getMonthlyExpenses("oct", this.expenses.getMonthlyExpenses());
		
		//confirm expected is equal to actual
		assertEquals(monthlyExpensesExpected, monthlyExpenses, "The expected list of monthly expenses for Oct. do not match the actual list of monthly expenses for Oct.");
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
		
		
		// TODO insert 2 additional test cases
        // Hint(s): Create additional lists of expected monthly expense amounts 
		// and compare to actual monthly expense amounts for particular months
		// #1 Comparing to actual monthly expense while the expense is a list with more than 1 element
		List<Double> monthlyExpensesExpected_12 = new ArrayList<Double>();
		List<Double> monthlyExpenses_12 = ExpenseManagement.getMonthlyExpenses("dec", this.expenses.getMonthlyExpenses());
		monthlyExpensesExpected_12.add(2.34);
		monthlyExpensesExpected_12.add(12.01);
		assertEquals(monthlyExpensesExpected_12, monthlyExpenses_12, "The expected list of monthly expenses for Dec. do not match the actual list of monthly expenses for Oct.");

		// #2 Comparing to actual monthly expense right AFTER assert a new expense record in the corresponding month
		Expense expense = new Expense(12, 20.0);
		this.expenses.addExpense(expense);
		monthlyExpensesExpected_12.add(20.0);
		List<Double> monthlyExpenses_12_updated = ExpenseManagement.getMonthlyExpenses("dec", this.expenses.getMonthlyExpenses());
		assertEquals(monthlyExpensesExpected_12, monthlyExpenses_12_updated, "The expected list of monthly expenses for Dec. do not match the actual list of monthly expenses for Dec.");
	}

	@Test
	void testGetTotalMonthlyExpenses() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//get actual total monthly expense amount for oct
		double totalMonthlyExpenses = ExpenseManagement.getTotalMonthlyExpenses("oct", this.expenses.getMonthlyExpenses());
		
		//confirm it is 98.34
		assertEquals(98.34, totalMonthlyExpenses, "The expected total of monthly expenses for Oct. does not match the actual total of monthly expenses for Oct.");
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
		
		
		// TODO insert 2 additional test cases
        // Hint(s): Test other total monthly expense amounts for particular months
		// #1 Test all of the other total monthly expense amounts for particular months
		double totalMonthlyExpenses_2 = ExpenseManagement.getTotalMonthlyExpenses("feb", this.expenses.getMonthlyExpenses());
		double totalMonthlyExpenses_10 = ExpenseManagement.getTotalMonthlyExpenses("oct", this.expenses.getMonthlyExpenses());
		double totalMonthlyExpenses_12 = ExpenseManagement.getTotalMonthlyExpenses("dec", this.expenses.getMonthlyExpenses());
		assertEquals(44.0, totalMonthlyExpenses_2, "The expected total of monthly expenses for Oct. does not match the actual total of monthly expenses for Feb.");
		assertEquals(98.34, totalMonthlyExpenses_10, "The expected total of monthly expenses for Oct. does not match the actual total of monthly expenses for Oct.");
		assertEquals(14.35, totalMonthlyExpenses_12, "The expected total of monthly expenses for Oct. does not match the actual total of monthly expenses for Dec.");

		// #2 Test the total monthly expense right AFTER adding a new record to an existing month
		Expense expense = new Expense(12, 20.0);
		this.expenses.addExpense(expense);
		double totalMonthlyExpenses_12_updated = ExpenseManagement.getTotalMonthlyExpenses("dec", this.expenses.getMonthlyExpenses());
		assertEquals(34.35, totalMonthlyExpenses_12_updated, "The expected total of monthly expenses for Oct. does not match the actual total of monthly expenses for Dec.");

	}

	@Test
	void testGetMostExpensiveMonth() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create expense object for expected most expensive month 10 (oct)
		Expense mostExpensiveMonthCompare = new Expense(10, 98.34);
		
		//get expense object for actual most expensive month
		Expense mostExpensiveMonth = ExpenseManagement.getMostExpensiveMonth(this.expenses.getMonthlyExpenses());
		
		//compare expected expense object with actual expense object
		assertEquals(mostExpensiveMonthCompare, mostExpensiveMonth, "The expected most expensive month does not match the actual most expensive month.");
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
		
		
		// TODO insert 2 additional test cases
        // Hint(s): Create additional expense object for a particular month and add to monthly expenses
		// Test if it's the most expensive month
		// #1 Test after inserting a new record which is not the most expensive one
		Expense expense = new Expense(12, 20.0);
		this.expenses.addExpense(expense);
		Expense mostExpensiveMonth_updated_1 = ExpenseManagement.getMostExpensiveMonth(this.expenses.getMonthlyExpenses());
		assertEquals(mostExpensiveMonthCompare, mostExpensiveMonth_updated_1, "The expected most expensive month does not match the actual most expensive month.");

		// #2 Test after inserting a new record which is the most expensive one
		Expense expense_1 = new Expense(12, 20000.0);
		this.expenses.addExpense(expense_1);
		Expense mostExpensiveMonthCompare_updated = new Expense(12, 20034.35);

		Expense mostExpensiveMonth_updated_2 = ExpenseManagement.getMostExpensiveMonth(this.expenses.getMonthlyExpenses());
		assertEquals(mostExpensiveMonthCompare_updated, mostExpensiveMonth_updated_2, "The expected most expensive month does not match the actual most expensive month.");
	}

}
