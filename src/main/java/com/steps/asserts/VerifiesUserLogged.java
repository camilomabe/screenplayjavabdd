package com.steps.asserts;

        import net.serenitybdd.screenplay.Actor;
        import net.serenitybdd.screenplay.Question;
        import net.serenitybdd.screenplay.questions.Text;

        import static com.steps.ui.CommonTargetsPage.USER_EMAIL;

public class VerifiesUserLogged implements Question<String> {

    public static Question<String> displayed() {
        return new VerifiesUserLogged();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(USER_EMAIL).toString();
    }


}
