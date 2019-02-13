

import java.util.Random;


/**
 * This class holds the deck. It generates a deck of 52 cards and is able to shuffle it with the method.
 * It also has a deal function.
 * 
 * Deck Class
 * Project 1
 * @author Taylor Bui
 * @since 2010-02-07
 *
 */
public class Deck 
{
	private int size;
	private Card[] Deck; 
	private int Top;
	private String suits = "HDSC";
	private String ranks = "A23456789TJQK";

	/**
	 * Constructor for generating a deck of 52 cards with suits and ranks.
	 */
	public Deck() 
	{
		Deck = new Card[52];
		Top = 0; 
		int count = 0;
		Card C1;
		for (int s = 0; s < suits.length(); s++) {
			for (int r = 0; r < ranks.length(); r++) {
				C1 = new Card(ranks.charAt(r), suits.charAt(s));
				Deck[count++] = C1;
			}
		}
		size = Deck.length;

	}

	/**
	 * Shows the content of the deck.
	 */
	public void display() 
	{	
		int index = 0;
		for (int i = 0; i < suits.length(); i++) {
			for (int y = 0; y < ranks.length(); y++) {
				Deck[index].display();
				if (Deck[index].getRank() == 'T') {
					System.out.print("  ");
				} else {
					System.out.print("   ");
				}
				index++;
			}
			System.out.println();
		}
	}
	
	/**
	 *  Randomizes the order of the deck.
	 */
	public void shuffle() 
	{
		Random rand = new Random();
		int x, y;
		for (int i = 0; i < 1000; i++) 
		{
			x = rand.nextInt(52); // Total number of items.
			y = rand.nextInt(52);
			Card temp;
			temp = Deck[x];
			Deck[x] = Deck[y];
			Deck[y] = temp;
		}
		Top = 0;
	}
	
	/**
	 * Method that takes a card from the deck to give out.
	 * @return Deck. Card object that contains the card at the index Top.
	 */
	public Card deal() 
	{
		return Deck[Top++];
	}
}