package ipek;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class logOut_orderHistoryDownload extends BaseDriver {
    @Test
    public void Test1(){ //Sipariş geçmişini bilgisayara indirme
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
    @Test
    public void Test2(){  //LogOut
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
}
