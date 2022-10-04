package org.test;

import helpers.ExcelFileManager;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class E2EScenario extends TestBase {
    public E2EScenario() throws IOException {

    }

    @Test(priority = 1)
    @Description("verify that, user can login with valid username and password")
    @Severity(SeverityLevel.BLOCKER)
    public void loginWithValidCredentials() throws IOException {
        loginPage.setEmailAddress(emailAddress);
        loginPage.setPassword(password);
        loginPage.clickLogin();
    }


    @Test(priority = 2)
    @Description("verify that , user can open courses page")
    @Severity(SeverityLevel.CRITICAL)
    public void openCoursesPage() {
        homePage.openNavigationBar();
        homePage.openCoursesList();
    }

    @Test(priority = 3)
    @Description("verify that , user can add basic info for courses")
    @Severity(SeverityLevel.CRITICAL)
    public void addBasicInfoForCourse() throws InterruptedException {
        coursesPage.addCourse();
        coursesPage.setCourseName(courseName);
        coursesPage.setSubject();
        coursesPage.setGradeYear();
        coursesPage.setCourseTeacher();
        coursesPage.createCourse();

        Assert.assertTrue(driver.getPageSource().contains(courseName));
    }

}
