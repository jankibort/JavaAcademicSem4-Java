package pl.jaz.jazapp.webapp.extension.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.PropertyResourceBundle;

@FacesValidator("birthdateValidator")
public class BirthdateValidator implements Validator<String> {
    private static final String INVALID_BIRTHDATE =
            "pl.jaz.jazapp.webapp.extension.validator.EmailValidator.WRONG_BIRTHDATE_VALIDATOR_MESSAGE";

    @Override
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
        if (!value.matches("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$")) {
            var msg = getMsg(context);
            var message = msg.getString(INVALID_BIRTHDATE);
            throw new ValidatorException(new FacesMessage(message));
        }
    }

    public PropertyResourceBundle getMsg (FacesContext context){
        return context.getApplication().evaluateExpressionGet(
                context, "#{msg}", PropertyResourceBundle.class);
    }
}