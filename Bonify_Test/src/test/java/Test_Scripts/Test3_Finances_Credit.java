package Test_Scripts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.Test_Base;
import Pages.Finances_Credit;
import Pages.LoginPage_Bonify;

public class Test3_Finances_Credit extends Test_Base {
	
	 LoginPage_Bonify OBJ_LoginPage;
	 Finances_Credit OBJ_Finances_Credit;
	
public Test3_Finances_Credit() {
		
		super();
	}
	
	@BeforeClass
	public void steup() {
		Initialization();
		OBJ_LoginPage = new LoginPage_Bonify();
		
		String t= OBJ_LoginPage.Login();
		
	 OBJ_Finances_Credit= new Finances_Credit();
		System.out.println(t);
	}
	

	@Test(priority=1)
	public void Verify_LoansPage_Navigation() throws Exception {
		String S= OBJ_Finances_Credit.NavigateTo_LoansPage();
		System.out.println(S);
		
		Assert.assertEquals(S, "Kreditkarten");
	
	}
	@Test(priority=2)
	public void Verify_Cardselection_andresult() throws Exception{
		OBJ_Finances_Credit.Switch_To_Frames();
		
		String card= OBJ_Finances_Credit.Cardselect_andSearch();
		
		Assert.assertEquals(card, "American Express");	
	}
	
	@AfterClass
	public void TearDown() {
		
		driver.quit();
	}
	

}
