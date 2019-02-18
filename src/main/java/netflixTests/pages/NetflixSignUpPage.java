package netflixTests.pages;

import netflixTests.support.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NetflixSignUpPage extends BasePage {
    public NetflixSignUpPage(WebDriver driver) {
        super(driver);
    }

    WebElement userEmailField = driver.findElement(By.id("id_userLoginId"));
    WebElement userPasswordField = driver.findElement(By.id("id_password"));
    WebElement loginBtn = driver.findElement(By.cssSelector(".login-button"));

    public NetflixSignUpPage writeEmailField(String email){
        userEmailField.sendKeys(email);
        return this;
    }
    public NetflixSignUpPage writePswdField(String pswd){
        userPasswordField.sendKeys(pswd);
        return this;
    }
    public NetflixSignUpPage loginSubmitError(){
        loginBtn.click();
        Waiters.waitUntilElementIsPresent(".ui-message-error",10);
        return this;
    }

    public NetflixLoggedInPage loginSubmit(){
        loginBtn.click();
        return new NetflixLoggedInPage(driver);
    }

    public String getErrorMsg(){
        return driver.findElement(By.cssSelector(".ui-message-error")).getText();
    }
}
