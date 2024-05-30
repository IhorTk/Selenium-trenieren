package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class GoogleSearchTest {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() {
        // Получаем последнюю версию драйвера браузера Chrome
        System.setProperty("webDriver.chrome.driver", "D:\\BrowserDriver\\chromedriver-win64\\chromedriver.exe");
        // Создаём новый объект класса ChromeDriver
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
    }

    @Test
    public void testGoogleSearch() {
        // Открываем главную страницу Google
        driver.get(baseUrl);
        // Открываем бразуер на полный экран
        driver.manage().window().maximize();

        // Находим элемент для передачи значения для поиска (поисковая строка)
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("euroTech Study GmbH");
        searchInput.sendKeys(Keys.RETURN);

        // Ждём пока результаты появятся
        // Этот способ подходит только для демонстрации
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Находим результат соответствующий нашему запросу
        String sitePeek = driver.findElement(By.xpath("//div[.='https://www.eurotechstudy.com']/../../..//h3")).getText();

        // Выведем результат в консоль
        System.out.println(sitePeek);
        // Проверяем что страница с результатами поиска содержит искомую информацию
        assertEquals("euroTech Study: IT Courses", sitePeek);
    }

    @After
    public void tearDown() {
        // Закрываем браузер
        driver.quit();
    }
}
