package DemoWebShop;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DemoWebShop_Test_Negatif extends BaseDriver {

    @Test
    public void NegatifKullaniciHesabiOlusturma_US_2(){
        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.Bekle(1);

        WebElement register = driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click();
        MyFunc.Bekle(1);
        WebElement genderClick = driver.findElement(By.xpath("//input[@id='gender-female']"));
        genderClick.click();
        MyFunc.Bekle(1);
        WebElement firstNameWrite = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstNameWrite.sendKeys("Gokcen");
        MyFunc.Bekle(1);
        WebElement lastNameWrite = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastNameWrite.sendKeys("Gokcen");
        WebElement emailWrite = driver.findElement(By.xpath("//input[@id='Email']"));
        emailWrite.sendKeys("gokcena433@gmail.com");
        MyFunc.Bekle(1);
        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("Kaan151517");
        MyFunc.Bekle(1);
        WebElement confirm = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirm.sendKeys("Kaan151517");
        MyFunc.Bekle(1);
        WebElement registerClick = driver.findElement(By.xpath("//input[@id='register-button']"));
        registerClick.click();

        WebElement mesaj = driver.findElement(By.xpath("//li[text()='The specified email already exists']"));
        Assert.assertTrue("mesaj gözükmedi:", mesaj.isDisplayed());

        BekleVeKapat();

    }
    @Test
    public void NegatifOturumAcmaLogin_US_5() {
        //doğru e-mail : deneme.123@gmail.com
        //doğru şifre : deneme123
    }
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
    @Test
    public void NegatifSiparisVerme_US_6(){

    }

    @Test
    public void NegatifKuponHediyeKartiKullanma_US_8(){

    }
}
