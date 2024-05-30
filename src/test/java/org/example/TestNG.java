package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class TestNG {
    private WebDriver driver;
    private String baseUrl;


    @Before
    public void setUp() {
        // Получаем последнюю версию драйвера браузера Chrome
        System.setProperty("webDriver.chrome.driver", "D:\\BrowserDriver\\chromedriver-win64\\chromedriver.exe");
        // Создаём новый объект класса ChromeDriver
        driver = new ChromeDriver();
        baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    public void testHerokuAPP() {
        // Открываем  страницу HerokuAPP
        driver.get(baseUrl);
        // Открываем бразуер на полный экран
        driver.manage().window().maximize();
        //Создаем список ссылок
        List<WebElement> webElements = driver.findElements(By.xpath("//a"));
        System.out.println("Количество ссылок на странице" + webElements.size());
        // Переходим по 10 ссылке
        webElements.get(9).click();
    }


        @After
        public void tearDown() {
            // Закрываем браузер
            driver.quit();
        }
}
