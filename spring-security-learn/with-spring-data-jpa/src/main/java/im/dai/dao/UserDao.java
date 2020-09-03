package im.dai.dao;

import im.dai.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
    User findUserByUsername(String username);
}
