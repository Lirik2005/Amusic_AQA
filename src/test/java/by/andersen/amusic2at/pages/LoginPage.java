package by.andersen.amusic2at.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    public SelenideElement logInBtn = $(By.linkText("Log in"));
    public SelenideElement telInput = $("input[type='tel']");
    public SelenideElement passwordInput = $("#password");
    public SelenideElement continueBtn = $(By.xpath("//span[contains(text(),'Login')]"));
    public SelenideElement rememberMeCheckBox = $(By.xpath("//input[@type='checkbox']"));
    public SelenideElement alertWindow = $(By.xpath("//div[@role='alert']"));
    public SelenideElement phoneAlertMessage = $(By.xpath("//p[@class='errorMessage']"));
    public SelenideElement passwordAlertMessage = $(By.xpath("//p[@id='error-text']"));
    public SelenideElement userMenu = $(By.xpath("//div[@class='MainPageUserPanel_wrapper__1NOYN']"));
    public SelenideElement logOutBtn = $(By.xpath("//span[text()='Sign Out']"));
    public SelenideElement logInWindowCloseBtn = $(By.xpath("//div[@class='CloseButton_container__2d853']/button"));
    public SelenideElement logInViaEmail = $(By.xpath("//button[text() = 'Login via email']"));
    public SelenideElement emailInput = $("input[type='email']");
    public SelenideElement emailAlertMessage = $(By.xpath("//label[text()='Enter your email']/../p"));
    public SelenideElement emailPasswordAlertMessage = $(By.xpath("//label[text()='Password']/../p"));
    public SelenideElement invalidEmailMessage = $(By.xpath("//p[text()='Invalid e-mail address']"));

    public LoginPage open() {
        Selenide.open(START_URL);

        return this;
    }

    private LoginPage clickLogInButton() {
        this.logInBtn.click();

        return this;
    }

    public LoginPage doLogOut() {
        this.userMenu.click();
        this.logOutBtn.click();

        return this;
    }

    public LoginPage doRememberMeCheckBoxActive() {
        this.rememberMeCheckBox.click();

        return this;
    }

    private void clearFormControl() {
        do {
            telInput.sendKeys(Keys.BACK_SPACE);
        } while (!Objects.requireNonNull(telInput.getValue()).isEmpty());
    }

    public LoginPage clickContinueButton() {
        this.continueBtn.click();

        return this;
    }

    public LoginPage doLoginViaPhone(String tel, String password) {
        clickLogInButton();
        clearFormControl();
        this.telInput.setValue(tel);
        this.passwordInput.setValue(password);

        return this;
    }

    public LoginPage doLoginViaEmail(String email, String password) {
        clickLogInButton();
        this.logInViaEmail.click();
        this.emailInput.setValue(email);
        this.passwordInput.setValue(password);

        return this;
    }
}
