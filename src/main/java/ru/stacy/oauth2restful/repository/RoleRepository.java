package ru.stacy.oauth2restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stacy.oauth2restful.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {}
