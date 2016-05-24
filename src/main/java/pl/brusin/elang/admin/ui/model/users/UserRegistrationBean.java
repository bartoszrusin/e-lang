package pl.brusin.elang.admin.ui.model.users;

import java.io.Serializable;
import pl.brusin.elang.admin.domain.users.User;
import pl.brusin.elang.configuration.annotation.FlowBean;

@FlowBean
public class UserRegistrationBean implements Serializable {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
