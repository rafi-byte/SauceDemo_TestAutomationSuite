package com.saucedemo.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class AddToCartTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        // Login first
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void testAddToCart() {
        // Add first two products
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        // Go to cart
        driver.findElement(By.className("shopping_cart_link")).click();

        // Verify two products are in cart
        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
        Assert.assertEquals(cartItems.size(), 2, "Cart should contain 2 items");
    }

    @Test
    public void testAddRemoveItems() {
        // Add and remove same item twice
        for(int i = 0; i < 2; i++) {
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        }

        // Verify cart is empty (badge should not exist)
        List<WebElement> badge = driver.findElements(By.className("shopping_cart_badge"));
        Assert.assertTrue(badge.isEmpty(), "Cart should be empty");
    }

    @AfterMethod
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
