package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;

public class DataProviderClass {
    @DataProvider(name = "test")
    public static Object[][] provideTestData(Method method) throws IOException {
        ReadXLSFile reader = new ReadXLSFile();
        return reader.readExcelData(method);
    }
}