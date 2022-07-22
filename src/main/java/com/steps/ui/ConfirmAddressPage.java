package com.steps.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConfirmAddressPage {

    public static final Target WINDOWS_ADDRESS = Target.the("enters a city").located(By.xpath("//div[@id='__layout']/div/div/div/form/div[2]/div[2]/div/div/input"));
    public static final Target INDEX_CITY = Target.the("selects a city").located(By.id("autocomplete-item-0"));
    public static final Target STREET_NUMBER = Target.the("enters street number").located(By.xpath("//div[3]/div[2]/div/div/input"));
    public static final Target NUMBER = Target.the("enters number").located(By.xpath("//div[4]/div/div/div/input"));
    public static final Target WITH_NUMBER = Target.the("enters house number").located(By.xpath("//div[4]/div[2]/div/div/input"));
    public static final Target SEARCH_BUTTON = Target.the("search button").located(By.xpath("//button[@aria-label='BUSCAR']"));
    public static final Target SAVE_ADDRESS_BUTTON = Target.the("save address button").located(By.xpath("//button[@aria-label='Guardar']"));
    public static final Target ADDRESS_NOT_FOUND = Target.the("save address button").located(By.xpath("//div[@id='__layout']/div/div/div/form/div/p[2]"));
    public static final Target LOGIN_IN = Target.the("goes to login in").located(By.linkText("Iniciar Sesión"));

}
