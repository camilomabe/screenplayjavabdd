package com.steps.asserts;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.Wait;

import static com.steps.ui.SearchProductsPage.*;
import static com.steps.ui.SearchProductsPage.GOES_BACK;
import static com.steps.utils.Constants.WAIT_FOR;
import static com.steps.utils.SessionVariables.SAVE_PRODUCT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class VerifiesAddedProduct implements Task {

    public static Performable onCart() {
        return Tasks.instrumented(VerifiesAddedProduct.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String searchProduct = actor.recall(SAVE_PRODUCT.toString());
        actor.attemptsTo(Wait.until(the(searchProduct(searchProduct.toUpperCase())), isPresent()).forNoLongerThan(WAIT_FOR).seconds());
        String product = searchProduct(searchProduct.toUpperCase()).resolveFor(actor).getText();
        if (product.contains(searchProduct.toUpperCase())) {
            actor.attemptsTo(Ensure.that(product).isEqualTo(searchProduct.toUpperCase()));
            actor.attemptsTo(Wait.until(the(CLEAN_CART), isPresent()).forNoLongerThan(WAIT_FOR).seconds());
            actor.attemptsTo(Click.on(CLEAN_CART));
            actor.attemptsTo(Wait.until(the(YES_CLEAN_CART), isPresent()).forNoLongerThan(WAIT_FOR).seconds());
            actor.attemptsTo(Click.on(YES_CLEAN_CART));
            actor.attemptsTo(Wait.until(the(GOES_BACK), isPresent()).forNoLongerThan(WAIT_FOR).seconds());
            actor.attemptsTo(Click.on(GOES_BACK));
        } else {
            throw new RuntimeException("\nActual -> " + product.toUpperCase() + "\nExpected -> " + searchProduct.toUpperCase());
        }
    }
}
