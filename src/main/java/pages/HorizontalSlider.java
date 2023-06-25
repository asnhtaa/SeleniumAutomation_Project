package pages;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HorizontalSlider {
    private WebDriver driver;
    private By slider = By.xpath("//input[@type='range']");
    private By rangeIndicator = By.xpath("//span[@id='range']");
    public HorizontalSlider(WebDriver driver){
        this.driver=driver;
    }
    public void setSlider(int sliderHorizontal, int sliderVertical){
        WebElement sliderPosition = driver.findElement(slider);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(sliderPosition, sliderHorizontal, sliderVertical).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public String getRangeIndicator(){
        return driver.findElement(rangeIndicator).getText();
    }
}
