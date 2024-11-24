package org.example;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.example.Locators.*;
import static org.example.UserAction.*;

public class TestRunnner extends BaseClass{

   @BeforeTest
    public void BrowserSetup(){
       /*
       This Browser Init will launch the browser and maximize
        */
       BrowserInit();

       /*
       This will hit URL in browser
        */
       launchUrl();
   }

   @Test
    public void fitpeo() throws Exception {
        int alter = 560;
        String expectedRecurring = "$110700";
        clickOnElement(Locators.revenueXpath);
        UserAction.AdjustSliderByGivengRange(820);
        enterText(Locators.valueText,alter);
        valueAfterSlidingInTextBox(Locators.sliderXpath,alter);
        selectCPTCodes(CPT91091CheckBx,CPT99091Txt);
        selectCPTCodes(CPT99453CheckBx,CPT99453Txt);
        selectCPTCodes(CPT99454CheckBx,CPT99454Txt);
        selectCPTCodes(CPT99474CheckBx,CPT99474Txt);
        totalRecurringNumbers(TotalRecurring);
        Assert.assertEquals(actualRecurring,expectedRecurring);
   }

   @AfterTest
    public void closeBrowser(){
       downDriver();
   }
}
