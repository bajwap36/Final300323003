package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {

        // setup Webdriver and open a Chrome browser at localhost:8080/animal
        //find the fields we want by id and fill them in
        // animal: dog
        // adjective: funny
        // close the browser after 5 seconds

        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080/animal/");

        WebElement text = webDriver.findElement(By.id("animalText"));
        text.sendKeys("dog");

        WebElement inputad = webDriver.findElement(By.id("adjective"));
        inputad.sendKeys("funny");
        inputad.submit();

        Thread.sleep(5000);
        webDriver.quit();
    }
}