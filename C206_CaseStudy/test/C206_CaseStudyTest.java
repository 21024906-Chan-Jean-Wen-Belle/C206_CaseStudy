import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private User u1;
	private User u2;
	private Deal d1;
	private Deal d2;
	private Item I1;
	private Item I2;
	private Bid b1;
	private Bid b2;
	
	private ArrayList<User> useraccList;
	private ArrayList<Deal> dealList;
	private ArrayList<Item> itemList;
	private ArrayList<Bid> bidList;
	
	public C206_CaseStudyTest() {
		super();
	}
	

	//-------------------------------------- User Acct------------------------------
	@Before
	public void setUpUser() throws Exception {
		u1 = new User("May Tan", "Buyer", "may@gmail.com", "May Tan 123");
		u2 = new User("Sam Goh", "Seller", "sam123@hotmail.com", "Sam likes animals");
		
		useraccList = new ArrayList<User>();
	}

	@After
	public void tearDownUser() throws Exception {
	}

	@Test
	public void testAddUserAccount() {
		//fail("Not yet implemented"); 
		assertNotNull("Check if there is valid User Account arrayList to add to", useraccList);
		
		C206_CaseStudy.addUserAccount(useraccList, u1);
		assertEquals("Check that User Account arraylist size is 1", 1, useraccList.size());
		assertSame("Check that User Account is added", u1, useraccList.get(0));
		
		
		C206_CaseStudy.addUserAccount(useraccList, u2);
		assertEquals("Check that User Account arraylist size is 2", 2, useraccList.size());
		assertSame("Check that User Account is added", u2, useraccList.get(1));
	}
	
	public void testRetrieveAllUserAccount() {
		assertNotNull("Test if there is a valid User arraylist to retrieve user account", useraccList);
		
		String allUserAccount = C206_CaseStudy.retrieveAllUserAccounts(useraccList);
		String testOutput = "";
		assertEquals("Test that the retrieved User Account List is empty?", testOutput, allUserAccount);
		
		C206_CaseStudy.addUserAccount(useraccList, u1);
		C206_CaseStudy.addUserAccount(useraccList, u2);
		assertEquals("Test that User Account arraylist size is 2", 2, useraccList.size());
		
		allUserAccount = C206_CaseStudy.retrieveAllUserAccounts(useraccList);
		testOutput = String.format("%-15s %-15s %-15s %-15s\n", "May Tan", "Buyer", "may@gmail.com", "May Tan 123");
		testOutput += String.format("%-15s %-15s %-15s %-15s\n", "Sam Goh", "Seller", "sam123@hotmail.com", "Sam likes animals");
		
		assertEquals("Test that viewAllUserAccount", testOutput, allUserAccount);
	}
	
	public void testDoExistUserAccount() {
		// boundary
		assertNotNull("Test if there is valid User Account arraylist", useraccList);
		
		C206_CaseStudy.addUserAccount(useraccList, u1); 
		
		// normal
		Boolean doExist = C206_CaseStudy.doExistUserAccount(useraccList, "may@gmail.com");
		assertTrue("Test if the User Account exists in the arraylist?", doExist);
		
		// error condition
		doExist = C206_CaseStudy.doExistUserAccount(useraccList, "may@gmail.com");
		assertFalse("Tests that User Account does not exist", doExist);
		
		// error condition
		C206_CaseStudy.addUserAccount(useraccList, u2);
		useraccList.remove(1);
		doExist = C206_CaseStudy.doExistUserAccount(useraccList, "sam123@hotmail.com");
		assertFalse("Tests that User Account does not exist", doExist);
	}
	
	//------------------------------Deal-----------------------------------
	
	@Before
	public void setUpDeal() throws Exception {
		//prepares test data
		d1 = new Deal ("D001", "Toy Story 4", "may@gmail.com","sam123@hotmail.com" ,500 , "1 July 2021" );
		d2 = new Deal ("D002", "Chip & Dale CD","sam123@hotmail.com","may@gmail.com" , 30 , "3 March 2021" );
	
		dealList= new ArrayList<Deal>();
	}
	
	@Test
	public void testAddDeal() {
		// deal list is not null, so that can add a new deal - boundary
		assertNotNull("Check if there is valid Deal arraylist to add to", dealList);
		
		// Given an empty list, after adding 1 deal, the size of the list is 1 - normal
		// The deal just added is as same as the first deal of the list
		C206_CaseStudy.addDeal(dealList, d1);
		assertEquals("Check that Deal arraylist size is 1", 1, dealList.size());
		assertSame("Check that Deal is added", d1, dealList.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		C206_CaseStudy.addDeal(dealList, d2);
		assertEquals("Check that Deal arraylist size is 2", 2, dealList.size());
		assertSame("Check that Deal is added", d2, dealList.get(1));
	}
	@Test
	public void testRetrieveAllDeals() {
		// Test if deal list is not null but empty -boundary
		assertNotNull("Test if there is valid Deal arraylist to retrieve item", dealList);
		
		//test if the list of deal retrieved from the deal list is empty - boundary
		String allDeal= C206_CaseStudy.retrieveAllDeal(dealList);
		String testOutput = "";
		assertEquals("Check that ViewAllDeallist", testOutput, allDeal);
		
		//Given an empty list, after adding 2 deal, test if the size of the list is 2 - normal
		C206_CaseStudy.addDeal(dealList, d1);
		C206_CaseStudy.addDeal(dealList, d2);
		assertEquals("Test that Deal arraylist size is 2", 2, dealList.size());
		
		//test if the expected output string same as the list of deal retrieved from the deal list	
		allDeal = C206_CaseStudy.retrieveAllDeal(dealList);
		testOutput = String.format("%-10s %-30s %-30s %-10s %-20s %-10s\n","D001", "Toy Story 4", "may@gmail.com","sam123@hotmail.com" ,500 , "1 July 2021" );
		testOutput += String.format("%-10s %-30s %-30s %-10s %-20s %-10s\n","D002", "Chip & Dale CD","sam123@hotmail.com","may@gmail.com" , 30 , "3 March 2021" );
	

	}
	

	
	@Test
	public void testdoExistDeal () {
		// Deal list is not null, so that can delete deal - boundary
		assertNotNull("Test if there is valid Deal arraylist to delete", dealList);
		C206_CaseStudy.addDeal(dealList, d1);
		// Given a list with 2 deal, after deleting 1 deal, the size of the list is 1 - normal
		boolean t = C206_CaseStudy.doExistDeal(dealList,"D001");
		assertTrue("Test if an available deal is ok to delete?", t);
		
		// Error Condition, deal does not exist
		d2.setIsDeleted(true);
		t = C206_CaseStudy.doExistDeal(dealList,"D002");
		assertFalse("Test if an available deal is ok to delete?", t);
	}
	
	@After
	public void tearDownDeal() throws Exception {
		d1 = null;
		d2 = null;
		dealList = null;
	}
	
	// --------------------------------------------------Bid-----------------------------------------------
	@Before
	public void setupBid() throws Exception {
		//prepares test data
	    b1 = new Bid ("B001", "Apple", "jimmy@gmail.com", "tim@gmail.com", 50);
	    b2 = new Bid ("B002", "Samsung", "tim@gmail.com", "jimmy@gmail.com", 80);
	    
	    bidList = new ArrayList<Bid>();
	}
	
	@Test 
	public void testAddBid() {
		// Bid list is not null, so that can add a new item
		assertNotNull("Test if there is valid Bid arraylist to add to", bidList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addBid(bidList, b1);		
		assertEquals("Test if that Bid arraylist size is 1", 1, bidList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Bid is added same as 1st item of the list", b1, bidList.get(0));
		
		//Add another item. test the size of the list is 2
		C206_CaseStudy.addBid(bidList, b2);
	    assertEquals("Check that Bid arraylist size is 2", 2, bidList.size());
	    assertSame("Check that Bid is added", b2, bidList.get(1));
	}
	
	@Test
	  public void testRetrieveAllBid() {
	    // Test if Bid list is not null but empty -boundary
	    assertNotNull("Test if there is valid Bid in the arraylist", bidList);
	    
	    //test if the list of bid retrieved from the bid list is empty - boundary
	    String allBid= C206_CaseStudy.retrieveAllBid(bidList);
	    String testOutput = "";
	    assertEquals("Check that ViewAllBidlist", testOutput, allBid);
	    
	    //Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
	    C206_CaseStudy.addBid(bidList, b1);
	    C206_CaseStudy.addBid(bidList, b2);
	    assertEquals("Test that Bid in the arraylist size is 2", 2, bidList.size());
	    
	    //test if the expected output string same as the list of bid retrieved from the bid list  
	    allBid= C206_CaseStudy.retrieveAllBid(bidList);
	    testOutput = String.format("%-10s %-10s %-30s %-30s %-10s\n", "B001", "Apple", "jimmy@gmail.com", "tim@gmail.com", 50); 
	    testOutput += String.format("%-10s %-10s %-30s %-30s %-10s\n", "B002", "Samsung", "tim@gmail.com", "jimmy@gmail.com", 80);
	  
	  }
	
	@Test
	  public void testdoExistBid () {
	    // Bid list is not null, so that can delete bid - boundary
	    assertNotNull("Test if there is valid bid in the arraylist to delete", bidList);
	    C206_CaseStudy.addBid(bidList, b1);
	    
	    // Given a list with 2 items, after deleting 1 item, the size of the list is 1 - normal
	    boolean b_exist = C206_CaseStudy.doExistBid(bidList,"B001");
	    assertTrue("Test if an available bid is ok to delete?", b_exist);
	    
	    // Error Condition, item does not exist
	    b2.setIsDeleted(true);
	    b_exist = C206_CaseStudy.doExistBid(bidList,"B002");
	    assertFalse("Test if an available bid is ok to delete?", b_exist);
	  }
	  
	    @After
	    public void tearDownBid() throws Exception {
	      b1=null;
	      b2=null;
	      bidList = null;

	   }
	
	
	 //------------------------------Item-----------------------------------
	  
	  @Before
	  public void setUpItem() throws Exception {
	    //prepares test data
	    I1 = new Item ("Toy Story 4","This item is for consumers who are a fan of toy story",500.00, "10 August 2021", "20August 2021", 5.00);
	    I2 = new Item ("Chip & Dale CD","This item is for consumers who are a fan of Chip & Dale",30.00,"21 August 2021","31 August 2021",2.00 );
	  
	    itemList= new ArrayList<Item>();
	  }
	  @Test
	  public void testAddItem() {
	    // Item list is not null, so that can add a new Item - boundary
	    assertNotNull("Check if there is valid Item arraylist to add to", itemList);
	    
	    // Given an empty list, after adding 1 item, the size of the list is 1 - normal
	    // The item just added is as same as the first item of the list
	    C206_CaseStudy.addItem(itemList, I1);
	    assertEquals("Check that item arraylist size is 1", 1, itemList.size());
	    assertSame("Check that Item is added", I1, itemList.get(0));
	    // Add another item. test The size of the list is 2? -normal
	    // The item just added is as same as the second item of the list
	    C206_CaseStudy.addItem(itemList, I2);
	    assertEquals("Check that Item arraylist size is 2", 2, itemList.size());
	    assertSame("Check that Item is added", I2, itemList.get(1));
	    
	  }
	  @Test
	  public void testRetrieveAllItem() {
	    // Test if Item list is not null but empty -boundary
	    assertNotNull("Test if there is valid Item in the arraylist", itemList);
	    
	    //test if the list of item retrieved from the item list is empty - boundary
	    String allItem= C206_CaseStudy.retrieveAllItem(itemList);
	    String testOutput = "";
	    assertEquals("Check that ViewAllItemlist", testOutput, allItem);
	    
	    //Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
	    C206_CaseStudy.addItem(itemList, I1);
	    C206_CaseStudy.addItem(itemList, I2);
	    assertEquals("Test that item in the arraylist size is 2", 2, itemList.size());
	    
	    //test if the expected output string same as the list of items retrieved from the item list  
	    allItem= C206_CaseStudy.retrieveAllItem(itemList);
	    testOutput = String.format("%-10s %-30s %-30s %-10s %-20s %-10s\n","Toy Story 4","This item is for consumers who are a fan of toy story",50.00, "10 August 2021", "20August 2021", 5.00); 
	    testOutput += String.format("%-10s %-30s %-30s %-10s %-20s %-10s\n","Chip & Dale CD","This item is for consumers who are a fan of Chip & Dale",30.00,"21 August 2021","31 August 2021",2.00 );
	    //assertEquals("Test that ViewAllItemlist", testOutput, allItem);
	  }
	  
	  @Test
	  public void testdoExistItem () {
	    // Item list is not null, so that can delete item - boundary
	    assertNotNull("Test if there is valid item in the arraylist to delete", itemList);
	    C206_CaseStudy.addItem(itemList, I1);
	    // Given a list with 2 items, after deleting 1 item, the size of the list is 1 - normal
	    boolean t = C206_CaseStudy.doExistItem(itemList,"Toy Story 4");
	    assertTrue("Test if an available item is ok to delete?", t);
	    
	    // Error Condition, item does not exist
	    I2.setIsDeleted(true);
	    t = C206_CaseStudy.doExistItem(itemList,"Chip & Dale CD");
	    assertFalse("Test if an available item is ok to delete?", t);
	  }
	  
	    @After
	    public void tearDownItem() throws Exception {
	      I1=null;
	      I2=null;
	      dealList = null;

	   }
}