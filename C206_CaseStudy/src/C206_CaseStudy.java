import java.util.AbstractCollection;
import java.util.ArrayList;

public class C206_CaseStudy {
	
	private static final int OPTION_USER = 1;
	private static final int OPTION_CATEGORY = 2;
	private static final int OPTION_ITEM = 3;
	private static final int OPTION_BID = 4;
	private static final int OPTION_DEAL = 5;
	private static final int OPTION_QUIT = 6;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <User> useraccList = new ArrayList<User>();
		
		ArrayList<Deal> dealList = new ArrayList<Deal>();
		
		int option = 0;
		
		while (option != OPTION_QUIT) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == OPTION_USER) {
				userAccSubMenu();
				
				int user_option = Helper.readInt("Enter option > ");
				
				if (user_option == 1) {
					// Add new user account
					
					User userAccount = inputUserAccount();
					C206_CaseStudy.addUserAccount(useraccList, userAccount);
				} else if (user_option == 2) {
					// View all users
					
					viewAllUserAccount(useraccList);
				} else if (user_option == 3) {
					// Delete user account
					
					C206_CaseStudy.deleteUserAccount(useraccList);
				}
			} else if (option == OPTION_CATEGORY) {
			
			} else if (option == OPTION_ITEM) {
				
			} else if (option == OPTION_BID) {
				
			} else if (option == OPTION_DEAL) {
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
					String id = inputDealid();
					deleteDeal(dealList, id);
				}
				
			}
		}
		
	}
	
	public static void menu() {
		C206_CaseStudy.setHeader("CASE STUDY");
		
		System.out.println("1. User Account");
		System.out.println("2. Category");
		System.out.println("3. Item");
		System.out.println("4. Bid");
		System.out.println("5. Deal");
		System.out.println("6. Quit");
		
		Helper.line(80, "-");
	}
	
	private static void userAccSubMenu() {
		C206_CaseStudy.setHeader("USER ACCOUNT");
		
		System.out.println("1. Add User Account");
		System.out.println("2. View All Users");
		System.out.println("3. Delete User Account");
		Helper.line(80, "-");
	}
	private static void dealSubMenu() {
		C206_CaseStudy.setHeader("USER ACCOUNT");
		
		System.out.println("1. Add New Deal");
		System.out.println("2. Display All Deals");
		System.out.println("3. Delete Deal based on ID");
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
	
	
	
	
	
	
	//================================= Option 3 - Item =================================
	
	
	
	
	
	
	//================================= Option 4 - Bid =================================
	
	
	
	
	
	
	//================================= Option 5 - Deal =================================
	//input deal
	private static Deal inputDeal() {
		String dealID = Helper.readString("Enter ID for deal> ");
		String itemName = Helper.readString("Enter item name > ");
		String sellerEmail = Helper.readString("Enter seller name> ");
		String buyerEmail = Helper.readString("Enter buyer name > ");
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

	private static String inputDealid() {
		String dealID = Helper.readString("Enter ID for deal> ");
		return dealID;
	}

		
	// delete deal
	public static void deleteDeal(ArrayList<Deal> dealList, String id) {
		C206_CaseStudy.viewAllDeals(dealList);
	
		
		Boolean doExist = doExistDeal(dealList, inputDealid());
		if (doExist == false) {
			
			System.out.println("Invalid Deal ID");
		} else {
			for (int i = 0; i < dealList.size(); i++) {
				if (inputDealid().equals(dealList.get(i).getId())) {
					dealList.remove(i);
				}
			}
			System.out.println("Deal deleted");
		}
	}
}
	
	





