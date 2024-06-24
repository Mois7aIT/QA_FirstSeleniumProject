package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class FindElementsTests { //упражнение на поиск элементов
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();

        driver.get("https://ilcarro.web.app");
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
    public void findElementsByTagName(){

        //ищем элемент по тэгу
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());

        //ищем список элементов

        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
        //в консоли теперь выводит 31 элеметов где есть значения (списки товаров, например)
    }

    @Test
    public void findElementByLocator(){
        //стратегия id
        driver.findElement(By.id("city"));

        //стратегия уникальности класса
        WebElement phone = driver.findElement(By.className("telephone"));
        System.out.println(phone.getText());

        //link текст - это текст который находится рядом с линком
        WebElement linkText = driver.findElement(By.linkText("Let the car work"));
        System.out.println(linkText.getText());
        //вывод в консоль Let the car work

        //partial link text - частичное совпадение текста
        WebElement partialLinkText = driver.findElement(By.partialLinkText("work"));
        System.out.println(partialLinkText.getText());
        // вывод в консоль Let the car work
    }

    @Test
    public void findElementByCssSelector(){
        //tag name -> tag
        //driver.findElement(By.tagName("h1")):
        driver.findElement(By.cssSelector("#city"));

        //class -> class css из класа деланм сss
        // driver.findElement(By.className("telephone"));
        driver.findElement(By.cssSelector(".telephone"));

        //[attr="value]  пара
       // driver.findElement(By.cssSelector("[ng-reflect-name='city']"));
        //распечатываю селектор который выше
        WebElement cssSelector = driver.findElement(By.cssSelector("[ng-reflect-name='city']"));
        System.out.println(cssSelector.getAttribute("type"));

        //contains -> *
        WebElement elementContains = driver.findElement(By.cssSelector("[ng-reflect-router-link*='car']"));
        System.out.println(elementContains.getText());

        //ЭТО КАСАЕТСЯ ТОЛЬКО ЗНАЧЕНИЙ, ТЕКСТ ПО css НАЙТИ НЕЛЬЗЯ

        //start -> ^
        //циркунсфлекс (крышичка), она означает, что это значение начинается с этого слова
        driver.findElement(By.cssSelector("[ng-reflect-router-link^='let']"));

        //ent on -> $ если есть начало этого элемента то и есть конец (ent on)
        driver.findElement(By.cssSelector("[ng-reflect-router-link$='work']"));

    }

    @Test
    public void findElementByXpath(){
        // //*[@attr='value']  *ищи везде //ищи домен.имя @если не напишем собачку, эта пара не найдется и селениум будет думать, что это метод(даю знать, что это пара)

        //tag name -> //tag
        //driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//h1"));

        //id -> //*[@id='value']
        //driver.findElement(By.cssSelector("#city"));
        driver.findElement(By.xpath("//*[@id='city']"));

        //class -> //*[@class='value']
        //driver.findElement(By.cssSelector(".telephone"));
        driver.findElement(By.xpath("//*[@class='telephone']"));

   //text = //tag[text()='Text']
        driver.findElement(By.xpath("//h2[text()='Type your data and hit Yalla!']"));
        driver.findElement(By.xpath("//h2[.='Type your data and hit Yalla!']"));

    //contains - когда что-то где-то содержится
    //contains -> //tag[contains(.,'Text')]
        driver.findElement(By.xpath("//h2[contains(.,'Yalla!')]"));

        // берем какую-то пару для него
        //contains value -> //tag[contains(@attr,'partialValue')]
        driver.findElement(By.xpath("//input[contains(@class,'target')]"));


        //start -> //tag[starts-with(@attr,'startOfValue')]
        driver.findElement(By.xpath("//input[starts-with(@class,'ng-pristine')]"));
    }
}
