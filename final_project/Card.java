package edu.albany.finalproject1;

public class Card implements CartItems<Double> {

	private int cards;				// Card Identifier Number
	private int numCards;			// Number of Card Unit(s)
	private double priceOfItems; 	// Total Price of Card Item(s)
	
	public Card(int cards, int numCards) {
		// TODO Auto-generated constructor stub

		this.cards = cards;
		this.numCards = numCards;
		
	}

	public enum Answers{

		TIER_1("Tier_1", 0.99), 
		TIER_2("Tier_2", 1.99), 
		TIER_3("Tier_3", 2.99), 
		TIER_4("Tier_4", 3.99);

		private String cardName;
		private double itemPrice;
		
		Answers(String cardName, double itemPrice){
			
			this.cardName = cardName;
			this.itemPrice = itemPrice;
			
		}
			
	}
			
	public Answers cardType(){ // Compares Card choice in condition statement to access
							   // enum variables
		
		if(cards == 1){
			return Card.Answers.TIER_1;
		}
		else if(cards == 2){
			return Card.Answers.TIER_2;
		}
		else if(cards == 3){
			return Card.Answers.TIER_3;
		}
		else{
			return Card.Answers.TIER_4;				
		}
		
	}
	
	public String getCardName(){   // Gets Card Tier Name
		
		return cardType().cardName;
		
	}
		
	public Integer getCards(){		// This Integer is the initial Customer Flower Choice
		
		return cards;
		
	}

	public Integer getNumCards(){	// Number of Cards the Customer wants
		
		return numCards;
		
	}
	
	public Double getItemPrice(){	// Gets Price of each Card Item
		
		return cardType().itemPrice;

	}
		
	@Override
	public Double priceOfItems(){
		
		priceOfItems = getNumCards() * getItemPrice();	// Total Price of Card Item(s)
		
		return priceOfItems;
		
	}

	@Override
	public String toString(){  // PrintOut Card Purchase Information
		
		return String.format("%nYour %s %s Card(s) costs %.2f%n", getNumCards(), getCardName(), priceOfItems());
		
	}

}
