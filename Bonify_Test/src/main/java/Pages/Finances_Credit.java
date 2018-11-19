package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.Test_Base;

public class Finances_Credit extends Test_Base {

	
	@FindBy(xpath="//span[text()='Kredite']")
	WebElement  LoansLink;
	@FindBy(xpath="//label[@for='creditCards']")
	WebElement Creditcardslabel;
	@FindBy(xpath="//section[@class='iframe-container']//iframe")
	WebElement Frame1;
	//@FindBy(name="vxcp_frame")
	//WebElement Frame2;
	@FindBy(xpath="//select[@class='kreditkarterechner_kartengesellschaft']")
	WebElement  Carddropdown;
	@FindBy(xpath="//div[@class='col-md-3 col-md-offset-9 col-sm-4 col-sm-offset-8 col-xs-12']/input")
	WebElement SearchButton;
	@FindBy(xpath="//div[@class='col-md-9 col-sm-8 hidden-xs']/span[@class='fa_link']")
	WebElement  Carddisplay;
	
	
public Finances_Credit() {
		
		PageFactory.initElements(driver, this);
		
	}
	public String NavigateTo_LoansPage() throws Exception {
		
		LoansLink.click();
		Thread.sleep(2000);
	return 	Creditcardslabel.getText();	
	}
	
	public void Switch_To_Frames() throws Exception {
		int x=  driver.findElements(By.tagName("iframe")).size();
		 System.out.println("Total frames are " + x);
		 
		// driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='/dist/7cd751305ccc5696fb53f75e147ebc94.html?postcode=10117&campaignId=iframe&subPartnerId=333245']")));
		 driver.switchTo().frame(Frame1);
		 Thread.sleep(2000);
		 driver.switchTo().frame("vxcp_frame");

		 System.out.println("Driver switched ");
		// Thread.sleep(2000);
		 boolean T = driver.findElement(By.xpath("//select[@name='kartengesellschaft']")).isDisplayed();
			System.out.println("Element Displatyed ?  " + T);
	}
	
	
	public String Cardselect_andSearch() throws Exception {
		Select objselect= new Select(Carddropdown);
		objselect.selectByVisibleText("American Express");
		
		SearchButton.click();
		Thread.sleep(1000);
		return Carddisplay.getText();
	    
		   
	}
	
	
	
	
}
