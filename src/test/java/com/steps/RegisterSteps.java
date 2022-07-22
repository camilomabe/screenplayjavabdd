package com.steps;

import com.steps.asserts.VerifiesUser;
import com.steps.interactions.GoesRegisterHome;
import com.steps.tasks.EntersAddress;
import com.steps.tasks.StarsUserRegister;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegisterSteps {

    @When("^he goes to the registration Home$")
    public void goes_to_the_registration_home() {
        theActorInTheSpotlight().attemptsTo(GoesRegisterHome.letsGo());
    }

    @And("^he enters his information$")
    public void enters_personal_information(Map<String, String> info) {
        theActorInTheSpotlight().attemptsTo(StarsUserRegister.onWebSide(info));
    }

    @And("he enters address confirmation")
    public void enters_address_confirmation(Map<String, String> addressInfo) {
        theActorInTheSpotlight().attemptsTo(EntersAddress.confirmation(addressInfo));
    }

    @Then("^he verifies email registration correctly$")
    public void verifies_user_registration_correctly() {
        theActorInTheSpotlight().attemptsTo(VerifiesUser.user());
    }

}
