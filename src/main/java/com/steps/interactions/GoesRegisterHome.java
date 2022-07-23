package com.steps.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.Wait;

import static com.steps.ui.CommonTargetsPage.REGISTER;
import static com.steps.utils.Constants.WAIT_FOR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class GoesRegisterHome implements Interaction {

    public static Performable letsGo() {
        return Tasks.instrumented(GoesRegisterHome.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Wait.until(the(REGISTER), isEnabled()).forNoLongerThan(WAIT_FOR).seconds());
    }
}
