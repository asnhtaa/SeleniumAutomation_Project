package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditor {
    private WebDriver driver;
    private String frameId = "mce_0_ifr";
    private By frameTextArea = By.id("tinymce");
    private By increaseIndentButton = By.xpath("//button[@title='Increase indent']");
    public WysiwygEditor(WebDriver driver){
        this.driver = driver;
    }
    public void clearText(){
        switchToFrame();
        driver.findElement(frameTextArea).clear();
        switchToParentFrame();
    }
    public void setText(String inputText){
        switchToFrame();
        driver.findElement(frameTextArea).sendKeys(inputText);
        switchToParentFrame();
    }
    public void clickIncreaseIndent(){
        driver.findElement(increaseIndentButton).click();
    }
    public String verifyText(){
        switchToFrame();
        String resultText = driver.findElement(frameTextArea).getText();
        switchToParentFrame();
        return resultText;
    }
    public void switchToFrame(){
        driver.switchTo().frame(frameId);
    }
    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }
}
