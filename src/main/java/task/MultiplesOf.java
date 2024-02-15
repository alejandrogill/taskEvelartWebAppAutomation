package task;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;

import static userInterface.CompleteCycle.OPTIONS_THE_SELECT;
import static userInterface.CompleteCycle.TEXT_TO_SELECTED;

public class MultiplesOf implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String phrase = Text.of(TEXT_TO_SELECTED).viewedBy(actor).asString();
        int number = Integer.parseInt(String.valueOf(phrase.charAt(phrase.trim().length() - 1)));

        for (WebElementFacade option: OPTIONS_THE_SELECT.resolveAllFor(actor)) {
            if (Integer.parseInt(option.getAttribute("value"))%number==0)
                option.click();
        }
    }

    public static MultiplesOf inThePage(){
        return Tasks.instrumented(MultiplesOf.class);
    }
}
