/**
 * @author Steven Cassidy
 * Date: 5/27/16
 * Purpose: To create a square with specified sideLength with the numbers 1-sideLength^2 non repeating
 */
import java.util.ArrayList;

public class Square 
{
	private int sideLength;
	private int[][] square;
	/**
	 * initialize the square 
	 */
	
	public Square(int side)
	{
		sideLength = side;
		square = createSquare();
	}
	/**
	 * create sideLengthXsideLength a square  with the numbers 1-sideLength^2 non repeating
	 * @return the square
	 */
	public int[][] createSquare()
	{
		ArrayList <Integer> listOfNums = new ArrayList <Integer>();
		for(int num  = 0;num < (int)(Math.pow(sideLength, 2));num++)
		{
			listOfNums.add(new Integer(num + 1));
		}
		
		int[][] tempSquare = new int[sideLength][sideLength];
		
		for(int row = 0; row < tempSquare.length;row++)
		{
			for(int col = 0; col < tempSquare[0].length;col++)
			{
				int selection = (int) (Math.random() * listOfNums.size()); 
				tempSquare[row][col] = listOfNums.get(selection);
				listOfNums.remove(selection);
				
			}
		}
		return tempSquare;
	}
	
	
	
	public int getSideLength() 
	{
		return sideLength;
	}
	/**
	 * Allow the user to get the square
	 * @return the square
	 */
	public int[][] getSquare() 
	{
		return square;
	}
	/**
	 * Create a String representation of a Square object
	 * @return the message
	 */
	public String toString() 
	{
		String message = " Here is your " + sideLength + "X" + sideLength +" square: \n";
		for(int row = 0; row < square.length;row++)
		{
			for(int col = 0; col < square[0].length;col++)
			{
				message += square[row][col] + " ";
			}
			message += "\n";
		}
		return message;
	}
	
}