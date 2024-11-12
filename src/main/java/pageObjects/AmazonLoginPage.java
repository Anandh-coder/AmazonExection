package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonLoginPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "ap_email")
    WebElement emailField;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "ap_password")
    WebElement passwordField;

    @FindBy(id = "signInSubmit")
    WebElement signInSubmitButton;
    
    @FindBy(xpath = "//div[@id='nav-signin-tooltip']//span[@class='nav-action-inner'][normalize-space()='Sign in']")
    WebElement signInLink;
    
    public AmazonLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSignInSubmit() {
        signInSubmitButton.click();
    }
    
    public void clickSignInlink() {
    	signInLink.click();
    }
}
