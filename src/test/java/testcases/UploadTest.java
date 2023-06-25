package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DataProviderClass;

public class UploadTest extends BaseTest {
    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "test")
    public void testUploadSuccessful(String fileLocation, String result){
        var uploadPage = homePage.clickUploadButton();
        uploadPage.uploadFile(fileLocation);
        uploadPage.clickUploadButton();
        Assert.assertEquals(uploadPage.getResults(), result, "Result is incorrect");
    }
}
