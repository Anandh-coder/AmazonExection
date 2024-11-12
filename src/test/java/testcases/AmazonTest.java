package testcases;

import org.testng.annotations.Test;

import pageObjects.AmazonHomePage;
import pageObjects.AmazonLoginPage;
import pageObjects.AmazonPaymentPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import utils.BaseTest;

public class AmazonTest extends BaseTest {
    AmazonLoginPage loginPage;
    AmazonHomePage homePage;
    AmazonPaymentPage paymentPage;
    
    @Test
    public void testAmazonLoginAndPurchase() throws InterruptedException {
        loginPage = new AmazonLoginPage(driver);
        homePage = new AmazonHomePage(driver);
        paymentPage = new AmazonPaymentPage(driver);
        
        // Navigate to Amazon login page
        driver.get("https://www.amazon.in/");
        
        //Navigate to Sign link
        loginPage.clickSignInlink();
        
        // Perform login
        loginPage.enterEmail(""); //Please Enter Email
        loginPage.clickContinue();
        loginPage.enterPassword(""); //Please enter password
        loginPage.clickSignInSubmit();
        
        Thread.sleep(15000);
        // Search for product
        homePage.searchProduct("zebronics wired headphones");
        
        // Select product and buy now
        String parentwindow = driver.getWindowHandle();
        homePage.selectFirstProduct();

        for (String wind : driver.getWindowHandles()) {
            if (!wind.equals(parentwindow)) {
                driver.switchTo().window(wind);
                homePage.clickBuyNow();
            }
        }
        
        // select payment type
        paymentPage.clickPaymentOption();
        
        //select card
        paymentPage.selectCard();
        
        //Switch to card Frame to enter details.
        driver.switchTo().frame("ApxSecureIframe");
        paymentPage.enterCardNumber("5555555555554444");
        Actions actions = new Actions(driver); 
        // Send the TAB key 
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
        paymentPage.selectExpYear();
         
        //submit card details
        
        paymentPage.submitCardDetails();
        Thread.sleep(5000);

        driver.switchTo().defaultContent();
        
        //Enter CVV details
        driver.switchTo().frame(paymentPage.cvviframe);
        paymentPage.enterCVVdetails("786");
        driver.switchTo().defaultContent();
        // Click payment
        paymentPage.usepayment();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ENTER).perform();
        
        
        //paymentPage.carddismiss();
    }
}
