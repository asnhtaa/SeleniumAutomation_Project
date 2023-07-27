package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.CookieManager;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;


public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;
    private Properties p;

    @BeforeClass
    public void setUp(){
        initializeDriver();
        goHome();
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
        createScreenshotDirectory();
    }

    @BeforeMethod
    public void goHome(){
        driver.get(p.getProperty("url"));
    }

    @AfterMethod
    public void captureFailure(ITestResult result) throws IOException {
        if(ITestResult.FAILURE == result.getStatus()){
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("resources/screenshots"+result.getName()+".png"));
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    private void initializeDriver() {
        try (InputStream input = BaseTest.class.getClassLoader().getResourceAsStream("configfile/config.properties")) {
            p = new Properties();
            p.load(input);

            String browser = p.getProperty("browser");
            if (browser == null) {
                throw new IllegalArgumentException("Browser parameter is not specified in the properties file!");
            }

            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(getChromeOptions());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser specified in the properties file!");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read properties file!");
        }
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        return options;
    }

    private void createScreenshotDirectory() {
        Path screenshotDir = Paths.get("resources/screenshots");
        if (!Files.exists(screenshotDir)) {
            try {
                Files.createDirectories(screenshotDir);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to create screenshot directory!");
            }
        }
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
    public CookieManager getCookieManager(){
        return new CookieManager(driver);
    }
}