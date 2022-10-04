package org.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private By emailAddress = By.id("Email");
    private By password = By.id("inputPassword");
    private By loginButton = By.id("btnLogin");


    @Step("Add Email Address")
    public void setEmailAddress (String email){
        setText(emailAddress , email);
    }

    @Step("add password")
    public void setPassword(String pass) {
       setText(password , pass);
    }

    @Step("click login")
    public void clickLogin(){
        click(loginButton);
    }
}
