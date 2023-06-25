package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.DataProviderClass;

public class WysiwygTest extends BaseTest {
    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "test")
    public void testWysiwygSuccessful(String text1, String text2){
        var wysiwygEditor = homePage.clickWysiwygButton();
        wysiwygEditor.clearText();
        wysiwygEditor.setText(text1);
        wysiwygEditor.clickIncreaseIndent();
        wysiwygEditor.setText(text2);
        Assert.assertEquals(wysiwygEditor.verifyText(), text1+text2, "Text input is incorrect");
    }
}
