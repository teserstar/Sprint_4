package ru.yandex.practicum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage {
    private final WebDriver driver;

    // Раздел "Вопросы о важном": 1-й блок "Сколько это стоит? И как оплатить?"
    private final By firstAccordionQuestion = By.xpath(".//div[@id='accordion__heading-0']");

    // Раздел "Вопросы о важном": 2-й блок "Хочу сразу несколько самокатов! Так можно?"
    private final By secondAccordionQuestion = By.xpath(".//div[@id='accordion__heading-1']");

    // Раздел "Вопросы о важном": 3-й блок "Как рассчитывается время аренды?"
    private final By thirdAccordionQuestion = By.xpath(".//div[@id='accordion__heading-2']");

    // Раздел "Вопросы о важном": 4-й блок "Можно ли заказать самокат прямо на сегодня?"
    private final By fourthAccordionQuestion = By.xpath(".//div[@id='accordion__heading-3']");

    // Раздел "Вопросы о важном": 5-й блок "Можно ли продлить заказ или вернуть самокат раньше?"
    private final By fifthAccordionQuestion = By.xpath(".//div[@id='accordion__heading-4']");

    // Раздел "Вопросы о важном": 6-й блок "Вы привозите зарядку вместе с самокатом?"
    private final By sixthAccordionQuestion = By.xpath(".//div[@id='accordion__heading-5']");

    // Раздел "Вопросы о важном": 7-й блок "Можно ли отменить заказ?"
    private final By seventhAccordionQuestion = By.xpath(".//div[@id='accordion__heading-6']");

    // Раздел "Вопросы о важном": 8-й блок "Я жизу за МКАДом, привезёте?"
    private final By eighthAccordionQuestion = By.xpath(".//div[@id='accordion__heading-7']");

    // Раздел "Вопросы о важном": ответ 1-го блока
    private final By firstAccordionAnswer = By.xpath(".//div[@id='accordion__panel-0']/p");

    // Раздел "Вопросы о важном": ответ 2-го блока
    private final By secondAccordionAnswer = By.xpath(".//div[@id='accordion__panel-1']/p");

    // Раздел "Вопросы о важном": ответ 3-го блока
    private final By thirdAccordionAnswer = By.xpath(".//div[@id='accordion__panel-2']/p");

    // Раздел "Вопросы о важном": ответ 4-го блока
    private final By fourthAccordionAnswer = By.xpath(".//div[@id='accordion__panel-3']/p");

    // Раздел "Вопросы о важном": ответ 5-го блока
    private final By fifthAccordionAnswer = By.xpath(".//div[@id='accordion__panel-4']/p");

    // Раздел "Вопросы о важном": ответ 6-го блока
    private final By sixthAccordionAnswer = By.xpath(".//div[@id='accordion__panel-5']/p");

    // Раздел "Вопросы о важном": ответ 7-го блока
    private final By seventhAccordionAnswer = By.xpath(".//div[@id='accordion__panel-6']/p");

    // Раздел "Вопросы о важном": ответ 8-го блока
    private final By eighthAccordionAnswer = By.xpath(".//div[@id='accordion__panel-7']/p");

    //Первая кнопка "Заказать" на странице
    private final By firstOrderButton = By.xpath(".//div[contains(@class, 'Header')]/button[text()='Заказать']");

    //Вторая кнопка "Заказать" на странице
    private final By secondOrderButton = By.xpath(".//div[contains(@class, 'Home')]/button[text()='Заказать']");

    //Ожидаемые тексты ответов в разделе "Вопросы о важном"
    private final String firstExpectedAnswer = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private final String secondExpectedAnswer = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private final String thirdExpectedAnswer = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private final String fourthExpectedAnswer = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private final String fifthExpectedAnswer = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private final String sixthExpectedAnswer = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private final String seventhExpectedAnswer = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private final String eighthExpectedAnswer = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    //Массив из элементов-вопросов из раздела "Вопросы о важном" для использования в тестах
    By[] accordionQuestions = {firstAccordionQuestion, secondAccordionQuestion, thirdAccordionQuestion, fourthAccordionQuestion,
            fifthAccordionQuestion, sixthAccordionQuestion, seventhAccordionQuestion, eighthAccordionQuestion};
    //Массив из элементов-ответов из раздела "Вопросы о важном" для использования в тестах
    By[] accordionAnswers = {firstAccordionAnswer, secondAccordionAnswer, thirdAccordionAnswer, fourthAccordionAnswer,
            fifthAccordionAnswer, sixthAccordionAnswer, seventhAccordionAnswer, eighthAccordionAnswer};
    //Массив из ожидаемых текстов ответов из раздела "Вопросы о важном" для использования в тестах
    String[] expectedAnswers = {firstExpectedAnswer, secondExpectedAnswer, thirdExpectedAnswer, fourthExpectedAnswer,
            fifthExpectedAnswer, sixthExpectedAnswer, seventhExpectedAnswer, eighthExpectedAnswer};
    public StartPage(WebDriver driver){
        this.driver = driver;
    }

    //Прокрутка страницы до нижней части, (чтобы веб-элементы были видны драйверу)
    public void scrollToBottomOfPage(){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    //Ожидание появления веб-элемента на странице и нажатие на вопрос-аккордион
    public StartPage clickAccordionQuestion(int indexOfAccordionQuestion) { //By accordionQuestion
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(accordionQuestions[indexOfAccordionQuestion]));
        driver.findElement(accordionQuestions[indexOfAccordionQuestion]).click();
        return this;
    }

    //Ожидание появления веб-элемента на странице, проверка что ответ-аккордион виден на странице и его сравнение с ожидаемым результатом
    public void checkVisibilityAndContentOfAccordionAnswer(int indexOfAccordionAnswer) { //String expectedAnswer, By accordionAnswer
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(accordionAnswers[indexOfAccordionAnswer]));
        Assert.assertTrue("Текст ответа должен быть виден после нажатия на вопрос в разделе 'Вопросы о важном'",
                driver.findElement(accordionAnswers[indexOfAccordionAnswer]).isDisplayed());
        Assert.assertEquals("Тескт ответа в разделе 'Вопросы о важном' должен совпадать с ожидаемым значением",
                expectedAnswers[indexOfAccordionAnswer], driver.findElement(accordionAnswers[indexOfAccordionAnswer]).getText());
    }

    // Нажатие на первую кнопку "Заказать" в верхней части страницы
    public void clickFirstOrderButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(firstOrderButton));
        driver.findElement(firstOrderButton).click();
        new OrderPage(driver);
    }

    // Нажатие на вторую кнопку "Заказать" в средней части страницы (использован JS, чтобы избежать перекрытие элементов)
    public void clickSecondOrderButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(secondOrderButton));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(secondOrderButton));
        new OrderPage(driver);
    }

}
