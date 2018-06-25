package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PostHazard {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testPostHazard() throws Exception {
    driver.get("http://csc648team07.herokuapp.com/");
    driver.findElement(By.xpath("//a[contains(text(),'Sign\n              in')]")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("selenium");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("selenium");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    new Select(driver.findElement(By.name("category"))).selectByVisibleText("Landslide");
    driver.findElement(By.xpath("//option[@value='3']")).click();
    driver.findElement(By.id("id_title_text")).click();
    driver.findElement(By.id("id_title_text")).clear();
    driver.findElement(By.id("id_title_text")).sendKeys("Landslide Hazard");
    driver.findElement(By.id("id_content_text")).clear();
    driver.findElement(By.id("id_content_text")).sendKeys("This is an automated Description written from Selenium.");
    driver.findElement(By.id("autocomplete")).clear();
    driver.findElement(By.id("autocomplete")).sendKeys("Daly City CA, USA");
    driver.findElement(By.id("id_zipcode")).clear();
    driver.findElement(By.id("id_zipcode")).sendKeys("94015");
    driver.findElement(By.id("id_location")).clear();
    driver.findElement(By.id("id_location")).sendKeys("Daly City");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
