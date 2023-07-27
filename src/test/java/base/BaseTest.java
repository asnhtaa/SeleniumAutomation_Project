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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.CookieManager;
import utils.WindowManager;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;
    private static Properties p = new Properties();
    private static FileReader fr;
    @BeforeClass
    public void setUp() throws IOException {
        if(driver==null){
            fr = new FileReader("src/test/resources/configfile/config.properties");
            p.load(fr);
        }
        if(p.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver(getChromeOptions());
        }
        if(p.getProperty("browser").equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        if(p.getProperty("browser").equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        if(p.getProperty("browser").equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }
        goHome();
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
        createScreenshotDirectory();
    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
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

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        return options;
    }
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
    public CookieManager getCookieManager(){
        return new CookieManager(driver);
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


}