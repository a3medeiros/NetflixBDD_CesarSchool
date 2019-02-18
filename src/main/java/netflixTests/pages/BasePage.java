package netflixTests.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    //driver that is going to be used by the Forms pages
    protected WebDriver driver;
    //constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

}
