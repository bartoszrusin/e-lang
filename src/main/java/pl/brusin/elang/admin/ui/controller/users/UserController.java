package pl.brusin.elang.admin.ui.controller.users;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import pl.brusin.elang.admin.domain.users.User;
import pl.brusin.elang.admin.service.users.UserService;
import pl.brusin.elang.admin.service.users.impl.UserServiceImpl;
import pl.brusin.elang.admin.ui.model.users.UserBean;

@Named
@Scope("request")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserBean userBean;
    private final UserService userService;

    @Inject
    public UserController(UserService userService, UserBean userBean) {
        this.userService = userService;
        this.userBean = userBean;
    }

    public void loadUsers() {
        LOGGER.info("Load users");
        List<User> users = userService.getAll();
        userBean.setUsers(users);
    }

    public List<User> getUsers() {
        if (userBean.getUsers() == null) {
            loadUsers();
        }
        return userBean.getUsers();
    }

    public String add() {
        userBean.setUser(new User());
        return "add";
    }

    public void add(String userName) {
        LOGGER.info(userName);
    }

    public String create() {
        User newUser = userBean.getUser();
        userService.create(newUser);
        loadUsers();
        return "home";
    }

    public String edit() {
        return "edit";
    }

    public String update() {
        User editedUser = userBean.getSelectedUser();
        userService.update(editedUser);
        loadUsers();
        return "home";
    }

    public void delete() {
        User deletedUser = userBean.getSelectedUser();
        userService.delete(deletedUser);
        loadUsers();
    }
}
