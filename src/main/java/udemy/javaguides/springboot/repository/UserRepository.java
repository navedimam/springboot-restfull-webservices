package udemy.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import udemy.javaguides.springboot.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
