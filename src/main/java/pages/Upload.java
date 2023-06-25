package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Upload {
    private WebDriver driver;
    By chooseFileButton = By.xpath("//input[@id='file-upload']");
    By uploadButton = By.xpath("//input[@id='file-submit']");
    By resultButton = By.xpath("//div[@id='uploaded-files']");
    public Upload(WebDriver driver){
        this.driver = driver;
    }
    public void uploadFile(String fileLocation){
        driver.findElement(chooseFileButton).sendKeys(fileLocation);
    }
    public void clickUploadButton(){
        driver.findElement(uploadButton).click();
    }
    public String getResults(){
        return driver.findElement(resultButton).getText();
    }
}
