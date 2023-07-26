package testcases;

import base.BaseTest;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Keypress;

public class KeypressTest extends BaseTest {
    @Test
    public void testBackspaceSuccessful(){
        Keypress keypressPage = homePage.clickKeypressButton();
        keypressPage.enterText("A"+Keys.BACK_SPACE);
        Assert.assertTrue(keypressPage.getResult().contains("BACK_SPACE"), "Result is incorrect");
    }
}
