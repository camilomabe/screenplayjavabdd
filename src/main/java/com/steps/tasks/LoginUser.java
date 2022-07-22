package com.steps.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.Wait;

import static com.steps.ui.CommonTargetsPage.*;
import static com.steps.ui.LoginPage.LOGIN_BUTTON;
import static com.steps.utils.sessionVariables.EMAIL_USER;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

@AllArgsConstructor
public class LoginUser implements Task {

    private final String email;
    private final String pass;

    public static Performable toLoginIn(String email, String pass) {
        return Tasks.instrumented(LoginUser.class, email, pass);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember(EMAIL_USER.toString(), email);
        actor.attemptsTo(Wait.until(the(REGISTER), isEnabled()).forNoLongerThan(30).seconds());
        actor.attemptsTo(Click.on(REGISTER));
        actor.attemptsTo(Enter.theValue(email).into(USER_EMAIL));
        actor.attemptsTo(Enter.theValue(pass).into(PASSWORD));
        actor.attemptsTo(Click.on(LOGIN_BUTTON));
    }
}
