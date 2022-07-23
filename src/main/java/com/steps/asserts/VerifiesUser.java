package com.steps.asserts;

import com.steps.interactions.GoesToUserData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.Wait;

import static com.steps.ui.CommonTargetsPage.USER_EMAIL;
import static com.steps.utils.Constants.WAIT_FOR;
import static com.steps.utils.SessionVariables.EMAIL_USER;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class VerifiesUser implements Task {

    public static Performable user() {
        return Tasks.instrumented(VerifiesUser.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(GoesToUserData.user());
        actor.attemptsTo(Wait.until(the(USER_EMAIL), isVisible()).forNoLongerThan(WAIT_FOR).seconds());
        actor.attemptsTo(Ensure.that(USER_EMAIL).value().isEqualTo(actor.recall(EMAIL_USER.toString())));
    }
}
