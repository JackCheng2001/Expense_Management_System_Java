package expenses;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExpenseTest {

	@Test
	void testEquals() {

		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create individual expenses
		Expense expense1 = new Expense(12, 2.34);
		Expense expense2 = new Expense(12, 2.34);
		
		//compare for equality
		assertEquals(expense1, expense2, "The 2 expenses should be considered equal. They are for the same amount and the same month.");
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
		
		
		// TODO insert 1 additional test case
        // Hint(s): Create additional expense objects and compare
		// #1 compare two not equal expense, with both not equal month and amount
		Expense expense3 = new Expense(1, 2.34);
		Expense expense4 = new Expense(2, 5.34);
		assertNotEquals(expense3, expense4, "The 2 expenses should be considered not equal. They are for the same amount and the same month.");
		// #2 compare two not equal expense, with equal month but not equal amount
		Expense expense5 = new Expense(1, 2.34);
		Expense expense6 = new Expense(1, 5.34);
		assertNotEquals(expense5, expense6, "The 2 expenses should be considered not equal. They are for the same amount and the same month.");
		// #3 compare two not equal expense, with equal amount but not equal in month
		Expense expense7 = new Expense(1, 2.34);
		Expense expense8 = new Expense(2, 2.34);
		assertNotEquals(expense7, expense8, "The 2 expenses should be considered not equal. They are for the same amount and the same month.");
	}

}
