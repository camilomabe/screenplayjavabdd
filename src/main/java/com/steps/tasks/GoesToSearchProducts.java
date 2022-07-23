package com.steps.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.Wait;

import static com.steps.ui.SearchProductsPage.*;
import static com.steps.utils.Constants.WAIT_FOR;
import static com.steps.utils.SessionVariables.SAVE_PRODUCT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

@AllArgsConstructor
public class GoesToSearchProducts implements Task {

    private final String products;

    public static Performable atStore(String products) {
        return Tasks.instrumented(GoesToSearchProducts.class, products);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember(SAVE_PRODUCT.toString(), products);
        actor.attemptsTo(Wait.until(the(SEARCH_PRODUCTS), isPresent()).forNoLongerThan(WAIT_FOR).seconds());
        actor.attemptsTo(Enter.theValue(products).into(SEARCH_PRODUCTS));
        actor.attemptsTo(Wait.until(the(selectProduct(products)), isPresent()).forNoLongerThan(WAIT_FOR).seconds());
        actor.attemptsTo(Click.on(selectProduct(products)));
        actor.attemptsTo(Wait.until(the(ADD_PRODUCT), isPresent()).forNoLongerThan(WAIT_FOR).seconds());
        actor.attemptsTo(Click.on(ADD_PRODUCT));
        actor.attemptsTo(Wait.until(the(LOCATION_ADDRESS), isPresent()).forNoLongerThan(WAIT_FOR).seconds());
        actor.attemptsTo(Click.on(LOCATION_ADDRESS));
    }
}
