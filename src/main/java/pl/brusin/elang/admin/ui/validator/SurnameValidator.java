package pl.brusin.elang.admin.ui.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.apache.commons.lang.StringUtils;

@FacesValidator("surnameValidator")
public class SurnameValidator implements Validator {

    private static final int MAX_LENGTH = 200;

    private static final String SURNAME_REQUIRED_MSG = "Surname is required";
    private static final String SURNAME_MAX_LENGTH_MSG = "Maximum length of surname is " + MAX_LENGTH + " characters";

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {

        String surname = StringUtils.trimToNull((String) value);

        if (surname == null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, SURNAME_REQUIRED_MSG, ""));
        }

        if (surname.length() > MAX_LENGTH) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, SURNAME_MAX_LENGTH_MSG, ""));
        }
    }
}
