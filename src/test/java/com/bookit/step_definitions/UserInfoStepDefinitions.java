package com.bookit.step_definitions;

import com.bookit.database.UserDB;
import com.bookit.pages.LoginPage;
import com.bookit.pages.SelfPage;
import com.bookit.utilities.Driver;
import com.bookit.utilities.Environment;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class UserInfoStepDefinitions {


    SelfPage selfPage = new SelfPage();
    UserDB userDB = new UserDB();


    /**
     *      | first-name | last-name | email                          | password | role                | campus-location | batch-number | team-name      |
     *       | Lesly      | SDET      | lessleefromb15online@email.com | 1111     | student-team-member | VA              | 15           | Online_Hackers |
     *
     * @param dataTable
     */
    @Then("user verifies that information displays correctly:")
    public void user_verifies_that_information_displays_correctly(List<Map<String,String>> dataTable) {

String fullName= dataTable.get(0).get("first-name")+" "+dataTable.get(0).get("last-name");
        System.out.println("############## [UI VALIDATION ] ##############");
        Assert.assertEquals(fullName,selfPage.getUserInfo("name"));
        Assert.assertEquals(dataTable.get(0).get("role"),selfPage.getUserInfo("role"));
        Assert.assertEquals(dataTable.get(0).get("campus-location"),selfPage.getUserInfo("campus"));
        Assert.assertEquals(dataTable.get(0).get("batch-number"),selfPage.getUserInfo("batch").replace("#",""));
        Assert.assertEquals(dataTable.get(0).get("team-name"),selfPage.getUserInfo("team"));
        System.out.println("######## [ Database Validation ] ###########");
        Assert.assertTrue(userDB.checkIfUserExistingDB(dataTable.get(0).get("email")));
    }


}
