package Test_Scripts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Base.Test_Base;
import Pages.LoginPage_Bonify;
import Util.Testutil;

public class Test2_LoginPage_Bonify extends Test_Base {

	 LoginPage_Bonify OBJ_LoginPage;
	 
	
	public Test2_LoginPage_Bonify() {
		
		super();
	}
	
	@BeforeClass
	public void steup() {
		Initialization();
		OBJ_LoginPage = new LoginPage_Bonify();
		
	}
	
	
	
	
	@Test(priority=1)
	public void VerifyHeader_F_pwdpage() {
		
	boolean  I = OBJ_LoginPage.NavigateForgotpwdpage();
	
	Assert.assertEquals(I, true);		
	}
	
	@DataProvider
    public Object [][] getValidationText() {
   	 
   	 Object data[][]= Testutil.getTestData("ValidationText");
   	 return data;
    }
	
	// Datadriven Verifications are used
	@Test(priority=2,dataProvider="getValidationText")
	public void VerifyvalidationTexts_F_pwdpage(String EmailValidationText, String InfoIconText) {
	String Etxt=	OBJ_LoginPage.EmailvalidationTxt();
	
	String Itxt= OBJ_LoginPage.InfoiconTxt();
	Assert.assertEquals(Etxt, EmailValidationText);
	Assert.assertEquals(Itxt, InfoIconText);
	
	
	}
	
	@DataProvider
    public Object [][] getTitlesText() {
   	 
   	 Object data[][]= Testutil.getTestData("Titles");
   	 return data;
    }
	
	
	
	@Test(priority=3,dataProvider="getTitlesText")
	public void Verify_Impressum_LinkandTitle(String WindowTitle, String AGBTitle, String DatenschutzTitle, String HomePageText) throws InterruptedException {
		String Parent=OBJ_LoginPage.Parentwindow();
		
		OBJ_LoginPage.Impressumlink.click();
		String title1= OBJ_LoginPage.Links_getwindowtitle();
		System.out.println(title1);
		Assert.assertEquals(title1, WindowTitle);
				
		driver.close();
		driver.switchTo().window(Parent);
			
	}
	
	@Test(priority=4,dataProvider="getTitlesText")
	public void Verify_AGB_LinkandTitle(String WindowTitle, String AGBTitle, String DatenschutzTitle, String HomePageText) throws InterruptedException{
		String Parent=OBJ_LoginPage.Parentwindow();
		OBJ_LoginPage.AGBlink.click();
		String title2= OBJ_LoginPage.Links_getwindowtitle();
	Assert.assertEquals(title2, AGBTitle);
				driver.close();
		driver.switchTo().window(Parent);
	}
	@Test(priority=5,dataProvider="getTitlesText")
	public void Verify_Datenschutz_LinkandTitle(String WindowTitle, String AGBTitle, String DatenschutzTitle, String HomePageText) throws InterruptedException{
		String Parent=OBJ_LoginPage.Parentwindow();
		
		OBJ_LoginPage.Datenschutzlink.click();
		String title3= OBJ_LoginPage.Links_getwindowtitle();
		Assert.assertEquals(title3, DatenschutzTitle);
				driver.close();
		driver.switchTo().window(Parent);
	}
	
	
	
	@Test(priority=6,dataProvider="getTitlesText")
	public void Verify_Login(String WindowTitle, String AGBTitle, String DatenschutzTitle, String HomePageText){
		String Homepagetxt= OBJ_LoginPage.Login();
		
		Assert.assertEquals(Homepagetxt, HomePageText);
	}
	
	@AfterClass
	public void TearDown() {
		driver.quit();
	}
}
