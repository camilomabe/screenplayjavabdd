package com.steps.asserts;

import com.steps.interactions.GoesToUserData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.Wait;

import static com.steps.ui.CommonTargetsPage.USER_EMAIL;
import static com.steps.utils.sessionVariables.EMAIL_USER;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;


public class VerifiesUser implements Task {

    public static Performable user() {
        return Tasks.instrumented(VerifiesUser.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String validateUser = actor.recall(EMAIL_USER.toString());
        actor.attemptsTo(GoesToUserData.user());
        actor.attemptsTo(Wait.until(the(USER_EMAIL), isVisible()).forNoLongerThan(30).seconds());
        actor.attemptsTo(Ensure.that(USER_EMAIL).value().isEqualTo(validateUser));
    }
}
