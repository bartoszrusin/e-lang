package pl.brusin.elang.admin.ui.validator;

import org.apache.commons.lang.StringUtils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("nameValidator")
public class NameValidator implements Validator {

    private static final int MAX_LENGTH = 200;

    private static final String NAME_REQUIRED_MSG = "Name is required";
    private static final String NAME_MAX_LENGTH_MSG = "Maximum length of name is " + MAX_LENGTH + " characters";

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {

        String name = StringUtils.trimToNull((String) value);

        if (name == null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, NAME_REQUIRED_MSG, ""));
        }

        if (name.length() > MAX_LENGTH) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, NAME_MAX_LENGTH_MSG, ""));
        }
    }
}
