package demo;

import java.text.NumberFormat.Style;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;
import javax.tools.Tool;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.hc.core5.http.nio.entity.NoopEntityConsumer;
import org.openqa.selenium.JavascriptExecutor;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///

public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01()throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        
        // Launch Chrome :
        // Load URL :https://demoqa.com/slider/
        driver.get("https://demoqa.com/slider/");
        Thread.sleep(6000);
        // Locating the slider  Using Locator "Class" Name:"range-slider range-slider--primary" //div[@id='sliderContainer']//input
        WebElement slider = driver.findElementByXPath("//div[@id='sliderContainer']//input");
        // Locate the ToolTip  Using Locator "Class" Name:"range-slider__tooltip__label" 
        WebElement toolTip = driver.findElementByClassName("range-slider__tooltip__label");
        // Initiate the  Action Class and use Method dragAndDrop in while loop :dradAndDropBy();
        Actions action = new Actions(driver);
        Thread.sleep(3000);
        int i =100;
        while(!toolTip.getText().equals("90")){
            action.dragAndDropBy(slider, i, 0).build().perform();
            // Thread.sleep(3000);
            i++;
        } 
        //Print the Value is set to 90 after while loop
        System.out.println("Slider is set to 90 Value");
        
     
    }


}
