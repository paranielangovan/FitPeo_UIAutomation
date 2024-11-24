package org.example;

import org.openqa.selenium.By;

public class Locators {

    public static By revenueXpath = By.xpath("//div[text()='Revenue Calculator']");
    public static By sliderXpath = By.xpath("//input[@type='range']");
    public static By rangeTextBxId = By.id(":R57alklff9da:");
    public static By textPatientShouldBe = By.xpath("//div[@class='MuiFormControl-root MuiTextField-root css-1s5tg4z']/child::node()/input");
    public static By sliderTrack = By.xpath("//span[@class='MuiSlider-track css-10opxo5']");
    public static By ballPointer = By.xpath("//span[@class='MuiSlider-track css-10opxo5']/following-sibling::span/input[@type='range' and @data-index='0']");
    public static By valueText = By.id(":r0:");
    public static By CPT91091CheckBx = By.xpath("//label[@class='MuiFormControlLabel-root MuiFormControlLabel-labelPlacementEnd inter css-1ml0yeg']/child::span[text()='57']");
    public static By CPT99091Txt = By.xpath("//p[text()='CPT-99091']");
    public static By CPT99453CheckBx = By.xpath("//label[@class='MuiFormControlLabel-root MuiFormControlLabel-labelPlacementEnd inter css-1ml0yeg']/child::span[text()='19.19']");
    public static By CPT99453Txt = By.xpath("//p[text()='CPT-99453']");
    public static By CPT99454CheckBx = By.xpath("//label[@class='MuiFormControlLabel-root MuiFormControlLabel-labelPlacementEnd inter css-1ml0yeg']/child::span[text()='63']");
    public static By CPT99454Txt = By.xpath("//p[text()='CPT-99454']");
    public static By CPT99474CheckBx = By.xpath("//label[@class='MuiFormControlLabel-root MuiFormControlLabel-labelPlacementEnd inter css-1ml0yeg']/child::span[text()='15']");
    public static By CPT99474Txt = By.xpath("//p[text()='CPT-99474']");
    public static By TotalRecurring = By.xpath("//p[text()='Total Recurring Reimbursement for all Patients Per Month:']/p");

}
