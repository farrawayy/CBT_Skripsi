package com.cbt.cbt;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private MainPresenter mPresenter;

    @BindView(R.id.et_username) EditText etUsername;

    @BindView(R.id.et_password) EditText etPassword;

    @BindView(R.id.bt_login) Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPresenter = new MainPresenter(this);

    }

    @OnClick(R.id.bt_login)
    void loginClicked() {
        mPresenter.doLogin(etUsername.getText().toString(),etPassword.getText().toString());
    }

    @Override
    public void loginSuccess(String title) {
        btLogin.setText(title);
        etUsername.setText("");
        etPassword.setText("");
        Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
        startActivity(intent);
    }

    @Override
    public void logout(String title) {
        btLogin.setText(title);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

}
