package expenses;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import expenses.file.ExpenseFileParser;
import expenses.file.ExpenseFileReader;


/**
 * Creates and stores monthly expenses.
 * @author lbrandon
 */
public class Expenses {

	/**
	 * List of monthly expenses.
	 */	
	private List<Expense> monthlyExpenses;
	
	/**
	 * Initializes list of monthly expenses.
	 */
	public Expenses() {
		
		//initialize list of expenses
		this.monthlyExpenses = new ArrayList<Expense>();
	}
	
	/**
	 * Gets list of monthly expenses.
	 * @return list of expenses
	 */
	public List<Expense> getMonthlyExpenses() {
		
		// TODO Implement method
		return monthlyExpenses;
	}
	
	/**
	 * Converts each expense in the given list to an Expense object,
	 * and adds it to the internal list of monthly expenses.
	 * @param expenses to add
	 */
	public void addExpenses(List<Map<Integer, Double>> expenses) {
		
		// TODO Implement method
		// Iterate over each map in the provided list of expenses
		for (Map<Integer, Double> expenseMap : expenses) {
			// For each map, iterate over its entries
			expenseMap.forEach((month, amount) -> {
				// Create a new Expense object using the month and amount from the map entry
				Expense expense = new Expense(month, amount);
				// Add the newly created Expense object to the list of expenses
				// The addExpense method is assumed to be another method in the Expenses class
				// that adds an Expense object to an internal collection (like an ArrayList)
				addExpense(expense);
			});
		}
	}
	
	/**
	 * Adds given Expense object to the internal list of monthly expense objects.
	 * @param expense to add
	 */
	public void addExpense(Expense expense) {
		
		// TODO Implement method
		monthlyExpenses.add(expense);
	}
	
	///// DO NOT CHANGE CODE IN MAIN METHOD! /////
	public static void main(String[] args) {
		
		//load expenses.txt file and get list of expenses
		List<String> expensesList = ExpenseFileReader.loadExpenses("expenses.txt");
		
		//parse list of expenses into a list of expense maps
		List<Map<Integer, Double>> monthlyExpenses = ExpenseFileParser.parseExpenses(expensesList);
				
		//print list of expense maps for debugging purposes
		System.out.println(monthlyExpenses);
		
		//create instance of expenses class
		Expenses expenses = new Expenses();
				
		//add list of maps to internal list of expense objects
		expenses.addExpenses(monthlyExpenses);	
		
	}
}
