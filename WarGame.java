/**
 * WarGame Class
 * Project 1
 * @author Taylor Bui
 * @since 2010-02-07
 * 
 * This program creates a deck of 52 cards. It then distributes the 52 cards in half between a player and a computer.
 * The program then simulates "War." It gives the user the ability to choose to draw or not draw a class if they lose.
 * The computer's turn is automatically done. If the user single card is higher than the computer then the player wins
 * the card the computer is holding. If the opposite happens then the user gets the choice to draw a card. If they draw
 * a card they will win if the first card and second card value is less than the computer's card. If they lose then they
 * lose both cards. If the user and computer ties then war happens. The computer and player bet 4 cards. The one that has
 * the higher value on the 4th card will win all 8 cards. If it ties then war repeats again and bets an additional 4 cards
 * from each.
 *
 */

import java.util.*;

/**
 * WarGame Class
 * Project 1
 * @author Taylor Bui
 * @since 2010-02-07
 *
 */
public class WarGame {
	public static void main(String[] args) {
		
		Menu c= new Menu();
		c.playWar();
	}
}