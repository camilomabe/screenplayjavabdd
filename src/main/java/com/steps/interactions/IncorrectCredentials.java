package com.steps.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.Wait;

import static com.steps.ui.LoginPage.WRONG_CREDENTIALS;
import static com.steps.utils.Constants.ACCESS_DENIED_MESSAGE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class IncorrectCredentials implements Task {

    public static Performable user() {
        return Tasks.instrumented(IncorrectCredentials.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Wait.until(the(WRONG_CREDENTIALS), isVisible()).forNoLongerThan(30).seconds());
        String wrong = WRONG_CREDENTIALS.resolveFor(actor).getText();
        if (wrong.contains(ACCESS_DENIED_MESSAGE)) {
            throw new RuntimeException("\nIncorrect credentials -> " + wrong);
        } else {
            throw new RuntimeException("\nActual -> " + wrong + "\nExpected -> " + ACCESS_DENIED_MESSAGE);
        }
    }
}
