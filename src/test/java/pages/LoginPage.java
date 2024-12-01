package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public void clickLoginButton() {
        driver.findElement(By.cssSelector("#cookiesplus-form > div.cookiesplus-actions.col-12.col-xs-12 > div.first-layer > div:nth-child(1) > div:nth-child(1) > button > span")).click();
    }

    @FindBy(xpath = "//input[@id='pass']/../../button")
    private WebElement signInButton = driver.findElement(By.cssSelector("#submit-login"));


    @FindBy(id = "user")
    private WebElement emailInput = driver.findElement(By.cssSelector("#login-form > section > div:nth-child(2) > div.col-md-6 > input"));



    @FindBy(id = "pass")
    private WebElement passwordInput = driver.findElement(By.cssSelector("#login-form > section > div:nth-child(3) > div.col-md-6 > div > input"));


    @FindBy(xpath = "//h1[contains(text(),'Sign in')]")
    private WebElement pageIdentifier;

    @FindBy(className = "error-message")
    private WebElement errorMessageElement;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        System.out.println("Waiting for login page to load");
        waitUntilElementVisible(pageIdentifier);
        this.enterUsername(username);
        this.enterPassword(password);
        this.submit();
    }

    public void enterUsername(String username) {
        waitUntilElementVisible(emailInput);
        System.out.println("Enter email:" + username);
        emailInput.clear();
        emailInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(passwordInput);
        System.out.println("Enter password:" + password);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void submit() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        System.out.println("Click sign in button");
        signInButton.click();
    }

    public boolean verifyLoginSuccessful(String username) {
        String xpath = "//h1[contains(text(),'Welcome to web-stubs, " + username + "!')]";

        WebElement welcomeMessage = waitUntilElementVisible(By.xpath(xpath));
        System.out.println("Welcome message displayed: " + welcomeMessage.getText());
        return welcomeMessage.isDisplayed();
    }

    public boolean verifyLoginFailed(String errorMessage) {
        waitUntilElementVisible(errorMessageElement);
        System.out.println("Error message displayed: " + errorMessageElement.getText());
        return errorMessageElement.getText().equalsIgnoreCase(errorMessage);
    }

}
