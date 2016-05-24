package pl.brusin.elang.admin.ui.validator;

import org.apache.commons.lang.StringUtils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("addressValidator")
public class AddressValidator implements Validator {

    private static final int MAX_LENGTH = 1024;

    private static final String ADDRESS_REQUIRED_MSG = "Address is required";
    private static final String ADDRESS_MAX_LENGTH_MSG = "Maximum length of address is " + MAX_LENGTH + " characters";


    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {

        String address = StringUtils.trimToNull((String) value);

        if (address == null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, ADDRESS_REQUIRED_MSG, ""));
        }

        if (address.length() > MAX_LENGTH) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, ADDRESS_MAX_LENGTH_MSG, ""));
        }
    }
}
