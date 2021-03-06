/**
 * @author Steven Cassidy
 * Date: 5/27/16
 * Purpose: To create a MagicSquare class that tests if a Square is a MagicSquare 
 */
public class MagicSquare extends Square 
{
	private boolean isMagic;
	private final int MAGIC_NUMBER = this.getMagicNumber(); //The number all rows columns and diagonals must add up to in order for the square to be magic
	
	/**
	 *  call the  of the super class and set isMagic to true or false depending on if it is a MagicSquare
	 */
	public MagicSquare(int side)
	{
		super(side);
		isMagic = this.testIfMagic();
	}
	/**
	 * calculate the magic number based on side length
	 * @return the magic number
	 */
	
	public int getMagicNumber()
	{
		int number = 0;
		for(int num = 1;num <= (int)(Math.pow(super.getSideLength(), 2));num++)
		{
			number += num;
		}
		number /= super.getSideLength();
		return number;
	}
	/**
	 * test if the sum of elements in each row add up the magic number
	 * @return true or false based on the calculated sum
	 */
	public boolean testRows()
	{
		int sideLength = super.getSideLength();
		int numberOfSuccessfulAttempts = 0;
		
		for(int row = 0; row < sideLength; row++)
		{
			int rowSum = 0;
			
			for(int col = 0; col < sideLength; col++)
			{
				rowSum += super.getSquare()[row][col];
			}
			if(rowSum == MAGIC_NUMBER)
			{
				numberOfSuccessfulAttempts++;
			}
		}
		if(numberOfSuccessfulAttempts == sideLength)
		{
			return true;
		}
		return false;
	}
	/**
	 * test if the sum of elements in each column add up the magic number
	 * @return true or false based on the calculated sum
	 */
	public boolean testCols()
	{
		int sideLength = super.getSideLength();
		int numberOfSuccessfulAttempts = 0;
		
		for(int col = 0; col < sideLength; col++)
		{
			int colSum = 0;
			
			for(int row = 0; row < sideLength; row++)
			{
				colSum += super.getSquare()[row][col];
			}
			if(colSum == MAGIC_NUMBER)
			{
				numberOfSuccessfulAttempts++;
			}
		}
		if(numberOfSuccessfulAttempts == sideLength)
		{
			return true;
		}
		return false;
	}
	/**
	 * test if the sum of elements in each diagonal add up the magic number
	 * @return true or false based on the calculated sum
	 */
	public boolean testDiagonals()
	{
		int sideLength = super.getSideLength();
		int numberOfSuccessfulAttempts = 0;
		int diagOneSum = 0;
		int col = 0;
		for(int row  = 0; row < sideLength; row++)
		{
			diagOneSum += super.getSquare()[row][col];
			col++;
		}
		if(diagOneSum == MAGIC_NUMBER)
		{
			numberOfSuccessfulAttempts++;
		}
		int diagTwoSum = 0;
		col = sideLength - 1;
		for(int row  = 0; row < sideLength; row++)
		{
			diagTwoSum += super.getSquare()[row][col];
			col--;
		}
		if(diagTwoSum == MAGIC_NUMBER)
		{
			numberOfSuccessfulAttempts++;
		}
		if(numberOfSuccessfulAttempts == 2)
		{
			return true;
		}
		return false;

	}
	
	
	/**
	 * test if the Square is a MagicSquare
	 * @return true or false depending on if the square is magic
	 */
	public boolean testIfMagic()
	{
		boolean rows = this.testRows();
		boolean cols = this.testCols();
		boolean diagonals = this.testDiagonals();
		
		
		if(rows && cols && diagonals)
		{
			return true;
		}
		return false;
		
	}
	
	/**
	 * get isMagic
	 * @return isMagic
	 */
	public boolean getIsMagic() 
	{
		return isMagic;
	}
	
	/**
	 * Create a String representation of a MagicSquare object
	 * @return Square's toString plus the message
	 */
	public String toString()
	{
		String message = "";
		
		if(isMagic)
		{
			message = "Congradulations all sums add up to " + MAGIC_NUMBER + " your square is magic!";
		}
		else
		{
			message = "Sorry all sums do not add up to " + MAGIC_NUMBER + " your square is not magic!";
		}
		return super.toString() + message;
	}
	
}