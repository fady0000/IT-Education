package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    private  By navigationBar = By.id("btnMinifyMe");
    private  By coursesList = By.id("btnMyCoursesList");

    public void openNavigationBar() {
        click(navigationBar);
    }

    public void openCoursesList() {
        click(coursesList);
    }
}
