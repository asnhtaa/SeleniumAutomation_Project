package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowTests extends BaseTest {
    @Test
    public void testSwitchNewTab() {
        var dynamicLoad2Click = homePage.clickDynamicLoad().rightclickDynamicLoad2();
        getWindowManager().switchToNewTab();
        dynamicLoad2Click.clickStartButton();
        Assert.assertEquals(dynamicLoad2Click.getLoadedText(), "Hello World!", "Loaded Text is incorrect");
    }

    @Test
    public void testTabSwitch() {
        homePage.clickMultipleWindows().clickButton();
        getWindowManager().switchToTab("New Window");
    }
}
