package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultipleWindowsTest extends BaseTest {
    @Test
    public void multipleWindowsSuccessful(){
        var multipleWindows = homePage.clickMultipleWindows();
        multipleWindows.clickButton();
        getWindowManager().switchToNewTab();
        Assert.assertEquals(multipleWindows.getWindowTitle(), "New Window", "Window title is incorrect");
    }
}
