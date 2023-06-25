package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenu {
    private WebDriver driver;
    private By box = By.xpath("//div[@id='hot-spot']");

    public ContextMenu(WebDriver driver) {
        this.driver = driver;
    }
    public void clickContextMenu(){
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(box)).perform();

    }
    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }
}