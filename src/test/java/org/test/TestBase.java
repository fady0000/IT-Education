package org.test;

import com.google.common.collect.ImmutableMap;
import helpers.ExcelFileManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.CoursesPage;
import org.pages.HomePage;
import org.pages.LoginPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class TestBase {
    String courseName = ExcelFileManager.setDataFromExcelFile(0, 2);
    String emailAddress = ExcelFileManager.setDataFromExcelFile(0, 1);
    String password = ExcelFileManager.setDataFromExcelFile(1, 1);
    String URL = "https://swinji.azurewebsites.net";
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    CoursesPage coursesPage;

    public TestBase() throws IOException {
    }

    @BeforeSuite
    void setEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", "Chrome")
                        .put("Browser.Version", "97.0.4692.71")
                        .build(), System.getProperty("user.dir")
                        + "/allure-results/");

    }

    @BeforeClass
    public void initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(URL);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        coursesPage = new CoursesPage(driver);


    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
