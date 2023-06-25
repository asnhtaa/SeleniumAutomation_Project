package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFrames {
    private WebDriver driver;
    private By body = By.tagName("body");
    private String upperFrame = "frame-top";
    private String upperLeftFrame = "frame-left";
    private String lowerFrame = "frame-bottom";
    public NestedFrames(WebDriver driver){
        this.driver=driver;
    }
    public String switchToUpperLeftFrame(){
        driver.switchTo().frame(upperFrame);
        driver.switchTo().frame(upperLeftFrame);
        String Text = getFrameText();
        driver.switchTo().defaultContent();
        return Text;
    }
    public String switchToLowerFrame(){
        driver.switchTo().frame(lowerFrame);
        String Text = getFrameText();
        driver.switchTo().parentFrame();
        return Text;
    }
    public String getFrameText(){
        return driver.findElement(body).getText();
    }
}
