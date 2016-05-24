package pl.brusin.elang.admin.ui.model.users;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import pl.brusin.elang.admin.domain.users.User;

@Named
@Scope("flow")
public class UserBean implements Serializable {

    private User user;

    private User selectedUser;

    private List<User> users;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
