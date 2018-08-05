package Pages;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Test_Base;

public class LoginPage_Bonify extends Test_Base {
	
	@FindBy(name="email")
	WebElement Username;
	@FindBy(name="password")
	WebElement Password;
	@FindBy(xpath="//a[@href='/recover']")
	WebElement ForgotPwd;
	@FindBy(xpath="//div[@class='message']//div//span")
	WebElement Homepagetxt;
	
	
	
	//Links
	@FindBy(linkText="Impressum")
	public WebElement Impressumlink;
	@FindBy(linkText="AGB")
	public WebElement AGBlink;
	@FindBy(linkText="Datenschutz")
	public WebElement Datenschutzlink;
	
	
	
	// Forgotpasswordpage  Elements
	@FindBy(xpath="//h1[text()='Email senden']")
	WebElement ForgotPwdPageheader;
	@FindBy(xpath="//button[@type='submit']")
	WebElement Send;
	@FindBy(xpath="//i[@class='ico-bonify-tooltip tooltip-trigger']")
	WebElement Infoicon;
	@FindBy(xpath="//div[@class='form-group input-field lower-tooltip']/span[contains(text(),'Gib hier')]")
	WebElement Infotxt;
	@FindBy(className="error")
	WebElement ErrorTxt;
	@FindBy(xpath="//div[@class='ripple-wrapper'][1]")
	WebElement Back;
	
	String str;
	public LoginPage_Bonify() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean  NavigateForgotpwdpage() {
		
		ForgotPwd.click();
		Send.click();
		Infoicon.click();
	return	ForgotPwdPageheader.isDisplayed();
		
	}
	
	public String EmailvalidationTxt() {
		return ErrorTxt.getText();
	}
       public String InfoiconTxt() {
		
    	   return Infotxt.getText();
	}
      
       public  String Parentwindow() {
    	   Back.click();
    	    String Parent= driver.getWindowHandle();
    	    return Parent;
       }
       
     public  String Links_getwindowtitle() throws InterruptedException {
    	 Thread.sleep(3000);
 	    Set<String>  Windows=  driver.getWindowHandles();
 	    
 	   LoginPage_Bonify obj= new LoginPage_Bonify();
 	String Parent = obj.Parentwindow();
 	System.out.println(Parent); 
 	
 	     for(String child: Windows) {
 	    	
 	    	 if (!child.equals(Parent)) { 
 	    		 driver.switchTo().window(child);
 	    		 System.out.println(child); 
 	    		String s= driver.getTitle();
 	    		System.out.println(s); 
 	    		str=s;
 	    		 
 	    	 }    	 
 	    	
     }
 	     return str;
     }
	
     public String Login(){
   	
    	 Username.sendKeys("er.anandsingh7@gmail.com");
    	 Password.sendKeys("Prometric@1");
    	 Send.click();
    	 
    	return  Homepagetxt.getText();
    	 
    	
     }
	
	
	
	
	
	
	
}
