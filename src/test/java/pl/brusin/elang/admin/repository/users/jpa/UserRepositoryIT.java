package pl.brusin.elang.admin.repository.users.jpa;

import javax.inject.Inject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import pl.brusin.elang.admin.domain.users.User;
import pl.brusin.elang.admin.repository.AbstractBaseRepositoryContexts;

public class UserRepositoryIT extends AbstractBaseRepositoryContexts {

    @Inject
    private UserRepository userRepository;

    @Value("${prop1}")
    private String property;

    @Test
    public void findAll() throws Exception {
        System.out.println(property);
        userRepository.findAll();
    }

    @Test
    public void saveOrUpdate() throws Exception {
        User user = new User();
        user.setAddress("address");
        user.setName("NameUser");
        user.setPhoneNumber("98989899");
        user.setSurname("story");
        userRepository.save(user);
        userRepository.delete(user);
    }

    @Test
    public void delete() throws Exception {

    }
}
