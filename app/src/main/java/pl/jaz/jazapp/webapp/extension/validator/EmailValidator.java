package pl.jaz.jazapp.webapp.extension.validator;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.PropertyResourceBundle;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator<String> {
    private static final String WRONG_EMAIL =
            "pl.jaz.jazapp.webapp.extension.validator.EmailValidator.WRONG_MAIL_VALIDATOR_MESSAGE";

    @Override
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
        InternetAddress emailAdr = null;
        try {
            emailAdr = new InternetAddress(value);
        } catch (AddressException e) {
            var msg = getMsg(context);
            var onlySmallLettersMsg = msg.getString(WRONG_EMAIL);
            throw new ValidatorException(new FacesMessage(onlySmallLettersMsg));
        }
    }

    public PropertyResourceBundle getMsg(FacesContext context) {
        return context.getApplication().evaluateExpressionGet(
                context, "#{msg}", PropertyResourceBundle.class);
    }
}