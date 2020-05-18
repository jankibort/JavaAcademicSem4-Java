package pl.jaz.jazapp.webapp.extension.validator;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.PropertyResourceBundle;

@FacesValidator("nameValidator")
public class NameValidator implements Validator<String> {
    private static final String FIRSTNAME_VALIDATOR =
            "pl.jaz.jazapp.webapp.extension.validator.NameValidator.FIRSTNAME_VALIDATOR_MESSAGE";

    private static final String LASTNAME_VALIDATOR =
            "pl.jaz.jazapp.webapp.extension.validator.NameValidator.LASTNAME_VALIDATOR_MESSAGE";

    @Override
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
        if (!value.matches("[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ]+")) {
            var msg = getMsg(context);
            var message = "";
            switch (component.getId()) {
                case "first-name":
                    message = msg.getString(FIRSTNAME_VALIDATOR);
                case "last-name":
                    message = msg.getString(LASTNAME_VALIDATOR);
            }
            throw new ValidatorException(new FacesMessage(message));
        }
    }

    public PropertyResourceBundle getMsg(FacesContext context) {
        return context.getApplication().evaluateExpressionGet(
                context, "#{msg}", PropertyResourceBundle.class);
    }
}