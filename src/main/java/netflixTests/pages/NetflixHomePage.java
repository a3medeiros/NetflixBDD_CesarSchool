package netflixTests.pages;

import netflixTests.support.Waiters;
import netflixTests.support.Web;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NetflixHomePage extends BasePage {
    public NetflixHomePage(WebDriver driver) {
        super(driver);
            }

    Select languageSelect = new Select(driver.findElement(By.cssSelector(".ui-select")));
    WebElement contactUs = driver.findElement(By.linkText("Entre em contato"));
    WebElement waysToWatch = driver.findElement(By.linkText("Formas de assistir"));

    public NetflixHomePage changeLanguage(String language){
        languageSelect.selectByVisibleText(language);
        return this;
    }

    public NetflixSignUpPage clickToSignIn(){
        WebElement signUpButton = driver.findElement(By.cssSelector("[href='/login']"));
        signUpButton.click();
        return new NetflixSignUpPage(driver);
    }

    public NetflixPlansNotifyPage click30DaysSign(){
        WebElement sign30days = driver.findElement(By.cssSelector(".our-story-cta.btn-red.btn-large[placeholder='cta_link_startSignup']"));
        sign30days.click();
        return new NetflixPlansNotifyPage(driver);
    }

    public NetflixContactPage clickToContactUs(){
        contactUs.click();
        Waiters.waitUntilElementIsPresent(".signin-modal-content",10);
        return new NetflixContactPage(driver);
    }

    public NetflixWaysToWatchPage clickToWaysToWatch(){
        waysToWatch.click();
        Waiters.waitUntilElementIsPresent("[data-i18n='devices-hero-title']",10);
        return new NetflixWaysToWatchPage(driver);
    }
}
