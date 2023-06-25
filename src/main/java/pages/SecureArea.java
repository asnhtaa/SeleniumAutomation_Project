package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureArea {
    private WebDriver driver;
    By SecureAreaButton = By.xpath("//div[@class='flash success']");
    public SecureArea(WebDriver driver){
        this.driver = driver;
    }
    public String returnSecureAreaText(){
        String SecureAreaText = driver.findElement(SecureAreaButton).getText();
        return SecureAreaText;
    }
}
