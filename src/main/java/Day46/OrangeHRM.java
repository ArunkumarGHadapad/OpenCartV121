package Day46;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Day46.MyListner.class)
public class OrangeHRM {
	

	@Test(priority=1)	void Openapp() {assertTrue(true);}
	@Test(priority=2,dependsOnMethods= {"Openapp"})	void Login() { assertTrue(false);}
	@Test(priority=3,dependsOnMethods= {"Login"})	void Search() {assertTrue(false);}
	//@Test(priority=4,dependsOnMethods= {"Search"})	void AdvSearch() {System.out.println("This is Advsearch");}
	//@Test(priority=5,dependsOnMethods= {"AdvSearch"})	void Logout() {System.out.println("This is logout");}

}
