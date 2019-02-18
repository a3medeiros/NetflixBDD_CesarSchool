package netflixTests.pages;

import netflixTests.support.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NetflixContactPage extends BasePage {

    public NetflixContactPage(WebDriver driver) {
        super(driver);
    }

    WebElement callForUsBtn = driver.findElement(By.cssSelector("#phoneContactTrigger"));

    public NetflixContactPage closeModal(){
        driver.findElement(By.cssSelector(".close-modal")).click();
        return this;
    }

    public NetflixContactPage clickCallForUs(){
        callForUsBtn.click();
        Waiters.waitUntilElementIsPresent(".phonePopover",10);
        return this;
    }

    public String getNetflixBRnumber(){
        return driver.findElement(By.cssSelector(".phonePopover .phone-no .btn")).getText();
    }

}
