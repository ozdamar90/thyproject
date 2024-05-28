package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.TestConfig;

import java.text.MessageFormat;

public class SignUpControl extends WebControl{

    public static final String INPUT = "//label[contains(text(), \"{0}\")]//ancestor::div[1]//input";
    public static final String INPUT2 = "//input[@id=\"{0}\"]";
    public static final String INPUT1 = "//label[contains(text(), \"{0}\")]//ancestor::div[1]//input";


    public SignUpControl(By locator) {
        super(locator);
    }

    public static SignUpControl fromLabel(String label) {
        return fromLabel(label, 1);
    }
    public static SignUpControl fromLabel(String label, int no) {

        String xpath = "((" +
                MessageFormat.format(INPUT, label) +
                ") | (" +
                MessageFormat.format(INPUT2, label) +
                "))[" + no +"]";


        By SignUpControlLocator = By.xpath(xpath);
        SignUpControl control = new SignUpControl(SignUpControlLocator);
        control.label = label;
        return control;
    }


    public static SignUpControl fromLocator(By locator) {
        SignUpControl control = new SignUpControl(locator);
        return control;
    }

    public void setText(String text){
        setText(text, true);
    }
    public void setText(TestConfig.Thy text){
        setText(text, true);
    }
    public void setText(String text, boolean clear){

        WebElement rootElement = getRootElement();
        if (clear) {
            rootElement.clear();
        }
        click();
        rootElement.sendKeys(text);
    }
    public void setText(TestConfig.Thy text, boolean clear){

        WebElement rootElement = getRootElement();
        if (clear) {
            rootElement.clear();
        }
        click();
        rootElement.sendKeys((CharSequence) text);
    }

    public String getText() {
        WebElement rootElement = getRootElement();
        return rootElement.getAttribute("value");
    }

    public void waitForValue(String waitForValue){
        WebElement rootElement = getRootElement();
        String finalWaitForValue = waitForValue;
        try {
            wait.until((driver) -> {
                String value = rootElement.getAttribute("value");
                value = value == null ? "" : value.trim();
                boolean eq = finalWaitForValue.equals(value);
                return eq;
            });
        } catch (Exception e) {
            takeAllureScreenShot(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void waitForNotEmpty() {
        WebElement rootElement = getRootElement();
        wait.until((driver) -> {
            String value = rootElement.getAttribute("value");
            value = value == null ? "" : value.trim();
            return value.trim().length() > 0;
        });
    }

    public void waitForContainsValue(String waitForValue) {
        WebElement rootElement = getRootElement();
        String finalWaitForValue = waitForValue;
        wait.until((driver) -> {
            String value = rootElement.getAttribute("value");
            value = value == null ? "" : value.trim();
            return value.contains(finalWaitForValue);
        });
    }
}
