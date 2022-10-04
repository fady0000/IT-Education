package org.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoursesPage extends PageBase {

    private By addCourseButton = By.id("btnListAddCourse");
    private By courseNameInput = By.id("txtCourseName");
    private By subject = By.id("courseSubject");
    private By courseTeacher = By.xpath("//div[@placeholder='Course Teacher']");
    private By createCourseButton = By.id("btnSaveAsDraftCourse");
    private By gradeYear = By.xpath("//select[@id='courseGrade']");
    private By teacherOption = By.xpath("//span[@class='ui-select-choices-row-inner']");

    public CoursesPage(WebDriver driver) {
        super(driver);
    }

    @Step("add course Name : [{courseName}]")
    public void setCourseName(String courseName) {
        setText(courseNameInput, courseName);
    }

    @Step(" click on add course button to open basic info for courses")
    public void addCourse() {
        click(addCourseButton);
    }

    @Step("Add Course subject")
    public void setSubject() {
        selectFromList(subject, 2);
    }

    @Step("add grade year")
    public void setGradeYear() {
        selectFromList(gradeYear, 1);
    }


    @Step("add course Teacher")
    public void setCourseTeacher() {
        click(courseTeacher);
        click(teacherOption);
    }

    @Step("Save Course")
    public void createCourse() throws InterruptedException {
        click(createCourseButton);
        Thread.sleep(3000);
    }
}


