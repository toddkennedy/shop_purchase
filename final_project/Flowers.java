package edu.albany.finalproject1;

public class Flowers implements CartItems<Double> {

	private int flowers;				// Flower Identifier Number
	private int numFlowers;				// Number of Flower(s) Unit(s)
	private double priceOfItems; 		// Total Price of Flower Item(s)

	public Flowers(int flowers, int numFlowers) {
		// TODO Auto-generated constructor stub

		this.flowers = flowers;
		this.numFlowers = numFlowers;
	
	}
		
	public enum Answers{

		ROSE("Rose(s)", 1.99), 
		CARNATION("Carnation(s)", 0.99), 
		TULIP("Tulip(s)", 1.25), 
		LILY("Lily(s)", 1.75);

		private String flowerName;
		private double itemPrice;
		
		Answers(String flowerName, double itemPrice){
			
			this.flowerName = flowerName;
			this.itemPrice = itemPrice;
			
		}
			
	}
			
	public Answers flowerType(){ // Compares Flower choice in condition statement to access
								 // enum variables

		if(flowers == 1){
			return Flowers.Answers.ROSE;
		}
		else if(flowers == 2){
			return Flowers.Answers.CARNATION;
		}
		else if(flowers == 3){
			return Flowers.Answers.TULIP;
		}
		else{
			return Flowers.Answers.LILY;
		}
	
	}
	
	public String getFlowerName(){  // Get Flower Name
		
		return flowerType().flowerName;
			
	}
	
	public Integer getFlowers(){  	// This Integer is the initial Customer Flower Choice 
		
		return flowers;
		
	}
	public Integer getNumFlowers(){	// Number of Flowers the Customer wants
		
		return numFlowers;
		
	}
		
	public Double getItemPrice(){	// Gets Price of each Flower Item
		
		return flowerType().itemPrice;
		
	}
	
	@Override
	public Double priceOfItems(){
		
		priceOfItems = getNumFlowers() * getItemPrice();	// Total Price of Flower Item(s)
		
		return priceOfItems;
		
	}

	@Override
	public String toString(){  // PrintOut Flower Purchase Information
		
		return String.format("%nYour %s %s costs %.2f%n", getNumFlowers(), getFlowerName(), priceOfItems());
		
	}

}
