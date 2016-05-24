package pl.brusin.elang.admin.service.users.impl;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.brusin.elang.admin.domain.users.User;
import pl.brusin.elang.admin.repository.users.jpa.UserRepository;
import pl.brusin.elang.admin.service.users.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Inject
    public UserServiceImpl(UserRepository repository) {
        this.userRepository = repository;
    }

    @Transactional
    @Override
    public User create(User user) {
        userRepository.save(user);
        return user;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
