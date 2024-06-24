package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementsTestsDz { //упражнение на поиск элементов
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com/");
        //maximize хотим что бы браузер развернулся до размера моего окна
        driver.manage().window().maximize();
        //wait что бы все элементы загрузились прежде чем начнутся тестирование
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = true)
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void FindElementByTagName(){

        //ищем элемент по тэгу
        WebElement element = driver.findElement(By.tagName("li"));
        System.out.println(element.getText());

        //ищем элемент по тэгу
        WebElement element0 = driver.findElement(By.tagName("form"));
        System.out.println(element0.getText());

        WebElement element1 = driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());

        //ищем список элементов

        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());


        List<WebElement> elements1 = driver.findElements(By.tagName("ul"));
        System.out.println(elements1.size());
        //в консоли выводит кол-во элеметов где есть значения
    }

    @Test
    public void findElementByLocator() {
        //стратегия id
        driver.findElement(By.id("bar-notification"));

        driver.findElement(By.id("dialog-notifications-error"));

        driver.findElement(By.id("dialog-notifications-success"));


        //стратегия уникальности класса
        WebElement login = driver.findElement(By.className("ico-login"));
        System.out.println(login.getText());

        WebElement register = driver.findElement(By.className("ico-register"));
        System.out.println(register.getText());

        //link текст - это текст который находится рядом с линком
        //WebElement linkText = driver.findElement(By.linkText("Let the car work"));
        //System.out.println(linkText.getText());
        //вывод в консоль Let the car work

        try {
            // ищу ссылку с текстом "Shopping cart"
            WebElement linkText = driver.findElement(By.linkText("Shopping cart"));

            // Вывод текст ссылки в консоль
            System.out.println(linkText.getText());
            // Попроб. найти элемент с помощью XPath
            WebElement partialLinkText = driver.findElement(By.xpath("//a[contains(text(), 'cart')]"));
            System.out.println(partialLinkText.getText());
        } catch (Exception e) {
            System.out.println("Element not found: " + e.getMessage());
        } finally {
            // Закрываю браузер
            driver.quit();
        }


        //partial link text - частичное совпадение текста
        //WebElement partialLinkText = driver.findElement(By.partialLinkText("cart"));
        //System.out.println(partialLinkText.getText());
        // вывод в консоль Let the car work

}

    @Test
    public void findElementByCssSelector(){
        //tag name -> tag
        //driver.findElement(By.tagName("h1")):
        driver.findElement(By.cssSelector("#bar-notification"));

        driver.findElement(By.cssSelector("#dialog-notifications-error"));


        driver.findElement(By.cssSelector("#dialog-notifications-success"));
        //class -> class css из класа деланм сss
        // driver.findElement(By.className("telephone"));
        driver.findElement(By.cssSelector(".ico-login"));

        driver.findElement(By.cssSelector(".ico-register"));

        //[attr="value]  пара
        // driver.findElement(By.cssSelector("[ng-reflect-name='city']"));
        //распечатываю селектор который выше
        //WebElement cssSelector = driver.findElement(By.cssSelector("//a[contains(text(), 'cart')]"));
        //System.out.println(cssSelector.getAttribute("type"));


    }
}
