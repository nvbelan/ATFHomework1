package ru.appline.sberbank;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class BaseClass {
        public WebDriver driver;
        public WebDriverWait wait;
    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new String[][]{
                {"Петров", "Петр", "Валерьевич","29.08.1995","firstTry@mail.ru","(123) 456-78-87"},
                {"Кожемяка", "Иммануил", "Дунаевич","11.12.2000","TakeMyMoney@mail.ru","(999) 666-99-11"},
                {"Углич", "Милиса", "Батьковна","01.01.2000","Ponchiki@mail.ru","(800) 555-35-35"}
        });
    }
    @Parameterized.Parameter(0)
    public String lastName;

    @Parameterized.Parameter(1)
    public String firstName;

    @Parameterized.Parameter(2)
    public String middleName;

    @Parameterized.Parameter(3)
    public String birthDate;

    @Parameterized.Parameter(4)
    public String eMail;
    @Parameterized.Parameter(5)
    public String telephone;



    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10, 1000);
        String baseUrl = "https://www.sberbank.ru/ru/person";
        driver.get(baseUrl);
    }
   @After
   public void out(){driver.quit();}

    public void fillInputField(WebElement element, String value) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        element.sendKeys(value);
        Assert.assertEquals("Поле было заполнено некорректно", value, element.getAttribute("value"));
    }
    public void fillInputField(WebElement element, String value1, String value2) throws InterruptedException {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",element);
        //Простите, я не смог отловить момент когда он разрешает заполнять телефон.
        Thread.sleep(1000);
        element.click();
        element.sendKeys(value1);
        Assert.assertEquals("Поле было заполнено некорректно", value2, element.getAttribute("value"));
    }

}
