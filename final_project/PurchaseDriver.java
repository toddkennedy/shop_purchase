package edu.albany.finalproject1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PurchaseDriver {

// This Program is designed for Sweet Something's Flower, Candy and Card Shop.
// Buyer's input whether they want to purchase certain items and then they choose how many items they want.
// The items are then placed in the their Cart which will be calculated and the results will finally 
// be printed out.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int flowers = 0;		// Flower Identifier Number
		int numFlowers = 0;		// Number of Flower(s)
		int candy = 0;			// Candy Identifier Number
		int numCandy = 0;		// Number of Candy
		int cards = 0;			// Card Identifier Number
		int numCards = 0;		// Number of Card(s)
		boolean doWhileTrue = true;  // Loop for another transaction 
		
		Scanner input = new Scanner(System.in);		// Input reference of Scanner object

		do{
		System.out.println("Please Input Flower Number - 0: NO Flower(s), 1: Rose($1.99), 2: Carnation($0.99),"
					   + "\n                             3: Tulip($1.25), 4: Lily($1.75)  ");
	    flowers = itemRangeFilter(input);	// This itemRangeFilter Method sets Range of Number Input
	    if(flowers != 0){
		    System.out.println("Please Input the Number of Flower(s) You would like to Purchase: ");
		    numFlowers = quantityRangeFilter(input); // This quantityRangeFilter Method sets Range of Number selected Items
	    	}
	    
	    System.out.println("Please Input Candy Number - 0: NO Chocolates, 1: Chocolates($4.99), 2: Dark Chocolates($5.25), "
					   + "\n                            3: White Chocolates($5.50), 4: SugarFree Chocolates($5.99)  ");
	    candy = itemRangeFilter(input);		// This itemRangeFilter Method sets Range of Number Input
	    if(candy != 0){
		    System.out.println("Please Input the Number of Candy You would like to Purchase: ");
		    numCandy = quantityRangeFilter(input);	// This quantityRangeFilter Method sets Range of Number selected Items	
	    	}

	    System.out.println("Please Input Card Tier Number - 0: NO Card(s), 1: Tier_1($0.99), 2: Tier_2($1.99), "
	    			   + "\n                                3: Tier_3($2.99), 4: Tier_4($3.99)  ");
	    cards = itemRangeFilter(input);		// This itemRangeFilter Method sets Range of Number Input
	    if(cards != 0){
		    System.out.println("Please Input the Number of Card(s) You would like to Purchase: ");
		    numCards = quantityRangeFilter(input);	// This quantityRangeFilter Method sets Range of Number selected Items
	    }

	    if(flowers == 0 && candy == 0 && cards == 0){
	    	
	    	System.out.println("\nCouldn't find anything you like? \n\nWell have a Nice Day.");
	    	
	    	doWhileTrue = false;  // Out of Loop and Ends program

	    	}
	    else{
	    	// Implementing a Singleton Pattern Design
	    	StoreNameAddress storeNameAddress1 = StoreNameAddress.getStoreNameAddress();
	    	// Implementing a Facade Pattern Design
		    PurchaseItems purchaseItems = new PurchaseItems(flowers, numFlowers, candy, numCandy, cards, numCards);
				    	
	    	System.out.println("\n***********************************************\n");
	    	System.out.println(storeNameAddress1);
	    	System.out.println("***********************************************");
	    	System.out.println("\nItem(s) in your Cart");
	    	System.out.printf("%s", purchaseItems.toString());
	    	System.out.println("\n****************************************************\n");

	    	doWhileTrue = anotherTransaction(input);  // Method will ask if the customer wants another transaction.
		    
	    	}
	    		
		}while(doWhileTrue);

	    input.close();
	}

	public static Integer itemRangeFilter(Scanner input){
		
		int itemInteger = 0;
		boolean continueLoop1 = true;
		
		do{
			try{

				itemInteger = input.nextInt();
				
				if(itemInteger >= 0 && itemInteger <= 4){
					
					continueLoop1 = false;  // Stops Loop, then goes to the return statement
											// outside of do-while Loop
				}
				else{
					
					System.out.println("Out Of Item Integer Range. Please Input an Integer between 0 and 4:  \n");
					continueLoop1 = true;   // Continues Loop and starts back up to top of try statement.
					
				}
				
			}
			catch(InputMismatchException exception){
				
//		       	System.err.printf("Exception: %s%n", exception);
		        System.out.println("Input Mismatch. Please Input an Integer between 0 and 4:  \n");
               	input.nextLine();
				System.out.println();	        	
				// Past this point in the catch the continueLoop stays true and the 
				// loop starts over again at the top of the try statement
				}

			}while(continueLoop1);
		
		return itemInteger;
	}	

	public static Integer quantityRangeFilter(Scanner input){
		
		int quantityInteger = 0;
		boolean continueLoop1 = true;
		
		do{
			try{

				quantityInteger = input.nextInt();
				
				if(quantityInteger > 0){
					
					continueLoop1 = false;  // Stops Loop, then goes to the return statement
											// outside of do-while Loop 
				}
				else{
					
					System.out.println("Out Of Quantity Range. Please Try an Integer Greater Than 0:  \n");
					continueLoop1 = true;   // Continues Loop and starts back up to top of try statement.
					
				}
				
			}
			catch(InputMismatchException exception){
				
//		       	System.err.printf("Exception: %s%n", exception);
		        System.out.println("Input Mismatch. Please Input an Integer of how many Items You would like to Buy:  \n");
               	input.nextLine();
				System.out.println();	        	
				// Past this point in the catch the continueLoop stays true and the 
				// loop starts over again at the top of the try statement
				}

			}while(continueLoop1);
		
		return quantityInteger;
	}	

	public static boolean anotherTransaction(Scanner input){

		boolean doWhileTrue1;
		String answer1 = null;         // Yes or No to try another transaction
		
		input.nextLine();              // Clears input and sets it to null
		System.out.println("Would you like to make another Transaction? (y or n):  ");
		answer1 = input.nextLine();

		if(answer1.equalsIgnoreCase("y") == true){			
			System.out.println("\nHere we go again!\n");
			doWhileTrue1 = true;
			}
		else{
			System.out.println("\nThank You for Shopping at Sweet Something's and have a Great Day!\n");
			doWhileTrue1 = false;
			}
		
		return doWhileTrue1;
	}

}
