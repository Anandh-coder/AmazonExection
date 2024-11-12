package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonHomePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//input[@type = 'text']")
    WebElement searchBox;

    @FindBy(xpath = "(//div[contains(@class, 'a-section aok-relative s-image-fixed-height')])[1]")
    WebElement firstProduct;

    @FindBy(id = "buy-now-button")
    WebElement buyNowButton;

    

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String productName) {
        searchBox.sendKeys(productName, Keys.ENTER);
    }

    public void selectFirstProduct() {
        firstProduct.click();
    }

    public void clickBuyNow() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(buyNowButton));
        element.click();
    }

    
}
