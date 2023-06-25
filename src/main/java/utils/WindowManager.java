package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {
    private WebDriver driver;
    private WebDriver.Navigation navigate;
    public WindowManager(WebDriver driver){
        this.driver = driver;
    }
    public void goBack(){
        navigate.back();
    }
    public void goForward(){
        navigate.forward();
    }
    public void navigateTo(String url){
        navigate.to(url);
    }
    public void refresh(){
        navigate.refresh();
    }
    public void switchToTab(String tabTitle){
        var windows = driver.getWindowHandles();
        for(String window:windows){
            driver.switchTo().window(window);
            if(tabTitle.equalsIgnoreCase(driver.getTitle())){
                break;
            }
        }

        }

    public void switchToNewTab(){
        var windows = driver.getWindowHandles();
        windows.forEach(driver.switchTo()::window);
    }
}
