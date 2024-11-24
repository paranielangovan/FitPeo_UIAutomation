package org.example;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v128.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.example.BaseClass.driver;

public class UserAction extends Locators{

    static Actions actions = new Actions(driver);
    static BaseClass base = new BaseClass();
    static String actualRecurring ="";
    public static void AdjustSliderByGivengRange(int attrValShould) throws Exception {

        WebElement element = base.findElement(textPatientShouldBe);
        String totlIndDefaultValue = element.getAttribute("value");
        System.out.println(":: INFO  Default Value :: =>"+totlIndDefaultValue +" ::");
        WebElement sliderxpath = base.findElement(sliderXpath);
        WebElement ballPointerEle = base.findElement(ballPointer);
        actions.clickAndHold(ballPointerEle).build().perform();
        System.out.println(":: INFO  BallPointer ClickAndHold ::");
        Thread.sleep(100);
        String attrValOfBallPointerInitially = ballPointerEle.getAttribute("value");
        assert attrValOfBallPointerInitially != null;
        if (attrValShould>200 && !(attrValShould>2000)) {
            if (!attrValOfBallPointerInitially.equalsIgnoreCase(String.valueOf(attrValShould))) {
                for (int j = Integer.parseInt(attrValOfBallPointerInitially); j <= attrValShould - 1; j++) {
                    actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
                    if (Integer.parseInt(attrValOfBallPointerInitially) == (attrValShould-1)) {
                        actions.release().perform();
                        break;
                    }
                }

            }
            valueAfterSlidingInTextBox(valueText,attrValShould);
        }
        else {
            if (!attrValOfBallPointerInitially.equalsIgnoreCase(String.valueOf(attrValShould))) {
                for (int j = Integer.parseInt(attrValOfBallPointerInitially); j > attrValShould; j--) {
                    actions.sendKeys(Keys.ARROW_LEFT).build().perform();
                    if (attrValOfBallPointerInitially.equalsIgnoreCase(String.valueOf(attrValShould))) {
                        actions.release().perform();
                        break;
                    }
                }

            }
            valueAfterSlidingInTextBox(valueText,attrValShould);
        }

        Thread.sleep(10000);

    }

    public static void valueAfterSlidingInTextBox(By ele,int expected) throws Exception {
        String value = base.findElement(ele).getAttribute("value");
        if (Integer.parseInt(value) == expected){
            System.out.println(":: Slider value updated as expected :: =>"+value);
        }
        else {
            System.out.println(":: Slider value not matching as expected :: =>"+value);
        }
    }

    public static void selectCPTCodes(By elechck,By TxtCPT) throws Exception {

        try {

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebElement ObjCPT91091 = driver.findElement(elechck);
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({behavior: \"smooth\", block: \"center\", inline: \"nearest\"});",
                    ObjCPT91091);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            String text = driver.findElement(TxtCPT).getText();
            ObjCPT91091.click();
            System.out.println(":: Check box '"+text.toUpperCase()+"' selected successfully");
            Thread.sleep(5000);
        }catch (Exception e){
            System.out.println("Not able to select the CPTCodes");
            throw new RuntimeException(e);
        }
    }

    public static void totalRecurringNumbers(By txtRecurring) throws Exception {

        try {

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebElement Objtotal = driver.findElement(txtRecurring);
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].style.border='2px solid red'", driver.findElement(txtRecurring));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            actualRecurring = Objtotal.getText();
            System.out.println(":: Total recurring captured here is ::=>" + actualRecurring);

            Thread.sleep(5000);
        }catch (Exception e){
            System.out.println("Not able to calculate total recurring Number:: =>"+e);
            throw new RuntimeException(e);
        }
    }

}
