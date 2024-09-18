package expenses.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages the loading and parsing of expense files.
 * @author lbrandon
 *
 */
public class ExpenseFileReader {

	/**
	 * Loads the given filename and adds each line to a list.
	 * Ignores lines with only whitespace.
	 * @param fileName to load
	 * @return list of lines from the file
	 */
	public static List<String> loadExpenses(String fileName) {
		
		// TODO Implement method
		// Hint: Load and read each line in the file
		// Strip each line of leading and trailing whitespace
		// If a line is made up entirely of whitespace, ignore it
		// Return a list of lines

		// Initialize an empty list to store the lines from the file
		List<String> lines = new ArrayList<>();
		// Create a Path object from the given filename
		Path path = Paths.get(fileName);
		// Use a try-with-resources statement to ensure the BufferedReader is closed after use
		try (BufferedReader reader = Files.newBufferedReader(path)) {
			String line;
			// Read each line from the file until there are no more lines
			while ((line = reader.readLine()) != null) {
				// Trim leading and trailing whitespace from the line
				line = line.trim();
				// Check if the line is not empty after trimming
				if (!line.isEmpty()) {
					// Add the non-empty line to the list
					lines.add(line);
				}
			}
		} catch (IOException e) {
			// If an IOException occurs, print an error message with the exception details
			System.err.println("Error reading the file: " + e.getMessage());
		}
		// Return the list of lines read from the file
		return lines;

	}
	
	///// DO NOT CHANGE CODE IN MAIN METHOD! /////
	public static void main(String[] args) {
		
		//load expenses_sample.txt file and get list of expenses
		List<String> expensesListSample = ExpenseFileReader.loadExpenses("expenses_sample.txt");
		
		//print sample expenses
		System.out.println("SAMPLE EXPENSES\n");
		for (String line : expensesListSample) {
			System.out.println(line);
		}
		
		//blank line
		System.out.println();
		
		//load expenses.txt file and get list of expenses
		List<String> expensesList = ExpenseFileReader.loadExpenses("expenses.txt");
		
		//print expenses 
		System.out.println("EXPENSES\n");
		for (String line : expensesList) {
			System.out.println(line);
		}
	}
}