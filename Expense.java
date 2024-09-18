package expenses;

/**
 * Represents a single expense for a particular month.
 * @author lbrandon
 */
public class Expense {

	/**
	 * Number of month for expense.
	 */
	private int month;
	
	/**
	 * Amount of expense.
	 */
	private double amount;
	
	/**
	 * Creates Expense with given month number and amount.
	 * @param month for expense
	 * @param amount for expense
	 */
	public Expense(int month, double amount) {
		this.month = month;
		this.amount = amount;
	}
	
	/**
	 * Get month of expense.
	 * @return month
	 */
	public int getMonth() {
		return this.month;
	}
	
	/**
	 * Get amount of expense.
	 * @return amount
	 */
	public double getAmount() {
		return this.amount;
	}
	
	/**
	 * Returns the month number and amount for expense.
	 */
	@Override 
	public String toString() {
		return this.month + " : " + this.amount;
	}
	
	/**
	 * Compares two Expense objects for equality, based on the months and amounts.
	 * If the month and amount of one Expense object is equal to 
	 * the month and amount of the other Expense object, 
	 * the two Expense objects are equal.
	 */
	@Override 
	public boolean equals(Object o) {

		// TODO Implement method
		// Hint: Cast given Object o to Expense object
		// Compare month and amount of this Expense to other casted Expense
		// Check if the current instance is the same as the object being compared with
		if (this == o) return true;
		// Check if the object being compared is null or if it's not an instance of the same class
		// If either condition is true, the objects are not equal
		if (o == null || getClass() != o.getClass()) return false;
		// Cast the object to Expense to compare the fields
		Expense expense = (Expense) o;
		// Compare the month and amount fields of the current instance and the other instance
		// Return true if both the month and amount are equal, otherwise return false
		// The Double.compare method is used for comparing double values to handle floating-point precision
		return month == expense.month &&
				Double.compare(expense.amount, amount) == 0;
	}
}