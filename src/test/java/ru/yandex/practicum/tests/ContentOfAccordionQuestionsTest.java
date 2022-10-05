package ru.yandex.practicum.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.practicum.pages.StartPage;

public class ContentOfAccordionQuestionsTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);
    }

    @Test
    public void checkContentOfFirstAccordionQuestions() {
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        StartPage startPage = new StartPage(driver);
        // Прокрутка стартовой страницы до нижней части, чтобы блок с вопросами был виден
        startPage.scrollToBottomOfPage();
        // Нажатие на вопрос и проверка видимости и содержания ответа
        startPage.clickAccordionQuestion(0)
                .checkVisibilityAndContentOfAccordionAnswer(0);
    }

    @Test
    public void checkContentOfSecondAccordionQuestions() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        StartPage startPage = new StartPage(driver);
        startPage.scrollToBottomOfPage();
        startPage.clickAccordionQuestion(1)
                .checkVisibilityAndContentOfAccordionAnswer(1);
    }

    @Test
    public void checkContentOfThirdAccordionQuestions() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        StartPage startPage = new StartPage(driver);
        startPage.scrollToBottomOfPage();
        startPage.clickAccordionQuestion(2)
                .checkVisibilityAndContentOfAccordionAnswer(2);
    }

    @Test
    public void checkContentOfFourthAccordionQuestions() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        StartPage startPage = new StartPage(driver);
        startPage.scrollToBottomOfPage();
        startPage.clickAccordionQuestion(3)
                .checkVisibilityAndContentOfAccordionAnswer(3);
    }

    @Test
    public void checkContentOfFifthAccordionQuestions() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        StartPage startPage = new StartPage(driver);
        startPage.scrollToBottomOfPage();
        startPage.clickAccordionQuestion(4)
                .checkVisibilityAndContentOfAccordionAnswer(4);
    }

    @Test
    public void checkContentOfSixthAccordionQuestions() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        StartPage startPage = new StartPage(driver);
        startPage.scrollToBottomOfPage();
        startPage.clickAccordionQuestion(5)
                .checkVisibilityAndContentOfAccordionAnswer(5);
    }

    @Test
    public void checkContentOfSeventhAccordionQuestions() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        StartPage startPage = new StartPage(driver);
        startPage.scrollToBottomOfPage();
        startPage.clickAccordionQuestion(6)
                .checkVisibilityAndContentOfAccordionAnswer(6);
    }

    @Test
    public void checkContentOfEighthAccordionQuestions() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        StartPage startPage = new StartPage(driver);
        startPage.scrollToBottomOfPage();
        startPage.clickAccordionQuestion(7)
                .checkVisibilityAndContentOfAccordionAnswer(7);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
