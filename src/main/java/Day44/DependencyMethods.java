package Day44;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class DependencyMethods {

	@Test(priority=1)	void Openapp() {System.out.println("This is Openapp");}
	@Test(priority=2,dependsOnMethods= {"Openapp"})	void Login() { assertTrue(true);}
	@Test(priority=3,dependsOnMethods= {"Login"})	void Search() {assertTrue(false);}
	@Test(priority=4,dependsOnMethods= {"Search"})	void AdvSearch() {System.out.println("This is Advsearch");}
	@Test(priority=5,dependsOnMethods= {"AdvSearch"})	void Logout() {System.out.println("This is logout");}
}
