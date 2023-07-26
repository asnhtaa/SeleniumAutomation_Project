package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Alert;

public class AlertTest extends BaseTest {
    @Test
    public void testAlertSuccessful() {
        Alert alertPage = homePage.clickAlertButton();
        alertPage.triggerAlert();
        alertPage.acceptAlert();
        Assert.assertEquals(alertPage.alertResult(), "You successfully clicked an alert", "Alert result is incorrect");
    }

    @Test
    public void testConfirmSuccessful() {
        Alert alertPage = homePage.clickAlertButton();
        alertPage.triggerConfirmAlert();
        alertPage.dismissConfirmAlert();
        Assert.assertEquals(alertPage.alertResult(), "You clicked: Cancel", "Alert result is incorrect");
    }

    @Test
    public void testPromptSuccessful() {
        Alert alertPage = homePage.clickAlertButton();
        alertPage.triggerPromptAlert();
        String inputText = "Hello!";
        alertPage.promptSetInput(inputText);
        alertPage.acceptAlert();
        Assert.assertEquals(alertPage.alertResult(), "You entered: "+ inputText, "Alert result is incorrect");
    }

}
