package com.steps.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.Wait;

import static com.steps.ui.LoginPage.MY_DATA_FIELD;
import static com.steps.ui.LoginPage.USER_FIELD;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class GoesToUserData implements Interaction {

    public static Performable user() {
        return Tasks.instrumented(GoesToUserData.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Wait.until(the(USER_FIELD), isEnabled()).forNoLongerThan(30).seconds());
        actor.attemptsTo(Click.on(USER_FIELD));
        actor.attemptsTo(Wait.until(the(MY_DATA_FIELD), isEnabled()).forNoLongerThan(30).seconds());
        actor.attemptsTo(Click.on(MY_DATA_FIELD));
    }
}
