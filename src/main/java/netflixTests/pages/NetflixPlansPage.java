package netflixTests.pages;

import netflixTests.support.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;

public class NetflixPlansPage extends BasePage{
    public NetflixPlansPage(WebDriver driver) {
        super(driver);
        Waiters.waitUntilElementIsPresent(".headerRow.show .Tappable-inactive[data-uia-name='text_1_stream_name'] .cellContent",10);
    }

    public String getBoxPlanName01(){
        driver.findElement(By.cssSelector(".headerRow.show .Tappable-inactive[data-uia-name='text_1_stream_name'] .cellContent")).click();
        WebElement plans = driver.findElement(By.cssSelector(".headerRow.show .Tappable-inactive.selected .cellContent"));
        return plans.getText();
    }
    public String getBoxPlanName02(){
        driver.findElement(By.cssSelector(".headerRow.show .Tappable-inactive[data-uia-name='text_2_stream_name'] .cellContent")).click();
        WebElement plans = driver.findElement(By.cssSelector(".headerRow.show .Tappable-inactive.selected .cellContent"));
        return plans.getText();
    }

    public String getBoxPlanName03(){
        WebElement plans = driver.findElement(By.cssSelector(".headerRow.show .Tappable-inactive.selected .cellContent"));
        return plans.getText();
    }

}
