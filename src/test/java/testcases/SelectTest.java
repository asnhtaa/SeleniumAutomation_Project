package testcases;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Dropdown;
import utilities.DataProviderClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SelectTest extends BaseTest {
    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "test")
    public void testSelectSuccessful(String option, double result){
        Dropdown dropdownPage = homePage.clickDropdownButton();
        dropdownPage.selectOption(option);
        var selectedOptions = dropdownPage.getSelectedOptions();
        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(selectedOptions.size(), result, "Number of selected options is incorrect");
        assertion.assertTrue(selectedOptions.contains(option), "Selected option is incorrect");
    }
}
