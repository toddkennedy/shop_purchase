package edu.albany.finalproject1;
import java.util.ArrayList;

// Facade Design Pattern
// This Class takes in Inputted values from Main and if Buyer decided to choose item
// object will be instantiated and then put into a list to be printed out.

public class PurchaseItems {

	int flowers;		// Flower Identifier Number
	int numFlowers;		// Number of Flower(s)
	int candy;			// Candy Identifier Number
	int numCandy;		// Number of Candy
	int cards;			// Card Identifier Number
	int numCards;		// Number of Card(s)
	double addPrices;	// Adds Item Prices for Total Price
	StringBuffer stringBuffer = new StringBuffer("");  // StringBuffer for Appended toString Methods
	
	// Class Constructor
	public PurchaseItems(int flowers, int numFlowers, int candy, int numCandy, int cards, int numCards) {
		// TODO Auto-generated constructor stub

	// Creates an ArrayList cartItems reference of a CartItems object	
	ArrayList<CartItems<Double>> cartItems = new ArrayList<CartItems<Double>>();
	
	if(flowers != 0){													// If Not Zero flowers
		CartItems<Double> flowerBuy = new Flowers(flowers, numFlowers); // Create flowerBuy reference
		cartItems.add(flowerBuy);										// Add flowerBuy to cartItems Array
		}

	if(candy != 0){														// If Not Zero candy
		CartItems<Double> candyBuy = new Candy(candy, numCandy);		// Create candyBuy reference
		cartItems.add(candyBuy);										// Add candyBuy to cartItems Array
		}
	
	if(cards != 0){														// If Not Zero cards
		CartItems<Double> cardsBuy = new Card(cards, numCards);			// Create cardsBuy reference
		cartItems.add(cardsBuy);										// Add cardsBuy to cartItems Array
		}
	
	if(flowers > 0 || candy > 0 || cards > 0){	// If an Item is to be purchased 
												// run item through enhanced for-Loop

		for(CartItems<Double> cartItem : cartItems){
			
			stringBuffer = stringBuffer.append(cartItem.toString()); // Appends Item's toString Method(s) 
			
			addPrices = addPrices + cartItem.priceOfItems();		 // Totals Price of Items
			
		    }
		}
	}

	@Override
	public String toString(){
		
		return String.format("%s%nThe Total Price of Items in your Cart is: $%.2f%n%n", 
				stringBuffer, addPrices);
		
	}

}
