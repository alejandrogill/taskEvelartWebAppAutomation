package userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class Login {
    public static final Target USER=Target.the("field for write the user").locatedBy("//input[@name='username']");
    public static final Target PASS=Target.the("field for write the pass").locatedBy("//input[@name='password']");
    public static final Target SEND=Target.the("Button for login").locatedBy("//button[@type='submit']");
}
