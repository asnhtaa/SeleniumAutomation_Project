package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MultipleWindows {
    private WebDriver driver;
    private By clickHereButton = By.linkText("Click Here");
    public MultipleWindows(WebDriver driver){
        this.driver=driver;
    }
    public void clickButton(){
        driver.findElement(clickHereButton).click();
    }

    public String getWindowTitle(){
        String driverTitle = driver.getTitle();
        return driverTitle;
    }
}
