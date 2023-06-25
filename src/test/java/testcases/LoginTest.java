package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login;
import pages.SecureArea;
import utilities.DataProviderClass;


public class LoginTest extends BaseTest {
    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "test")
    public void TestLoginSuccessful(String username, String password){
        Login loginPage = homePage.clickAuthenticationButton();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        SecureArea secureArea = loginPage.clickLoginButton();
        Assert.assertTrue(secureArea.returnSecureAreaText().contains("You logged into a secure area!"), "Alert is incorrect");
    }
}

