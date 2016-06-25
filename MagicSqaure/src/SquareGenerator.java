/**
 * @author Steven Cassidy
 * Date: 5/27/16
 * Purpose: To allow the user to generate a square and test if it  is magic
 */
import java.util.Scanner;

public class SquareGenerator 
{
	public static void main(String [] args)
	{
		boolean keepGoing = true;
		/**
		 * Run the program while keepGoing is true
		 */
		while(keepGoing)
		{
			/**
			 * Create a menu for the program
			 */
			String menu = "Choose one of the following Menu Items: \n"
					+ "1. Generate a square once and test if it is a magic square.\n"
					+ "2. Generate multiple squares until a magic square is found.\n"
					+ "Enter your choice: ";
			System.out.print(menu);
			/**
			 * Allow the user to enter a choice 
			 */
			Scanner intInput = new Scanner(System.in);
			int choice = intInput.nextInt();
			
			/**
			 * Allow the user to input the size of the square
			 */
			System.out.print("Enter the number of rows and columns in the square: ");
			int sideLength = intInput.nextInt();
			
			/**
			 * if the user chooses 1 generate a square, test if it is magic and print it out
			 */
			if(choice == 1)
			{
					MagicSquare square = new MagicSquare(sideLength);
					System.out.println(square);
			
			}
			/**
			 * if the user chooses 2 generate a square until a magic  is found, print the count every 1000000  generated and print the magic square with the number of times it took 
			 */
			else if(choice == 2)
			{
				boolean magic= false;
				long count = 0;
				while(magic == false)
				{
					MagicSquare square = new MagicSquare(sideLength);
					
					if(square.getIsMagic() == true)
					{
						magic = true;
						System.out.println(count);
						System.out.println(square);
					}
					count++;
				if(count%1000000 ==0)
				{
					System.out.println(count);
				}
				
				}
			}
			/** 
			 * Ask the the user if they want to run the program again if yes the loop starts over if no the program prints goodbye and exits
			 */
			
			System.out.print("Would you like to keep going? (y for yes or n for no) ");
			Scanner StringInput = new Scanner(System.in);
			String answer = StringInput.nextLine();
			if(answer.equalsIgnoreCase("n"))
			{
				keepGoing = false;
				System.out.println("Goodbye!");
			}
		
		}
	}
}
