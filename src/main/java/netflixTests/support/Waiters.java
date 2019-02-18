package netflixTests.support;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {

    // Wait until element is present on the page
    public static void waitUntilElementIsPresent (String css, int seconds) {
        WebDriverWait wait = new WebDriverWait (Web.driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByCssSelector(css)));
    }


    // Wait until element is NOT present on the page
    public static void waitUntilElementIsNotPresent (String css, int seconds){
        WebDriverWait wait = new WebDriverWait (Web.driver, seconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(new By.ByCssSelector(css)));
    }


    // Wait until element has a specific text
    public static void waitUntilTextIsPresentInElement (String css, String text, int seconds){
        WebDriverWait wait = new WebDriverWait (Web.driver, seconds);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(new By.ByCssSelector(css), text));
    }
}
