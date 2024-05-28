package stepdefs;

import actions.SignUpActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import utils.TestConfig;
import utils.TestConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SignUpSteps {
    @When("user fill form of the personel information")
    public void userFillFormOfThePersonelInformation(DataTable table) {
        TestConfig config= TestConfiguration.instance().getTestConfiguration();

//        List<TestConfig.Thy> thyInfoList = Arrays.asList(
//
//                new TestConfig.Thy ("Mumin"),
//                new TestConfig.Thy ("Ozdamar"),
//                new TestConfig.Thy ("21.10.1976"),
//                new TestConfig.Thy ("mozzi998@gmail.com"),
//                new TestConfig.Thy ("06100"),
//                new TestConfig.Thy ("3499 sok No:4 Yenimahalle"),
//                new TestConfig.Thy ("505 511 80 90"),
//                new TestConfig.Thy ("Amasya197605"),
//                new TestConfig.Thy ("Amasya197605"),
//                new TestConfig.Thy ("Celik")
//
//        );


        List<String> list= table.asList();
        for (String question : list) {
            for (String answerInfo : config.getThy().getInfo()) {
                SignUpActions.setText(question,answerInfo);

            }

        }








         }
    }

