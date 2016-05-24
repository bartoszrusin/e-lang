package pl.brusin.elang.admin.repository.users.jpa;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.brusin.elang.admin.domain.users.User;

public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long>, Serializable {

    @Query("from User u where u.name = :name")
    User findUserByLogin(@Param("name") String name);
}
