package DemoWebShop;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
public class DemoWebShop_Test_Pozitif extends BaseDriver {

    @Test
    public void KullaniciHesabiOlusturma_US_1(){
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
        emailWrite.sendKeys("gokcenab433@gmail.com");
        MyFunc.Bekle(1);
        WebElement password= driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("Kaan151517");
        MyFunc.Bekle(1);
        WebElement confirm= driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirm.sendKeys("Kaan151517");
        MyFunc.Bekle(1);
        WebElement registerClick= driver.findElement(By.xpath("//input[@id='register-button']"));
        registerClick.click();

        WebElement emailDisplay= driver.findElement(By.xpath("//a[text()='gokcenab433@gmail.com']"));
        Assert.assertTrue("eMail gözükmedi:",emailDisplay.isDisplayed());

        BekleVeKapat();
    }
    @Test
    public void LogOut_US_3(){

        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.Bekle(2);

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

        WebElement logout=driver.findElement(By.xpath("//a[text()='Log out']"));
        logout.click();
        MyFunc.Bekle(1);

        Assert.assertTrue("Anasayfada değil! ", driver.getCurrentUrl().contains("https://demowebshop.tricentis.com/") );

        BekleVeKapat();


    }

    @Test
    public void OturumAcmaLogin_US_4(){

        driver.get("https://demowebshop.tricentis.com/");

        WebElement girisYapTikla= driver.findElement(By.xpath("//*[text()='Log in']"));
        girisYapTikla.click();

        MyFunc.Bekle(2);

        WebElement eMailDoldur= driver.findElement(By.xpath("//input[@class='email']"));
        eMailDoldur.sendKeys("deneme.123@gmail.com");

        MyFunc.Bekle(2);

        WebElement sifreDoldur=driver.findElement(By.xpath("//input[@id='Password']"));
        sifreDoldur.sendKeys("deneme123");

        MyFunc.Bekle(2);

        WebElement girisButonu=driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        girisButonu.click();


        BekleVeKapat();
    }
    @Test
    public void SiparisVerme_US_6_1(){

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

        WebElement urun1 = driver.findElement(By.xpath("(//div[@data-productid='31']//*[@href='/141-inch-laptop'])[2]"));
        urun1.click();
        MyFunc.Bekle(1);

        WebElement addToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button-31']"));
        addToCart.click();
        MyFunc.Bekle(1);

        WebElement shoppingCart = driver.findElement(By.xpath("//span[@class='cart-label' and text()='Shopping cart']"));
        shoppingCart.click();
        MyFunc.Bekle(1);

//        WebElement selectCountry = driver.findElement(By.xpath("//select[@class='country-input']//*[text()='Turkey']"));
//        selectCountry.click();
//        MyFunc.Bekle(1);

        WebElement selectCountry1 = driver.findElement(By.xpath("//select[@class='country-input']"));
        Select ddMenu1 = new Select(selectCountry1);
        MyFunc.Bekle(1);
        //ddMenu.selectByVisibleText("United States");
        ddMenu1.selectByValue("1");  // value direkt yazılır.

        WebElement selectState1 = driver.findElement(By.xpath("//select[@id='StateProvinceId']"));
        Select ddMenu2 = new Select(selectState1);
        MyFunc.Bekle(1);
        //ddMenu.selectByVisibleText("Georgia");
        ddMenu2.selectByValue("16");  // value yazılır.

        WebElement termsOfService = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        termsOfService.click();
        MyFunc.Bekle(1);

        WebElement checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
        checkout.click();
        MyFunc.Bekle(1);

        WebElement selectCountry2 = driver.findElement(By.cssSelector("[id='BillingNewAddress_CountryId']"));
        MyFunc.Bekle(1);
        Select ddMenu3 = new Select(selectCountry2);
        ddMenu3.selectByValue("1");

        WebElement selectState2 = driver.findElement(By.cssSelector("[id='BillingNewAddress_StateProvinceId']"));
        MyFunc.Bekle(1);
        Select ddMenu4 = new Select(selectState2);
        ddMenu4.selectByValue("16");

        WebElement city = driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']"));
        city.sendKeys("aaaaa");

        WebElement address1 = driver.findElement(By.xpath("(//input[@id='BillingNewAddress_Address1'])"));
        address1.sendKeys("bbbbbb");

        WebElement zipCode = driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"));
        zipCode.sendKeys("353535");

        WebElement phone = driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"));
        phone.sendKeys("+123456789");

        WebElement continueBtn1 = driver.findElement(By.xpath("(//input[@value='Continue'])[1]"));
        continueBtn1.click();

        WebElement pickUp = driver.findElement(By.xpath("//input[@id='PickUpInStore']"));
        pickUp.click();

        WebElement continueBtn2 = driver.findElement(By.xpath("(//input[@value='Continue'])[2]"));
        continueBtn2.click();

        WebElement cod = driver.findElement(By.xpath("//input[@id='paymentmethod_0']"));
        cod.click();

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

        WebElement confirmBtn = driver.findElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button']"));
        confirmBtn.click();

        WebElement confirmMsg = driver.findElement(By.xpath("//strong[contains(text(),'successfully')]"));
        org.testng.Assert.assertTrue(confirmMsg.getText().contains("successfully"), "ödeme yöntemi yanlış");

        WebElement confirmContinueBtn = driver.findElement(By.xpath("//input[@class='button-2 order-completed-continue-button']"));
        confirmContinueBtn.click();

        BekleVeKapat();
    }
    @Test
    public void SiparisVerme_US_6_2(){

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
        MyFunc.Bekle(2);
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
        org.testng.Assert.assertTrue(paymentMsg.getText().contains("Business Check"), "ödeme yöntemi yanlış");

        WebElement continueBtn4 = driver.findElement(By.xpath("//input[@value='Continue' and @onclick='PaymentInfo.save()']"));
        continueBtn4.click();

        WebElement subTotal = driver.findElement(By.xpath("(//span[@class='product-price'])[1]"));
        double st = Double.parseDouble(subTotal.getText());

        WebElement additionalFee = driver.findElement(By.xpath("(//span[@class='product-price'])[2]"));
        double af = Double.parseDouble(additionalFee.getText());

        double t = st + af;

        WebElement total = driver.findElement(By.xpath("//span[@class='product-price order-total']/strong"));
        double toplam = Double.parseDouble(total.getText());

        org.testng.Assert.assertTrue(t==toplam, "Tutarda hata var.");

        WebElement confirmBtn = driver.findElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button']"));
        confirmBtn.click();

        WebElement confirmMsg = driver.findElement(By.xpath("//strong[contains(text(),'successfully')]"));
        org.testng.Assert.assertTrue(confirmMsg.getText().contains("successfully"), "ödeme yöntemi yanlış");

        WebElement confirmContinueBtn = driver.findElement(By.xpath("//input[@class='button-2 order-completed-continue-button']"));
        confirmContinueBtn.click();

        BekleVeKapat();
    }
    @Test
    public void SiparisVerme_US_6_4(){
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
        org.testng.Assert.assertTrue(paymentMsg.getText().contains("PO Number"), "ödeme yöntemi yanlış");
        MyFunc.Bekle(1);

        WebElement continueBtn4 = driver.findElement(By.xpath("//input[@value='Continue' and @onclick='PaymentInfo.save()']"));
        continueBtn4.click();
        MyFunc.Bekle(1);

//        driver.switchTo().alert().accept();

        WebElement subTotal = driver.findElement(By.xpath("(//span[@class='product-price'])[1]"));
        double st = Double.parseDouble(subTotal.getText());

        WebElement total = driver.findElement(By.xpath("//span[@class='product-price order-total']/strong"));
        double toplam = Double.parseDouble(total.getText());

        org.testng.Assert.assertTrue(st==toplam, "Tutarda hata var.");

        WebElement confirmBtn = driver.findElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button']"));
        confirmBtn.click();


        WebElement confirmMsg = driver.findElement(By.xpath("//strong[contains(text(),'successfully')]"));
        org.testng.Assert.assertTrue(confirmMsg.getText().contains("successfully"), "ödeme yöntemi yanlış");

        WebElement confirmContinueBtn = driver.findElement(By.xpath("//input[@class='button-2 order-completed-continue-button']"));
        confirmContinueBtn.click();

        BekleVeKapat();
    }

    @Test
    public void AnketYanitlama_US_7(){
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


    @Test
    public void SiparisGecmisiniIndirme_US_9(){
        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.Bekle(1);
        JavascriptExecutor js=(JavascriptExecutor)driver;
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

        Actions aksiyonDriver=new Actions(driver);

        WebElement urun=driver.findElement(By.xpath("//ul[@class='top-menu']/li[2]/a"));
        MyFunc.Bekle(1);
        aksiyonDriver.moveToElement(urun).build().perform();
        MyFunc.Bekle(1);

        WebElement desktops=driver.findElement(By.xpath("(//a[@href='/desktops'])[1]"));
        desktops.click();

        MyFunc.Bekle(1);
        WebElement add=driver.findElement(By.xpath("(//div[@class='buttons']/input)[2]"));
        add.click();

        MyFunc.Bekle(1);
        WebElement add2=driver.findElement(By.xpath("//input[@id='add-to-cart-button-72']"));
        js.executeScript("window.scrollTo(0, 500);");
        add2.click();

        MyFunc.Bekle(2);
        WebElement shoppingCart=driver.findElement(By.xpath("//span[text()='Shopping cart']"));
        shoppingCart.click();

        MyFunc.Bekle(1);
        WebElement onay=driver.findElement(By.xpath("//input[@name='removefromcart']"));
        onay.click();

        MyFunc.Bekle(1);
        WebElement onay2=driver.findElement(By.xpath("//input[@name='termsofservice']"));
        onay2.click();

        MyFunc.Bekle(1);
        WebElement onay3=driver.findElement(By.xpath("//button[@name='checkout']"));
        onay3.click();

        MyFunc.Bekle(1);
        WebElement confirm=driver.findElement(By.xpath("//div[@id='billing-buttons-container']/input"));
        confirm.click();

        MyFunc.Bekle(1);
        WebElement confirm2=driver.findElement(By.xpath("(//input[@class='button-1 new-address-next-step-button'])[2]"));
        confirm2.click();

        MyFunc.Bekle(1);
        WebElement confirm3=driver.findElement(By.xpath("//input[@class='button-1 shipping-method-next-step-button']"));
        confirm3.click();

        MyFunc.Bekle(1);
        WebElement confirm4=driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button']"));
        confirm4.click();

        MyFunc.Bekle(1);
        WebElement confirm5=driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button']"));
        confirm5.click();

        MyFunc.Bekle(1);
        WebElement confirm6=driver.findElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button']"));
        confirm6.click();

        MyFunc.Bekle(1);
        WebElement hesabim=driver.findElement(By.xpath("//a[text()='kayay2906@gmail.com']"));
        hesabim.click();
        MyFunc.Bekle(1);

        WebElement orders=driver.findElement(By.xpath("//ul[@class='list']/li[3]/a"));
        orders.click();
        MyFunc.Bekle(1);

        WebElement msg=
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Order Number: 1501570']")));

        Assert.assertTrue("Aranılan mesaj bulunamadı", msg.getText().contains("Order Number"));

        WebElement details=driver.findElement(By.xpath("//input[@class='button-2 order-details-button']"));
        details.click();
        MyFunc.Bekle(1);

        WebElement indir=driver.findElement(By.xpath("//a[text()='PDF Invoice']"));
        indir.click();
        MyFunc.Bekle(1);

        BekleVeKapat();


    }



}
