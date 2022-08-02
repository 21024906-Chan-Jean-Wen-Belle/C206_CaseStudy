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
	
	private ArrayList<User> useraccList;
	private ArrayList<Deal> dealList;
	
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
		testOutput = String.format("%-15s %-15s %-15s %-15s\n", "May Tan", "Test Role", "may@gmail.com", "May Tan 123");
		testOutput += String.format("%-15s %-15s %-15s %-15s\n", "Sam Goh", "Test Role", "sam123@hotmail.com", "Sam likes animals");
		
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
	
		//assertEquals("Test that ViewAllDeallist", testOutput, allDeal);
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
		
}