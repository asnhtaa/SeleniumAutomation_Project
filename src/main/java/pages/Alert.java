package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Alert {
    private WebDriver driver;
    private By triggerAlertButton = By.xpath("//button[@onclick='jsAlert()']");
    private By alertResult= By.xpath("//p[@id='result']");
    private By triggerConfirmButton = By.xpath("//button[@onclick='jsConfirm()']");
    private By triggerPromptButton = By.xpath("//button[@onclick='jsPrompt()']");
    public Alert(WebDriver driver){
        this.driver=driver;
    }
    public void triggerAlert(){
        driver.findElement(triggerAlertButton).click();
    }
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public String alertResult(){
        return driver.findElement(alertResult).getText();
    }
    public void triggerConfirmAlert(){
        driver.findElement(triggerConfirmButton).click();
    }
    public void dismissConfirmAlert() {
        driver.switchTo().alert().dismiss();
    }
    public void triggerPromptAlert(){
        driver.findElement(triggerPromptButton).click();
    }
    public void promptSetInput(String AlertInput){
        driver.switchTo().alert().sendKeys(AlertInput);
    }
}

