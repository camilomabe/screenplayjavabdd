package com.steps.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {


    public static final Target LOGIN_BUTTON = Target.the("clicks on login button").located(By.xpath("//button/span"));
    public static final Target WRONG_CREDENTIALS = Target.the("sees alert text").located(By.xpath("//div[4]/div/div/div"));

    public static final Target USER_FIELD = Target.the("registered user label").located(By.xpath("//div[2]/div/div/div/div/div/span"));
    public static final Target MY_DATA_FIELD = Target.the("registered user label").located(By.xpath("//a[contains(text(),'Mis datos')]"));



}
