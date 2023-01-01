import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Index {
    WebDriver wd;

    @BeforeMethod
    public void start(){
     wd=new ChromeDriver();
     wd.get("file:///D:/ind/index.html");
     wd.manage().window().maximize();
    }
    @Test
    public void itemsTest(){

        // find Item1 & click() ===> assert that "div-alert" contains message  "Clicked by Item 1"
        // find Item3 & click() ===> assert that "div-alert" contains message  "Clicked by Item 3"

        wd.findElement(By.cssSelector("a[href='#item1']")).click();
        String item1 = wd.findElement(By.cssSelector("div#alert")).getText();
       //System.out.println(item1);
        Assert.assertEquals(item1,"Clicked by Item 1");
        wd.findElement(By.cssSelector("a[href='#item3']")).click();
       String item3= wd.findElement(By.cssSelector("div#alert")).getText();
        //System.out.println(item3);
        Assert.assertEquals(item3,"Clicked by Item 3");



    }
    @Test
        public void formTest(){
        // fill name & fill surname & click send
        // Assert that "div-alert" contains text with name + surname

        WebElement element = wd.findElement(By.cssSelector("[placeholder='Type your name']"));
        element.click();
        element.sendKeys("Vladimir");
        WebElement element1 = wd.findElement(By.cssSelector("[placeholder='Type your surename']"));
        element1.click();
        element1.sendKeys("Ozer");
        wd.findElement(By.cssSelector(".btn")).click();
        String text = wd.findElement(By.cssSelector("div#alert")).getText();
        //System.out.println(text);
        Assert.assertEquals(text,"Vladimir Ozer");



    }
   @Test
    public void tableTest(){
//проверь правда ли в таблице 4 строки
       List<WebElement> rows = wd.findElements(By.cssSelector("tr"));
       Assert.assertEquals(rows.size(),4);

       //правда ли последняя строка содержит мехико
       WebElement LastRow=wd.findElement(By.cssSelector(" tr:last-child"));
       String text = LastRow.getText();
       System.out.println(text);
       //Poland Chine Mexico contains "mexico"
       Assert.assertTrue(text.contains("Mexico"));
       //правда ли последняя ячейка содержит Mexico
       WebElement LastCell= wd.findElement(By.cssSelector("tr:last-child td:last-child"));
       String str = LastCell.getText();
       boolean res=str.contains("Mexico");
       Assert.assertTrue(res);




   }
   @AfterMethod
    public void end(){
      // wd.quit();
   }
}
