package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScroll {
    private WebDriver driver;
    private By textBlocks = By.xpath("//div[@class='jscroll-added']");
    public InfiniteScroll(WebDriver driver){
        this.driver=driver;
    }
    public void scrollIntoTextBlock(int textBlockNumber){
        while(getNumberOfTextBlocks()>textBlockNumber) {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight");
        }
    }
    public int getNumberOfTextBlocks(){
        return driver.findElements(textBlocks).size();
    }
}
