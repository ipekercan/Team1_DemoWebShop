package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    public static WebDriver driver;

    //SingletonDriver method deniyor buna

    static //sadece static kalması yeterli
    {

        Logger logger= Logger.getLogger(""); // output yapılan logları al. //chrome ile seleinum uyumsuzlugu warningi vermesin diye warningleri kaldırdık
        logger.setLevel(Level.SEVERE); // sadece ERROR ları göster

        driver = new ChromeDriver();
        driver.manage().window().maximize();//Ekranı maximize yapıyor
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));//20 sn mühlet sayfayı yüklemek için
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//20 sn mühlet elemanı bulmak içinı bulmak için
    }

    public static void BekleVeKapat()
    {
        MyFunc.Bekle(5);
        driver.quit();
    }
}

//  Java hızlı - Web sitesi yavaş
// java elemanı bulmaya çalışıyor, ama web sitesi hala yuklenıyor. site yüklenmeden java bulamadım dıyor bıtırıyor,
// Web elementı bulmaya calıstıgında (FindElement/s)
//  çözüm 1 : biraz süre vereceğiz (20s)

//  Thread.sleep(); -> javayı direkt verilen süre kadar durdurur. kac sanıye verırsen o kadar durdurur programı. Osebeple bu işimize yaramıyor. Bize buldugu zaman cıksın yanı mesela 20 sn verdık 10. sanıyede java buldun cık, 20 sn beklemesın ısterız
//         bıde bu Thread.sleep ıyı kod degıldır mulakatta bundan bahsetme mesela.
//  bunun yerıne driver.manage yapıp bunu MyFunc a atıcam oradan cagırıyorum her seferınde yazmayayım dıye
