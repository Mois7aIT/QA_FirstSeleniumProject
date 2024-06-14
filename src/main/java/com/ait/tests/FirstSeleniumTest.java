package com.ait.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver driver;
    //before -setUp
    @BeforeMethod
public void setUp(){
    driver=new ChromeDriver();
    driver.get("https://demowebshop.tricentis.com/"); //открывает браузер

        // driver.navigate().to("https://demowebshop.tricentis.com/"); //открывает браузер но с историей
        // driver.navigate().back();    вернемся назад
        // driver.navigate().forward();   вернемся назад и опять вернемся на сайт demowebschop
        // driver.navigate().refresh();   перезагрузка страницы (бывают ситуации, что это нужно)
    }
    //tests
@Test
    public void openDemowebshop(){
    System.out.println("Demowebshop opened!");
}
    //after-tearDown
              // @AfterMethod(enabled=false)
@AfterMethod  // если в анатации написать (enabled=false) то она не будет работать, причем где напишеш та и не работает
    public void tearDown(){
        //interview question
        driver.quit(); //закрывается окно, браузера, все вкладки какие открыты
        // driver.close();//закрывает только одну вкладку
    }
}
