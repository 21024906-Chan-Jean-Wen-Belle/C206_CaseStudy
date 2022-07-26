import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private User u1;
	private User u2;
	
	private ArrayList<User> useraccList;

	@Before
	public void setUp() throws Exception {
		u1 = new User("May Tan", "Test Role", "may@gmail.com", "May Tan 123");
		u2 = new User("Sam Goh", "Test Role", "sam123@hotmail.com", "Sam likes animals");
		
		useraccList = new ArrayList<User>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInputUserAccount() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	public void testRetrieveAllUserAccount() {
		assertNotNull("Test if there is a valid User arraylist to retrieve user account", useraccList);
		
		String allUserAccount = C206_CaseStudy.retrieveAllUserAccounts(useraccList);
		
	}
	
	public void testDoExistUserAccount() {
		
	}
	
}
