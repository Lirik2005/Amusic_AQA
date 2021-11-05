package by.andersen.amusic2at.tests.login;

import by.andersen.amusic2at.enums.Alerts;
import by.andersen.amusic2at.pages.MainPage;
import by.andersen.amusic2at.tests.LoginTest;
import by.andersen.amusic2at.utils.TestRails;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static by.andersen.amusic2at.data.DataProvider.getInvalidPasswordAndValidPhoneUser;
import static by.andersen.amusic2at.data.DataProvider.getInvalidPhoneAndPasswordUser;
import static by.andersen.amusic2at.data.DataProvider.getInvalidPhoneAndValidPasswordUser;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class NegativeLoginTestsViaPhone extends LoginTest {

    @AfterMethod
    public void loginWindowClose() {
        loginPage.logInWindowCloseBtn.click();

        loginPage.logInBtn.shouldBe(enabled);
    }

    @TestRails(id = "C5629319")
    @Test(groups = {"negativeAuthorization"})
    public void negativeSingInWithInvalidCredentials() {
        user = getInvalidPhoneAndPasswordUser();
        loginPage.doLoginViaPhone(user.getPhone(), user.getPassword()).clickContinueButton();

        loginPage.alertWindow.shouldHave(exactText(Alerts.WRONG_LOGIN.getValue()));
        webdriver().shouldNotHave(url(MainPage.URL));
    }

    @TestRails(id = "C5629335")
    @Test(groups = {"negativeAuthorization"})
    public void negativeSingInWithInvalidPassword() {
        user = getInvalidPasswordAndValidPhoneUser();
        loginPage.doLoginViaPhone(user.getPhone(), user.getPassword()).clickContinueButton();

        loginPage.alertWindow.shouldHave(exactText(Alerts.WRONG_PASSWORD.getValue()));
        webdriver().shouldNotHave(url(MainPage.URL));
    }

    @TestRails(id = "C5629336")
    @Test(groups = {"negativeAuthorization"})
    public void negativeSingInWithInvalidPhone() {
        user = getInvalidPhoneAndValidPasswordUser();
        loginPage.doLoginViaPhone(user.getPhone(), user.getPassword()).clickContinueButton();

        loginPage.alertWindow.shouldHave(exactText(Alerts.WRONG_LOGIN.getValue()));
        webdriver().shouldNotHave(url(MainPage.URL));
    }

    @TestRails(id = "C5629805")
    @Test(groups = {"negativeAuthorization"})
    public void negativeSingInWithEmptyCredentials() {
        loginPage.doLoginViaPhone("", "").clickContinueButton();

        loginPage.phoneAlertMessage.shouldBe(appear);
        loginPage.passwordAlertMessage.shouldBe(appear);
        webdriver().shouldNotHave(url(MainPage.URL));
    }

    @TestRails(id = "C5649887")
    @Test(groups = {"negativeAuthorization"})
    public void negativeSingInWithEmptyPassword() {
        user = getInvalidPasswordAndValidPhoneUser();
        loginPage.doLoginViaPhone(user.getPhone(), "").clickContinueButton();

        loginPage.passwordAlertMessage.shouldBe(appear);
        webdriver().shouldNotHave(url(MainPage.URL));
    }

    @TestRails(id = "C5649890")
    @Test(groups = {"negativeAuthorization"})
    public void negativeSingInWithEmptyPhone() {
        user = getInvalidPhoneAndValidPasswordUser();
        loginPage.doLoginViaPhone("", user.getPassword()).clickContinueButton();

        loginPage.phoneAlertMessage.shouldBe(appear);
        webdriver().shouldNotHave(url(MainPage.URL));
    }
}
