package by.andersen.amusic2at.tests;

import by.andersen.amusic2at.data.User;
import by.andersen.amusic2at.pages.LoginPage;
import org.testng.annotations.BeforeMethod;

public class LoginTest extends BaseTest {

    public LoginPage loginPage = new LoginPage();

    public User user;

    @BeforeMethod
    public void setUp() {
        loginPage.open();
    }
}
