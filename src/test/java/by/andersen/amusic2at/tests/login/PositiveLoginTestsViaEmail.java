package by.andersen.amusic2at.tests.login;

import by.andersen.amusic2at.pages.MainPage;
import by.andersen.amusic2at.tests.LoginTest;
import by.andersen.amusic2at.utils.TestRails;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static by.andersen.amusic2at.data.DataProvider.getValidEmailAndPasswordUser;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class PositiveLoginTestsViaEmail extends LoginTest {

    @AfterMethod
    private void logOut() {
        loginPage.doLogOut();

        loginPage.logInBtn.shouldBe(enabled);
    }

    @TestRails(id = "C5629354")
    @Test
    public void weCanSuccessLoginWithValidCredentials() {
        user = getValidEmailAndPasswordUser();
        loginPage.doLoginViaEmail(user.getEmail(), user.getPassword()).clickContinueButton();

        webdriver().shouldHave(url(MainPage.URL));
        loginPage.userMenu.shouldBe(visible);
    }

    @TestRails(id = "C5629356")
    @Test
    public void weCanUseRememberMeForLoginWithValidCredentials() {
        user = getValidEmailAndPasswordUser();
        loginPage.doLoginViaEmail(user.getEmail(), user.getPassword()).doRememberMeCheckBoxActive().clickContinueButton();

        webdriver().shouldHave(url(MainPage.URL));
        loginPage.userMenu.shouldBe(visible);
    }
}
