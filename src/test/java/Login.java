import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Login {
    WebDriver wd;

    @BeforeMethod
    public void preCondition() {
        // open browser
        wd = new ChromeDriver();
        //open site
        wd.get("https://telranedu.web.app");

    }

    @Test
    public void findElementsOnPage(){
      //by tagName
       WebElement element= wd.findElement(By.tagName("div"));
      List<WebElement> divs =wd.findElements(By.tagName("div"));

      //By id
        WebElement el1 = wd.findElement(By.id("root"));
        //By class
        WebElement el2 = wd.findElement(By.className("container"));
        //by name
        //wd.findElement(By.name("name"));
        //by link text a href
        wd.findElement(By.linkText("HOME"));
        wd.findElement(By.linkText("ABOUT"));
        wd.findElement(By.partialLinkText("HO"));


    }


@Test
    public void loginSuccess(){

        // open form
        // wd find item + click
    WebElement itemLogin = wd.findElement(By.linkText("LOGIN"));
    itemLogin.click();



    // fill form
         // find email + click + clear + type
    WebElement email = wd.findElement(By.name("email"));
    email.click();
    email.clear();
    email.sendKeys("v762900819@gmail.com");
         // find password + click + clear + type
    WebElement password = wd.findElement(By.name("password"));
    password.click();
    password.clear();
    password.sendKeys("Vova1234$");

    //submit form
        //find button login + click
    List<WebElement> buttons = wd.findElements(By.tagName("button"));
    WebElement buttonLogin = buttons.get(0);
    buttonLogin.click();


    Assert.assertEquals("","");
    // act result== exp result
    }

    @Test
    public void registrationSuccess(){
        WebElement itemLogin = wd.findElement(By.linkText("LOGIN"));
        itemLogin.click();
        WebElement registrationEmail = wd.findElement(By.name("email"));
        registrationEmail.click();
        registrationEmail.clear();
        registrationEmail.sendKeys("VovanOzz76@gmail.com");
        WebElement registrationPassword = wd.findElement(By.name("password"));
        registrationPassword.click();
        registrationPassword.clear();
        registrationPassword.sendKeys("VovanOzz76$");

        List<WebElement> buttons=wd.findElements(By.tagName("button"));
        WebElement registrationButton = buttons.get(1);
        registrationButton.click();

    }
    @Test
    public void ccsLocalTest(){
        wd.findElement(By.linkText("LOGIN")).click();


//task1
        List<WebElement> div = wd.findElements(By.cssSelector("div"));
        System.out.println("div="+div.size());
        List<WebElement> a = wd.findElements(By.cssSelector("a"));
        System.out.println("a href ="+a.size());
        List<WebElement> input = wd.findElements(By.cssSelector("input"));
        System.out.println("input ="+input.size());
        List<WebElement> button = wd.findElements(By.cssSelector("button"));
        System.out.println("button="+ button.size() );


        wd.findElement(By.cssSelector(".active")); //class==.active
        wd.findElement(By.cssSelector(".container"));
        wd.findElement(By.cssSelector("#root")); //id== #root
//task 2
         wd.findElement(By.cssSelector("[placeholder^='Pass']"));
        wd.findElement(By.cssSelector("[placeholder*='ass']"));
        wd.findElement(By.cssSelector("[placeholder$='ord']"));
        //task3
        wd.findElement(By.cssSelector("div#root.container"));
        wd.findElement(By.cssSelector("a[href='/login']"));
        wd.findElement(By.cssSelector("input[name='email']"));
        wd.findElement(By.cssSelector("button[name='login']"));
//task 3
        wd.findElement(By.cssSelector(""));
    }

    @AfterMethod
    public void postCondition(){
        // close browser
        wd.quit();




    }
}
