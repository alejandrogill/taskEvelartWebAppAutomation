package userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class CompleteCycle {
    public static final Target TEXT_TO_FIND_IMAGE= Target.the("Text to find image").locatedBy("//form[@action='/automatization/forms/answer']//p[contains(.,'Indique cuantos')]");
    public static final Target TEXT_TO_WRITE_LETTER= Target.the("Text to write letter").locatedBy("//form[@action='/automatization/forms/answer']//p[contains(.,'Escriba ')]");
    public static final Target TEXT_TO_SELECTED= Target.the("Text to selected the multiples").locatedBy("//form[@action='/automatization/forms/answer']//p[contains(.,'Selecciona')]");
    public static final Target OPTIONS_THE_SELECT= Target.the("Text to selected the multiples").locatedBy(TEXT_TO_SELECTED.getCssOrXPathSelector()+"/following::div[1]//input");
    public static final Target OPERATION= Target.the("Text with Operation").locatedBy("//form[@action='/automatization/forms/answer']//p[contains(.,'Complete')]/following::p");
    public static final Target OPTION_VALUE_OPERATION= Target.the("Text with value Operation").locatedBy(OPERATION.getCssOrXPathSelector()+"/following::input[@value='{0}']");


    public static final Target TEXT_IMAGE= Target.the("Text to find image").locatedBy("//form[@action='/automatization/forms/answer']//p[contains(.,'Indique cuantos')]/following::p");
    public static final Target NUMBER= Target.the("Input to write count of image").locatedBy("//input[@name='number']");
    public static final Target FIELD_TO_WRITE_LETTER= Target.the("field to write letter").locatedBy("//textarea[@name='text']");




}
