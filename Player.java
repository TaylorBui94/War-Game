import java.util.*;

/**
 * This class holds the objects of Cards to create the hand. It also has methods that relate to the player
 * making their move as well as comparing their card to others.
 * 
 * Player Class
 * Project 1
 * @author Taylor Bui
 * @since 2010-02-07
 *
 */
public class Player {
	
	ArrayList<Card> myHand = new ArrayList<Card>();
	
	/**
	 * This method adds a Card object to the ArrayList. Used for making myHand bigger
	 * @param Card object that has a suit and a rank
	 */
	public void drawCard(Card drawnCard)
	{
		myHand.add(drawnCard);
	}
	
/**
 * This method returns the true numerical value after summing myHand
 * @return value of the sum of myHand
 */
public int getRealValue(){ 
		int value = 0;
		
		for (int i = 0; i<myHand.size(); i++)
		{
			value += myHand.get(i).getRealValue();
		}
		
		for (int i = 0; i<myHand.size(); i++){
			if(myHand.get(i).getRealValue() == 11 && value > 21){
				value -= 10;
			}
		}	
		return value;
	}
	
	/**
	 * Print method to display myHand.
	 */
	public void displayHand(){
		
	for(int i = 0; i < myHand.size(); i++){
		myHand.get(i).display();
		System.out.print(" ");
	}
	System.out.println();
}
	
	/**
	 * Getter method for obtaining a card at a certain index "count."
	 * @param count. The index of the card to get.
	 * @return myHand.get(count) is the card at the index count.
	 */
	public Card getCard(int count)
	{
		return myHand.get(count);
	}

	/**
	 * This method compares the values of the myHand card at index 0 and another card inputted called player2
	 * @param player2. The card that is being compared to myHand's 0 index card
	 * @param type. This determines the type of comparison. 1 is for a regular 1 card to 1 card comparison. 2 is for
	 * comparing two card values to 1. 3 is for comparing war game
	 * @return 1, 0 ,2. 1 is for win, 0 is for lose, 2 is for tie.
	 */
	public int compareValues(Card player2, int type)
	{
		if(type == 1)
		{
			if(myHand.get(0).getValue()> player2.getValue())
			{
				return 1; //win
			}else
				if(myHand.get(0).getValue() < player2.getValue())
				{
					//lose
					return 0;
				}else
				{
					System.out.println("Tied, War time." );
					return 2;
				}
		}else
			if( type ==2)
			{
				int sum  = myHand.get(0).getValue() +myHand.get(1).getValue();
				if( sum <= player2.getValue())
				{
					return 1;
				}else
					{
						return 0;
					}
			}else
			{
				if(myHand.get(0).getValue()> player2.getValue())
				{
					return 1;
				}else
					if(myHand.get(0).getValue() < player2.getValue())
					{
						return 0;
					}else
						{System.out.println("Tied" );
						return 2;}
			}
	}
	
	/**
	 * Getter method for the size of the ArrayList myHand
	 * @return myHand.size(). Size of myHand
	 */
	public int getSize()
	{
		return myHand.size();
	}

	/**
	 * Called when a player loses a card. It will remove the card from myHand.
	 * @return lost. The card that is removed from myHand.
	 */
	public Card loseCard()
	{
		Card lost = myHand.get(0);
		myHand.remove(0);
		return lost;
	}
	
	/**
	 * This method resets the card from the 0th index to the last of the ArrayList
	 */
	public void addBottom()
	{
		myHand.add(myHand.get(0));
		myHand.remove(0);
	}
}
