package ru.yandex.practicum.tests;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.yandex.practicum.pages.OrderPage;
import ru.yandex.practicum.pages.StartPage;

@RunWith(Parameterized.class)
public class CreatingScooterOrderTest {
    private WebDriver driver;

    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String date;

    public CreatingScooterOrderTest(String name, String surname, String address, String phone, String date) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.date = date;
    }

    // Параметры (входные данные) для заполнения формы оформления заказа
    @Parameterized.Parameters
    public static Object[][] getOrderDetails() {
        return new Object[][] {
                {"Иван", "Иванов", "ул Советская, д 1, кв 1", "+79091234567", "15.10.2022"},
                {"Петр", "Петров", "ул Пушкинская, д 2, кв 2", "+79097654321", "10.10.2022"},
        };
    }

    @Test
    public void checkScooterOrderCreation() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);

        /*FirefoxOptions options = new FirefoxOptions();
        options.addArguments();
        driver = new FirefoxDriver(options);*/

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        StartPage startPage = new StartPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        // Переход на страницу оформления заказа через первую кнопку "Заказать"
        startPage.clickFirstOrderButton();
        // Поиск формы оформления заказа и возврат на стартовую страницу
        orderPage.findOrderForm()
                .goToStartPage();
        // Переход на страницу оформления заказа через вторую кнопку "Заказать"
        startPage.scrollToBottomOfPage();
        startPage.clickSecondOrderButton();
        // Заполнение формы оформления заказа, создание заказа, проверка информационного сообщения о созданном заказе
        orderPage.findOrderForm()
                .fillInNameInput(name)
                .fillInSurnameInput(surname)
                .fillInAddressInput(address)
                .fillInMetroInput()
                .fillInPhoneInput(phone)
                .clickNextButton()
                .fillInDateInput(date)
                .clickRentalPeriodDropdownList()
                .clickValueOfRentalPeriodDropdownList()
                .clickOrderButton()
                .clickYesPopupButton()
                .checkVisibilityInfoAboutCreatedOrder();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
