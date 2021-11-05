package by.andersen.amusic2at.data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataProvider {

    private static final List<User> validPhoneAndPasswordUserList = Arrays.asList(
            new User("+375291111111", null, "12345678"),
            new User("+380931616161", null, "12345678"),
            new User("+375297122695", null, "23041987")
    );

    private static final List<User> invalidPhoneAndPasswordUserList = Arrays.asList(
            new User("+375292222222", null, "11111111"),
            new User("+380932222222", null, "11111111"),
            new User("+375292222222", null, "11111111")
    );

    private static final List<User> invalidPhoneAndValidPasswordUserList = Arrays.asList(
            new User("+375292222222", null, "12345678"),
            new User("+375292222222", null, "12345678"),
            new User("+375292222222", null, "23041987")
    );

    private static final List<User> invalidPasswordAndValidPhoneUserList = Arrays.asList(
            new User("+375291111111", null, "11111111"),
            new User("+380931616161", null, "11111111"),
            new User("+375297122695", null, "11111111")
    );

    private static final List<User> validEmailAndPasswordUserList = Arrays.asList(
            new User(null, "pft06@vmani.com", "L12345678v"),
            new User(null, "amusictest@bk.ru", "testcaseforgot1"),
            new User(null, "Gusakov24@gmail.com", "23041987")
    );

    private static final List<User> invalidEmailAndPasswordUserList = Arrays.asList(
            new User(null, "pft06@vmaghni.com", "L1234567hgf8v"),
            new User(null, "amghgfhusictest@bk.ru", "testcfhhaseforgot1"),
            new User(null, "Gusahfhkov24@gmail.com", "23041ghfgh987")
    );

    private static final List<User> invalidPasswordAndValidEmailUserList = Arrays.asList(
            new User(null, "pft06@vmani.com", "11111111"),
            new User(null, "amusictest@bk.ru", "11111111"),
            new User(null, "Gusakov24@gmail.com", "11111111")
    );

    private static final List<User> invalidEmailAndValidPasswordUserList = Arrays.asList(
            new User(null, "pft06@vmaghni.com", "L12345678v"),
            new User(null, "amghgfhusictest@bk.ru", "testcaseforgot1!"),
            new User(null, "Gusahfhkov24@gmail.com", "23041987")
    );

    private static final List<User> incorrectEmailUserList = Arrays.asList(
            new User(null, "pft06vmani.com", "L12345678v"),
            new User(null, "amusictestbk.ru", "testcaseforgot1!"),
            new User(null, "Gusakov24gmail.com", "23041987")
    );

    public static User getValidPhoneAndPasswordUser() {
        return validPhoneAndPasswordUserList.get(new Random().nextInt(validPhoneAndPasswordUserList.size()));
    }

    public static User getInvalidPhoneAndPasswordUser() {
        return invalidPhoneAndPasswordUserList.get(new Random().nextInt(invalidPhoneAndPasswordUserList.size()));
    }

    public static User getInvalidPhoneAndValidPasswordUser() {
        return invalidPhoneAndValidPasswordUserList.get(new Random().nextInt(invalidPhoneAndValidPasswordUserList.size()));
    }

    public static User getInvalidPasswordAndValidPhoneUser() {
        return invalidPasswordAndValidPhoneUserList.get(new Random().nextInt(invalidPasswordAndValidPhoneUserList.size()));
    }

    public static User getValidEmailAndPasswordUser() {
        return validEmailAndPasswordUserList.get(new Random().nextInt(validEmailAndPasswordUserList.size()));
    }

    public static User getInvalidEmailAndPasswordUser() {
        return invalidEmailAndPasswordUserList.get(new Random().nextInt(invalidEmailAndPasswordUserList.size()));
    }

    public static User getInvalidPasswordAndValidEmailUser() {
        return invalidPasswordAndValidEmailUserList.get(new Random().nextInt(invalidPasswordAndValidEmailUserList.size()));
    }

    public static User getInvalidEmailAndValidPasswordUser() {
        return invalidEmailAndValidPasswordUserList.get(new Random().nextInt(invalidEmailAndValidPasswordUserList.size()));
    }

    public static User getIncorrectEmailUser() {
        return incorrectEmailUserList.get(new Random().nextInt(incorrectEmailUserList.size()));
    }
}
