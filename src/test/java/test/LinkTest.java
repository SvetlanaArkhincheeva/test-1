package test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by s.arkhincheeva on 10.12.2018.
 */
public class LinkTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/s.arkhincheeva/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    @Test
    public void testLink() throws InterruptedException {
        driver.get("http://blog.csssr.ru/qa-engineer/");
        driver.findElement(By.linkText("НАХОДИТЬ НЕСОВЕРШЕНСТВА")).click();
        driver.findElement(By.linkText("Софт для быстрого создания скриншотов")).click();
        Thread.sleep(3000);
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Assert.assertEquals("Url page isn't correct", "http://monosnap.com/", driver.getCurrentUrl());
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
