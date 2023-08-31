package Korhan;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Korhan_TC2_NULL_GiftCard extends BaseDriver {

    @Test

    public void TestK(){

        driver.get("https://demowebshop.tricentis.com/");

        WebElement girisYapTikla= driver.findElement(By.xpath("//*[text()='Log in']"));
        girisYapTikla.click();

        MyFunc.Bekle(2);

        WebElement eMailDoldur= driver.findElement(By.xpath("//input[@class='email']"));
        eMailDoldur.sendKeys("lykan23@gmail.com");

        MyFunc.Bekle(2);

        WebElement sifreDoldur=driver.findElement(By.xpath("//input[@id='Password']"));
        sifreDoldur.sendKeys("2430177");

        MyFunc.Bekle(2);

        WebElement girisButonu=driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        girisButonu.click();
        MyFunc.Bekle(2);

        JavascriptExecutor js=(JavascriptExecutor)driver;
        Actions aksiyonDriver=new Actions(driver);

        WebElement urun=driver.findElement(By.xpath("//ul[@class='top-menu']/li[2]/a"));
        MyFunc.Bekle(1);
        aksiyonDriver.moveToElement(urun).build().perform();
        MyFunc.Bekle(1);

        WebElement desktops=driver.findElement(By.xpath("(//a[@href='/desktops'])[1]"));
        desktops.click();

        MyFunc.Bekle(1);
        WebElement add=driver.findElement(By.xpath("(//input[@class='button-2 product-box-add-to-cart-button'])[1]"));
        add.click();

        MyFunc.Bekle(2);
        js.executeScript("window.scrollTo(0, 700);");

        WebElement add2=driver.findElement(By.xpath("//input[@id='add-to-cart-button-72']"));
        add2.click();

        MyFunc.Bekle(2);
        js.executeScript("window.scrollTo(0,0);");

        MyFunc.Bekle(2);
        WebElement shoppingCart=driver.findElement(By.xpath("//span[text()='Shopping cart']"));
        shoppingCart.click();

        WebElement giftCard=driver.findElement(By.name("applygiftcardcouponcode"));
        js.executeScript("arguments[0].scrollIntoView(true);", giftCard);//GiftCarda kadar kaydır demek
        giftCard.click();

        WebElement hataMsj=driver.findElement(By.xpath("//div[@class='message']"));
        Assert.assertTrue(hataMsj.getText().contains("couldn't be applied to your order"),"Kupon kodu girin");

        WebElement selectCountry1 = driver.findElement(By.xpath("//select[@class='country-input']"));
        Select ddMenu1 = new Select(selectCountry1);
        MyFunc.Bekle(1);
        ddMenu1.selectByValue("1");  // value direkt yazılır.

        WebElement selectState1 = driver.findElement(By.xpath("//select[@id='StateProvinceId']"));
        Select ddMenu2 = new Select(selectState1);
        MyFunc.Bekle(1);
        ddMenu2.selectByValue("16");  // value yazılır.

        WebElement termsOfService = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        termsOfService.click();
        MyFunc.Bekle(1);

        WebElement checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
        checkout.click();
        MyFunc.Bekle(1);

//        WebElement selectCountry2 = driver.findElement(By.cssSelector("[id='BillingNewAddress_CountryId']"));
//        MyFunc.Bekle(1);
//        Select ddMenu3 = new Select(selectCountry2);
//        ddMenu3.selectByValue("1");
//
//        WebElement selectState2 = driver.findElement(By.cssSelector("[id='BillingNewAddress_StateProvinceId']"));
//        MyFunc.Bekle(1);
//        Select ddMenu4 = new Select(selectState2);
//        ddMenu4.selectByValue("16");
//
//        MyFunc.Bekle(1);
//        WebElement city = driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']"));
//        city.sendKeys("aaaaa");
//
//        MyFunc.Bekle(1);
//        WebElement address1 = driver.findElement(By.xpath("(//input[@id='BillingNewAddress_Address1'])"));
//        address1.sendKeys("bbbbbb");
//
//        MyFunc.Bekle(1);
//        WebElement zipCode = driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"));
//        zipCode.sendKeys("353535");
//
//        MyFunc.Bekle(1);
//        WebElement phone = driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"));
//        phone.sendKeys("+123456789");

        MyFunc.Bekle(1);
        WebElement continueBtn1 = driver.findElement(By.xpath("(//input[@value='Continue'])[1]"));
        continueBtn1.click();

        MyFunc.Bekle(1);
        WebElement pickUp = driver.findElement(By.xpath("//input[@id='PickUpInStore']"));
        pickUp.click();


        MyFunc.Bekle(1);
        WebElement continueBtn2 = driver.findElement(By.xpath("(//input[@value='Continue'])[2]"));
        continueBtn2.click();

        WebElement cod = driver.findElement(By.xpath("//input[@id='paymentmethod_0']"));
        cod.click();

        MyFunc.Bekle(1);
        WebElement continueBtn3 = driver.findElement(By.xpath("(//input[@value='Continue'])[4]"));
        continueBtn3.click();

        WebElement paymentMsg = driver.findElement(By.xpath("//p[text()='You will pay by COD']"));
        Assert.assertTrue(paymentMsg.getText().contains("COD"), "ödeme yöntemi yanlış");

        WebElement continueBtn4 = driver.findElement(By.xpath("//input[@value='Continue' and @onclick='PaymentInfo.save()']"));
        continueBtn4.click();

        WebElement subTotal = driver.findElement(By.xpath("(//span[@class='product-price'])[1]"));
        double st = Double.parseDouble(subTotal.getText());

        WebElement additionalFee = driver.findElement(By.xpath("(//span[@class='product-price'])[3]"));
        double af = Double.parseDouble(additionalFee.getText());

        double t = st + af;

        WebElement total = driver.findElement(By.xpath("//span[@class='product-price order-total']/strong"));
        double toplam = Double.parseDouble(total.getText());

        Assert.assertTrue(t==toplam, "Tutarda hata var.");

        MyFunc.Bekle(1);
        WebElement confirm= driver.findElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button']"));
        confirm.click();

        WebElement success=driver.findElement(By.xpath("//strong[contains(text(),'Your order')]"));
        Assert.assertTrue(success.getText().equals("Your order has been successfully processed!"),"Başarısız ödeme");


        BekleVeKapat();
    }

}
