package pl.brusin.elang.admin.service.users;

import pl.brusin.elang.admin.domain.users.User;

import java.util.List;

public interface UserService {

    User create(User user);

    List<User> getAll();

    void update(User user);

    void delete(User user);
}
