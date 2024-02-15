package interaction;

import models.WaitElementBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MyWebDriver;

public class WaitElement implements Interaction {
    private WebDriverWait wait;
    private Target element;


    public WaitElement(int timeInSeconds, Target element) {
        this.wait =new WebDriverWait(MyWebDriver.driver, timeInSeconds);;
        this.element = element;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element.getCssOrXPathSelector())));
    }

    public static WaitElementBuilder into(Target element){
        return new WaitElementBuilder(element);
    }

}
