package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;

import java.util.ArrayList;
import java.util.List;

import static userInterface.CompleteCycle.OPERATION;
import static userInterface.CompleteCycle.OPTION_VALUE_OPERATION;
import static userInterface.Login.SEND;
import static utils.Utils.operationResult;

public class OperationResult implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String phrase = Text.of(OPERATION).viewedBy(actor).asString().split("=")[0];
        actor.attemptsTo(Click.on(OPTION_VALUE_OPERATION.of(String.valueOf(operationResult(phrase)))));
    }

    public static OperationResult inThePage(){
        return Tasks.instrumented(OperationResult.class);
    }
}
