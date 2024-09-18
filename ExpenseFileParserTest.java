package expenses.file;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExpenseFileParserTest {

	//list to store lines from expenses_sample.txt file
	List<String> expensesListSample;
	
	//list to store lines from expenses.txt file
	List<String> expensesList;
		
	@BeforeEach
	void setUp() throws Exception {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//load expenses_sample.txt file and get list of expenses
		this.expensesListSample = ExpenseFileReader.loadExpenses("expenses_sample.txt");
				
		//load expenses.txt file and get list of expenses
		this.expensesList = ExpenseFileReader.loadExpenses("expenses.txt");
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
		
	}

	@Test
	void testParseExpenses() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//parse list of sample expenses into a list of expense maps
		List<Map<Integer, Double>> monthlyExpensesSample = ExpenseFileParser.parseExpenses(this.expensesListSample);
		
		//create arraylist with expected expense maps
		List<Map<Integer, Double>> expectedMonthlyExpensesSample = new ArrayList<Map<Integer, Double>>();
		
		Map<Integer, Double> sampleExpenseMap = new HashMap<Integer, Double>();
		sampleExpenseMap.put(1, 57.38);
		expectedMonthlyExpensesSample.add(sampleExpenseMap);
		
		sampleExpenseMap = new HashMap<Integer, Double>();
		sampleExpenseMap.put(2, 32.88);
		expectedMonthlyExpensesSample.add(sampleExpenseMap);
		
		sampleExpenseMap = new HashMap<Integer, Double>();
		sampleExpenseMap.put(3, 44.64);
		expectedMonthlyExpensesSample.add(sampleExpenseMap);
		
		//compare to actual expense maps
		assertEquals(expectedMonthlyExpensesSample, monthlyExpensesSample, "The expected 3 expense maps do not match the actual 3 expense maps from the sample expenses.");
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
		
		
		// TODO insert 1 additional test case
        // Hint(s): Parse and test list of expenses from expenses.txt
		// #1 Parse and test list of expenses from expenses.txt

		// Parse the list of expenses using the parseExpenses method from ExpenseFileParser
		List<Map<Integer, Double>> monthlyExpenses = ExpenseFileParser.parseExpenses(this.expensesList);
		// Initialize a list to hold the expected results for comparison
		List<Map<Integer, Double>> expectedMonthlyExpenses = new ArrayList<Map<Integer, Double>>();
		// Create and add expense maps for each expected entry based on the contents of expenses.txt
		// Adding expected entry for month 1 with amount 57.38
		Map<Integer, Double> ExpenseMap = new HashMap<Integer, Double>();
		ExpenseMap.put(1, 57.38);
		expectedMonthlyExpenses.add(ExpenseMap);

		ExpenseMap = new HashMap<Integer, Double>();
		ExpenseMap.put(2, 32.88);
		expectedMonthlyExpenses.add(ExpenseMap);

		ExpenseMap = new HashMap<Integer, Double>();
		ExpenseMap.put(3, 44.64);
		expectedMonthlyExpenses.add(ExpenseMap);

		ExpenseMap = new HashMap<Integer, Double>();
		ExpenseMap.put(4, 3.09);
		expectedMonthlyExpenses.add(ExpenseMap);

		ExpenseMap = new HashMap<Integer, Double>();
		ExpenseMap.put(5, 5.06);
		expectedMonthlyExpenses.add(ExpenseMap);

		ExpenseMap = new HashMap<Integer, Double>();
		ExpenseMap.put(10, 456.99);
		expectedMonthlyExpenses.add(ExpenseMap);

		ExpenseMap = new HashMap<Integer, Double>();
		ExpenseMap.put(5, 3.99);
		expectedMonthlyExpenses.add(ExpenseMap);

		ExpenseMap = new HashMap<Integer, Double>();
		ExpenseMap.put(2, 10.0);
		expectedMonthlyExpenses.add(ExpenseMap);

		ExpenseMap = new HashMap<Integer, Double>();
		ExpenseMap.put(12, 32.0);
		expectedMonthlyExpenses.add(ExpenseMap);

		ExpenseMap = new HashMap<Integer, Double>();
		ExpenseMap.put(1, 57.38);
		expectedMonthlyExpenses.add(ExpenseMap);

		ExpenseMap = new HashMap<Integer, Double>();
		ExpenseMap.put(2, 1.1);
		expectedMonthlyExpenses.add(ExpenseMap);

		ExpenseMap = new HashMap<Integer, Double>();
		ExpenseMap.put(5, 0.0);
		expectedMonthlyExpenses.add(ExpenseMap);

		ExpenseMap = new HashMap<Integer, Double>();
		ExpenseMap.put(7, 999.0);
		expectedMonthlyExpenses.add(ExpenseMap);

		ExpenseMap = new HashMap<Integer, Double>();
		ExpenseMap.put(4, 4.0);
		expectedMonthlyExpenses.add(ExpenseMap);

		ExpenseMap = new HashMap<Integer, Double>();
		ExpenseMap.put(12, 5.0);
		expectedMonthlyExpenses.add(ExpenseMap);

		ExpenseMap = new HashMap<Integer, Double>();
		ExpenseMap.put(11, 6.0);
		expectedMonthlyExpenses.add(ExpenseMap);

		// Compare the parsed expenses with the expected expenses
		// Asserts that the two lists are equal
		assertEquals(expectedMonthlyExpenses, monthlyExpenses, "The expected 16 expense maps do not match the actual 16 expense maps from the sample expenses.");
	}

}
