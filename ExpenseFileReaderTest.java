package expenses.file;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExpenseFileReaderTest {

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
	void testLoadExpenses() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create array with expected lines of expenses_sample.txt file
		String[] expectedLines1Array = {
			"1,57.38", 
			"2:32.88", 
			"3 44.64"
		};
		
		List<String> expectedExpensesListSample = new ArrayList<String>(Arrays.asList(expectedLines1Array));
		
		//compare to actual lines of expenses_sample.txt file
		assertEquals(expectedExpensesListSample, this.expensesListSample, "The expected 3 lines do not match the actual 3 lines from the sample expenses.");
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
		
		
		
		// TODO insert 1 additional test case
        // Hint(s): Test lines from expenses.txt file
		// Define an array of expected lines representing expenses.
		// Each string in the array corresponds to a line as it should appear in the 'expenses_sample.txt' file.
		String[] expectedLines1Array_1 = {
				"1,57.38",
				"2,32.88",
				"3 44.64",
				"4,3.09",
				"5 5.06",
				"10:456.99",
				"5,  3.99",
				"2,10",
				"12 ,32",
				"1 :57.38",
				"2 , 1.1",
				"5,0.0",
				"7, 999",
				"4 4",
				"12 5",
				"11  6"
		};
		// Convert the array of expected lines into a List for easy comparison
		List<String> expectedExpensesList = new ArrayList<String>(Arrays.asList(expectedLines1Array_1));
		// Compare the expected list of expense lines to the actual list obtained from the file
		// Asserts that the two lists are equal in both content and order
		assertEquals(expectedExpensesList, this.expensesList, "The expected 16 lines do not match the actual 16 lines from the sample expenses.");

	}

}
