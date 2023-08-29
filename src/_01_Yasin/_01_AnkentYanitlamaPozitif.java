package _01_Yasin;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

// anket yanıtlama pozitif

public class _01_AnkentYanitlamaPozitif extends BaseDriver {
    @Test
    public void Test1()
    {
        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.Bekle(2);

        WebElement good=driver.findElement(By.xpath("//input[@id='pollanswers-2']"));
        good.click();
        MyFunc.Bekle(1);

        WebElement vote=driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
        vote.click();
        MyFunc.Bekle(1);


        WebElement text1=
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Only registered users can vote.']")));

        Assert.assertTrue(text1.getText().contains("Only registered users can vote."));
        MyFunc.Bekle(1);


        WebElement login=driver.findElement(By.xpath("//a[text()='Log in']"));
        login.click();
        MyFunc.Bekle(1);

        WebElement email=driver.findElement(By.id("Email"));
        email.sendKeys("kayay2906@gmail.com");
        MyFunc.Bekle(1);

        WebElement pw=driver.findElement(By.id("Password"));
        pw.sendKeys("izmir35KSK");
        MyFunc.Bekle(1);

        WebElement submit=driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        submit.click();
        MyFunc.Bekle(1);

        WebElement text2=driver.findElement(By.xpath("//div[@id='poll-block-1']/ul"));


        Assert.assertTrue(text2.getText().contains("Excellent"));







        BekleVeKapat();
    }
}
