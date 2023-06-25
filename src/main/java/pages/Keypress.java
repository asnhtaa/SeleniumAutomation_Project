package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Keypress {
    private WebDriver driver;
    By textField = By.xpath("//input[@id='target']");
    By resultField = By.xpath("//p[@id='result']");

    public Keypress(WebDriver driver){
        this.driver = driver;
    }
    public void enterText(String input){
        driver.findElement(textField).sendKeys(input);
    }
    public String getResult(){
        return driver.findElement(resultField).getText();
    }
}
