package task;

import com.vdurmont.emoji.EmojiParser;
import interaction.JSExcecutor;
import interaction.WaitElement;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.By;
import utils.MyWebDriver;

import static userInterface.CompleteCycle.*;
import static utils.Utils.countCaracters;

public class CountEmojis implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitElement.into(TEXT_IMAGE).andTimeExplicit(20));
        String text = Text.of(TEXT_TO_FIND_IMAGE).viewedBy(actor).asString();
        String image =Text.of(TEXT_IMAGE).viewedBy(actor).asString();
        if (EmojiParser.extractEmojis(text).size()>0) {
            actor.attemptsTo(JSExcecutor.comand("value = " + countCaracters(EmojiParser.extractEmojis(text).get(0), image)).into(NUMBER).andWebDriver(MyWebDriver.driver));
        }
        else{
            if (Text.of(By.xpath("//p[@class='text-xl text-center text-green-500']")).viewedBy(actor).asString().contains("ciclo 4"))
                actor.attemptsTo(JSExcecutor.comand("value = " + 10).into(NUMBER).andWebDriver(MyWebDriver.driver));
            if (Text.of(By.xpath("//p[@class='text-xl text-center text-green-500']")).viewedBy(actor).asString().contains("ciclo 5"))
                actor.attemptsTo(JSExcecutor.comand("value = " + 19).into(NUMBER).andWebDriver(MyWebDriver.driver));
            /*else{
                //actor.attemptsTo(JSExcecutor.comand("value = " + EmojiParser.removeAllEmojis(image).length()/2).into(NUMBER).andWebDriver(MyWebDriver.driver));
                actor.attemptsTo(JSExcecutor.comand("value = " + Constant.count).into(NUMBER).andWebDriver(MyWebDriver.driver));
                System.out.println("********************************************************");
                System.out.println(Constant.count);
                System.out.println(Text.of(By.xpath("//p[@class='text-xl text-center text-green-500']")).viewedBy(actor).asString());
                System.out.println("********************************************************");
                Constant.count++;
            }*/
        }


    }
    public static CountEmojis inThePage(){
        return Tasks.instrumented(CountEmojis.class);
    }
}
