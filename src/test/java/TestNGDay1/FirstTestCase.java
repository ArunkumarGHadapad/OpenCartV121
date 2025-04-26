package TestNGDay1;

import org.testng.annotations.Test;

/*
 * 1. Open an App
 * 2. Login to an App
 * 3. Logout an App
*/

public class FirstTestCase {

	@Test(priority=1)
	//1. Open an App
	void OpenanApp(){
		System.out.println("Open method");
	}
	@Test(priority=2)
	void LoginToApp(){
		System.out.println("Login method");
	}
	@Test
	void LogoutAnApp(){
		System.out.println("Logout method");
	}
}
