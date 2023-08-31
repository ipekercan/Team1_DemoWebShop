package SiparisVerme_Deniz;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TC_0604 extends BaseDriver {

    @Test
    public void Test1(){

        driver.get("https://demowebshop.tricentis.com/");

        WebElement girisYapTikla= driver.findElement(By.xpath("//*[text()='Log in']"));
        girisYapTikla.click();
        MyFunc.Bekle(1);

        WebElement eMailDoldur= driver.findElement(By.xpath("//input[@class='email']"));
        eMailDoldur.sendKeys("deniseosdim@gmail.com");
        MyFunc.Bekle(1);

        WebElement sifreDoldur=driver.findElement(By.xpath("//input[@id='Password']"));
        sifreDoldur.sendKeys("123Den456");
        MyFunc.Bekle(1);

        WebElement girisButonu=driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        girisButonu.click();

        //*******//

        WebElement ApparelMenu = driver.findElement(By.linkText("Apparel & Shoes"));
        ApparelMenu.click();
        MyFunc.Bekle(1);

        WebElement shirt = driver.findElement(By.linkText("50's Rockabilly Polka Dot Top JR Plus Size"));
        shirt.click();
        MyFunc.Bekle(1);

        WebElement addToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button-5']"));
        addToCart.click();
        MyFunc.Bekle(1);

        WebElement shoppingCart = driver.findElement(By.xpath("//span[@class='cart-label' and text()='Shopping cart']"));
        shoppingCart.click();
        MyFunc.Bekle(1);

//        WebElement selectCountry1 = driver.findElement(By.xpath("//select[@class='country-input']"));
//        Select ddMenu1 = new Select(selectCountry1);
//        MyFunc.Bekle(1);
//        //ddMenu.selectByVisibleText("United States");
//        ddMenu1.selectByValue("1");  // value direkt yazılır.
//
//        WebElement selectState1 = driver.findElement(By.xpath("//select[@id='StateProvinceId']"));
//        Select ddMenu2 = new Select(selectState1);
//        MyFunc.Bekle(1);
//        //ddMenu.selectByVisibleText("Georgia");
//        ddMenu2.selectByValue("16");  // value yazılır.

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
//        WebElement city = driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']"));
//        city.sendKeys("aaaaa");
//
//        WebElement address1 = driver.findElement(By.xpath("(//input[@id='BillingNewAddress_Address1'])"));
//        address1.sendKeys("bbbbbb");
//
//        WebElement zipCode = driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"));
//        zipCode.sendKeys("353535");
//
//        WebElement phone = driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"));
//        phone.sendKeys("+123456789");

        WebElement continueBtn1 = driver.findElement(By.xpath("(//input[@value='Continue'])[1]"));
        continueBtn1.click();

        WebElement pickUp = driver.findElement(By.xpath("//input[@id='PickUpInStore']"));
        pickUp.click();

        WebElement continueBtn2 = driver.findElement(By.xpath("(//input[@value='Continue'])[2]"));
        continueBtn2.click();

        WebElement po = driver.findElement(By.xpath("//input[@id='paymentmethod_3']"));
        po.click();
        MyFunc.Bekle(1);

        WebElement continueBtn3 = driver.findElement(By.xpath("(//input[@value='Continue'])[4]"));
        continueBtn3.click();
        MyFunc.Bekle(1);

        WebElement paymentMsg = driver.findElement(By.xpath("//label[@for='PurchaseOrderNumber']"));
        Assert.assertTrue(paymentMsg.getText().contains("PO Number"), "ödeme yöntemi yanlış");
        MyFunc.Bekle(1);

        WebElement continueBtn4 = driver.findElement(By.xpath("//input[@value='Continue' and @onclick='PaymentInfo.save()']"));
        continueBtn4.click();
        MyFunc.Bekle(1);

//        driver.switchTo().alert().accept();

        WebElement subTotal = driver.findElement(By.xpath("(//span[@class='product-price'])[1]"));
        double st = Double.parseDouble(subTotal.getText());

        WebElement total = driver.findElement(By.xpath("//span[@class='product-price order-total']/strong"));
        double toplam = Double.parseDouble(total.getText());

        Assert.assertTrue(st==toplam, "Tutarda hata var.");

        WebElement confirmBtn = driver.findElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button']"));
        confirmBtn.click();


        WebElement confirmMsg = driver.findElement(By.xpath("//strong[contains(text(),'successfully')]"));
        Assert.assertTrue(confirmMsg.getText().contains("successfully"), "ödeme yöntemi yanlış");

        WebElement confirmContinueBtn = driver.findElement(By.xpath("//input[@class='button-2 order-completed-continue-button']"));
        confirmContinueBtn.click();

        BekleVeKapat();
    }

}
