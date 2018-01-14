package edu.albany.finalproject1;

public class Candy implements CartItems<Double> {

	private int candy;					// Candy Identifier Number
	private int numCandy;				// Number of Candy Units
	private double priceOfItems; 		// Total Price of Candy Items 

	public Candy(int candy, int numCandy) {
		// TODO Auto-generated constructor stub

		this.candy = candy;
		this.numCandy = numCandy;
		
	}

	public enum Answers{

		CHOCOLATE("Chocolate(s)", 4.99), 
		DARK_CHOCOLATE("Dark Chocolate(s)", 5.25), 
		WHITE_CHOCOLATE("White Chocolate(s)", 5.50), 
		SUGAR_FREE_CHOCOLATE("Sugar-Free Chocolate(s)", 5.99);

		private String candyName;
		private double itemPrice;
		
		Answers(String candyName, double itemPrice){
			
			this.candyName = candyName;
			this.itemPrice = itemPrice;
			
		}
			
	}
			
	public Answers candyType(){ // Compares Candy choice in condition statement to access
								 // enum variables
		
		if(candy == 1){
			return Candy.Answers.CHOCOLATE;
		}
		else if(candy == 2){
			return Candy.Answers.DARK_CHOCOLATE;
		}
		else if(candy == 3){
			return Candy.Answers.WHITE_CHOCOLATE;
		}
		else{
			return Candy.Answers.SUGAR_FREE_CHOCOLATE;
		}	

	}
	
	public String getCandyName(){  // Get Candy Name
		
		return candyType().candyName;
		
	}
		
	public Integer getCandy(){   	// This Integer is the initial Customer Candy Choice
		
		return candy;
		
	}

	public Integer getNumCandy(){	// Number of Candy the Customer wants
		
		return numCandy;
		
	}
	
	public Double getItemPrice(){	// Gets price of each Candy Item
		
		return candyType().itemPrice;

	}
		
	@Override
	public Double priceOfItems(){		// Total Price of Candy Item(s)
		
		priceOfItems = getNumCandy() * getItemPrice();  
		
		return priceOfItems;
		
	}

	@Override
	public String toString(){  // PrintOut Candy Purchase Information
		
		return String.format("%nYour %s %s costs %.2f%n", getNumCandy(), getCandyName(), priceOfItems());
		
	}

}
