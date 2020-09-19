package ru.appline.sberbank;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;




public class HardTest extends BaseClass {
    @Test
    public void bodyTest() throws InterruptedException {

        //Нажимаем пункт карты
        String xPathCards = "//label [text()='Карты']";
        WebElement buttonCard = driver.findElement(By.xpath(xPathCards));
        wait.until(ExpectedConditions.elementToBeClickable(buttonCard));
        buttonCard.click();

        //Нажимаем дебетовые карты
        String xPathDeb = "//a [@data-cga_click_top_menu='Карты_Дебетовые карты_type_important']";
        WebElement buttonDeb = driver.findElement(By.xpath(xPathDeb));
        wait.until(ExpectedConditions.elementToBeClickable(buttonDeb));
        buttonDeb.click();


        // Проверяем заголовок Дебетовые карты
        String xPathControlText1 = "//h2 [normalize-space() = 'Дебетовые карты']";
        WebElement controlText1 = driver.findElement(By.xpath(xPathControlText1));
        wait.until(ExpectedConditions.visibilityOf(controlText1));
        Assert.assertEquals("Заголовок отсутствует/не соответствует требуемому",
                "Дебетовые карты", controlText1.getText());

        //Нажимаем на кнопку "Молодежная"
        String xPathButtonYouth = "//label [text() = 'Молодежная']";
        WebElement buttonYouth = driver.findElement(By.xpath(xPathButtonYouth));
        wait.until(ExpectedConditions.elementToBeClickable(buttonYouth));
        buttonYouth.click();
        // Нажимаем кнопку заказать
        String xPathButtonOrder = "//a[@href='/ru/person/bank_cards/debit/youth-card#order']";
        WebElement buttonOrder = driver.findElement(By.xpath(xPathButtonOrder));
        buttonOrder.click();

        String xPathBFB = "//button[text()='Закрыть']";
        String xPathTelephone = "//input[@data-name='phone']";
        String xPathLastName = "//input[@name='odc-personal__lastName']";
        String xPathFirstName = "//input[@id='odc-personal__firstName']";
        String xPathMiddleName = "//input[@id='odc-personal__middleName']";
        String xPathBirthDate = "//input[@id='odc-personal__birthDate']";
        String xPathEmail = "//input[@id='odc-personal__email']";
        String xPathFButton = "//button[@class='odcui-button odcui-button_color_black odc-footer__step-button odc-footer__step-button_type_next -visor-no-click']";
        String xPathCardName ="//input[@data-name='cardName']";
        String xPathSerialMess ="//input[@data-name='series']/../div[@class]";
        String xPathNumberMess ="//input[@data-name='number']/../div[@class]";
        String xPathDateOfIssureMess="//input[@data-name='issueDate']/../../../div[@class='odcui-error__text']";
        String xPathTickMess = "//button[@class='odc-personal__agree-button']/../div[@class='odcui-error__text']";
        String phone = "(777) 777-77-77";

        driver.findElement(By.xpath(xPathBFB)).click();

        fillInputField(driver.findElement(By.xpath(xPathLastName)), "Иванов");
        fillInputField(driver.findElement(By.xpath(xPathFirstName)), "Иван");
        fillInputField(driver.findElement(By.xpath(xPathMiddleName)), "Иванович");
        fillInputField(driver.findElement(By.xpath(xPathBirthDate)), "15.03.2000");
        fillInputField(driver.findElement(By.xpath(xPathEmail)), "Example@Mail.ru");
        fillInputField(driver.findElement(By.xpath(xPathTelephone)),  phone,"+7 "+phone);

        driver.findElement(By.xpath(xPathFButton)).click();

        xPathTelephone += "/../div[@class]";
        xPathLastName += "/../div[@class]";
        xPathFirstName += "/../div[@class]";
        xPathMiddleName = "//input[@data-name='middleName']/../../div[@class='odcui-error__text']";
        xPathBirthDate = "//input[@data-name='birthDate']/../../../div[@class='odcui-error__text']";
        xPathEmail += "/../div[@class]";
        xPathCardName+="/../div[@class]";

        // Проверка полей на сообщение "Обязательное поле"

        Assert.assertEquals("Сообщение в поле фамилия должно отсутствовать"
                ,"",driver.findElement(By.xpath(xPathLastName)).getText());

        Assert.assertEquals("Сообщение в поле имя должно отсутствовать",
                "",driver.findElement(By.xpath(xPathFirstName)).getText());

        Assert.assertEquals("Сообщение в поле отчество должно отсутствовать",
                "",driver.findElement(By.xpath(xPathMiddleName)).getText());

        Assert.assertEquals("Сообщение в поле E-mail должно отсутствовать",
                "",driver.findElement(By.xpath(xPathEmail)).getText());

        Assert.assertEquals("Сообщение в поле имя карты должно отсутствовать",
                "",driver.findElement(By.xpath(xPathCardName)).getText());

        Assert.assertEquals("Сообщение в поле дата рождения должно отсутствовать"
                ,"",driver.findElement(By.xpath(xPathBirthDate)).getText());

        Assert.assertEquals("Сообщение в поле Мобильный телефон должно отсутствовать"
                ,"",driver.findElement(By.xpath(xPathTelephone)).getText());

        Assert.assertEquals("Сообщение в поле серия должно присутствовать"
                ,"Обязательное поле",driver.findElement(By.xpath(xPathSerialMess)).getText());

        Assert.assertEquals("Сообщение в поле номер должно присутствовать"
                ,"Обязательное поле",driver.findElement(By.xpath(xPathNumberMess)).getText());

        Assert.assertEquals("Сообщение в поле дата выдачи должно присутствовать"
                ,"Обязательное поле",driver.findElement(By.xpath(xPathDateOfIssureMess)).getText());

        Assert.assertEquals("Сообщение в поле дата выдачи должно присутствовать"
                ,"Обязательное поле",driver.findElement(By.xpath(xPathTickMess)).getText());



    }

}
