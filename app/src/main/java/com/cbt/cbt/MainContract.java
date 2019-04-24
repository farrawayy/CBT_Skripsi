package com.cbt.cbt;

public interface MainContract {
    interface View {
        void loginSuccess(String title);
        void logout(String title);
        void showMessage(String message);
    }

    interface Presenter {
        void doLogin(String username, String password);
    }

}