package netflixTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NetflixWaysToWatchPage extends BasePage{
    public NetflixWaysToWatchPage(WebDriver driver) {
        super(driver);
    }

    public String getWay2Watch(String txt){
        return driver.findElement(By.xpath("//span[contains(.,'"+txt+"')]")).getText();
    }

    public boolean getWayToWatchNetflix(String text){
        System.out.println(text);
        boolean result = driver.getPageSource().contains(text);
        return result;
    }
}
