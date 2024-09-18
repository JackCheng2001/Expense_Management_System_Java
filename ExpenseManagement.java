
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import expenses.Expense;
import expenses.Expenses;
import expenses.file.ExpenseFileParser;
import expenses.file.ExpenseFileReader;
/**
 * Provides static methods for extracting information from monthly expenses.
 * @author lbrandon
 */
public class ExpenseManagement {

	/**
	 * Mappings to match a month abbreviation with a month number.
	 * For example, the map should look like this:
	 *   {"jan"=1, "feb"=2, ...}
	 */
	private static Map<String, Integer> MONTHLY_MAPPINGS;
	
	static {
		
		//Initializes map of month abbreviations and creates mappings 
		ExpenseManagement.MONTHLY_MAPPINGS = new HashMap<String, Integer>();
		
		//populate map with keys (month abbreviations) and values (month numbers)
		ExpenseManagement.MONTHLY_MAPPINGS.put("jan", 1);
		ExpenseManagement.MONTHLY_MAPPINGS.put("feb", 2);
		ExpenseManagement.MONTHLY_MAPPINGS.put("march", 3);
		ExpenseManagement.MONTHLY_MAPPINGS.put("april", 4);
		ExpenseManagement.MONTHLY_MAPPINGS.put("may", 5);
		ExpenseManagement.MONTHLY_MAPPINGS.put("june", 6);
		ExpenseManagement.MONTHLY_MAPPINGS.put("july", 7);
		ExpenseManagement.MONTHLY_MAPPINGS.put("aug", 8);
		ExpenseManagement.MONTHLY_MAPPINGS.put("sept", 9);
		ExpenseManagement.MONTHLY_MAPPINGS.put("oct", 10);
		ExpenseManagement.MONTHLY_MAPPINGS.put("nov", 11);
		ExpenseManagement.MONTHLY_MAPPINGS.put("dec", 12);
	}
	
	/**
	 * Static method that gets mappings to match a month abbreviation with a month number.
	 * @return map of month names and month numbers
	 */
	public static Map<String, Integer> getMonthlyMappings() {
		return ExpenseManagement.MONTHLY_MAPPINGS;
	}
	
	/**
	 * Static method that gets list of expense amounts for given month number.
	 * @param month to look up
	 * @param monthlyExpenses of monthly expenses to search
	 * @return list of expense amounts for given month
	 */
	public static List<Double> getMonthlyExpenses(int month, List<Expense> monthlyExpenses) {
		
		// TODO Implement method
		// Hint: Iterate over list of monthly expenses and find the expense amounts for given month
		// Initialize an empty list to store the expenses for the specified month
		List<Double> expensesForMonth = new ArrayList<>();
		// Iterate over each Expense object in the list of monthly expenses
		for (Expense expense : monthlyExpenses) {
			// Check if the month of the current expense matches the specified month
			if (expense.getMonth() == month) {
				// If it matches, add the amount of the expense to the list
				expensesForMonth.add(expense.getAmount());
			}
		}
		// Return the list containing all the expense amounts for the specified month
		return expensesForMonth;
	}
	
	/**
	 * Static method that gets list of expense amounts for given month abbreviation.
	 * Maps given month name to month number.
	 * @param month to look up
	 * @param monthlyExpenses of monthly expenses to search
	 * @return list of expense amounts for given month
	 */
	public static List<Double> getMonthlyExpenses(String month, List<Expense> monthlyExpenses) {
		
		// TODO Implement method
		// Hint: Get number associated with given month
		// Iterate over list of monthly expenses and find the expense amounts for given numeric month

		// Retrieve the month number associated with the given month name from the MONTHLY_MAPPINGS map.
		// The month name is converted to lower case to match the keys in the map.
		Integer month_1 = MONTHLY_MAPPINGS.get(month.toLowerCase());
		// Check if the month name is valid and found in the MONTHLY_MAPPINGS map
		// If the month name is valid (i.e., the month number is not null), call getMonthlyExpenses
		// method with the numeric month value to get the list of expenses for that month.
		// If the month name is not valid (i.e., the month number is null), return an empty list.
		return month_1 != null ? getMonthlyExpenses(month_1, monthlyExpenses) : new ArrayList<>();
	}

	/**
	 * Static method that gets total expense amount for given month abbreviation.
	 * @param month to look up
	 * @param monthlyExpenses of monthly expenses to search
	 * @return total expense amount for given month
	 */
	public static double getTotalMonthlyExpenses(String month, List<Expense> monthlyExpenses) {

		// TODO Implement method
		// Hint: Get expense amounts for given month
		// Calculate sum of all expense amounts
		// Retrieve the list of expense amounts for a given month
		// This uses the getMonthlyExpenses method to get all expense amounts for the specified month
		List<Double> expensesForMonth = getMonthlyExpenses(month, monthlyExpenses);
		// Calculate the total of all expenses for the month
		// The stream() method is used to create a stream from the list of expenses
		// The mapToDouble(Double::doubleValue) method converts each Double object to a primitive double value
		// The sum() method calculates the total sum of these double values
		// This total sum represents the total expenses for the specified month
		return expensesForMonth.stream().mapToDouble(Double::doubleValue).sum();
	}
	
	/**
	 * Static method that identifies the month with the highest expense amount.
	 * First, gets the total expense amount for each month, then gets the greatest one.
	 * @param monthlyExpenses of monthly expenses to search
	 * @return Expense object with information for most expensive month
	 */
	public static Expense getMostExpensiveMonth(List<Expense> monthlyExpenses) {

		// TODO Implement method
		// Iterate over each month and get the total expenses for each
		// Identify the month with the greatest expense amount
		// Initialize a HashMap to store the total expenses for each month
		Map<Integer, Double> totalExpensesPerMonth = new HashMap<>();
		// Iterate over each Expense object in the list of monthly expenses
		for (Expense expense : monthlyExpenses) {
			// Merge expenses for the same month
			// The merge method adds the amount to the total for that month if it already exists,
			// or initializes a new total if it doesn't
			totalExpensesPerMonth.merge(expense.getMonth(), expense.getAmount(), Double::sum);
		}
		// Stream over the entries in the map
		// The max method is used to find the entry with the highest total expense amount
		// The comparingByValue method of Map.Entry is used as the comparator
		// This finds the month with the highest total expense
		return totalExpensesPerMonth.entrySet().stream()
				.max(Map.Entry.comparingByValue())
				.map(entry -> new Expense(entry.getKey(), entry.getValue()))
				.orElse(null);
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
		
		//get list of expense amounts for 10 (oct)
		List<Double> octMonthlyExpenses = ExpenseManagement.getMonthlyExpenses(10, 
				expenses.getMonthlyExpenses());
		System.out.println("Oct. Expenses: " + octMonthlyExpenses);
		
		System.out.println();
		
		//get list of expense amounts for jan
		List<Double> janMonthlyExpenses = ExpenseManagement.getMonthlyExpenses("jan", 
				expenses.getMonthlyExpenses());
		System.out.println("Jan. Expenses: " + janMonthlyExpenses);
		
		//get total expense amount for jan
		double totalJanMonthlyExpenses = ExpenseManagement.getTotalMonthlyExpenses("jan",
				expenses.getMonthlyExpenses());
		System.out.println("Total: " + totalJanMonthlyExpenses);
				
		System.out.println();
		
		//get list of expense amounts for 2 (feb)
		List<Double> febMonthlyExpenses = ExpenseManagement.getMonthlyExpenses(2,
				expenses.getMonthlyExpenses());
		System.out.println("Feb. Expenses: " + febMonthlyExpenses);
		
		//get total expense amount for feb
		double totalFebMonthlyExpenses = ExpenseManagement.getTotalMonthlyExpenses("feb",
				expenses.getMonthlyExpenses());
		System.out.println("Total: " + totalFebMonthlyExpenses);
		
		System.out.println();
		
		//get highest expense
		Expense mostExpensiveMonth = ExpenseManagement.getMostExpensiveMonth(expenses.getMonthlyExpenses());
		System.out.println("Most Expensive Month: " + mostExpensiveMonth);
	}
}
