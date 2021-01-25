package pastebin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinCreatedPage {
    private WebDriver driver;

    @FindBy(xpath = "//h1[text()='helloweb']")
    private WebElement headerName1;

    @FindBy(xpath = "//h1[text()='how to gain dominance among developers']")
    private WebElement headerName2;

    public PastebinCreatedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHeaderName1 () {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='helloweb']")));
        return headerName1.getText();
    }
    public String getHeaderName2 () {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='how to gain dominance among developers']")));
        return headerName2.getText();
    }
}
