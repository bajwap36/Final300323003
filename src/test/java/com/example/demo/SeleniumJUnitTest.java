package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.Assert.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SeleniumJUnitTest {
    @LocalServerPort
    private Integer port;
    private static WebDriver webDrv;

    @BeforeAll
    public static void beforeAll() {
//        setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        webDrv = new ChromeDriver();
    }

    @BeforeEach
    public void beforeEach() {
//        open browser at localhost:port/animal
        webDrv.get("http://localhost:" + port + "/animal");
    }

    @Test
    public void maintest () {
        // perform an automated test with
        // animal: dog
        // adjective: funny
        WebElement text = webDrv.findElement(By.id("animalText"));
        text.sendKeys("dog");
        WebElement adj = webDrv.findElement(By.id("adjective"));
        adj.sendKeys("funny");
        adj.submit();

        WebElement result = webDrv.findElement(By.className("trainingMessage"));

        assertEquals("We love funny dogs.", result.getText());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDrv.quit();
    }
}