package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static userInterface.Login.SEND;

public class CompleteCycles implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 0; i < 10; i++) {
            actor.attemptsTo(CountEmojis.inThePage(), WriteLetter.inThePage(), MultiplesOf.inThePage(),
                    OperationResult.inThePage(), Click.on(SEND));
        }
    }

    public static CompleteCycles inThePage(){
        return Tasks.instrumented(CompleteCycles.class);
    }
}
