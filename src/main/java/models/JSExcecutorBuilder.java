package models;

import interaction.JSExcecutor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebDriver;

public class JSExcecutorBuilder {
    private Target target;
    private String command;

    public JSExcecutorBuilder(String command) {
        this.command = command;
    }

    public JSExcecutorBuilder into(Target target){
        this.target=target;
        return this;
    }
    public JSExcecutor andWebDriver(WebDriver driver){
        return new JSExcecutor(target,driver,command);
    }
}
