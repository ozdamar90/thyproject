package actions;

import controls.SignUpControl;
import controls.TextfieldControl;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import utils.TestConfig;

public class SignUpActions {

    public static void setText(String label, String value) {
        setText(label, value, 1);
    }

    //public static void setText(String label, TestConfig.Thy value) {
        //setText(label, value, 1);
   // }

    public static void setText(String label, String value, int no) {
        SignUpControl
                .fromLabel(label, no)
                .setText(value);
    }
//    public static void setText(String label, TestConfig.Thy value, int no) {
//        SignUpControl
//                .fromLabel(label, no)
//                .setText(value);
//    }
    public static void setTextAndPressTab(String label, String value) {
        SignUpControl
                .fromLabel(label)
                .setText(value + Keys.TAB);
    }

    public static void setTextAndPressEnter(String label, String value) {
        SignUpControl
                .fromLabel(label)
                .setText(value + Keys.ENTER);
    }

    public static void checkText(String label, String expectedValue) {
        String actualValue = SignUpControl
                .fromLabel(label)
                .getText();
        Assert.assertEquals(expectedValue, actualValue);
    }

    public static void waitUntilTextfieldHasValue(String label, String value) {
        SignUpControl
                .fromLabel(label)
                .waitForValue(value);
    }

    public static void waitUntilTextfieldHasValue(int n, String label, String value) {
        SignUpControl
                .fromLabel(label,n)
                .waitForValue(value);
    }

    public static void waitUntilContains(String label, String value) {
        SignUpControl
                .fromLabel(label)
                .waitForContainsValue(value);
    }

}
