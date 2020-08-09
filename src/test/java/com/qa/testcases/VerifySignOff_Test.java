package com.qa.testcases;

import com.qa.pages.*;
import com.qa.testbase.TestBase;
import com.qa.testdatautil.ExcelFilesNames;
import com.qa.testdatautil.ProductInfoExcelUtil;
import com.qa.testdatautil.SheetNames;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import javax.mail.search.SearchTerm;
import java.util.Set;

public class VerifySignOff_Test extends TestBase {


    PageHome2 pageHome2;
    PageCreateAccount pageCreateAccount;
    //PageEmail pageEmail;
    PageGoogleSignIn pageGoogleSignIn;
    //FinalPage finalPage;
    PageGmailHome pageGmailHome;
    PageLogin2 pageLogin2;
    PageAccountSetup pageAccountSetup;

    String mailId;
    String password;
    String url;
    String []temp;
    String expectedEmail;


    @BeforeClass
    public void setupBeforeClass(){
        this.pageHome2=new PageHome2(driver);
       // this.url="https://accounts.google.com/AddSession/signinchooser?hl=en-GB&continue=https%3A%2F%2Fmail.google.com%2Fmail&service=mail&flowName=GlifWebSignIn&flowEntry=AddSession";
        this.mailId="caset4641@gmail.com";
        this.password="Password@123";
    }

    @BeforeMethod
    public void setupBeforeMethod(){
    }

    @Test(groups = {"Sanity"},priority = 1,enabled = true)
    public void TC01() throws InterruptedException {


        this.pageHome2.clkBtnTryForFree();
        this.pageCreateAccount=new PageCreateAccount(driver);
        this.pageCreateAccount.passEmailID("caset4641@gmail.com");
        this.pageCreateAccount.clkBtnTryForFree();

        Thread.sleep(500);



        driver.get("https://accounts.google.com/AddSession/signinchooser?hl=en-GB&continue=https%3A%2F%2Fmail.google.com%2Fmail&service=mail&flowName=GlifWebSignIn&flowEntry=AddSession");

        this.pageGoogleSignIn=new PageGoogleSignIn(driver);
        this.pageGoogleSignIn.passUsername(this.mailId);
        this.pageGoogleSignIn.clkBtnNext();
        this.pageGoogleSignIn.passPassword(this.password);
        this.pageGoogleSignIn.clkBtnNext();


        this.pageGmailHome=new PageGmailHome(driver);
        this.pageGmailHome.clkLblInbox();
        this.pageGmailHome.clklblCompleteYourAsanaignUp();
        this.pageGmailHome.clickVerifyEmailAddress();

        Thread.sleep(5000);

        Set<String> Windows=driver.getWindowHandles();

        for(String windowName : Windows){
            driver.switchTo().window(windowName);
            if(driver.getCurrentUrl().equals("https://app.asana.com/0/account_setup")){
                this.pageAccountSetup=new PageAccountSetup(driver);
                break;
            }

        }

        this.temp=this.pageAccountSetup.doGetText(this.pageAccountSetup.getLblEmailID()).split(" ");
        this.expectedEmail=temp[temp.length-1];
        System.out.println("Actual Email id "+this.expectedEmail.substring(0,this.expectedEmail.length()-1)+" Expected mail id " +this.mailId);
        Assert.assertEquals(this.expectedEmail.substring(0,this.expectedEmail.length()-1),this.mailId,"Email id has not matched");

    }




    @Test(enabled = false)
    public void TC02() throws InterruptedException {

        this.pageGoogleSignIn = new PageGoogleSignIn(driver);
        this.pageGoogleSignIn.passUsername("automationt599@gmail.com");
        this.pageGoogleSignIn.clkBtnNext();
        this.pageGoogleSignIn.passPassword("Password@123");
        this.pageGoogleSignIn.clkBtnNext();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@role,'presentation')]")));

        String currentWindow = driver.getWindowHandle();
        System.out.println("CC" + currentWindow);
        driver.findElement(By.xpath("//span[contains(text(),'Gmail')]")).click();
        Thread.sleep(5000);
        Set<String> allwindows = driver.getWindowHandles();

        for (String window : allwindows) {
            if (!window.equals(currentWindow)) {
                System.out.println("EX" + window);
                driver.switchTo().window(window);
                this.pageGmailHome = new PageGmailHome(driver);
            }
        }


        this.pageGmailHome.clkLblInbox();
        this.pageGmailHome.clklblCompleteYourAsanaignUp();
        this.pageGmailHome.clickVerifyEmailAddress();

        Thread.sleep(5000);

        allwindows = driver.getWindowHandles();

        System.out.println(allwindows.size());

        for (String window : allwindows) {
            driver.switchTo().window(window);
            if (driver.getCurrentUrl().equals("https://app.asana.com/-/login")) {
                this.pageLogin2 = new PageLogin2(driver);
                break;
            }

        }
        this.pageLogin2.passUsername("automationt599@gmail.com");
        this.pageLogin2.passPassword("Password@123");
        this.pageLogin2.clkBtnSignIn();

         /*
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@role,'presentation')]")));

        String currentWindow=driver.getWindowHandle();
        driver.findElement(By.xpath("//span[contains(text(),'Gmail')]")).click();
        Thread.sleep(5000);
        Set<String> allwindows=driver.getWindowHandles();

        for( String window : allwindows){
            if(!window.equals(currentWindow)){
                driver.switchTo().window(window);
                this.pageGmailHome=new PageGmailHome(driver);
            }
        }



        /*
        this.pageGoogleSignIn=new PageGoogleSignIn(driver);
        this.pageGoogleSignIn.passUsername("testdekoy@gmail.com");
        this.pageGoogleSignIn.clkBtnNext();
        this.pageGoogleSignIn.passPassword("Password@123");
        this.pageGoogleSignIn.clkBtnNext();
        this.finalPage=new FinalPage(driver);

         */


    }



    @AfterMethod
    public void setupAfterMethod(){

    }

    @AfterClass
    public void setupAfterClass(){

    }




}
