package netflixTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NetflixPlansNotifyPage extends BasePage{
    public NetflixPlansNotifyPage(WebDriver driver) {
        super(driver);
    }

    WebElement showPlansButton = driver.findElement(By.cssSelector(".nf-btn"));

    public NetflixPlansPage clickShowPlans(){
        showPlansButton.click();
        return new NetflixPlansPage(driver);
    }
}
