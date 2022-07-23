package com.steps.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.Wait;

import java.util.Map;

import static com.steps.ui.ConfirmAddressPage.*;
import static com.steps.utils.Constants.*;
import static com.steps.utils.SessionVariables.EMAIL_USER;
import static com.steps.utils.SessionVariables.PASSWORD_USER;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

@AllArgsConstructor
public class EntersAddress implements Task {

    private final Map<String, String> addressInfo;

    public static Performable confirmation(Map<String, String> addressInfo) {
        return Tasks.instrumented(EntersAddress.class, addressInfo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Wait.until(the(WINDOWS_ADDRESS), isPresent()).forNoLongerThan(WAIT_FOR).seconds());
        actor.attemptsTo(Enter.theValue(addressInfo.get(USER_SELECT_CITY)).into(WINDOWS_ADDRESS));
        actor.attemptsTo(Click.on(INDEX_CITY));
        actor.attemptsTo(Enter.theValue(addressInfo.get(USER_STREET_NUMBER)).into(STREET_NUMBER));
        actor.attemptsTo(Enter.theValue(addressInfo.get(USER_NUMBER)).into(NUMBER));
        actor.attemptsTo(Enter.theValue(addressInfo.get(USER_WITH_NUMBER)).into(WITH_NUMBER));
        actor.attemptsTo(Click.on(SEARCH_BUTTON));
        actor.attemptsTo(Click.on(SAVE_ADDRESS_BUTTON));
        actor.attemptsTo(Click.on(ADDRESS_NOT_FOUND));

        String notFound = ADDRESS_NOT_FOUND.resolveFor(actor).getText();
        if (notFound.contains(ADDRESS_NO_FOUND_MESSAGE)) {
            String validateUser = actor.recall(EMAIL_USER.toString());
            String passwordUser = actor.recall(PASSWORD_USER.toString());
            actor.attemptsTo(Click.on(LOGIN_IN));
            actor.attemptsTo(LoginUser.toLoginIn(validateUser, passwordUser));
        }
    }
}
