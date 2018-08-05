package Test_Scripts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base.Test_Base;
import Pages.LoginPage_Bonify;

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
		
	boolean  I = 	OBJ_LoginPage.NavigateForgotpwdpage();
	
	Assert.assertEquals(I, true);		
	}
	
	@Test(priority=2)
	public void VerifyvalidationTexts_F_pwdpage() {
	String Etxt=	OBJ_LoginPage.EmailvalidationTxt();
	
	String Itxt= OBJ_LoginPage.InfoiconTxt();
	
	Assert.assertEquals(Etxt, "Trage bitte Deine Email-Adresse ein");
	Assert.assertEquals(Itxt, "Gib hier Deine Email-Adresse ein,­ mit der Du bei bonify angemeldet bist");
	}
	
	//@Test(priority=3)
	public void Verify_Impressum_LinkandTitle() throws InterruptedException {
		String Parent=OBJ_LoginPage.Parentwindow();
		
		OBJ_LoginPage.Impressumlink.click();
		String title1= OBJ_LoginPage.Links_getwindowtitle();
		System.out.println(title1);
		Assert.assertEquals(title1, "Impressum bonify");
				
		driver.close();
		driver.switchTo().window(Parent);
			
	}
	
	@Test(priority=4)
	public void Verify_AGB_LinkandTitle() throws InterruptedException{
		String Parent=OBJ_LoginPage.Parentwindow();
		OBJ_LoginPage.AGBlink.click();
		String title2= OBJ_LoginPage.Links_getwindowtitle();
	Assert.assertEquals(title2, "bonify - AGB");
				driver.close();
		driver.switchTo().window(Parent);
	}
	//@Test(priority=5)
	public void Verify_Datenschutz_LinkandTitle() throws InterruptedException{
		String Parent=OBJ_LoginPage.Parentwindow();
		
		OBJ_LoginPage.Datenschutzlink.click();
		String title3= OBJ_LoginPage.Links_getwindowtitle();
		Assert.assertEquals(title3, "Datenschutz bei bonify - Sicherheit ist sehr wichtig für die Bonitätsprüfung");
				driver.close();
		driver.switchTo().window(Parent);
	}
	
	@Test(priority=6)
	public void Verify_Login(){
		String Homepagetxt= OBJ_LoginPage.Login();
		
		Assert.assertEquals(Homepagetxt, "Hey ANAND, schön Dich zu sehen!");
	}
	@AfterClass
	public void TearDown() {
		
		driver.quit();
	}
}
