package com.saucedemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CartBadgeTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void testCartBadgeCount() {
        // Add multiple items
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        // Verify badge count is 3
        String badgeCount = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(badgeCount, "3", "Badge count should be 3");

        // Remove one item
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        // Verify badge count is 2
        badgeCount = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(badgeCount, "2", "Badge count should be 2");
    }

    @AfterMethod
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
