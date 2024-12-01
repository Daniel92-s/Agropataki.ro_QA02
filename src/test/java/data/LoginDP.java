package data;

import org.testng.annotations.DataProvider;

public class LoginDP {
    @DataProvider
    public Object[][] loginDataProvider() {
        return new Object[][]{
//          username, password, browser
                {"zebra", "zebrapassword", "edge"},
                {"dingo", "dingopassword", "chrome"},
                {"camel", "camelpassword", "edge"},
        };
    }
}
