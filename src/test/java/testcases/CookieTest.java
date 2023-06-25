package testcases;

import base.BaseTest;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DataProviderClass;

public class CookieTest extends BaseTest {
    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "test")
    public void addAndDeleteCookieSuccessful(String name, String value){
        var cookieManager = getCookieManager();
        Cookie cookie = cookieManager.buildCookie(name, value);
        cookieManager.addCookie(cookie);
        Assert.assertTrue(cookieManager.isCookiePresent(cookie), "Cookie is not added");
        cookieManager.deleteCookie(cookie);
        Assert.assertFalse(cookieManager.isCookiePresent(cookie), "Cookie is not deleted");
    }
}
