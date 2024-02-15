package models;

import interaction.WaitElement;
import net.serenitybdd.screenplay.targets.Target;

public class WaitElementBuilder {
    private Target element;
    public WaitElementBuilder(Target element) {
        this.element=element;}
    public WaitElement andTimeExplicit(int timeInSeconds){
        return new WaitElement(timeInSeconds,element);
    }
}
