package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoad {
    private WebDriver driver;
    By example1 = By.xpath("//a[contains(text(), 'Example 1')]");
    By example2 = By.xpath("//a[contains(text(), 'Example 2')]");
    public DynamicLoad(WebDriver driver){
        this.driver = driver;
    }
    public DynamicLoad1 clickDynamicLoad1(){
        driver.findElement(example1).click();
        return new DynamicLoad1(driver);
    }
    public DynamicLoad2 clickDynamicLoad2(){
        driver.findElement(example2).click();
        return new DynamicLoad2(driver);
    }
    public DynamicLoad2 rightclickDynamicLoad2(){
        driver.findElement(example2).click();
        return new DynamicLoad2(driver);
    }
}
