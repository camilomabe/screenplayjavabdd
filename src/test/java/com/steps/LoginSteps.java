package com.steps;

import com.steps.asserts.VerifiesUser;
import com.steps.interactions.IncorrectCredentials;
import com.steps.tasks.LoginUser;
import com.steps.utils.NavigateTo;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginSteps {


    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) opens the browser in the login home$")
    public void opens_the_browser_in_login_home(String actor) {
        theActorCalled(actor).attemptsTo(NavigateTo.theWebSideHome());
    }

    @When("^he enters his credentials (.*) and (.*)$")
    public void stars_session_user(String email, String pass) {
        theActorInTheSpotlight().attemptsTo(LoginUser.toLoginIn(email, pass));
    }

    @Then("^he verifies that he has logged in correctly with his email$")
    public void validates_correct_credentials() {
        theActorInTheSpotlight().attemptsTo(VerifiesUser.user());
    }

    @Then("^he sees that he entered his credentials incorrectly$")
    public void incorrect_credentials() {
        theActorInTheSpotlight().attemptsTo(IncorrectCredentials.user());
    }

}
