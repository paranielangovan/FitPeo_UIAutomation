package org.example;

import com.google.j2objc.annotations.Property;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class BaseClass {
    int  defaultWaitPeriod = 15;
    public static WebDriver driver;
    public static void BrowserInit(){
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        catch (Exception e){
            System.out.println("Browser initiation failed:: " + e.getMessage());
        }
    }

    public static void launchUrl(){
        try {
            driver.get("https://www.fitpeo.com/");
            driver.manage().timeouts().getPageLoadTimeout().withSeconds(10);
        }
        catch (Exception e){
            System.out.println("Launching URL failed:: " + e.getMessage());
        }
    }

    public static void downDriver(){

        driver.close();
        driver.quit();

    }

    /*** Focus the Element ***/
    public void focusWebElement(By element) throws Exception {
        try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({behavior: \"smooth\", block: \"center\", inline: \"nearest\"});",
                    driver.findElement(element));
            applyWait(3);
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({behavior: \"smooth\", block: \"center\", inline: \"nearest\"});",
                    driver.findElement(element));

        } catch (Exception e) {

            System.out.println("Unable to focus on element");
            throw new RuntimeException(e);
        }
    }
    /*** Wait for visible of element ***/
    public boolean waitTillElementVisible(By by) {
        boolean eleVisible = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(defaultWaitPeriod));
            eleVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(by)) != null;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return eleVisible;
    }
    /*** Wait for Element sleep ***/
    public void applyWait(long timeout) {
        try {
            Thread.sleep(timeout*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement findElement(By ele) throws Exception {
        focusWebElement(ele);
        waitTillElementVisible(ele);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.border='2px solid red'", driver.findElement(ele));
        WebElement element = driver.findElement(ele);
        applyWait(10);
        return  element;
    }

    public void clickOnElement(By ele) throws Exception {

        try {
            focusWebElement(ele);
            applyWait(3);
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].style.border='2px solid red'", driver.findElement(ele));
            driver.findElement(ele).click();
            System.out.println(":: Revenue calculator clicked Successfully ::");
            applyWait(3);
        }
        catch (Exception e){

            System.out.println(":: Unable to click the element ::" + e.getMessage());
            throw new RuntimeException(":: Unable to click the element ::");
        }
    }
    public void enterText(By ele,int value){

        try {
            focusWebElement(ele);
            applyWait(3);
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].style.border='2px solid red'", driver.findElement(ele));
            driver.findElement(ele).click();
            String val1 = driver.findElement(ele).getAttribute("value");
            assert val1 != null;
            for (int i = 0; i <=val1.length()-1 ; i++) {
                driver.findElement(ele).sendKeys(Keys.BACK_SPACE);
            }
            System.out.println(":: Text Box cleared successfully ::");
            applyWait(1);
            String s = String.valueOf(value);
                   Actions actions = new Actions(driver);
                   actions.sendKeys(s).build().perform();
            System.out.println(":: Value entered in textbox is :: =>"+s);
            applyWait(1);
        }
        catch (Exception e){
            System.out.println("Unable to enter the given text in the element::" + e.getMessage());
            throw new RuntimeException("Unable to enter the given text in click the element::");
        }

    }

}
