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
    private static final String ONLY_SMALL_LETTERS_MESSAGE_ID =
            "pl.jaz.jazapp.app.webapp.extension.validator.UsernameValidator.ONLY_SMALL_LETTERS";

    @Override
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
        if (!value.matches("[a-z]+")) {
            var msg = getMsg(context);
            var onlySmallLettersMsg = msg.getString(ONLY_SMALL_LETTERS_MESSAGE_ID);
            throw new ValidatorException(new FacesMessage(onlySmallLettersMsg));
        }
    }

    public PropertyResourceBundle getMsg(FacesContext context) {
        return context.getApplication().evaluateExpressionGet(
                context, "#{msg}", PropertyResourceBundle.class);
    }
}