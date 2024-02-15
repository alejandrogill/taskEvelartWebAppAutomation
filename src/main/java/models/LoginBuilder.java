package models;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Tasks;
import task.Login;


public class LoginBuilder {

    private String user;

    public LoginBuilder(String user) {
        this.user = user;
    }

    public Login andPass(String pass){
        return Tasks.instrumented(Login.class,user,pass);
    }
}
