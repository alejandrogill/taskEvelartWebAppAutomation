package interaction;

import models.JSExcecutorBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JSExcecutor implements Interaction {
    private Target target;
    private WebDriver driver;
    private String comand;

    public JSExcecutor(Target target, WebDriver driver, String comand) {
        this.target = target;
        this.driver = driver;
        this.comand = comand;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0]."+comand+";", target.resolveFor(actor));
    }

    public static JSExcecutorBuilder comand(String comand){
        return new JSExcecutorBuilder(comand);
    }
}
