package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private WebDriver driver;
    private By usernameButton = By.xpath("//input[@name='username']");
    private By passwordButton = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//button[@type='submit']");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username1) {
        driver.findElement(usernameButton).sendKeys(username1);
    }

    public void setPassword(String password1) {
        driver.findElement(passwordButton).sendKeys(password1);
    }

    public SecureArea clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureArea(driver);
    }

}

