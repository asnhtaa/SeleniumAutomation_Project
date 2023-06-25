package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickLink(String link) {
        driver.findElement(By.linkText(link)).click();
    }

    public Login clickAuthenticationButton() {
        clickLink("Form Authentication");
        return new Login(driver);
    }

    public Dropdown clickDropdownButton() {
        clickLink("Dropdown");
        return new Dropdown(driver);
    }

    public Hover clickHoverButton() {
        clickLink("Hovers");
        return new Hover(driver);
    }

    public Keypress clickKeypressButton() {
        clickLink("Key Presses");
        return new Keypress(driver);
    }

    public Alert clickAlertButton() {
        clickLink("JavaScript Alerts");
        return new Alert(driver);
    }

    public Upload clickUploadButton() {
        clickLink("File Upload");
        return new Upload(driver);
    }

    public WysiwygEditor clickWysiwygButton() {
        clickLink("WYSIWYG Editor");
        return new WysiwygEditor(driver);
    }

    public DynamicLoad clickDynamicLoad() {
        clickLink("Dynamic Loading");
        return new DynamicLoad(driver);
    }

    public LargeAndDeepDOM clickLargeAndDeepDOM() {
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDOM(driver);
    }

    public InfiniteScroll clickInfiniteScroll() {
        clickLink("Infinite Scroll");
        return new InfiniteScroll(driver);
    }

    public MultipleWindows clickMultipleWindows() {
        clickLink("Multiple Windows");
        return new MultipleWindows(driver);
    }

    public HorizontalSlider clickHorizontalSlider() {
        clickLink("Horizontal Slider");
        return new HorizontalSlider(driver);
    }

    public ContextMenu clickContextMenu() {
        clickLink("Context Menu");
        return new ContextMenu(driver);
    }

    public NestedFrames clickNestedFrames() {
        clickLink("Nested Frames");
        return new NestedFrames(driver);
    }
}
