package ahmetProje2;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class registerPozitive extends BaseDriver {

    @Test

    public void RegisterPozitive() {
        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.Bekle(1);

        WebElement register= driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click();
        MyFunc.Bekle(1);
        WebElement genderClick= driver.findElement(By.xpath("//input[@id='gender-female']"));
        genderClick.click();
        MyFunc.Bekle(1);
        WebElement firstNameWrite= driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstNameWrite.sendKeys("Gokcen");
        MyFunc.Bekle(1);
        WebElement lastNameWrite= driver.findElement(By.xpath("//input[@id='LastName']"));
        lastNameWrite.sendKeys("Gokcen");
        WebElement emailWrite= driver.findElement(By.xpath("//input[@id='Email']"));
        emailWrite.sendKeys("gokcena433@gmail.com");
        MyFunc.Bekle(1);
        WebElement password= driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("Kaan151517");
        MyFunc.Bekle(1);
        WebElement confirm= driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirm.sendKeys("Kaan151517");
        MyFunc.Bekle(1);
        WebElement registerClick= driver.findElement(By.xpath("//input[@id='register-button']"));
        registerClick.click();

       WebElement emailDisplay= driver.findElement(By.xpath("//a[text()='gokcena433@gmail.com']"));
        Assert.assertTrue("eMail gözükmedi:",emailDisplay.isDisplayed());





        BekleVeKapat();
    }
}
