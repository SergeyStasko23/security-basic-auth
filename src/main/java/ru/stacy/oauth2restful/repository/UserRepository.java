package ru.stacy.oauth2restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stacy.oauth2restful.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
