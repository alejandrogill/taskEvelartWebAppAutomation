package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;

import static userInterface.CompleteCycle.FIELD_TO_WRITE_LETTER;
import static userInterface.CompleteCycle.TEXT_TO_WRITE_LETTER;

public class WriteLetter implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        String phrase = Text.of(TEXT_TO_WRITE_LETTER).viewedBy(actor).asString();
        int amount = Integer.parseInt(phrase.split("Escriba ")[1].split(" ")[0]);
        String letter = phrase.split("\"")[1].substring(0);

        String sentence = letter;
        for (int i = 1; i < amount; i++) {
            sentence=sentence+letter;
        }
        actor.attemptsTo(Enter.theValue(sentence).into(FIELD_TO_WRITE_LETTER));
    }
    public static WriteLetter inThePage(){
        return Tasks.instrumented(WriteLetter.class);
    }
}
