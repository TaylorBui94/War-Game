

/**
 * This class contains the rank and suits of each card. It also displays the card rank and suit if needed.
 * 
 * Card Class
 * Project 1
 * @author Taylor Bui
 * @since 2010-02-07
 *
 */
public class Card 
{
	private char suit;
	private char rank;

	/**
	 * Constructor for the Card method.
	 * @param r. The rank of the card expressed as a char.
	 * @param s. The suit of the card expressed as a char.
	 */
	public Card(char r, char s) 
	{
		rank = r;
		suit = s;
	}
	
	/**
	 * Method for printing individual cards.
	 */
	public void display() 
	{
		if (rank == 'T') 
		{
			System.out.print("10" + "" + suit);
		}
		else 
		{
			System.out.print(rank + "" + suit);
		}
	}
	
	/**
	 * Gives the value of each rank. King, Queen, Jack are given bigger values than usual.
	 * @return. The value of the rank.
	 */
	public int getValue() 
	{
		if(rank == 'K')return 13;
		if(rank == 'Q')return 12;
		if(rank == 'J')return 11;
		if(rank == 'T')return 10;
	    if(rank == '9')return 9;
	    if(rank == '8')return 8;
	    if(rank == '7')return 7;
	    if(rank == '6')return 6;
	    if(rank == '5')return 5;
	    if(rank == '4')return 4;
	    if(rank == '3')return 3;
	    if(rank == '2')return 2;
	    if(rank == 'A')return 1;
	    System.out.println("Rank failed: ");
	    return 0;	
	}

	/**
	 * Gives the numeric value of each for computing the card value.
	 * @return. The value of the rank
	 */
	public int getRealValue() 
	{
		if(rank == 'K')return 10;
		if(rank == 'Q')return 10;
		if(rank == 'J')return 10;
		if(rank == 'T')return 10;
	    if(rank == '9')return 9;
	    if(rank == '8')return 8;
	    if(rank == '7')return 7;
	    if(rank == '6')return 6;
	    if(rank == '5')return 5;
	    if(rank == '4')return 4;
	    if(rank == '3')return 3;
	    if(rank == '2')return 2;
	    if(rank == 'A')return 1;
	    System.out.println("Rank failed: ");
	    return 0;	
	}
	
	/**
	 * Getter method for suit
	 * @return suit. The suit of the card.
	 */
	public char getSuit() 
	{return suit;}
	
	/**
	 * Getter method for the rank.
	 * @return rank. The rank of the card.
	 */
	public char getRank() 
	{return rank;}
	
	
}

