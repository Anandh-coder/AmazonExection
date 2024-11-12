# Selenium TestNG POM Framework
This project is a hybrid framework using Selenium WebDriver, TestNG, and the Page Object Model (POM) pattern to automate test cases for a web application.

# Project Structure
src ├── main │ ├── java │ │ └── pageobjects │ │ └── AmazonLoginPage.java │ │ └── AmazonHomePage.java │ └── AmazonPaymentPage.java
src ├── test ├── java │ └── testcases │ └── AmazonTest.java │ └── utils │ └── BaseTest.java └── resources └── testng.xml

# Prerequisites - Java (JDK 8 or higher) - Maven - ChromeDriver - IDE (IntelliJ IDEA, Eclipse, etc.)

# Project Components

AmazonLoginPage.java
// Handles interactions with the Amazon login page

AmazonHomePage.java
// Handles interactions with the Amazon home page and product selection

AmazonPaymentPage.java
// Handles interactions with the Amazon payment page.

AmazonTest.java
// Test case for logging into Amazon and purchasing a product

BaseTest.java
// Handles the setup and teardown of the WebDriver

<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Amazon Test Suite">
    <test name="Amazon Test">
        <classes>
            <class name="testcases.AmazonTest"/>
        </classes>
    </test>
</suite>
