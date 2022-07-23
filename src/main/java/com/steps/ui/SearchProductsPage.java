package com.steps.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class SearchProductsPage {

    public static final Target SEARCH_PRODUCTS = Target.the("enters search product").located(By.xpath("//div[2]/div/div/div/div/div/input"));
    public static final Target SELECT_PRODUCT = Target.the("selects first product").located(By.xpath("//div[@class='mt-3 text-default-slate text-xs cursor-pointer']"));
    public static final Target LOCATION_ADDRESS = Target.the("confirms location address").located(By.xpath("//p[@class='location-address']"));
    public static final Target ADD_PRODUCT = Target.the("adds product").located(By.xpath("//div[4]/button"));
    public static Target selectProduct(String product) {return Target.the("add product").located(By.xpath("//div[contains(text(),'" + product + "')]"));}
    public static final Target CLEAN_CART = Target.the("clean cart").located(By.id("clean-cart"));
    public static final Target YES_CLEAN_CART = Target.the("yes, clean cart").located(By.xpath("//div[@id='__layout']/div/div[3]/div[3]/div[2]/div/button[2]"));
    public static final Target GOES_BACK = Target.the("goes back to the store").located(By.xpath("//div[@id='__layout']/div/div[3]/div[2]/div[2]/div/button"));
    public static Target addProduct(String product) {return Target.the("add product").located(By.xpath("//div[contains(text(), '" + product + "')]"));}
    public static Target searchProduct(String product) {return Target.the("added product").located(By.xpath("//a[contains(text(), '" + product + "')]"));}

}
