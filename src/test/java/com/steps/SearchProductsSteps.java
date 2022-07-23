package com.steps;

import com.steps.asserts.VerifiesAddedProduct;
import com.steps.tasks.GoesToSearchProducts;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SearchProductsSteps {

    @And("^he search (.*)$")
    public void heSearchProducts(String products) {
        theActorInTheSpotlight().attemptsTo(GoesToSearchProducts.atStore(products));
    }

    @Then("^he verifies the text of the products found$")
    public void heVerifiesTextProducts() {
        theActorInTheSpotlight().attemptsTo(VerifiesAddedProduct.onCart());
    }
}
