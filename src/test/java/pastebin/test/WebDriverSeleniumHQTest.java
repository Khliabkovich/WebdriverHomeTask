package pastebin.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pastebin.page.PastebinCreatedPage;
import pastebin.page.PastebinHomePage;

public class WebDriverSeleniumHQTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test (description = "I Can Win")
    public void newPasteCreation() {

        PastebinHomePage page = new PastebinHomePage(driver)
                .openPage()
                .typeCode ("Hello from WebDriver")
                .setExpiration10Min()
                .typeName("helloweb")
                .createNewPaste();

        PastebinCreatedPage newPage = new PastebinCreatedPage(driver);

        Assert.assertEquals(newPage.getHeaderName1(), "helloweb");

    }
    @AfterMethod (alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver=null;
    }

    @Test (description = "Bring It On")
    public void newPaste1Creation() {

        PastebinHomePage page = new PastebinHomePage(driver)
                .openPage()
                .typeCode ("git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force")
                .setHighlightingBash()
                .setExpiration10Min()
                .typeName("how to gain dominance among developers")
                .createNewPaste();

        PastebinCreatedPage newPage = new PastebinCreatedPage(driver);

        Assert.assertEquals(newPage.getHeaderName2(), "how to gain dominance among developers");

    }
}
