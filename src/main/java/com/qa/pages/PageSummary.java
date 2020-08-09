package com.qa.pages;

import org.apache.commons.math3.optim.nonlinear.scalar.LineSearch;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageSummary extends PageBase {

    public WebDriver webDriver;

    public PageSummary(WebDriver driver) {
        super(driver);
        this.webDriver = driver;
        PageFactory.initElements(this.webDriver, this);
    }


    @FindBy(how = How.XPATH, using = "//span[contains(@id,'summary_products_quantity')]")
    private WebElement productCount;

    public WebElement productCount() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
        if (verifyPresentOfElement("//span[contains(@id,'summary_products_quantity')]", Locator.XPath)) {
            return this.productCount;
        } else {
            return null;
        }
    }

    public Integer getProductCount() {
        return Integer.valueOf(doGetText(productCount).split(" ")[0].trim());
    }

    @FindBy(how = How.XPATH, using = "//table[contains(@id,'cart_summary')]/descendant::img[1]")
    private WebElement imgProduct;

    public WebElement getImgProduct() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
        if (verifyPresentOfElement("//table[contains(@id,'cart_summary')]/descendant::img[1]", Locator.XPath)) {
            return this.imgProduct;
        } else {
            return null;
        }
    }

    @FindBy(how = How.XPATH, using = "//table[contains(@id,'cart_summary')]/descendant::input[1]")
    private WebElement productQuantity;

    private WebElement productQuantity() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
        if (verifyPresentOfElement("//table[contains(@id,'cart_summary')]/descendant::input[1]", Locator.XPath)) {
            return this.productQuantity;
        } else {
            return null;
        }
    }

    public Integer getProductQuantity() {
        return Integer.valueOf(productQuantity.getAttribute("value"));
    }


    @FindBy(how = How.XPATH, using = "//table[contains(@id,'cart_summary')]/descendant::i[contains(@class,'icon-minus')]")
    private WebElement btnDecreaseProductQuantity;

    public WebElement getBtnDecreaseProductQuantity() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
        if (verifyPresentOfElement("//table[contains(@id,'cart_summary')]/descendant::i[contains(@class,'icon-minus')]", Locator.XPath)) {
            return this.btnDecreaseProductQuantity;
        } else {
            return null;
        }
    }

    public void clkBtnDecreaseProductQuantity() throws TimeoutException, NullPointerException {
        doClick(getBtnDecreaseProductQuantity());
    }

    @FindBy(how = How.XPATH, using = "//table[contains(@id,'cart_summary')]/descendant::i[contains(@class,'icon-plus')]")
    private WebElement btnIncreaseProductQuantity;

    public WebElement getBtnIncreaseProductQuantity() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
        if (verifyPresentOfElement("//table[contains(@id,'cart_summary')]/descendant::i[contains(@class,'icon-plus')]", Locator.XPath)) {
            return this.btnIncreaseProductQuantity;
        } else {
            return null;
        }
    }

    public void clkLnkLblContactUs() throws TimeoutException, NullPointerException {
        doClick(getBtnIncreaseProductQuantity());
    }

    @FindBy(how = How.XPATH, using = "//table[contains(@id,'cart_summary')]/descendant::span[8]")
    private WebElement productTotal;

    public WebElement getProductTotal() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
        if (verifyPresentOfElement("//table[contains(@id,'cart_summary')]/descendant::span[8]", Locator.XPath)) {
            return this.productTotal;
        } else {
            return null;
        }
    }

    @FindBy(how = How.XPATH, using = "//table[contains(@id,'cart_summary')]/descendant::i[contains(@class,'icon-trash')]")
    private WebElement btnRemoveProduct;

    public WebElement getBtnRemoveProduct() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
        if (verifyPresentOfElement("//table[contains(@id,'cart_summary')]/descendant::i[contains(@class,'icon-trash')]", Locator.XPath)) {
            return this.btnRemoveProduct;
        } else {
            return null;
        }
    }

    public void clkBtnRemoveProduct() throws TimeoutException, NullPointerException {
        doClick(getBtnRemoveProduct());
    }

    @FindBy(how = How.XPATH, using = "//td[contains(@id,'total_price_without_tax')]")
    private WebElement totalPrice;

    public WebElement getTotalPrice() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
        if (verifyPresentOfElement("//td[contains(@id,'total_price_without_tax')]", Locator.XPath)) {
            return this.totalPrice;
        } else {
            return null;
        }
    }

    @FindBy(how = How.XPATH, using = "//td[contains(@id,'total_tax')]")
    private WebElement productTotalTax;

    public WebElement getProductTotalTax() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
        if (verifyPresentOfElement("//td[contains(@id,'total_tax')]", Locator.XPath)) {
            return this.productTotalTax;
        } else {
            return null;
        }
    }

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Your shopping cart is empty.')]")
    private WebElement alertLblYourShoppingCartIsEmpty;

    public WebElement getAlertLblYourShoppingCartIsEmpty() throws NoSuchElementException, TimeoutException, NotFoundException, NullPointerException {
        if (verifyPresentOfElement("//p[contains(text(),'Your shopping cart is empty.')]", Locator.XPath)) {
            return this.alertLblYourShoppingCartIsEmpty;
        } else {
            return null;
        }
    }

    public List<WebElement> getPresenceOfAlertLblYourShoppingCartIsEmpty() {
        return this.driver.findElements(By.xpath("//p[contains(text(),'Your shopping cart is empty.')]"));
    }


}
