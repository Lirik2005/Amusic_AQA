package by.andersen.amusic2at.tests.login;

import by.andersen.amusic2at.pages.MainPage;
import by.andersen.amusic2at.tests.LoginTest;
import by.andersen.amusic2at.utils.TestRails;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static by.andersen.amusic2at.data.DataProvider.getValidPhoneAndPasswordUser;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class PositiveLoginTestsViaPhone extends LoginTest {

    @AfterMethod
    private void logOut() {
        loginPage.doLogOut();

        loginPage.logInBtn.shouldBe(enabled);
    }

    @TestRails(id = "C5629315")
    @Test
    public void weCanSuccessLoginWithValidCredentials() {
        user = getValidPhoneAndPasswordUser();
        loginPage.doLoginViaPhone(user.getPhone(), user.getPassword()).clickContinueButton();

        webdriver().shouldHave(url(MainPage.URL));
        loginPage.userMenu.shouldBe(visible);
    }

    @TestRails(id = "C5629318")
    @Test
    public void weCanUseRememberMeForLoginWithValidCredentials() {
        user = getValidPhoneAndPasswordUser();
        loginPage.doLoginViaPhone(user.getPhone(), user.getPassword()).doRememberMeCheckBoxActive().clickContinueButton();

        webdriver().shouldHave(url(MainPage.URL));
        loginPage.userMenu.shouldBe(visible);
    }
}
