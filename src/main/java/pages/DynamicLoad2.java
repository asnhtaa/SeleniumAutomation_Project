package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoad2 {
    private WebDriver driver;
    public DynamicLoad2(WebDriver driver){
        this.driver=driver;
    }
    private By startButton = By.cssSelector("#start button");
    private By loading = By.xpath("//div[@id='loading']");
    private By loadedText = By.xpath("//div[@id='finish']");
    public void clickStartButton(){
        driver.findElement(startButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(loadedText));
    }
    public String getLoadedText(){
        return driver.findElement(loadedText).getText();
    }
}
