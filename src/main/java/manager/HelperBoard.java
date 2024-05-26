package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperBoard extends HelperBase {
    public HelperBoard(WebDriver driver) {
        super(driver);
    }

    By btnCreateNewBoard = By.xpath("//li[@data-testid='create-board-tile']");
    By inputBoardTitle = By.xpath("//input[@data-testid='create-board-title-input']");
    By btnCreateSubmit = By.xpath("//button[@data-testid='create-board-submit-button']");
    By boardTitle = By.xpath("//h1[@data-testid='board-name-display']");
    By btnDots = By.xpath("//button[@aria-label='Show menu']");
    By btnCloseBoard = By.xpath("//ul[@class='board-menu-navigation']/li[last()]/a");
    By btnCloseConfirm = By.xpath("//input[@value='Close']");
    By btnDelete = By.xpath("//button[@data-testid='close-board-delete-board-button']");
    By btnDeleteConfirm = By.xpath("//button[@data-testid='close-board-delete-board-confirm-button']");
    By popUpMessageBoardDelete = By.xpath("//span[@class='QMKgZFIlTLiEJN']");
    By btnCloseCreateBoardForm = By.xpath("//button[@data-testid='popover-close']");
    By textBoardTitleRequired = By.xpath("//p[text()='Board title is required']");

    public void createNewBoard(String boardTitle) {
        pause(5);
        clickBase(btnCreateNewBoard);
        pause(3);
        typeBase(inputBoardTitle, boardTitle);
        clickBase(btnCreateSubmit);
    }

    public boolean isTextInElementEquals_boardTitle(String text) {
        pause(3);

        return isTextInElementEquals(boardTitle, text);
    }
    public boolean isElementPresent_textBoardTitleRequired(){
        return  isElementPresent(textBoardTitleRequired);
    }

    public boolean isAttributeDisabled() {
        WebElement element = driver.findElement(btnCreateSubmit);
        return !element.isEnabled();
    }

    public void deleteBoard(String boardTitle) {
        pause(3);
        clickBase(btnDots);
        pause(3);
        clickBase(btnCloseBoard);
        clickBase(btnCloseConfirm);
        clickBase(btnDelete);
        clickBase(btnDeleteConfirm);
    }

    public boolean isTextInElementPresent_BoardDeleted() {
        return isTextInElementEquals(popUpMessageBoardDelete, "Board deleted.");
    }

    public void closeCreateBoardForm() {
        clickBase(btnCloseCreateBoardForm);
    }
}

