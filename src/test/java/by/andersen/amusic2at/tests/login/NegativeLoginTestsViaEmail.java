package by.andersen.amusic2at.tests.login;

import by.andersen.amusic2at.enums.Alerts;
import by.andersen.amusic2at.pages.MainPage;
import by.andersen.amusic2at.tests.LoginTest;
import by.andersen.amusic2at.utils.TestRails;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static by.andersen.amusic2at.data.DataProvider.getIncorrectEmailUser;
import static by.andersen.amusic2at.data.DataProvider.getInvalidEmailAndPasswordUser;
import static by.andersen.amusic2at.data.DataProvider.getInvalidEmailAndValidPasswordUser;
import static by.andersen.amusic2at.data.DataProvider.getInvalidPasswordAndValidEmailUser;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class NegativeLoginTestsViaEmail extends LoginTest {

    @AfterMethod
    public void loginWindowClose() {
        loginPage.logInWindowCloseBtn.click();

        loginPage.logInBtn.shouldBe(enabled);
    }

    @TestRails(id = "C5629357")
    @Test(groups = {"negativeAuthorization"})
    public void negativeSingInWithInvalidCredentials() {
        user = getInvalidEmailAndPasswordUser();
        loginPage.doLoginViaEmail(user.getEmail(), user.getPassword()).clickContinueButton();

        loginPage.alertWindow.shouldHave(exactText(Alerts.WRONG_LOGIN.getValue()));
        webdriver().shouldNotHave(url(MainPage.URL));
    }

    @TestRails(id = "C5629360")
    @Test(groups = {"negativeAuthorization"})
    public void negativeSingInWithEmptyPassword() {
        user = getInvalidPasswordAndValidEmailUser();
        loginPage.doLoginViaEmail(user.getEmail(), "").clickContinueButton();

        loginPage.passwordAlertMessage.shouldBe(appear);
        loginPage.emailPasswordAlertMessage.shouldBe(appear);
        webdriver().shouldNotHave(url(MainPage.URL));
    }

    @TestRails(id = "C5629376")
    @Test(groups = {"negativeAuthorization"})
    public void negativeSingInWithEmptyEmail() {
        user = getInvalidEmailAndValidPasswordUser();
        loginPage.doLoginViaEmail("", user.getPassword()).clickContinueButton();

        loginPage.emailAlertMessage.shouldBe(appear);
        webdriver().shouldNotHave(url(MainPage.URL));
    }

    @TestRails(id = "C5629806")
    @Test(groups = {"negativeAuthorization"})
    public void negativeSingInWithEmptyCredentials() {
        loginPage.doLoginViaEmail("", "").clickContinueButton();

        loginPage.emailAlertMessage.shouldBe(appear);
        loginPage.emailPasswordAlertMessage.shouldBe(appear);
        webdriver().shouldNotHave(url(MainPage.URL));
    }

    @TestRails(id = "C5649894")
    @Test(groups = {"negativeAuthorization"})
    public void negativeSingInWithIncorrectEmail() {
        user = getIncorrectEmailUser();
        loginPage.doLoginViaEmail(user.getEmail(), user.getPassword()).clickContinueButton();

        loginPage.invalidEmailMessage.shouldBe(appear);
        webdriver().shouldNotHave(url(MainPage.URL));
    }

    @TestRails(id = "C5649902")
    @Test(groups = {"negativeAuthorization"})
    public void negativeSingInWithInvalidPassword() {
        user = getInvalidPasswordAndValidEmailUser();
        loginPage.doLoginViaEmail(user.getEmail(), user.getPassword()).clickContinueButton();

        loginPage.alertWindow.shouldHave(exactText(Alerts.WRONG_PASSWORD.getValue()));
        webdriver().shouldNotHave(url(MainPage.URL));
    }

    @TestRails(id = "C5649906")
    @Test(groups = {"negativeAuthorization"})
    public void negativeSingInWithInvalidEmail() {
        user = getInvalidEmailAndValidPasswordUser();
        loginPage.doLoginViaEmail(user.getEmail(), user.getPassword()).clickContinueButton();

        loginPage.alertWindow.shouldHave(exactText(Alerts.WRONG_LOGIN.getValue()));
        webdriver().shouldNotHave(url(MainPage.URL));
    }
}
