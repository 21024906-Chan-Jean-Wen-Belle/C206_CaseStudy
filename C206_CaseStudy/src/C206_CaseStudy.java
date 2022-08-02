import java.util.AbstractCollection;
import java.util.ArrayList;

public class C206_CaseStudy {
	
	//private static final int OPTION_USER = 1;
	private static final int OPTION_CATEGORY = 1;
	private static final int OPTION_ITEM = 2;
	private static final int OPTION_BID = 3;
	private static final int OPTION_DEAL = 4;
	private static final int OPTION_QUIT = 5;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList <User> useraccList = new ArrayList<User>();
		
		ArrayList<Deal> dealList = new ArrayList<Deal>();
		
		ArrayList<Category>catList = new ArrayList<Category>();
		
		ArrayList<Item>itemList = new ArrayList<Item>();
		
		ArrayList<Bid>bidList = new ArrayList<Bid>();
		
		useraccList.add(new User("Tommy", "Buyer", "Tommy_Wong@gmail.com", "TommyWong123"));
		useraccList.add(new User("Sally", "Seller", "Sally@gmail.com", "Sallyyy"));
	
		int option = 0;
		
		int y_option = 0;
		
		while (option != 4) {
			C206_CaseStudy.mainMenu();
			y_option = Helper.readInt("Enter option number > ");
		
			if (y_option == 1) {
				User userAccount = inputUserAccount();
				C206_CaseStudy.addUserAccount(useraccList, userAccount);
				
			}
			else if (y_option == 2) {
				
				viewAllUserAccount(useraccList);
				
				String email = Helper.readString("Enter email > ");
				String password = Helper.readString("Enter password > ");
				
				for (int i = 0; i < useraccList.size(); i++) {
					
					if (email.matches(useraccList.get(i).getEmail()) && password.matches(useraccList.get(i).getPassword()) ) {
						if (useraccList.get(i).getRole().equalsIgnoreCase("Seller") ) {
							C206_CaseStudy.sellerMenu();
							int s_option = Helper.readInt("Enter option number > ");
							
							if (s_option == 1) {
								itemSubMenu();
								int item_option= Helper.readInt("Enter option for item > ");
								
								if (item_option == 1) {
								// add item
									Item I = inputItem();
					                 C206_CaseStudy.addItem(itemList,I);
					                 System.out.println("Item added ");
								}
								else if (item_option == 2) {
								// view all items
									C206_CaseStudy.viewAllitems(itemList);
								}
								else if (item_option == 3) {
								// delete item based on name
									C206_CaseStudy.deleteUserAccount(useraccList);
									 C206_CaseStudy.deleteitem(itemList);
								}
											
							} else if (s_option == 2) {
								bidSubMenu();
											
								int bid_option = Helper.readInt("Enter option for bid > ");
											
								if (bid_option == 1) {
									// add bid
									Bid b = inputBid();
									C206_CaseStudy.addBid(bidList, b);
									System.out.println("Bid added.");
									
								}
								else if (bid_option == 2) {
									// view all bids
									C206_CaseStudy.viewAllBid(bidList);
								}
								else if (bid_option == 3) {
									// delete bid based on id
									C206_CaseStudy.deleteBid(bidList);
								}
								
							}
							
						} else if (useraccList.get(i).getRole().equalsIgnoreCase("Buyer") ){	
							C206_CaseStudy.buyerMenu();
								
							int b_option = Helper.readInt ("Enter option number >");
							
							
							if (b_option == 1) {
								catSubMenu();
									
								int cat_option = Helper.readInt("Enter option for category > ");
								
								if (cat_option == 1) {
									// add cat
							
								}
												
								else if (cat_option == 2) {
									// view all cat
									
								}
								
								else if (cat_option == 3) {
									//delete cat based on name
							
								}
								
								
						} else if (b_option == 2) {
							dealSubMenu();
							int deal_option = Helper.readInt("Enter option for deal> ");

							if (deal_option == 1) {
								// add deals
								Deal d = inputDeal();
								C206_CaseStudy.addDeal(dealList, d);
								System.out.println("New Deal added!");



							} else if (deal_option == 2) {
								// View all deals
								retrieveAllDeal(dealList);
								viewAllDeals(dealList);

								

							} else if (deal_option == 3) {
								// Delete deals
								deleteDeal(dealList);




								}
								
							}
						}
					}
				}
				
			} else if (y_option == 3) {
				System.out.println("Thank you for using CAMPUS ONLINE AUCTION SHOP !");
			}
		}
	}


	
		

	public static void sellerMenu() {
		C206_CaseStudy.setHeader("Seller Menu");
		System.out.println("1. Item");
		System.out.println("2. Bid");
		System.out.println("3. Delete Account");
		
	}
	
	public static void buyerMenu() {
		C206_CaseStudy.setHeader("Buyer Menu");
		System.out.println("1. Category");
		System.out.println("2. Deal");
		System.out.println("3. Delete Account");
		
	}
	public static void mainMenu() {
		C206_CaseStudy.setHeader("CAMPUS ONLINE AUCTION SHOP");
		
		System.out.println("1.Register Account");
		System.out.println("2.Login");
		System.out.println("3.Quit");
	}
	public static void menu() {
		C206_CaseStudy.setHeader("CASE STUDY");
		
		//System.out.println("1. User Account");
		System.out.println("1. Category");
		System.out.println("2. Item");
		System.out.println("3. Bid");
		System.out.println("4. Deal");
		System.out.println("5. Quit");
		
		Helper.line(80, "-");
	}
	// user acc menu
	private static void userAccSubMenu() {
		C206_CaseStudy.setHeader("USER ACCOUNT");
		
		System.out.println("1. Add User Account");
		System.out.println("2. View All Users");
		System.out.println("3. Delete User Account");
		Helper.line(80, "-");
	}
	// deal menu
	private static void dealSubMenu() {
		C206_CaseStudy.setHeader("Deal");
		
		System.out.println("1. Add New Deal");
		System.out.println("2. Display All Deals");
		System.out.println("3. Delete Deal based on ID");
		Helper.line(80, "-");
	}
	// category menu
	private static void catSubMenu() {
		C206_CaseStudy.setHeader("Category");

		System.out.println("1. Add New Category");
		System.out.println("2. Display All Category");
		System.out.println("3. Delete Category based on name");
		Helper.line(80, "-");
	}
	// item menu
	private static void itemSubMenu() {
		C206_CaseStudy.setHeader("Item");

		System.out.println("1. Add New Item");
		System.out.println("2. Display All Items");
		System.out.println("3. Delete Item based on name");
		Helper.line(80, "-");
	}
	// bid menu
	private static void bidSubMenu() {
		C206_CaseStudy.setHeader("Bid");

		System.out.println("1. Add New Bid");
		System.out.println("2. Display All Bid");
		System.out.println("3. Delete Bid based on ID");
		Helper.line(80, "-");
	}
	
	private static void setHeader(String header) {
		// TODO Auto-generated method stub
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	//================================= Option 1 - User Account =================================
	// Add User Account
	public static User inputUserAccount() {
		boolean available_email = false;
		String userName = Helper.readString("Enter user name > ");
		String role = Helper.readString("Enter role > ");
		String email = Helper.readString("Enter email > ");
		if (email.contains("@") && email.contains(".")) {
			available_email = true;
		}
		String password = Helper.readString("Enter password > ");
		
		if (available_email == true) {
			User userAccount = new User(userName, role, email, password);
			return userAccount;
		} else {
			return null;
		}
		//return userAccount;
	}
	
	public static void addUserAccount(ArrayList<User> useraccList, User userAccount) {
		useraccList.add(userAccount);
	}
	
	// View User Accounts
	public static String retrieveAllUserAccounts(ArrayList<User> useraccList) {
		String output= "";
		
		if (!useraccList.isEmpty()) {
			for (int i = 0; i < useraccList.size(); i++) {
				
				output += String.format("%-100s\n", useraccList.get(i).toString());
			}
		}
		
		return output;
	}
	
	public static void viewAllUserAccount(ArrayList<User> useraccList) {
		C206_CaseStudy.setHeader("USER ACCOUNT LIST");
		String output = String.format("%-15s %-15s %-15s\n", "USER NAME", "ROLE", "EMAIL");
		
		output += retrieveAllUserAccounts(useraccList);
		System.out.println(output);
	}
	
	// Delete User Account
	public static boolean doExistUserAccount(ArrayList<User> useraccList, String input_email_address) {
		boolean doExist = false;
		
		for (int i = 0; i < useraccList.size(); i++) {
			String email_address = useraccList.get(i).getEmail();
			
			if (input_email_address.equals(email_address)) {
				doExist = true;
			}
		}
		
		return doExist;
	}
	
	public static void deleteUserAccount(ArrayList<User> useraccList) {
		C206_CaseStudy.viewAllUserAccount(useraccList);
		String input_email_address = Helper.readString("Enter email address to delete user account > ");
		
		Boolean doExist = doExistUserAccount(useraccList, input_email_address);
		if (doExist == false) {
			
			System.out.println("Invalid User Account");
		} else {
			for (int i = 0; i < useraccList.size(); i++) {
				if (input_email_address.equals(useraccList.get(i).getEmail())) {
					useraccList.remove(i);
				}
			}
			System.out.println("User Account deleted");
		}
	}
	//================================= Option 2 - Category =================================
	// input category name

	
	
	// add category name

	
	// retrieve all category
	

	
	
	// display category

	
	
	
	
	
	
	// find if category name exist
	
	
	
	

	
	// delete category based on name
	
	
	
	
	
	
	
	//================================= Option 3 - Item =================================
	
	// input item
	 public static Item inputItem() {
	      String name = Helper.readString("Enter item name > ");
	      String description = Helper.readString("Enter description > ");
	      double minBidPrice = Helper.readDouble("Enter minimum bid price > ");
	      String auctionSDate = Helper.readString("Enter auction start date > ");
	      String auctionEDate = Helper.readString("Enter auction end date > ");
	      double bidIncrement =  Helper.readDouble("Enter bid increment > ");
	      
	      if (name != null && description != null && auctionSDate != null && auctionEDate != null) {
	        Item item = new Item (name, description, minBidPrice, auctionSDate, auctionEDate, bidIncrement);
	         return item;
	      } else {
	        return null;
	      }
	     
	      
	    }
	
	

	
	// add item
	  public static void addItem (ArrayList<Item> itemList, Item i) {
	      itemList.add(i);
	    }
	    
	 // retrieve all items
	  public static String retrieveAllItem(ArrayList<Item> itemList) {
	      String output = "";
	      
	      if (!itemList.isEmpty()) {
	        for (int i = 0; i < itemList.size(); i++) {
	            output += String.format("%-10s %-20s %-30.2f %-30s %-20s %-20.2f\n", itemList.get(i).getName(),
	                itemList.get(i).getDescription(), 
	                itemList.get(i).getBidPrice(),
	                itemList.get(i).getStartDate(), itemList.get(i).getEndDate(), itemList.get(i).getIncrement());
	          }
	          
	      }
	      return output;
	  }
	      

	// display all items
	  public static void viewAllitems (ArrayList<Item> itemList) {
		    C206_CaseStudy.setHeader("ITEMS LIST");
		    String output = String.format("%-10s %-20s %-20s %-20s %-20s %-20s\n", "NAME", "DESCRIPTION ",
		         "MIN BID PRICE", "AUCTION START DATE","AUCTION END DATE", "BID INCREMENT");
		    output += retrieveAllItem(itemList);
		    System.out.println(output);
		  }	
	
	
	
	
	// find if item exists
	  public static boolean doExistItem(ArrayList<Item> itemList, String input_name) {
		    boolean doExist = false;
		    
		    for (int i = 0; i < itemList.size(); i++) {
		      String name= itemList.get(i).getName();
		      if (input_name.equals(name) ) {
		        doExist = true;
		      }
		    }
		    return doExist;
		    
		  }	
	
	
	
	
	// delete item based on name
	
	  public static void deleteitem(ArrayList<Item> itemList) {
		    String item = Helper.readString("Enter name for item > ");
		    Boolean doExist = doExistItem(itemList, item);
		    if (doExist == false) {
		      
		      System.out.println("Invalid Item Name");
		    } else {
		      for (int i = 0; i < itemList.size(); i++) {
		        if (item.equals(itemList.get(i).getName())) {
		          itemList.remove(i);
		        }
		      }
		      System.out.println("Item deleted");
		    }
		  }	
	
	
	
	//================================= Option 4 - Bid =================================
	
	// input bid
	private static Bid inputBid() {
		
		String bidId = Helper.readString("Enter ID for bid> ");
	    String itemName = Helper.readString("Enter item name > ");
	    String sellerEmail = Helper.readString("Enter seller email> ");
	    String buyerEmail = Helper.readString("Enter buyer email > ");
	    double bidPrice = Helper.readDouble("Enter the transaction price > ");
	    
	    Bid bid = new Bid (bidId, itemName,sellerEmail, buyerEmail, bidPrice);
	    return bid;
	}
	
	// add bid 
	public static void addBid (ArrayList<Bid> bidList, Bid b) {
	    bidList.add(b);
	}
	
	// retrieve all bids
	public static String retrieveAllBid(ArrayList<Bid> bidList) {
	    String output = "";

	    for (int i = 0; i < bidList.size(); i++) {
	      output += String.format("%-10s %-20s %-30s %-30s %-20.2f\n", bidList.get(i).getBidId(),
	          bidList.get(i).getItemName(), 
	          bidList.get(i).getSellerEmail(),
	          bidList.get(i).getBuyerEmail(),
	          bidList.get(i).getBidPrice());
	    }
	    return output;
	  }
	
	// display bid
	public static void viewAllBid (ArrayList<Bid> bidList) {
		C206_CaseStudy.setHeader("BID LIST");
		String output = String.format("%-10s %-20s %-30s %-30s %-20s\n", "ID", "ITEM NAME",
				 "SELLER EMAIL", "BUYER EMAIL","BID PRICE");
		output += retrieveAllBid(bidList);
		System.out.println(output);
	}
	
	// find if bid exist
	public static boolean doExistBid(ArrayList<Bid> bidList, String input_Bid) {
		boolean doExistBid = false;
		
		for (int i = 0; i < bidList.size(); i++) {
			String bidId = bidList.get(i).getBidId();
			if (input_Bid.equals(bidId)) {
				doExistBid = true;
			}
		}
		
		return doExistBid;
	}
	
	// delete bid based on id
	public static void deleteBid(ArrayList<Bid> bidList) {
		String BidID = Helper.readString("Enter ID for bid> ");
		Boolean doExistBid = doExistBid(bidList, BidID);
		if (doExistBid == false) {
			
			System.out.println("Invalid Bid ID");
		} else {
			for (int i = 0; i < bidList.size(); i++) {
				if (BidID.equals(bidList.get(i).getBidId())) {
					bidList.remove(i);
				}
			}
			System.out.println("Bid deleted");
		}
	}
	
	//================================= Option 5 - Deal =================================
	//input deal
	private static Deal inputDeal() { 
		String dealID = Helper.readString("Enter ID for deal> ");
		String itemName = Helper.readString("Enter item name > ");
		String sellerEmail = Helper.readString("Enter seller email> ");
		String buyerEmail = Helper.readString("Enter buyer email > ");
		double transPrice = Helper.readDouble("Enter the transaction price > ");
		String closeDate = Helper.readString("Enter the close date > ");
		
		Deal deal = new Deal (dealID, itemName,sellerEmail, buyerEmail, transPrice, closeDate);
		return deal;
	}
	
	// add deal
	public static void addDeal (ArrayList<Deal> dealList, Deal d) {
		dealList.add(d);
	}
	
	// retrieve all deals
	public static String retrieveAllDeal(ArrayList<Deal> dealList) {
		String output = "";

		for (int i = 0; i < dealList.size(); i++) {
			output += String.format("%-10s %-20s %-30s %-30s %-20.2f %-20s\n", dealList.get(i).getId(),
					dealList.get(i).getItemName(), 
					dealList.get(i).getSellerEmail(),
					dealList.get(i).getBuyerEmail(),dealList.get(i).getTransactionPrice(), dealList.get(i).getCloseDate());
		}
		return output;
	}
	
	// view all deals
	public static void viewAllDeals (ArrayList<Deal> dealList) {
		C206_CaseStudy.setHeader("DEAL LIST");
		String output = String.format("%-10s %-20s %-30s %-30s %-20s %-20s\n", "ID", "ITEM NAME",
				 "SELLER EMAIL", "BUYER EMAIL","TRANSACTION PRICE", "CLOSE DATE");
		output += retrieveAllDeal(dealList);
		System.out.println(output);
	}
	
	// find deal if it exist
	public static boolean doExistDeal(ArrayList<Deal> dealList, String input_dealID) {
		boolean doExist = false;
		
		for (int i = 0; i < dealList.size(); i++) {
			String dealID = dealList.get(i).getId();
			if (input_dealID.equals(dealID) ) {
				dealList.get(i).setIsDeleted(false);
				doExist = true;
			}
		}
		
		return doExist;
	}



		
	// delete deal
	public static void deleteDeal(ArrayList<Deal> dealList) {
		String dealID = Helper.readString("Enter ID for deal> ");
		Boolean doExist = doExistDeal(dealList, dealID);
		if (doExist == false) {
			
			System.out.println("Invalid Deal ID");
		} else {
			for (int i = 0; i < dealList.size(); i++) {
				if (dealID.equals(dealList.get(i).getId())) {
					dealList.remove(i);
				}
			}
			System.out.println("Deal deleted");
		}
	}
}
	
	





