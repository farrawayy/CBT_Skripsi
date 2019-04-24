package com.cbt.cbt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginManager {

    private LoginManager() {}

    private static class LoginManagerHelper {
        private static final LoginManager INSTANCE = new LoginManager();
    }
    public static LoginManager getInstance() {
        return LoginManagerHelper.INSTANCE;
    }

    public boolean validate(String email, String password) {
        return isValidEmail(email) && isPasswordCorrect(password);
    }

    private boolean isValidEmail(String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isPasswordCorrect(String password) {
        return password.equalsIgnoreCase("123");
    }
}