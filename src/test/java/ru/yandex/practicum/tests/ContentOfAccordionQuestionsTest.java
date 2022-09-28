package ru.yandex.practicum.tests;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.practicum.pages.StartPage;

@RunWith(Parameterized.class)
public class ContentOfAccordionQuestionsTest {
    private WebDriver driver;
    private final int indexOfAccordionQuestion;

    public ContentOfAccordionQuestionsTest(int indexOfAccordionQuestion) {
        this.indexOfAccordionQuestion = indexOfAccordionQuestion;
    }
    // Параметры (индексы) для проверки каждого вопроса-аккордиона
    @Parameterized.Parameters
    public static Object[][] getIndexOfAccordionQuestion() {
        return new Object[][] {
                {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7},
        };
    }

    @Test
    public void checkContentOfAccordionQuestions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        StartPage startPage = new StartPage(driver);
        // Прокрутка стартовой страницы до нижней части, чтобы блок с вопросами был виден
        startPage.scrollToBottomOfPage();
        // Нажатие на вопрос и проверка видимости и содержания ответа
        startPage.clickAccordionQuestion(indexOfAccordionQuestion)
                .checkVisibilityAndContentOfAccordionAnswer(indexOfAccordionQuestion);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
