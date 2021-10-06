package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(how = How.CLASS_NAME, using = "user-pic__image")
    private WebElement userMenu;
    @FindBy(xpath = "//*[contains(text(), 'Выйти')]/..")
    private WebElement logoutBtn;
    @FindBy(how = How.CLASS_NAME, using = "personal-info-login__text")
    private WebElement loginSpan;
    @FindBy(xpath = "//*[contains(text(), 'Мои сервисы')]/..")
    private WebElement servicesBtn;
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Почта")
    private WebElement mailBtn;
    @FindBy(xpath = "//*[contains(text(), 'Управление аккаунтом')]/..")
    private WebElement accountBtn;

    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("personal-info-login__text")));

        String userName = loginSpan.getText();
        return userName; }

    public void entryMenu() {
        userMenu.click(); }

    public void userLogout() {
        logoutBtn.click(); }

    public void clickServicesBtn() {
        servicesBtn.click();
    }

    public void clickMailBtn() {
        mailBtn.click();
    }

    public void clickAccountBtn() {
        accountBtn.click();
    }
}
