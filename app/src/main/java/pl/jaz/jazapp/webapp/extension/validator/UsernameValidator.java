package pl.jaz.jazapp.webapp.extension.validator;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.PropertyResourceBundle;

@FacesValidator("usernameValidator")
public class UsernameValidator implements Validator<String> {
    private static final String USERNAME_VALIDATOR_MESSAGE =
            "pl.jaz.jazapp.webapp.extension.validator.UsernameValidator.USERNAME_VALIDATOR_MESSAGE";

    @Override
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
        if (!value.matches("[a-z\0-9]+")) {
            var msg = getMsg(context);
            var message = msg.getString(USERNAME_VALIDATOR_MESSAGE);
            throw new ValidatorException(new FacesMessage(message));
        }
    }

    public PropertyResourceBundle getMsg(FacesContext context) {
        return context.getApplication().evaluateExpressionGet(
                context, "#{msg}", PropertyResourceBundle.class);
    }
}