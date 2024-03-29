package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class Dropdown {
    private WebDriver driver;
    private By dropdown = By.xpath("//select[@id='dropdown']");
    public Dropdown(WebDriver driver) {
        this.driver = driver;
    }
    public List<String> getSelectedOptions(){
        List <WebElement> selectedOptions = findDropdown().getAllSelectedOptions();
        return selectedOptions.stream().map(e->e.getText()).collect(Collectors.toList());
    }
    public void selectOption(String option){
        findDropdown().selectByVisibleText(option);
    }
    private Select findDropdown(){
        return new Select(driver.findElement(dropdown));
    }

}
