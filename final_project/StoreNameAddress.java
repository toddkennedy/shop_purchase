package edu.albany.finalproject1;

// Singleton Design Pattern
// This Class is designed to provide Store Name and Address 

public class StoreNameAddress {

	private static StoreNameAddress storeNameAddress = null;	// Create Reference of StoreNameAddress 
	private String storeName;									// Store Name
	private String address1;									// Street Address of Store
	private String address2;									// City, State and Zipcode of Store

	private StoreNameAddress(){
		
		storeName = "Sweet Something's Flower, Candy and Card Shop";
		address1 = "1234 SweetHeart Lane";
		address2 = "Albany, NY 12222";
		
	}

	public static StoreNameAddress getStoreNameAddress(){
		
		if(storeNameAddress == null){

			storeNameAddress = new StoreNameAddress();
						
		}

		return storeNameAddress;
	}

	public String toString(){
		
		return String.format("%s%n%s%n%s%n", getStoreNameAddress().storeName, getStoreNameAddress().address1, 
							 getStoreNameAddress().address2);
		
	}

}
