package DemoWebShop;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
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
    public void EmailveSifreBosGirildi_US_5() {

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
    public void SadeceSifreBosGirildi_US_5() {

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
    public void SadeceEmailBosGirildi_US_5() {

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
    public void GecersizSifreveEmail_US_5() {

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
    public void yanlisEmailSekli_US_5() {

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
        org.testng.Assert.assertTrue(paymentInfo.getText().contains("credit card"), "ödeme yöntemi yanlış");

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
        org.testng.Assert.assertTrue(Msg.getText().contains("Wrong"), "Test Failed");

        BekleVeKapat();
    }

    @Test
    public void NegatifKuponKartiKullanma_US_8(){
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
        org.testng.Assert.assertTrue(hataMsj.getText().contains("couldn't be applied to your order"),"Kupon kodu girin");

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
        org.testng.Assert.assertTrue(paymentMsg.getText().contains("COD"), "ödeme yöntemi yanlış");

        WebElement continueBtn4 = driver.findElement(By.xpath("//input[@value='Continue' and @onclick='PaymentInfo.save()']"));
        continueBtn4.click();

        WebElement subTotal = driver.findElement(By.xpath("(//span[@class='product-price'])[1]"));
        double st = Double.parseDouble(subTotal.getText());

        WebElement additionalFee = driver.findElement(By.xpath("(//span[@class='product-price'])[3]"));
        double af = Double.parseDouble(additionalFee.getText());

        double t = st + af;

        WebElement total = driver.findElement(By.xpath("//span[@class='product-price order-total']/strong"));
        double toplam = Double.parseDouble(total.getText());

        org.testng.Assert.assertTrue(t==toplam, "Tutarda hata var.");

        MyFunc.Bekle(1);
        WebElement confirm= driver.findElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button']"));
        confirm.click();

        WebElement success=driver.findElement(By.xpath("//strong[contains(text(),'Your order')]"));
        org.testng.Assert.assertTrue(success.getText().equals("Your order has been successfully processed!"),"Başarısız ödeme");


        BekleVeKapat();
    }
    @Test
    public void NegatifGiftCartKullanma_US_8(){

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
        js.executeScript("window.scrollTo(700,0);");

        MyFunc.Bekle(2);
        WebElement shoppingCart=driver.findElement(By.xpath("//span[text()='Shopping cart']"));
        shoppingCart.click();

        WebElement hediyeKupon=driver.findElement(By.name("applydiscountcouponcode"));
        hediyeKupon.click();

        MyFunc.Bekle(2);
        js.executeScript("window.scrollTo(0, 500);");


        WebElement hataMsj=driver.findElement(By.xpath("//div[@class='message']"));
        org.testng.Assert.assertTrue(hataMsj.getText().contains("couldn't be applied to your order"),"Kupon kodu girin");

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
//
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
        org.testng.Assert.assertTrue(paymentMsg.getText().contains("COD"), "ödeme yöntemi yanlış");

        WebElement continueBtn4 = driver.findElement(By.xpath("//input[@value='Continue' and @onclick='PaymentInfo.save()']"));
        continueBtn4.click();

        WebElement subTotal = driver.findElement(By.xpath("(//span[@class='product-price'])[1]"));
        double st = Double.parseDouble(subTotal.getText());

        WebElement additionalFee = driver.findElement(By.xpath("(//span[@class='product-price'])[3]"));
        double af = Double.parseDouble(additionalFee.getText());

        double t = st + af;

        WebElement total = driver.findElement(By.xpath("//span[@class='product-price order-total']/strong"));
        double toplam = Double.parseDouble(total.getText());

        org.testng.Assert.assertTrue(t==toplam, "Tutarda hata var.");

        MyFunc.Bekle(1);
        WebElement confirm= driver.findElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button']"));
        confirm.click();

        WebElement success=driver.findElement(By.xpath("//strong[contains(text(),'Your order')]"));
        org.testng.Assert.assertTrue(success.getText().equals("Your order has been successfully processed!"),"Başarısız ödeme");


        BekleVeKapat();
    }
}
