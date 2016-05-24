package pl.brusin.elang.admin.ui.validator;

import org.apache.commons.lang.StringUtils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("phoneNumberValidator")
public class PhoneNumberValidator implements Validator {

    private static final int MAX_LENGTH = 20;

    private static final String PHONE_NUMBER_REQUIRED_MSG = "Phone number is required";
    private static final String PHONE_NUMBER_MAX_LENGTH_MSG = "Maximum length of phone number is " + MAX_LENGTH + " characters";

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {

        String phoneNumber = StringUtils.trimToNull((String) value);

        if (phoneNumber == null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, PHONE_NUMBER_REQUIRED_MSG, ""));
        }

        if (phoneNumber.length() > MAX_LENGTH) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, PHONE_NUMBER_MAX_LENGTH_MSG, ""));
        }
    }
}
