package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDOM {
    private WebDriver driver;
    private By table = By.xpath("//table[@id='large-table']");

    public LargeAndDeepDOM(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToTable() {
        WebElement tableElement = driver.findElement(table);
        JavascriptExecutor scriptExecutor = (JavascriptExecutor) driver;
        scriptExecutor.executeScript("arguments[0].scrollIntoView(true)", tableElement);
    }
}
