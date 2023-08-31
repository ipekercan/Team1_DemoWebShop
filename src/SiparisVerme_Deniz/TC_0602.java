package SiparisVerme_Deniz;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TC_0602 extends BaseDriver {

    @Test
    public void Test1(){

        driver.get("https://demowebshop.tricentis.com/");

        WebElement girisYapTikla= driver.findElement(By.xpath("//*[text()='Log in']"));
        girisYapTikla.click();

        WebElement eMailDoldur= driver.findElement(By.xpath("//input[@class='email']"));
        eMailDoldur.sendKeys("deniseosdim@gmail.com");

        WebElement sifreDoldur=driver.findElement(By.xpath("//input[@id='Password']"));
        sifreDoldur.sendKeys("123Den456");

        MyFunc.Bekle(1);

        WebElement girisButonu=driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        girisButonu.click();

        //***//

        WebElement urun1 = driver.findElement(By.linkText("$25 Virtual Gift Card"));
        urun1.click();
        MyFunc.Bekle(1);

        WebElement rcpName = driver.findElement(By.xpath("//input[@id='giftcard_2_RecipientName']"));
        rcpName.sendKeys("Jane");

        WebElement rcpEmail = driver.findElement(By.xpath("//input[@id='giftcard_2_RecipientEmail']"));
        rcpEmail.sendKeys("Jane@example.com");

        WebElement message = driver.findElement(By.xpath("//*[@id='giftcard_2_Message']"));
        message.sendKeys("Happy Gifts!!");

        WebElement addToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button-2']"));
        addToCart.click();
        MyFunc.Bekle(1);

        WebElement shoppingCart = driver.findElement(By.xpath("//span[@class='cart-label' and text()='Shopping cart']"));
        shoppingCart.click();
        MyFunc.Bekle(1);

        WebElement termsOfService = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        termsOfService.click();
        MyFunc.Bekle(1);

        WebElement checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
        checkout.click();
        MyFunc.Bekle(1);

        WebElement continueBtn1 = driver.findElement(By.xpath("(//input[@value='Continue'])[1]"));
        continueBtn1.click();

        WebElement moneyOrder = driver.findElement(By.xpath("//input[@id='paymentmethod_1']"));
        moneyOrder.click();

        WebElement continueBtn3 = driver.findElement(By.xpath("(//input[@value='Continue'])[2]"));
        continueBtn3.click();

        WebElement paymentMsg = driver.findElement(By.xpath("(//p[contains( text(), 'Business Check')])[1]"));
        Assert.assertTrue(paymentMsg.getText().contains("Business Check"), "ödeme yöntemi yanlış");

        WebElement continueBtn4 = driver.findElement(By.xpath("//input[@value='Continue' and @onclick='PaymentInfo.save()']"));
        continueBtn4.click();

        WebElement subTotal = driver.findElement(By.xpath("(//span[@class='product-price'])[1]"));
        double st = Double.parseDouble(subTotal.getText());

        WebElement additionalFee = driver.findElement(By.xpath("(//span[@class='product-price'])[2]"));
        double af = Double.parseDouble(additionalFee.getText());

        double t = st + af;

        WebElement total = driver.findElement(By.xpath("//span[@class='product-price order-total']/strong"));
        double toplam = Double.parseDouble(total.getText());

        Assert.assertTrue(t==toplam, "Tutarda hata var.");

        WebElement confirmBtn = driver.findElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button']"));
        confirmBtn.click();

        WebElement confirmMsg = driver.findElement(By.xpath("//strong[contains(text(),'successfully')]"));
        Assert.assertTrue(confirmMsg.getText().contains("successfully"), "ödeme yöntemi yanlış");

        WebElement confirmContinueBtn = driver.findElement(By.xpath("//input[@class='button-2 order-completed-continue-button']"));
        confirmContinueBtn.click();

        BekleVeKapat();
    }

}
