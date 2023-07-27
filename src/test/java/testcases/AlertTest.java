package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Alert;

public class AlertTest extends BaseTest {
    private Alert alertPage;

    @BeforeTest
    public void setUpAlertPage() {
        alertPage = homePage.clickAlertButton();
    }
    @Test
    public void testAlertSuccessful() {
        alertPage.triggerAlert();
        alertPage.acceptAlert();
        Assert.assertEquals(alertPage.alertResult(), "You successfully clicked an alert", "Alert result is incorrect");
    }

    @Test
    public void testConfirmSuccessful() {
        alertPage.triggerConfirmAlert();
        alertPage.dismissConfirmAlert();
        Assert.assertEquals(alertPage.alertResult(), "You clicked: Cancel", "Alert result is incorrect");
    }

    @Test
    public void testPromptSuccessful() {
        alertPage.triggerPromptAlert();
        String inputText = "Hello!";
        alertPage.promptSetInput(inputText);
        alertPage.acceptAlert();
        Assert.assertEquals(alertPage.alertResult(), "You entered: "+ inputText, "Alert result is incorrect");
    }

}
