package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonPaymentPage {
	  	WebDriver driver;
	    WebDriverWait wait;

	    @FindBy(xpath = "//input[@value = 'SelectableAddCreditCard']")
	    WebElement paymentOption;
	    
	    @FindBy(xpath = "//a[contains(text(), 'Enter card details')]")
	    WebElement cardoptions;
	    
	    @FindBy(name = "addCreditCardNumber")
	    WebElement cardNumber;
	    
	    
	    @FindBy(xpath = "//li[@class='a-dropdown-item']//a[text() = '2025']")
	    WebElement selectYear;
	    
	    @FindBy(xpath = "//input[contains(@name, 'ppw-widgetEvent:AddCreditCardEvent')]")
	    public WebElement carddetailssubmit;
	
	    
	    @FindBy (xpath = "//iframe[contains(@name, 'addCreditCardVerificationNumber')]")
	    public WebElement cvviframe;
	    
	    @FindBy(id = "field")
	    public WebElement CVV;
	    
	    @FindBy(xpath = "//input[contains(@aria-labelledby, 'orderSummaryPrimaryActionBtn-announce')]")
	    public WebElement paymentsubmit;
	    
	    @FindBy(xpath = "//span[text() = 'Continue without saving']")
	    public WebElement saveCard;
	    
	    public AmazonPaymentPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }
	    
	    public void clickPaymentOption() {
	        paymentOption.click();
	    }
	    
	    public void selectCard() {
	    	cardoptions.click();
	    }
	    
	    public void enterCardNumber(String card) {
	    	cardNumber.sendKeys(card);
	    }
	    
	   public void selectExpYear() {
		   selectYear.click();
	   }
	   
	   public void submitCardDetails() {
		   carddetailssubmit.click();
	   }
	   
	   public void enterCVVdetails(String cvv) {
		   CVV.sendKeys(cvv);
	   }
	   
	   public void usepayment() {
		   wait.until(ExpectedConditions.visibilityOf(paymentsubmit)).click();
		   
	   }
	   
	   public void carddismiss() {
		   saveCard.click();
	   }
}
