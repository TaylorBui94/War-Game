import java.util.*;

/**
 * This class has all of the menu for the war game. It also calls the other method for the game to function.
 * Menu Java
 * Project 1
 * @author Taylor Bui
 * @since 2010-02-07
 *
 */
public class Menu {

	/**
	 * This is the menu for the war game. It provides all of the method call as well as the
	 * layout and it runs the game.
	 */
	public void playWar()
	{

		System.out.println("Generating deck: ");
		Deck myDeck = new Deck();
		myDeck.display();
		
		System.out.println("Shuffling deck");
		myDeck.shuffle();
		myDeck.display();
		
		Player computer = new Player();
		Player player = new Player();
		
		//Creates a hand for both computer + user
		for(int i = 0 ; i < 52/2; i++)
		{
			Card topCard = myDeck.deal();
			player.drawCard(topCard);
			topCard = myDeck.deal();
			computer.drawCard(topCard);
		}
		
		System.out.println();

		System.out.println( "\nPlayer ");
		player.displayHand();
		System.out.println("Player deck size:" + player.getSize());
		
		System.out.println( "\nComputer ");
		computer.displayHand();
		System.out.println("Comp deck size: " +computer.getSize());
		System.out.println();
		
		System.out.println("\n\n\n\nWar Game start! ");
	
		while(true)
		{
		
		if(computer.getSize() == 0)
		{
			System.out.println("You won!");
			break;
		}
		
		if(player.getSize() == 0)
		{
			System.out.println("You lost.");
			break;
		}
		
		System.out.println("###############################");
		System.out.println( "####   Player Deck: " + player.getSize() + "    #####");
		System.out.println( "####   Comp   Deck: "  + computer.getSize() + "    #####");
		System.out.println("###############################");
		
		Card temp = player.getCard(0);
		Card temp2 = computer.getCard(0);
	
		System.out.print("Your Card: " );
		temp.display();
		System.out.println();
		
		System.out.print("Comp Card: " );
		temp2.display();
		System.out.println();

		nextTurn (player.compareValues(computer.getCard(0), 1 ), player,computer);
			
		System.out.println("Press Any Key To Continue...");
        new Scanner(System.in).nextLine();
		}
		
		System.out.println("###############################");
		System.out.println( "####   Player Deck: " + player.getSize() + "    #####");
		System.out.println( "####   Comp   Deck: "  + computer.getSize() + "    #####");
		System.out.println("###############################");
		System.out.println("War game ended");
	}
		
	/**
	 * This method is what dictates what the next turn the program will do based off the previoud cards.
	 * @param x. Value that indicates win, loss tied.
	 * @param player. The ArrayList player that contains the player's hand.
	 * @param computer. The Arraylist computer that contains the computer's hand.
	 */
	public void nextTurn(int x, Player player, Player computer)
	{
		
		Player tempHand = new Player();
		Player tempComp = new Player();

		if(x == 1)
		{
			player.addBottom();
			player.drawCard(computer.loseCard());
			System.out.println("# Won! You gained a card, Computer lost one. #");
			//done if computer does nothing
		}else
			if(x == 0)
			{
				
				System.out.println("# Your rank is lower, would you like to play another card? Y/N #");
				Scanner in = new Scanner(System.in);
				char c = in.nextLine().toLowerCase().charAt(0);
				//char c = 'n';
				if (c == 'y')
				{
					tempHand.drawCard(player.getCard(0));
					System.out.print("You drew: " );
					player.getCard(1).display();
					tempHand.drawCard(player.getCard(1));
					System.out.print(". Hand: " );
					
					tempHand.displayHand();
					int sum = tempHand.getRealValue();
							
					System.out.print("Your total is:" + sum +". Opponent is: ");
					computer.getCard(0).display();
					System.out.println("");
					
					int z =tempHand.compareValues(computer.getCard(0),2);
					if( z == 1 )
					{
						player.addBottom();
						player.addBottom();
						player.drawCard(computer.loseCard());
						System.out.println("# Won! You won a card, Comp lost one. #");
					}else
					{
						computer.addBottom();
						computer.drawCard(player.loseCard());
						computer.drawCard(player.loseCard());
						System.out.println("# Lost! You lost two cards, Comp gained both #");
					}
				}else
					if(c == 'n' )
					{
						computer.addBottom();
						computer.drawCard(player.loseCard());
						System.out.println("# Lost! You lost a card, Comp gained one. #");
					}
			}else
			{
				while(true)
				{
					System.out.println("##############");
					System.out.println("#  War time! #");
					System.out.println("##############");
					
					for ( int i = 0;i < 4; i++)
					{
						if(player.getSize() >  1)
							{tempHand.drawCard(player.loseCard());}
						if(computer.getSize() > 1)
							{tempComp.drawCard(computer.loseCard());}
					}
							
					int z = player.compareValues(computer.getCard(0), 3);	
					
					System.out.print("You drew: " );
					player.getCard(0).display();
					
					System.out.println("");
					
					System.out.print("Comp drew: " );
					computer.getCard(0).display();
					
					System.out.println("");
					
					if(z == 1)
					{
						System.out.println("# Won! You won the war. You gained a lot of cards #");
					
						int t = tempHand.getSize();
						for(int i = 0 ; i < t;i++)
						{
							player.drawCard(tempHand.loseCard());					
						}
						
						int u = tempComp.getSize();
						for(int i = 0; i < u; i++)
						{
							player.drawCard(tempComp.loseCard());
						}
						player.drawCard(computer.loseCard());
						
						tempHand.displayHand();
						tempComp.displayHand();
						
						break;
						}else
							
							if(z == 0)
							{
								System.out.println("# Lost! You lost the war. Computer gained a lot of cards #");
								
								int t = tempHand.getSize();
								for(int i = 0 ; i <t;i++)
								{
									computer.drawCard(tempHand.loseCard());					
								}
								
								int u = tempComp.getSize();
								for(int i = 0; i < u; i++)
								{
									computer.drawCard(tempComp.loseCard());
								}
								computer.drawCard(player.loseCard());
								break;
							}
				tempHand.drawCard(player.loseCard());
				tempComp.drawCard(computer.loseCard());
			}			
	}	
	}
}
