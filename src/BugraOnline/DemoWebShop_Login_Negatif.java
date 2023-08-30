package BugraOnline;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DemoWebShop_Login_Negatif extends BaseDriver {

    //doğru e-mail : deneme.123@gmail.com
    //doğru şifre : deneme123

    @Test
    public void EmailveSifreBosGirildi() {

        driver.get("https://demowebshop.tricentis.com/");

        WebElement girisYapTikla = driver.findElement(By.xpath("//*[text()='Log in']"));
        girisYapTikla.click();

        MyFunc.Bekle(2);

        WebElement eMailDoldur = driver.findElement(By.xpath("//input[@class='email']"));
        eMailDoldur.sendKeys("");

        MyFunc.Bekle(1);

        WebElement sifreDoldur = driver.findElement(By.xpath("//input[@id='Password']"));
        sifreDoldur.sendKeys("");

        MyFunc.Bekle(1);

        WebElement girisButonu = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        girisButonu.click();

        WebElement hataMesaji = driver.findElement(By.xpath("//div[@class='validation-summary-errors']//*[text()='Login was unsuccessful. Please correct the errors and try again.']"));
        MyFunc.Bekle(1);

        Assert.assertTrue("E-mail ve Şifre Girmediniz",hataMesaji.getText().contains("Login was unsuccessful. Please correct the errors and try again."));



        BekleVeKapat();
    }

    @Test

    public void SadeceSifreBosGirildi() {

        driver.get("https://demowebshop.tricentis.com/");

        WebElement girisYapTikla = driver.findElement(By.xpath("//*[text()='Log in']"));
        girisYapTikla.click();

        MyFunc.Bekle(2);

        WebElement eMailDoldur = driver.findElement(By.xpath("//input[@class='email']"));
        eMailDoldur.sendKeys("deneme.123@gmail.com");

        MyFunc.Bekle(1);

        WebElement sifreDoldur = driver.findElement(By.xpath("//input[@id='Password']"));
        sifreDoldur.sendKeys("");

        MyFunc.Bekle(1);

        WebElement girisButonu = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        girisButonu.click();

        WebElement hataMesaji = driver.findElement(By.xpath("//div[@class='validation-summary-errors']//*[text()='Login was unsuccessful. Please correct the errors and try again.']"));
        MyFunc.Bekle(1);

        Assert.assertTrue("Şifre Girmediniz",hataMesaji.getText().contains("Login was unsuccessful. Please correct the errors and try again."));



        BekleVeKapat();
    }

    @Test

    public void SadeceEmailBosGirildi() {

        driver.get("https://demowebshop.tricentis.com/");

        WebElement girisYapTikla = driver.findElement(By.xpath("//*[text()='Log in']"));
        girisYapTikla.click();

        MyFunc.Bekle(2);

        WebElement eMailDoldur = driver.findElement(By.xpath("//input[@class='email']"));
        eMailDoldur.sendKeys("");

        MyFunc.Bekle(1);

        WebElement sifreDoldur = driver.findElement(By.xpath("//input[@id='Password']"));
        sifreDoldur.sendKeys("deneme123");

        MyFunc.Bekle(1);

        WebElement girisButonu = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        girisButonu.click();

        WebElement hataMesaji = driver.findElement(By.xpath("//div[@class='validation-summary-errors']//*[text()='Login was unsuccessful. Please correct the errors and try again.']"));
        MyFunc.Bekle(1);

        Assert.assertTrue("E-mail Girmediniz",hataMesaji.getText().equals("Login was unsuccessful. Please correct the errors and try again."));



        BekleVeKapat();
    }

    @Test

    public void GecersizSifreveEmail() {

        driver.get("https://demowebshop.tricentis.com/");

        WebElement girisYapTikla = driver.findElement(By.xpath("//*[text()='Log in']"));
        girisYapTikla.click();

        MyFunc.Bekle(2);

        WebElement eMailDoldur = driver.findElement(By.xpath("//input[@class='email']"));
        eMailDoldur.sendKeys("deneme123@gmail.com");

        MyFunc.Bekle(1);

        WebElement sifreDoldur = driver.findElement(By.xpath("//input[@id='Password']"));
        sifreDoldur.sendKeys("deneme");

        MyFunc.Bekle(1);

        WebElement girisButonu = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        girisButonu.click();

        WebElement hataMesaji = driver.findElement(By.xpath("//div[@class='validation-summary-errors']//*[text()='Login was unsuccessful. Please correct the errors and try again.']"));
        MyFunc.Bekle(1);

        Assert.assertTrue("E-mail ve Şifreyi Yanlış Girdiniz",hataMesaji.getText().contains("Login was unsuccessful. Please correct the errors and try again."));



        BekleVeKapat();
    }


    @Test

    public void yanlisEmailSekli() {

        driver.get("https://demowebshop.tricentis.com/");

        WebElement girisYapTikla = driver.findElement(By.xpath("//*[text()='Log in']"));
        girisYapTikla.click();

        MyFunc.Bekle(2);

        WebElement eMailDoldur = driver.findElement(By.xpath("//input[@class='email']"));
        eMailDoldur.sendKeys("deneme.123gmail.com");

        MyFunc.Bekle(1);

        WebElement sifreDoldur = driver.findElement(By.xpath("//input[@id='Password']"));
        sifreDoldur.sendKeys("deneme");

        MyFunc.Bekle(1);

        WebElement girisButonu = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        girisButonu.click();

        WebElement hataMesaji = driver.findElement(By.xpath("//span[@class='field-validation-error']//span"));
        MyFunc.Bekle(1);

        Assert.assertTrue("E-mail i doğru giriniz.",hataMesaji.getText().contains("Please enter a valid email address."));



        BekleVeKapat();
    }
}
