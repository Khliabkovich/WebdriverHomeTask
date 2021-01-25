package pastebin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class PastebinHomePage {
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private WebDriver driver;

    @FindBy (id = "postform-text")
    private WebElement textArea;

    @FindBy (id = "select2-postform-expiration-container")
    private WebElement selectExpiration;

    @FindBy (id = "postform-name")
    private WebElement nameInput;

    @FindBy (xpath = "//button[text()='Create New Paste']")
    private WebElement submitBtn;

    @FindBy (id = "select2-postform-format-container")
    private WebElement selectHighlighting;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-text")));
        return this;
    }

    public PastebinHomePage typeCode (String term) {
        textArea.sendKeys(term);
        return this;
    }

    public PastebinHomePage setExpiration10Min () {
        selectExpiration.click();
        WebElement option10Min = driver.findElement(By.id("select2-postform-expiration-container"));
        option10Min.click();
        return this;
    }

    public PastebinHomePage typeName (String term) {
        nameInput.sendKeys(term);
        return this;
    }

    public PastebinHomePage createNewPaste() {
        submitBtn.click();
        return this;
    }

    public PastebinHomePage setHighlightingBash() {
        selectHighlighting.click();
        WebElement optionBash = driver.findElement(By.id("select2-postform-format-container"));
        optionBash.click();
        return this;
    }
}
