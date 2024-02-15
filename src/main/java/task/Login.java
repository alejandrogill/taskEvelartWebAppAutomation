package task;

import lombok.AllArgsConstructor;
import models.LoginBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValueIntoTarget;

import static userInterface.Login.*;


public class Login implements Task {

    private String user;
    private String pass;

    public Login(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user).into(USER),
                Enter.theValue(pass).into(PASS),
                Click.on(SEND));
    }

    public static LoginBuilder whitUser(String user){
        return new LoginBuilder(user);
    }
}
