package com.steps.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Map;

import static com.steps.ui.CommonTargetsPage.PASSWORD;
import static com.steps.ui.CommonTargetsPage.USER_EMAIL;
import static com.steps.ui.RegisterUserPage.*;
import static com.steps.utils.Constants.*;
import static com.steps.utils.sessionVariables.EMAIL_USER;
import static com.steps.utils.sessionVariables.PASSWORD_USER;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

@AllArgsConstructor
public class StarsUserRegister implements Task {

    private final Map<String, String> info;

    public static Performable onWebSide(Map<String, String> info) {
        return Tasks.instrumented(StarsUserRegister.class, info);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.remember(EMAIL_USER.toString(), info.get(USER_USER_EMAIL));
        actor.remember(PASSWORD_USER.toString(), info.get(USER_PASSWORD));

        actor.attemptsTo(WaitUntil.the(USER_NAME, isEnabled()).forNoMoreThan(10).seconds());
        actor.attemptsTo(Enter.theValue(info.get(NAME)).into(USER_NAME));
        actor.attemptsTo(Enter.theValue(info.get(USER_LAST_NAME)).into(LAST_NAME));
        actor.attemptsTo(Enter.theValue(info.get(USER_SECOND_LAST_NAME)).into(SECOND_LAST_NAME));
        actor.attemptsTo(SelectFromOptions.byVisibleText(info.get(USER_DOCUMENT_TYPE)).from(DOCUMENT_TYPE));
        actor.attemptsTo(Enter.theValue(info.get(USER_DOCUMENT_NUMBER)).into(DOCUMENT_NUMBER));
        actor.attemptsTo(Enter.theValue(info.get(USER_USER_EMAIL)).into(USER_EMAIL));
        actor.attemptsTo(Enter.theValue(info.get(USER_PHONE_NUMBER)).into(PHONE_NUMBER));
        actor.attemptsTo(Enter.theValue(info.get(USER_PASSWORD)).into(PASSWORD));
        actor.attemptsTo(Enter.theValue(info.get(USER_PASSWORD)).into(CONFIRM_PASSWORD));
        actor.attemptsTo(Scroll.to(CONFIRM_PASSWORD));
        actor.attemptsTo(Scroll.to(CONFIRM_PASSWORD).andAlignToTop());
        actor.attemptsTo(Click.on(TERM_AND_CONDITIONS));
        actor.attemptsTo(Click.on(CREATE_ACCOUNT_BUTTON));
    }
}
