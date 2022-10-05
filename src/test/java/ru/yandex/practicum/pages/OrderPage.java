package ru.yandex.practicum.pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    private WebDriver driver;

    // Интерактивный логотип "Самокат" на форме "Для кого самокат" (для возврата на стартовую страницу)
    private By logoScooter = By.xpath(".//a[contains(@class, 'LogoScooter')]");

    // Форма заказа на этапе "Для кого самокат"
    private By orderForm = By.xpath(".//div[contains(@class, 'Order_Form')]");

    // Поле "Имя" на форме "Для кого самокат"
    private By nameInput = By.xpath(".//input[contains(@placeholder, 'Имя')]");

    // Поле "Фамилия" на форме "Для кого самокат"
    private By surnameInput = By.xpath(".//input[contains(@placeholder, 'Фамилия')]");

    // Поле "Адрес" на форме "Для кого самокат"
    private By addressInput = By.xpath(".//input[contains(@placeholder, 'Адрес')]");

    // Поле "Станция метро" на форме "Для кого самокат"
    private By metroInput = By.xpath(".//input[contains(@placeholder, 'метро')]");

    // Поле "Телефон" на форме "Для кого самокат"
    private By phoneInput = By.xpath(".//input[contains(@placeholder, 'Телефон')]");

    // Кнопка "Далее" на форме "Для кого самокат"
    private By nextButton = By.xpath(".//button[text()='Далее']");

    // Поле "Когда привезти самокат" на форме "Про аренду"
    private By dateInput = By.xpath(".//input[contains(@placeholder, 'Когда')]");

    // Выпадающий список "Срок аренды" на форме "Про аренду"
    private By rentalPeriodDropdownList = By.xpath(".//div[@class='Dropdown-control']");

    // Любое значение из выпадающиго списока "Срок аренды" на форме "Про аренду"
    private By valueOfRentalPeriodDropdownList = By.xpath(".//div[@class='Dropdown-option']");

    // Кнопка "Заказать" под формой "Про аренду"
    private By orderButton = By.xpath("(.//button[text()='Заказать'])[2]");

    // Кнопка "Да" на поп-апе "Хотите оформить заказ?"
    private By yesPopupButton = By.xpath(".//button[text()='Да']");

    // Блок с номером оформленного заказа на поп-апе "Заказ оформлен"
    private By infoAboutCreatedOrder = By.xpath(".//div[text()='Заказ оформлен']/div");

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    // Ожидание появления формы для оформления заказа
    public OrderPage findOrderForm() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(orderForm));
        return this;
    }

    // Переход на стартовую страницу
    public void goToStartPage() {
        driver.findElement(logoScooter).click();
        new StartPage(driver);
    }

    // Заполнение поля "Имя" на форме "Для кого самокат"
    public OrderPage fillInNameInput(String name) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(nameInput));
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    // Заполнение поля "Фамилия" на форме "Для кого самокат"
    public OrderPage fillInSurnameInput(String surname) {
        driver.findElement(surnameInput).sendKeys(surname);
        return this;
    }

    // Заполнение поля "Адрес" на форме "Для кого самокат"
    public OrderPage fillInAddressInput(String address) {
        driver.findElement(addressInput).sendKeys(address);
        return this;
    }

    // Заполнение поля "Метро" на форме "Для кого самокат"
    public OrderPage fillInMetroInput() {
        driver.findElement(metroInput).click();
        driver.findElement(metroInput).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(metroInput).sendKeys(Keys.ENTER);
        return this;
    }

    // Заполнение поля "Телефон" на форме "Для кого самокат"
    public OrderPage fillInPhoneInput(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
        return this;
    }

    // Нажатие кнопки "Далее" на форме "Для кого самокат"
    public OrderPage clickNextButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(nextButton));
        driver.findElement(nextButton).click();
        return this;
    }

    // Заполнение поля "Когда привезти самокат" на форме "Про аренду"
    public OrderPage fillInDateInput(String date) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(dateInput));
        driver.findElement(dateInput).sendKeys(date);
        driver.findElement(dateInput).sendKeys(Keys.ENTER);
        return this;
    }

    // Нажатие на выпадающий список "Срок аренды" на форме "Про аренду"
    public OrderPage clickRentalPeriodDropdownList() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(rentalPeriodDropdownList));
        driver.findElement(rentalPeriodDropdownList).click();
        return this;
    }

    // Нажатие на любое значение из выпадающиго списока "Срок аренды" на форме "Про аренду"
    public OrderPage clickValueOfRentalPeriodDropdownList() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(valueOfRentalPeriodDropdownList));
        driver.findElement(valueOfRentalPeriodDropdownList).click();
        return this;
    }

    // Нажатие кнопки "Заказать" на форме "Про аренду"
    public OrderPage clickOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }

    // Нажатие кнопки "Да" на поп-апе "Хотите оформить заказ?"
    public OrderPage clickYesPopupButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(yesPopupButton));
        driver.findElement(yesPopupButton).click();
        return this;
    }

    //Ожидание появления блока с номером оформленного заказа на поп-апе "Заказ оформлен"
    //Проверка, что информация о созданном заказе отображается.
    public void checkVisibilityInfoAboutCreatedOrder() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(infoAboutCreatedOrder));
        Assert.assertTrue("Информация об оформленном заказе должна быть видна на поп-апе 'Заказ оформлен'",
                driver.findElement(infoAboutCreatedOrder).isDisplayed());
    }
}
