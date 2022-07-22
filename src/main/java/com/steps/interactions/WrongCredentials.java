package com.steps.interactions;

import net.serenitybdd.screenplay.Question;

import static com.steps.ui.LoginPage.WRONG_CREDENTIALS;

public class WrongCredentials {

    public static Question<Boolean> isShowed() {
        return actor -> WRONG_CREDENTIALS.resolveFor(actor).isEnabled();
    }
}
