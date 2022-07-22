package com.steps.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CommonTargetsPage {

    public static final Target REGISTER = Target.the("register user").located(By.xpath("//div[@class='flex items-center ml-8']"));
    public static final Target PASSWORD = Target.the("enters password").located(By.xpath("//input[@type='password']"));
    public static final Target USER_EMAIL = Target.the("enters user's email").located(By.xpath("//input[@type='email']"));
}
