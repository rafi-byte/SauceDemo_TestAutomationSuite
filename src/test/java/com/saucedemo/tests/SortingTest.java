package com.saucedemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class SortingTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");
        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void testProductSorting() {
        // Wait for and get sort dropdown
        WebElement sortDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.className("product_sort_container")));
        Select select = new Select(sortDropdown);

        // Test price low to high
        select.selectByValue("lohi");
        List<WebElement> pricesLowHigh = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.className("inventory_item_price")));
        Assert.assertTrue(isPriceSortedLowToHigh(pricesLowHigh),
                "Products should be sorted by price low to high");

        // Test price high to low
        sortDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.className("product_sort_container")));
        select = new Select(sortDropdown);
        select.selectByValue("hilo");
        List<WebElement> pricesHighLow = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.className("inventory_item_price")));
        Assert.assertTrue(isPriceSortedHighToLow(pricesHighLow),
                "Products should be sorted by price high to low");

        // Test name A to Z
        sortDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.className("product_sort_container")));
        select = new Select(sortDropdown);
        select.selectByValue("az");
        List<WebElement> names = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.className("inventory_item_name")));
        Assert.assertTrue(isNameSortedAToZ(names),
                "Products should be sorted by name A to Z");
    }

    private boolean isPriceSortedLowToHigh(List<WebElement> prices) {
        double previous = 0;
        for(WebElement price : prices) {
            double current = Double.parseDouble(price.getText().replace("$", ""));
            if(current < previous) return false;
            previous = current;
        }
        return true;
    }

    private boolean isPriceSortedHighToLow(List<WebElement> prices) {
        double previous = Double.MAX_VALUE;
        for(WebElement price : prices) {
            double current = Double.parseDouble(price.getText().replace("$", ""));
            if(current > previous) return false;
            previous = current;
        }
        return true;
    }

    private boolean isNameSortedAToZ(List<WebElement> names) {
        String previous = "";
        for(WebElement name : names) {
            String current = name.getText();
            if(current.compareTo(previous) < 0) return false;
            previous = current;
        }
        return true;
    }

    @AfterMethod
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
