package Day43;

import org.testng.annotations.*;

/*
 * 1.Login
 * 2.Search
 * 3.Logout
 * 4.Login
 * 5.AdvSearch
 * 6.Logout
 * */
public class annotationDemo2 {
	
@BeforeClass	void Login() { System.out.println("This is login");}
@AfterClass	void Logout() {System.out.println("This is logout");}
@Test(priority=1)	void Search() {System.out.println("This is Search");}
@Test(priority=2)	void AdvSearch() {System.out.println("This is Advsearch");}
	

}
