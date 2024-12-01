package data;

import org.testng.annotations.DataProvider;

public class LoginDP {
    @DataProvider
    public Object[][] loginDataProvider() {
        return new Object[][]{
//          username, password, browser
                {"$@a.com", "$$$$$$$$", "edge"},
                {"$@a.com", "$$$$$$$$", "chrome"},
                {"$@a.com", "$$$$$$$$", "firefox"},
        };
    }
}
