package com.steps.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisterUserPage {

    public static final Target USER_NAME = Target.the("enters name").located(By.xpath("//input[@placeholder='Escribe tu nombre']"));
    public static final Target LAST_NAME = Target.the("enters last name").located(By.xpath("//input[@placeholder='Escribe tu primer apellido']"));
    public static final Target SECOND_LAST_NAME = Target.the("enters second last name").located(By.xpath("//input[@placeholder='Escribe tu segundo apellido']"));
    public static final Target DOCUMENT_TYPE = Target.the("selects document type").located(By.xpath("//*[@id='__layout']/div/div[2]/div[4]/div/div[3]/div[2]/div/div[4]/div/select"));
    public static final Target DOCUMENT_NUMBER = Target.the("enters document number").located(By.xpath("//input[@placeholder='1234567890']"));
    public static final Target PHONE_NUMBER = Target.the("enters phone number").located(By.xpath("//input[@type='phone']"));
    public static final Target CONFIRM_PASSWORD = Target.the("enters confirmation password").located(By.xpath("(//input[@type='password'])[2]"));
    public static final Target TERM_AND_CONDITIONS = Target.the("clicks on accepts term and conditions").located(By.xpath("//label[@class='checkbox-item block mt-2 text-left']"));
    public static final Target CAPTCHA = Target.the("clicks on captcha box").located(By.xpath("//input[@placeholder='Confirma tu contraseña']"));
    public static final Target CREATE_ACCOUNT_BUTTON = Target.the("clicks on create account button").located(By.xpath("//span[contains(text(),'Crear Cuenta')]"));


}
