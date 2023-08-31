package SiparisVerme_Deniz;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TC_0603 extends BaseDriver {

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

        //******//

        WebElement booksMenu = driver.findElement(By.linkText("Books"));
        booksMenu.click();
        MyFunc.Bekle(1);

        WebElement computingBook = driver.findElement(By.linkText("Computing and Internet"));
        computingBook.click();
        MyFunc.Bekle(1);

        WebElement addToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button-13']"));
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
//
//        WebElement continueBtn1 = driver.findElement(By.xpath("(//input[@value='Continue'])[1]"));
//        continueBtn1.click();

        WebElement continueBtn1 = driver.findElement(By.xpath("(//input[@value='Continue'])[1]"));
        continueBtn1.click();

        WebElement pickUp = driver.findElement(By.xpath("//input[@id='PickUpInStore']"));
        pickUp.click();

        WebElement continueBtn2 = driver.findElement(By.xpath("(//input[@value='Continue'])[2]"));
        continueBtn2.click();

        WebElement creditCard = driver.findElement(By.xpath("//input[@id='paymentmethod_2']"));
        creditCard.click();

        WebElement continueBtn3 = driver.findElement(By.xpath("(//input[@value='Continue'])[4]"));
        continueBtn3.click();

        WebElement paymentInfo = driver.findElement(By.xpath("//label[@for='CreditCardTypes']"));
        Assert.assertTrue(paymentInfo.getText().contains("credit card"), "ödeme yöntemi yanlış");

        WebElement cctype = driver.findElement(By.xpath("//select[@id='CreditCardType']"));
        Select ddMenu4 = new Select(cctype);
        ddMenu4.selectByValue("Visa");

        WebElement holderName = driver.findElement(By.xpath("//input[@id='CardholderName']"));
        holderName.sendKeys("AAA BBB");

        WebElement cardHolderName = driver.findElement(By.xpath("//input[@id='CardNumber']"));
        cardHolderName.sendKeys("0001 0002 0003 004");

        WebElement expMonth = driver.findElement(By.xpath("//select[@id='ExpireMonth']"));
        Select ddMenu5 = new Select(expMonth);
        ddMenu5.selectByValue("5");

        WebElement expYear = driver.findElement(By.xpath("//select[@name='ExpireYear']"));
        Select ddMenu6 = new Select(expYear);
        ddMenu6.selectByValue("2025");

        WebElement cardCode = driver.findElement(By.xpath("//input[@id='CardCode']"));
        cardCode.sendKeys("111");

        WebElement continueBtn4 = driver.findElement(By.xpath("//input[@value='Continue' and @onclick='PaymentInfo.save()']"));
        continueBtn4.click();

        WebElement Msg = driver.findElement(By.xpath("//li[text()='Wrong card number']"));
        Assert.assertTrue(Msg.getText().contains("Wrong"), "Test Failed");

        BekleVeKapat();
    }

}
